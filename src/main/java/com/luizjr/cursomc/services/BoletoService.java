package com.luizjr.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.luizjr.cursomc.domain.PgtoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPgtoComBoleto(PgtoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7); //acrescenta 7 dias
		pagto.setDataVencimento(cal.getTime());
	}

}
