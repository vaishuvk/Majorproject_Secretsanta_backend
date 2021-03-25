package com.cybage.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="supplier", uniqueConstraints = {
@UniqueConstraint(columnNames = "gid"),
@UniqueConstraint(columnNames = "giftname")})
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long gid;
	private String giftname;
	private String description;
	private String category;
	private double price;
	private String image;
	private int quantity;
	private String giftfor;
	private String occasions;
	private String fileType;
	@Transient
	private MultipartFile file;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(Long gid, String giftname, String description, String category, double price, String image,
			int quantity, String giftfor, String occasions, String fileType, MultipartFile file) {
		super();
		this.gid = gid;
		this.giftname = giftname;
		this.description = description;
		this.category = category;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.giftfor = giftfor;
		this.occasions = occasions;
		this.fileType = fileType;
		this.file = file;
	}
	
	public Supplier(Long gid, String giftname, String description, String category, double price, String image,
			int quantity, String giftfor, String occasions) {
		super();
		this.gid = gid;
		this.giftname = giftname;
		this.description = description;
		this.category = category;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.giftfor = giftfor;
		this.occasions = occasions;
	}
	
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getGiftname() {
		return giftname;
	}
	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getGiftfor() {
		return giftfor;
	}
	public void setGiftfor(String giftfor) {
		this.giftfor = giftfor;
	}
	public String getOccasions() {
		return occasions;
	}
	public void setOccasions(String occasions) {
		this.occasions = occasions;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Supplier [gid=" + gid + ", giftname=" + giftname + ", description=" + description + ", category="
				+ category + ", price=" + price + ", image=" + image + ", quantity=" + quantity + ", giftfor=" + giftfor
				+ ", occasions=" + occasions + ", fileType=" + fileType + ", file=" + file + "]";
	}

	



	
	
}


