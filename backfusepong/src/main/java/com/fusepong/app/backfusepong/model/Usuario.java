package com.fusepong.app.backfusepong.model;

public class Usuario {
	
	private int idUsuario;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String email;
	private String contrasena;
	private String nombreEmpresa;
	private int idEmpresa;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsuario, String nombres, String apellidos, String telefono, String email, String contrasena,
			int idEmpresa) {
		
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.contrasena = contrasena;
		this.idEmpresa = idEmpresa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	
	

}
