package com.fusepong.app.backfusepong.repository.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fusepong.app.backfusepong.model.Empresa;
import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Ticket;
import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.repository.IMaestros;

public class MaestrosRepository implements IMaestros {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Empresa> getEmpresas() {
		return Optional.of(jdbcTemplate.queryForObject("select * from bdfusepong.empresa e",
				new Object[] { }, new BeanPropertyRowMapper<Empresa>(Empresa.class)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<IdNombre> getProyectos(int idEmpresa) {
		return Optional.of(jdbcTemplate.queryForObject("select p.idproyecto as id, p.nombre from bdfusepong.proyecto p where p.idempresa = ?",
				new Object[] { idEmpresa }, new BeanPropertyRowMapper<IdNombre>(IdNombre.class)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<IdNombre> getHistoriaUsuarios(int idProyecto) {
		return Optional.of(jdbcTemplate.queryForObject("select hu.idhistoria_usuario as id, hu.nombre from bdfusepong.historia_usuario hu where hu.idproyecto = ?",
				new Object[] { idProyecto }, new BeanPropertyRowMapper<IdNombre>(IdNombre.class)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Ticket> getTickets(int idHistoriaUsuario) {
		return Optional.of(jdbcTemplate.queryForObject("select t.idticket, t.nombre, e.idestado, e.nombre as estado, e.color from bdfusepong.ticket t LEFT JOIN bdfusepong.estado e ON e.idestado = t.idestado where t.idhistoria_usuario = ? ",
				new Object[] { idHistoriaUsuario }, new BeanPropertyRowMapper<Ticket>(Ticket.class)));
	}

	@Override
	public Optional<IdNombre> getDetallesTicket(int idTicket) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Optional<IdNombre> getEstado(Integer idEstado) {
		if(idEstado != null) {
			return Optional.of(jdbcTemplate.queryForObject("select e.idestado as id, e.nombre from bdfusepong.estado e where e.idestado > ?",
					new Object[] { idEstado }, new BeanPropertyRowMapper<IdNombre>(IdNombre.class)));
		}else {
			return Optional.of(jdbcTemplate.queryForObject("select e.idestado as id, e.nombre from bdfusepong.estado e",
					new Object[] {  }, new BeanPropertyRowMapper<IdNombre>(IdNombre.class)));
		}
	}

}
