package com.luizjr.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luizjr.cursomc.services.DBService;
import com.luizjr.cursomc.services.EmailService;
import com.luizjr.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	//quando instacia dessa forma, fica como componente para o sistema
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
