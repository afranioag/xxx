package com.ajude.ajude.entity;

import java.util.LinkedList;

//import Psoft.demo.Entity.Comentario;

public class Comentario {
	private String autor_email;
	private String comentario;
	private LinkedList<Comentario> comentarios;
	private Boolean status;
	
	public Comentario(String autor_email, String comentario) {
		super();
		comentarios = new LinkedList<Comentario>();
		this.status = true;
	}
	
	public Comentario() {
		super();
	}
	
	public void setStatus() {
		this.status = false;
	}
	
	public String getAutor_email() {
		return autor_email;
	}
	
//	public void setAutor_email(String autor_email) {
//		this.autor_email = autor_email;
//	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public LinkedList<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(LinkedList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor_email == null) ? 0 : autor_email.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Comentario other = (Comentario) obj;
		if (autor_email == null) {
			if (other.autor_email != null)
				return false;
		} else if (!autor_email.equals(other.autor_email))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	

}
