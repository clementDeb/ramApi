package com.ram.api.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ram.api.repositories.UserRepository;
import com.ram.api.service.PersonService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor=@__({@Autowired}))
public class LoginManager implements PasswordEncoder{
	
	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
	
	public boolean loginExist (String login, List<String> logins) {
		return logins.stream().anyMatch(l -> l.equals(login));
	}

}
