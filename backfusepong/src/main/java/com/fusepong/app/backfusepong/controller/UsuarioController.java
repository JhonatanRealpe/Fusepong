package com.fusepong.app.backfusepong.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/insert")
	private int insert(@RequestBody Usuario usuario) {
		return service.insert(usuario);

	}
	
	@GetMapping("/login")
	private Optional<Usuario> login(@RequestBody Usuario usuario) {
		return service.login(usuario);
	}

}
