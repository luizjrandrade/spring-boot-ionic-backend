package com.luizjr.cursomc.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		//caso for nulo
		if (cod == null) {
			return null;
		}
		
		// todo objeto X nos valores possiveis
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		//se esgotar o FOR, e não 1 ou 2, código invalido!
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	

}
