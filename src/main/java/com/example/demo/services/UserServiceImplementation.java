package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepository;
@Service
public class UserServiceImplementation implements UsersServices{

	@Autowired
	UsersRepository repo;
	public String addUsers(Users user) {
		repo.save(user);
		return "Insertion "+user+"  done ";
	}
	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}

	}
	@Override
	public boolean validateUser(String email, String password) {    //task 3 checking, email and password matches
		 Users user= repo.findByEmail(email);                        //obtaining the data of user usign the existing user mail id
		                                                            //if the user with enter mail-id is present in the db,
		 String db_password=user.getPassword();                     //then repository returns an object of entity within which all attribues are presennt.
		if(db_password.equals(password)==true)                     //And also we have pasword provided by the user while loggin ,
		{                                                //using the entity object we have to get the password  by entitYObjectreference.getPassword();
			return true;                              //since the user entered password and Database password are string we will use equals() to compare
		}                                     //if entered pass and Database pass matches the it return true ,
		else
			{return false;}
	}
	@Override
	public String getRole(String email) {
		Users user = repo.findByEmail(email);
		   return   user.getRole();


	
	}
	@Override
	public Users getUser(String email) {
	 
		return repo.findByEmail(email);
	}
	@Override
	public void updateUser(Users user) {
		 repo.save(user);
		
	}
}