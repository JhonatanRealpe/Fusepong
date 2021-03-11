package com.fusepong.app.backfusepong.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fusepong.app.backfusepong.model.CambioEstado;
import com.fusepong.app.backfusepong.model.DetalleTicket;
import com.fusepong.app.backfusepong.model.Empresa;
import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Ticket;
import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.service.MaestrosService;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("api/maestros")
public class MaestrosController {
	
	@Autowired
	MaestrosService maestrosService;
	
	@GetMapping("/empresas")
	private List<Empresa> getEmpresas() {
		return maestrosService.getEmpresa();
	}
	
	@GetMapping("/proyecto/{id}")
	private List<IdNombre> getProyecto(@PathVariable("id") Integer idEmpresa) {
		return maestrosService.getProyectos(idEmpresa);
	}
	
	@GetMapping("/historiausuario/{id}")
	private List<IdNombre> getHistoriaUsuario(@PathVariable("id") Integer idProyecto) {
		return maestrosService.getHistoriaUsuario(idProyecto);
	}
	
	@GetMapping("/ticket/{id}")
	private List<Ticket> getTicket(@PathVariable("id") Integer idHistoriaUsuario) {
		return maestrosService.getTicket(idHistoriaUsuario);
	}
	
	@GetMapping("/detalleticket/{id}")
	private List<DetalleTicket> getDetalleTicket(@PathVariable("id") Integer idTicket) {
		return maestrosService.getDetalleTicket(idTicket);
	}
	
	@GetMapping("/estado/{id}")
	private List<IdNombre> getEstado(@PathVariable("id") Integer idEstado) {
		return maestrosService.getEstado(idEstado);
	}
	
	@PostMapping("/cambioestado")
	private int cambioEstado(@RequestBody CambioEstado cambioEstado) {
		return maestrosService.cambioEstado(cambioEstado);

	}
	
	@PostMapping("/addhitoriausuario")
	private int addhitoriausuario(@RequestBody IdNombre hUsuario) {
		return maestrosService.addHistoriaUsuario(hUsuario);

	}
	
	@PostMapping("/addticket")
	private int addticket(@RequestBody IdNombre ticket) {
		return maestrosService.addTicket(ticket);

	}

}
