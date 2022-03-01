package com.luizjr.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.luizjr.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pgtoComCartao")
public class PgtoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numParcelas;
	
	public PgtoComCartao() {
	}

	public PgtoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numParcelas) {
		super(id, estado, pedido);
		this.setNumParcelas(numParcelas);
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}
	
	
}
