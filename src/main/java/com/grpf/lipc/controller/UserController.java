package com.grpf.lipc.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;



import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grpf.lipc.entities.Person;
import com.grpf.lipc.entities.User;
import com.grpf.lipc.exception.DataNotFoundException;
import com.grpf.lipc.exception.UserValidate;
import com.grpf.lipc.service.MapValidationErrorService;
import com.grpf.lipc.service.PersonService;
import com.grpf.lipc.service.UserService;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins= "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  PersonService personService;
	
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/{id}")
//	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public User getUserById(@PathVariable("id") int id) {
		return userService.findUserById(id);
	}
	
	
	@GetMapping("/email/{email}")
//	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.findUserByEmail(email);
	}
	
	
	
	@GetMapping("/getAllUsers")
//	@Path("/getAllUsers")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getAllUser(){
		return userService.findAllUsers();
	}
	
	
	@PostMapping("/add")
	@ResponseBody
//	@Path("/add")
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<User> addUser(@Valid @RequestBody User user, BindingResult result) {
		
		
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return (ResponseEntity<User>) errorMap;
		UserValidate validateUser=new UserValidate();
		
		boolean emailVal=validateUser.validateUser(user.getEmail());

		boolean passwordVal=validateUser.validatePassword(user.getPassword(), user.getEmail());
		
		try {
		
		if(emailVal) {
			if(passwordVal) {
				try {
					
				
				
			
				userService.addUser(user); 
//				User u=userService.findUserById(user.getUserId());
			
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				throw new DataNotFoundException("Enter Valid Password");
			}
			
		}
		else {
			throw new DataNotFoundException("Enter valid Email ID");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		
//		return ResponseEntity.accepted().body("Registered Successfully");
		
	}
	
	
	@PutMapping("/updateuser")
//	@Path("/updateuser")
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, BindingResult result) {
		
		User u=userService.findUserById((int)user.getUserId());
		
		u.setUserId(user.getUserId());
		
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		
		userService.updateUser(u);
		
		return new ResponseEntity<>(u, HttpStatus.CREATED);
		
//		return Response.status(Status.OK).entity("Successfully Updated").build();
	}
	
	
	@DeleteMapping("/delete/{id}")
//	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return Response.status(Status.OK).entity("Successfully Deleted").build();
	}
	
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<String> findDataByMailId(@PathVariable("email") String email,@PathVariable("password") String password) {
		User data=userService.findUserByEmail(email);
		UserValidate validateUser=new UserValidate();
		boolean emailVal=validateUser.validateUser(email);
//		System.out.println(emailVal);
		boolean passwordVal=validateUser.validatePassword(password, email);
//		System.out.println(passwordVal);
		
		try {
		if(emailVal) {
			if(passwordVal) {
			
		if(data!=null)
			
		{
//			System.out.println(data.getPassword()+" "+password+" "+data.getEmail()+" "+email);
			
			if(data.getPassword().equals(password)&& data.getEmail().equals(email))
			{
				return ResponseEntity.ok().body("UserLoginSuccess");
			}
			else
			{
				throw new DataNotFoundException("Enter correct password");
			}}
		else
		{
			throw new DataNotFoundException("Enter correct password with atleast special character");
			
		}
		}}else
		{
			throw new DataNotFoundException("Enter UserId correctly");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.accepted().body("Enter valid userId or mailId");
		
	}
	
	

}
