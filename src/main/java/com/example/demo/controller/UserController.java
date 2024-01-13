package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {
	@Autowired
	UsersServices service;

	@PostMapping("/register")
	/*public String addUsers(@RequestParam("username") String username,
		@RequestParam("password") String password,@RequestParam("email") String email,
		@RequestParam("gender") String gender,
		@RequestParam("role") String role,@RequestParam("address") String address)
	 */	
	public String addUsers(@ModelAttribute Users user)
	{
		boolean user_status=service.emailExists(user.getEmail());  //task2
		if(user_status==false)                                      //task2
		{
			service.addUsers(user);                                      //task1
			System.out.println("user added successfully.");
		}
		else
		{
			System.out.println("User is already present");
		}
		                                 //System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getGender()+" "+user.getRole()+" "+user.getAddress());
		return "home";
	}
	@PostMapping("/validate")							//task4
	public String validate(@RequestParam("email") String email,
			@RequestParam("password")String password ,HttpSession session)//when we,ll collect the data in backend Requestparm is user , here login module has email and password 
	{
		if( service.validateUser(email,password)==true)
		{
			String role=service.getRole(email);
			
			session.setAttribute("email",email);//when session object is created it will be empty  not contatining any attribute we'hv to add the email attribute.
			
			if(role.equals("Admin"))
			{
				return "adminHome";
			}
			else {
				return "customerHome";
			}
		}
		else
		{
			return "login";
		}
	}

	@GetMapping("/pay")
	public String pay(String email) {
		boolean paymentStatus =false; // payment api
		
		if(paymentStatus == true) {
			Users user =service.getUser(email);
			user.setPremium(true); // instance varible of users.java
		 service.updateUser(user);	
		}
		return "pay";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();//session.invalidate() is nothing but the ending the session object;
		return "login";
	}
	
}

