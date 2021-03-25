package com.cybage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cybage.model.Supplier;
import com.cybage.service.ExcelService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/")
public class ExcelController {
	
	@Autowired
	 private ExcelService excelService;
	
	private String fileLocation;
	 
	@PostMapping("/uploadExcelFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
		System.out.println("In Excel Controller");
	    InputStream in = file.getInputStream();
	    File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
	    FileOutputStream f = new FileOutputStream(fileLocation);
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();
	    System.out.println("File: " + file.getOriginalFilename() 
	      + " has been uploaded successfully!    "+" filelocation: "+fileLocation);
	 
	    String excelFilePath =fileLocation;
	    Supplier s=new Supplier();
	    
        
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = (Sheet) workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            rowIterator.next(); // skip the header row        
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
                   
                    switch (columnIndex) {
                    case 0:
                        
                        s.setGiftname(nextCell.getStringCellValue());
                        break;
                   
                    case 1:
                        
                        s.setDescription(nextCell.getStringCellValue());
                       
                        break;        
                    case 2:
                    	
                    	s.setCategory(nextCell.getStringCellValue());
                        break; 
                    case 3:
                        double price = nextCell.getNumericCellValue();
                        s.setPrice((float) price);
                       
                        break;  		 
                        

                    case 4:
                    
                    	s.setImage(nextCell.getStringCellValue());
                        break; 
                    	
                         
                    case 5:
                        int quantity = (int) nextCell.getNumericCellValue();
                        s.setQuantity(quantity);
                        
                        break; 
                    case 6:
                       
                        
                        s.setGiftfor(nextCell.getStringCellValue());
                        
                        break; 
                    case 7:
                        String occasion = nextCell.getStringCellValue();
                        System.out.println("occasion : " + occasion);
                        s.setOccasions(nextCell.getStringCellValue());
                        break;            
                    }
                    	//add service layer method
                    System.out.println(s.toString());
                    excelService.addSupplierFileData(s);
            }
                 
              }//end of while loop
            workbook.close();
           
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } 
	    
	    return "excel";
	}
	
	
	
}


