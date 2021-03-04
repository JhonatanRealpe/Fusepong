package com.fusepong.app.backfusepong.model;

public class Ticket {

	private int idTickect;
	private String nombre;
	private int idEstado;
	private String estado;
	private String color;

	public Ticket() {

	}

	public Ticket(int idTickect, String nombre, int idEstado, String estado, String color) {
		this.idTickect = idTickect;
		this.nombre = nombre;
		this.idEstado = idEstado;
		this.estado = estado;
		this.color = color;
	}

	public int getIdTickect() {
		return idTickect;
	}

	public void setIdTickect(int idTickect) {
		this.idTickect = idTickect;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

}
