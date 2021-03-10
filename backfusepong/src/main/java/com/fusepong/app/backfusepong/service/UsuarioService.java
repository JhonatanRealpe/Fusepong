package com.fusepong.app.backfusepong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.repository.IUsuario;

@Service
public class UsuarioService {
	
	@Autowired
	IUsuario repository;
	
	public int insert(Usuario usuario) {
		return repository.insert(usuario);
	}
	
	public List<Usuario> login(Usuario usuario) {
		return repository.findUsuario(usuario.getEmail(), usuario.getContrasena());
	}

}
