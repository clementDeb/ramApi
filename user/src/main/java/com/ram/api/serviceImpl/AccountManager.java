package com.ram.api.serviceImpl;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountManager implements PasswordEncoder{
	
	private final BCryptPasswordEncoder ENCODER;
	
	public AccountManager() {
		ENCODER = new BCryptPasswordEncoder();
	}

	@Override
	public String encode(CharSequence rawPassword) {
		return ENCODER.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return ENCODER.matches(rawPassword, encodedPassword);
	}
	
	public boolean loginExist (String login, List<String> logins) {
		return logins.stream().anyMatch(l -> l.equals(login));
	}

}
