package com.fusepong.app.backfusepong.model;

import java.util.Date;

public class DetalleTicket {
	private int idDetalleTickect;
	private String comentario;
	private Date fecha;
	private int idEstado;
	private int idTicket;
	private String estado;
	private String color;
	
	public DetalleTicket() {

	}

	public DetalleTicket(int idDetalleTickect, String comentario, Date fecha, int idEstado, int idTicket) {
		this.idDetalleTickect = idDetalleTickect;
		this.comentario = comentario;
		this.fecha = fecha;
		this.idEstado = idEstado;
		this.idTicket = idTicket;
	}

	public int getIdDetalleTickect() {
		return idDetalleTickect;
	}

	public void setIdDetalleTickect(int idDetalleTickect) {
		this.idDetalleTickect = idDetalleTickect;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
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
