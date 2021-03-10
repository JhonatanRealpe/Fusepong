package com.fusepong.app.backfusepong.repository;

import java.util.List;

import com.fusepong.app.backfusepong.model.CambioEstado;
import com.fusepong.app.backfusepong.model.Empresa;
import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Ticket;

public interface IMaestros {
	
	public List<Empresa> getEmpresas();
	
	public List<IdNombre> getProyectos(int idEmpresa);
	
	public List<IdNombre> getHistoriaUsuarios(int idProyecto);
	
	public List<Ticket> getTickets(int idHistoriaUsuario);
	
	public List<IdNombre> getDetallesTicket(int idTicket);
	
	public List<IdNombre> getEstado(Integer idEstado);
	
	public int cambioEstado(CambioEstado cambio);
	
}
