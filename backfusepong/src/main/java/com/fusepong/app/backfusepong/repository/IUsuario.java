package com.fusepong.app.backfusepong.repository;

import java.util.Optional;

import com.fusepong.app.backfusepong.model.Usuario;

public interface IUsuario {
	
	public int insert(Usuario usuario);
	
	public Optional<Usuario> findUsuario(String email, String pass);
}
