package com.fusepong.app.backfusepong.repository;

import java.util.Optional;

import com.fusepong.app.backfusepong.model.Empresa;
import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Ticket;

public interface IMaestros {
	
	public Optional<Empresa> getEmpresas();
	
	public Optional<IdNombre> getProyectos(int idEmpresa);
	
	public Optional<IdNombre> getHistoriaUsuarios(int idProyecto);
	
	public Optional<Ticket> getTickets(int idHistoriaUsuario);
	
	public Optional<IdNombre> getDetallesTicket(int idTicket);
	
	public Optional<IdNombre> getEstado(Integer idEstado);
	
}
