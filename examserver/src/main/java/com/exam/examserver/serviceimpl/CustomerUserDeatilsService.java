package com.exam.examserver.serviceimpl;

import java.util.ArrayList;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.repository.UserRepository;

@Service
public class CustomerUserDeatilsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User localUser = userRepository.findByUsername(username);
		if(localUser != null){
			return new org.springframework.security.core.userdetails.User(localUser.getUsername(),localUser.getPassword(), new ArrayList<>());		
		}else {
		   throw new UsernameNotFoundException("User not Found!!");
		}
		
	}

}
