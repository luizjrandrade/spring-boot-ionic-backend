package com.luizjr.cursomc.domain;

import javax.persistence.Entity;

import com.luizjr.cursomc.domain.enums.EstadoPagamento;

@Entity
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
