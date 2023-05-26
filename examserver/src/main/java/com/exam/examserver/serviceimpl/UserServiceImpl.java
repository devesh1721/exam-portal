package com.exam.examserver.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import com.exam.examserver.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public User addUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User localUser = this.userRepository.findByUsername(user.getUsername());
		if(localUser != null) {
			System.out.println("User already exits");
			throw new Exception("User already present");
		}
		else {
			for(UserRole ur :userRoles) {
				this.roleRepository.save(ur.getRole());
			}
		}
		user.getUserRoles().addAll(userRoles);
		localUser = this.userRepository.save(user);
		return localUser;
	}
	
	@Override
	public User findUser(String username) {
		return this.userRepository.findByUsername(username);
	}
}
