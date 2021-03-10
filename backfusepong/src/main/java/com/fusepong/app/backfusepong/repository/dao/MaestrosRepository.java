package com.fusepong.app.backfusepong.repository.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fusepong.app.backfusepong.model.CambioEstado;
import com.fusepong.app.backfusepong.model.DetalleTicket;
import com.fusepong.app.backfusepong.model.Empresa;
import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Ticket;
import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.repository.IMaestros;

@Repository
public class MaestrosRepository implements IMaestros {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class EmpresaRowMapper implements RowMapper<Empresa> {
		@Override
		public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException {
			Empresa empresa = new Empresa();
			empresa.setIdEmpresa(rs.getInt("idempresa"));
			empresa.setNombre(rs.getString("nombre"));
			empresa.setDireccion(rs.getString("direccion"));
			empresa.setEmail(rs.getString("email"));
			empresa.setNit(rs.getString("nit"));
			empresa.setTelefono(rs.getString("telefono"));
			return empresa;
		}
	}

	class TicketRowMapper implements RowMapper<Ticket> {
		@Override
		public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
			Ticket ticket = new Ticket();
			ticket.setIdTickect(rs.getInt("idticket"));
			ticket.setIdEstado(rs.getInt("idestado"));
			ticket.setNombre(rs.getString("nombre"));
			ticket.setColor(rs.getString("color"));
			ticket.setEstado(rs.getString("estado"));
			return ticket;
		}
	}
	
	class DetalleTicketRowMapper implements RowMapper<DetalleTicket> {
		@Override
		public DetalleTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
			DetalleTicket ticket = new DetalleTicket();
			ticket.setIdDetalleTickect(rs.getInt("iddetalle_ticket"));
			ticket.setComentario(rs.getString("comentario"));
			ticket.setIdTicket(rs.getInt("idticket"));
			ticket.setIdEstado(rs.getInt("idestado"));
			ticket.setFecha(rs.getDate("fecha"));
			ticket.setColor(rs.getString("color"));
			ticket.setEstado(rs.getString("estado"));
			return ticket;
		}
	}

	class MaestroRowMapper implements RowMapper<IdNombre> {
		@Override
		public IdNombre mapRow(ResultSet rs, int rowNum) throws SQLException {
			IdNombre idNombre = new IdNombre();
			idNombre.setId(rs.getInt("id"));
			idNombre.setNombre(rs.getString("nombre"));
			return idNombre;
		}
	}

	@SuppressWarnings("deprecation")
	public List<Empresa> getEmpresas() {
		return jdbcTemplate.query("select * from bdfusepong.empresa e", new EmpresaRowMapper());
	}

	@SuppressWarnings("deprecation")
	public List<IdNombre> getProyectos(int idEmpresa) {
		return jdbcTemplate.query(
				"select p.idproyecto as id, p.nombre from bdfusepong.proyecto p where p.idempresa = ?",
				new Object[] { idEmpresa }, new MaestroRowMapper());
	}

	@SuppressWarnings("deprecation")
	public List<IdNombre> getHistoriaUsuarios(int idProyecto) {
		return jdbcTemplate.query(
				"select hu.idhistoria_usuario as id, hu.nombre from bdfusepong.historia_usuario hu where hu.idproyecto = ?",
				new Object[] { idProyecto }, new MaestroRowMapper());
	}

	@SuppressWarnings("deprecation")
	public List<Ticket> getTickets(int idHistoriaUsuario) {
		return jdbcTemplate.query(
				"select t.idticket, t.nombre, e.idestado, e.nombre as estado, e.color from bdfusepong.ticket t LEFT JOIN bdfusepong.estado e ON e.idestado = t.idestado where t.idhistoria_usuario = ? ",
				new Object[] { idHistoriaUsuario }, new TicketRowMapper());
	}
	
	@SuppressWarnings("deprecation")
	public List<DetalleTicket> getDetallesTicket(int idTicket) {
		return jdbcTemplate.query(
				"select t.*, e.nombre as estado, e.color from bdfusepong.detalle_ticket t LEFT JOIN bdfusepong.estado e ON e.idestado = t.idestado where t.idticket = ? ",
				new Object[] { idTicket }, new DetalleTicketRowMapper());
	}

	@SuppressWarnings("deprecation")
	public List<IdNombre> getEstado(Integer idEstado) {
		if (idEstado != null && idEstado != 0) {
			return jdbcTemplate.query("select e.idestado as id, e.nombre from bdfusepong.estado e where e.idestado > ?",
					new Object[] { idEstado }, new MaestroRowMapper());
		} else {
			return jdbcTemplate.query("select e.idestado as id, e.nombre from bdfusepong.estado e",
					new MaestroRowMapper());
		}
	}
	
	public int cambioEstado(CambioEstado cambio) {
		int detalle = jdbcTemplate.update(
				"insert into bdfusepong.detalle_ticket (comentario,fecha,idestado,idticket) "
						+ "values(?, ?, ?, ?)",
				new Object[] { cambio.getComentario(), new Date(),cambio.getIdEstado(),cambio.getIdTickect() });
		return jdbcTemplate.update(
				"UPDATE bdfusepong.ticket t SET t.idestado=? WHERE t.idticket=? ",
				new Object[] {  cambio.getIdEstado(), cambio.getIdTickect() });
	}
	

}
