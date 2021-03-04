package com.fusepong.app.backfusepong.model;

public class Empresa {
	
	private int idEmpresa;
	private String nombre;
	private String nit;
	private String telefono;
	private String email;
	private String direccion;
	
	public Empresa() {
		
	}

	public Empresa(int idEmpresa, String nombre, String nit, String telefono, String email, String direccion) {
		
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.nit = nit;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
