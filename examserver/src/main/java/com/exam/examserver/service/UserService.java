package com.exam.examserver.service;

import java.util.Set;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;

public interface UserService {

	public User addUser(User user, Set<UserRole>userRoles) throws Exception;
	public User findUser(String username);


}
