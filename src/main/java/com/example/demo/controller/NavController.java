package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/login") //task3 
	public String login()
	{
		return "login";
	}
	@GetMapping("/registration")
	public String registration()
	{
		return "registration";
	}

	@GetMapping("/newSong")   //task4
	public String newSong( ) {
		return "newSong";
	}
	
}
 // for navigating the control to html files;