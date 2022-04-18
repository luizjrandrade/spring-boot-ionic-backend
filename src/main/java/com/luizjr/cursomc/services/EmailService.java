package com.luizjr.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.luizjr.cursomc.domain.Pedido;

public interface EmailService {
	
	//email de confirmação de pedidos
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
