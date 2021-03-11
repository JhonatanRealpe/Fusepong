package com.fusepong.app.backfusepong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusepong.app.backfusepong.model.CambioEstado;
import com.fusepong.app.backfusepong.model.DetalleTicket;
import com.fusepong.app.backfusepong.model.Empresa;
import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Ticket;
import com.fusepong.app.backfusepong.repository.IMaestros;

@Service
public class MaestrosService {

	@Autowired
	IMaestros repository;
	
	public List<Empresa> getEmpresa(){
		return repository.getEmpresas();
	}
	
	public List<IdNombre> getProyectos(int idEmpresa){
		return repository.getProyectos(idEmpresa);
	}
	
	public List<IdNombre> getHistoriaUsuario(int idProyecto){
		return repository.getHistoriaUsuarios(idProyecto);
	}
	
	public List<Ticket> getTicket(int idHistoriaUsuario){
		return repository.getTickets(idHistoriaUsuario);
	}
	
	public List<DetalleTicket> getDetalleTicket(int idTicket){
		return repository.getDetallesTicket(idTicket);
	}
	
	public List<IdNombre> getEstado(Integer idEstado){
		return repository.getEstado(idEstado);
	}
	
	public int cambioEstado(CambioEstado cambioEstado){
		return repository.cambioEstado(cambioEstado);
	}
	
	public int addHistoriaUsuario(IdNombre hUsuario){
		return repository.addHistoriaUsuario(hUsuario);
	}
	
	public int addTicket(IdNombre ticket){
		return repository.addTicket(ticket);
	}
}
