package com.exam.examserver.entity;

import org.springframework.stereotype.Service;

public class JwtResponse {

	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtResponse(String token) {
		this.token = token;
	}

	public JwtResponse() {

	}

}
