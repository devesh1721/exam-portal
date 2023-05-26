package com.exam.examserver.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import com.exam.examserver.repository.UserRoleRepository;

@RestController
@RequestMapping("/current-user")
@CrossOrigin("*")
public class Demo {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	
	@GetMapping("/{username}")
	private User getUserDeatils(@PathVariable("username") String username) {
		System.out.println("Devesj");
		User user= this.userRepo.findByUsername(username);
		if(user == null)
			return null;
		return user;
	}
	
	
	@GetMapping("/getRole/{username}")
	private HashMap<String, String> getUserRole(@PathVariable("username") String username) {
		System.out.println("Devesj");
		User user= this.userRepo.findByUsername(username);
		if(user == null)
			return null;
		UserRole userRole =this.userRoleRepo.findByUserId(user.getId());
		HashMap<String, String> mp= new HashMap<>();
//		mp.put("role",userRole.getRole().getRoleName());
		mp.put("role","ADMIN");
		return mp;
	}
	
	
}