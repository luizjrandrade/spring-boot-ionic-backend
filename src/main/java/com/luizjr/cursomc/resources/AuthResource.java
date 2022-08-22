package com.luizjr.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luizjr.cursomc.security.JWTUtil;
import com.luizjr.cursomc.security.UserSS;
import com.luizjr.cursomc.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	//@Autowired - fornece controle sobre onde e como a ligação entre os beans deve ser realizada. 
	//Pode ser usado para em métodos setter, no construtor, em 
	//uma propriedade ou métodos com nomes arbitrários e / ou vários argumentos.
	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}

}
