package com.ajude.ajude.entity;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UsuarioEntity {
	@Id
	private String email;
	private String primeroNome;
	private String ultimoNome;
	private String senha;
	private int cartaoDeCredito;
	private ArrayList<CampanhaEntity> campanhas = new ArrayList<>();
	
	public UsuarioEntity(String primeroNome, String ultimoNome, String email, String senha, int cartaoDeCredito) {
		this.primeroNome = primeroNome;
		this.ultimoNome = ultimoNome;
		this.cartaoDeCredito = cartaoDeCredito;
		this.email = email;
		this.senha = senha;
	}
	
	public void addCampanhas(CampanhaEntity campanha) {
		campanhas.add(campanha);
	}
	
	public String getPrimeroNome() {
		return primeroNome;
	}
	
	public void setPrimeroNome(String primeroNome) {
		this.primeroNome = primeroNome;
	}
	
	public String getUltimoNome() {
		return ultimoNome;
	}
	
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getCartaoDeCredito() {
		return cartaoDeCredito;
	}
	
	public void setCartaoDeCredito(int cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList getCampanhas() {
		return campanhas;
	}
	
	public void setCampanhas(ArrayList campanhas) {
		this.campanhas = campanhas;
	}

	//hashcode e equals -> cartaocredito, email, senha
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartaoDeCredito;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		if (cartaoDeCredito != other.cartaoDeCredito)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	
}
