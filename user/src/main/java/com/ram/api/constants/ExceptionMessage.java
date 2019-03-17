package com.ram.api.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="file:/home/ramApi/exceptionMessage.properties")
public class ExceptionMessage {
	
	@Value("${exception.USER_NOT_FOUND_MSG}")
	public static String USER_NOT_FOUND_MSG;
	
	@Value("${exception.EMAIL_ALREADY_EXISTS}")
	public static String EMAIL_ALREADY_EXISTS;
	
	@Value("${exception.ADRESS_NOT_FOUND}")
	public static String ADRESS_NOT_FOUND;

}
