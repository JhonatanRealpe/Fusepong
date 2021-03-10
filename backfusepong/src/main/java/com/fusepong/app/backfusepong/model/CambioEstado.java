package com.fusepong.app.backfusepong.model;

public class CambioEstado {
	private int idTickect;
	private int idEstado;
	private String comentario;
	
	public CambioEstado() {

	}

	public CambioEstado(int idTickect, int idEstado, String comentario) {
		this.idTickect = idTickect;
		this.idEstado = idEstado;
		this.comentario = comentario;
	}

	public int getIdTickect() {
		return idTickect;
	}

	public void setIdTickect(int idTickect) {
		this.idTickect = idTickect;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	

}
