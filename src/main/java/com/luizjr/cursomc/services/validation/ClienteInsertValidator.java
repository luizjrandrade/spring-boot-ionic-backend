package com.luizjr.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.luizjr.cursomc.domain.Cliente;
import com.luizjr.cursomc.domain.enums.TipoCliente;
import com.luizjr.cursomc.dto.ClienteNewDTO;
import com.luizjr.cursomc.repositories.ClienteRepository;
import com.luizjr.cursomc.resources.exception.FieldMessage;
import com.luizjr.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		// testa o tipo do cliente
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfouCnpj())) {
			list.add(new FieldMessage("cpfouCnpj", "CPF inválido"));
		}

		// testa o tipo do cliente
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfouCnpj())) {
			list.add(new FieldMessage("cpfouCnpj", "CNPJ inválido"));
		}
		
		//Verifica se email já existe
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente!"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
