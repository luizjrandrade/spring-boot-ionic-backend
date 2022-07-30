package com.luizjr.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizjr.cursomc.domain.PgtoComBoleto;
import com.luizjr.cursomc.domain.PgtoComCartao;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PgtoComCartao.class);
				objectMapper.registerSubtypes(PgtoComBoleto.class);
				super.configure(objectMapper);
			};
		};
		return builder;
	}
	
	@Bean
	public JavaMailSender jMS (){
		return new JavaMailSenderImpl();
	}

}
