package com.ajude.ajude.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CampanhaEntity {
	@NotBlank
	//@Column(nullable = false)
	@Id
	//@OneToOne(cascade=CascadeType.ALL)
	private int id;
	//@NotBlank
	//@Column(nullable = false)
	private String nomeCurto;
	//@NotBlank
	//@Column(nullable = false)
	private String URLUnico;
	//@NotBlank
	//@Column(nullable = false)
	private String descricao;
	//@NotBlank
	//@Column(nullable = false)
	private Date deadLine;
	//@NotBlank
	//@Column(nullable = false)
	private String status;
	//@NotBlank
	//@Column(nullable = false)
	private float metaValor;
//	@NotBlank
	//@Column(nullable = false)
	private LinkedList<Double> doacoes;
	//@NotBlank
	//@Column(nullable = false)
	private String dono;
	//@Column(nullable = false)
	private LinkedList<Comentario> comentarios;
	//@NotBlank
	//@Column(nullable = false)
	private boolean like;
	//@NotBlank
	//@Column(nullable = false)
	private Double valorArrecadado = 0.0;
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public CampanhaEntity(int id, String nome, String URL, String descricao, String deadLine, String status, float valor, String dono) throws ParseException {
		this.id = id;
		this.nomeCurto = nome;
		this.URLUnico = URL;
		this.descricao = descricao;
		this.deadLine = formato.parse(deadLine);
		this.doacoes = new LinkedList<>();
		this.dono = dono;
		this.comentarios = new LinkedList<Comentario>();
	}
	
	public int getId() {
		return id;
	}

	public String getNomeCurto() {
		return nomeCurto;
	}

	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}

	public String getURLUnico() {
		return URLUnico;
	}

	public void setURLUnico(String uRLUnico) {
		URLUnico = uRLUnico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) throws ParseException {
		this.deadLine = formato.parse(deadLine);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getMetaValor() {
		return metaValor;
	}

	public void setMetaValor(float metaValor) {
		this.metaValor = metaValor;
	}

	public LinkedList<Double> getDoacoes() {
		return doacoes;
	}

	public void doar(Double doa) {
		this.doacoes.add(doa);
		this.valorArrecadado += doa;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public LinkedList<Comentario> getComentarios() {
		return comentarios;
	}
//
//	public void setComentarios(Comentario comentarios) {
//		this.comentarios = comentarios;
//	}

	public boolean getLike() {
		return like;
	}
	
	public void setLike(boolean like) {
		this.like = like;
	}
	
	public void comenta(String comentario, String autor) {
		Comentario coment = new Comentario(comentario, autor);
		this.comentarios.add(coment);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URLUnico == null) ? 0 : URLUnico.hashCode());
		result = prime * result + id;
		result = prime * result + ((nomeCurto == null) ? 0 : nomeCurto.hashCode());
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
		CampanhaEntity other = (CampanhaEntity) obj;
		if (URLUnico == null) {
			if (other.URLUnico != null)
				return false;
		} else if (!URLUnico.equals(other.URLUnico))
			return false;
		if (id != other.id)
			return false;
		if (nomeCurto == null) {
			if (other.nomeCurto != null)
				return false;
		} else if (!nomeCurto.equals(other.nomeCurto))
			return false;
		return true;
	}	
}
