package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.modelo.User;
import com.example.demo.repositorio.IUser;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	private IUser data;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = data.getUserByemail(email);
		
		if (user == null)
			throw new UsernameNotFoundException("Could not find user");
		
		return new MyUserDetails(user);
	}

}
