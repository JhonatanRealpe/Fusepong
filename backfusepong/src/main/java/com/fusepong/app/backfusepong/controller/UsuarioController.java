package com.fusepong.app.backfusepong.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.service.UsuarioService;

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/insert")
	private int insert(@RequestBody Usuario usuario) {
		return service.insert(usuario);

	}
	
	@PostMapping("/login")
	private List<Usuario> login(@RequestBody Usuario usuario) {
		return service.login(usuario);
	}

}
