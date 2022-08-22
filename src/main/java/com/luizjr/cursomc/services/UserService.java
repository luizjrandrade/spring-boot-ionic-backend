package com.luizjr.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.luizjr.cursomc.security.UserSS;

//public pois podera ser chamado indepente de ser instanciado
public class UserService {
	
	public static UserSS authenticated() {
		//retorna user logado no sistema e cactch para proteger a sessão
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
