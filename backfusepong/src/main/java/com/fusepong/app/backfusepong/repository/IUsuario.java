package com.fusepong.app.backfusepong.repository;

import java.util.List;
import java.util.Optional;

import com.fusepong.app.backfusepong.model.Usuario;

public interface IUsuario {
	
	public int insert(Usuario usuario);
	
	public List<Usuario> findUsuario(String email, String pass);
}
