package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.config.JwtTokenUtil;
import com.cybage.model.JwtRequest;
import com.cybage.model.JwtResponse;
import com.cybage.model.UserDTO;
import com.cybage.service.UserRegistrationService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {
	
/*	@Autowired(required=true)
	private UserRegistrationService userRegistrationService;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> registerUser(@RequestBody User users)
	{
		User user=userRegistrationService.addUser(users);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/getusers")
	public Iterable<User> getAllUsers(){
	return userRegistrationService.getUserList();
	}
	
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }*/
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRegistrationService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("*********************"+token);

		return ResponseEntity.ok(new JwtResponse(token));
		
		/*final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("*********************"+token.length());
		System.out.println("*******************");
		//Map<String,String> map=new HashMap<String,String>();
		List<String> list=new ArrayList<>();
		System.out.println(userdao.findByUsername(jwtTokenUtil.getUsernameFromToken(token)).getRole());
		list.add(userdao.findByUsername(jwtTokenUtil.getUsernameFromToken(token)).getRole());
		list.add(token);
		//map.put("token", token);
		//System.out.println(userdao.findByUsername(authenticationRequest.getUsername()).getRole());
		//t.put("role", userdao.findByUsername(authenticationRequest.getUsername()).getRole());
		return ResponseEntity.ok(list);
		//return ResponseEntity.ok(new JwtResponse(token)+userdao.findByUsername(authenticationRequest.getUsername()).getRole());
	*/
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@RequestBody UserDTO user) throws Exception{
		System.out.println("in reg==============================");
		//return ResponseEntity.ok(userDetailsService.save(user));
		try{
			return userDetailsService.save(user);
		}
		catch(Exception e)
		{
			return "Something went wrong";		
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
