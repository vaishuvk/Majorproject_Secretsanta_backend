package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.exception.UserAlreadyExistException;
import com.cybage.model.User;
import com.cybage.model.UserDTO;
import com.cybage.repository.UserRepository;

/*import com.javainuse.dao.UserDao;//repositorty in my project
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;*/
@Service
public class UserRegistrationService implements UserDetailsService {
	/*
	 * @Autowired private UserRepository userRepository;
	 * 
	 * public User addUser(User user) { return userRepository.save(user);
	 * 
	 * }
	 * 
	 * public List<User> getUserList() { return userRepository.findAll(); }
	 */

	@Autowired
	private UserRepository userDao;
	@Autowired
	private UserRepository userrep;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public String save(UserDTO user) throws UserAlreadyExistException {

		System.out.println("in save sevice==============================");
		User newUser = new User();
		//User currentUser= userDao.findByUsername(user.getUsername());
//		if (currentUser.equals(null)) {
//			return "User Already Exist";
//			
//		} 
//		else {			
//			newUser.setUserame(user.getUsername());
//			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//			newUser.setEmail(user.getEmail());
//			newUser.setPhoneno(user.getPhoneno());
//			newUser.setRole(user.getRole());
//			User u = userrep.save(newUser);
//			System.out.println("user is-----------------" + u);
//			return "User Registered";
//		}
		newUser.setUserame(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setPhoneno(user.getPhoneno());
		newUser.setRole(user.getRole());
		User u = userrep.save(newUser);
		System.out.println("user is-----------------" + u);
		return "User Registered Sucessfully";

	}
}
