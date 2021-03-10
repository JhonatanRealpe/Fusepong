package com.fusepong.app.backfusepong.repository.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fusepong.app.backfusepong.model.IdNombre;
import com.fusepong.app.backfusepong.model.Usuario;
import com.fusepong.app.backfusepong.repository.IUsuario;
import com.fusepong.app.backfusepong.repository.dao.MaestrosRepository.MaestroRowMapper;

@Repository
public class UsuarioRepository implements IUsuario {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	class UsuarioRowMapper implements RowMapper<Usuario> {
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("idusuario"));
			usuario.setNombres(rs.getString("nombres"));
			usuario.setApellidos(rs.getString("apellidos"));
			usuario.setTelefono(rs.getString("telefono"));
			usuario.setEmail(rs.getString("email"));
			usuario.setContrasena(rs.getString("contrasena"));
			usuario.setNombreEmpresa(rs.getString("nombreempresa"));
			usuario.setIdEmpresa(rs.getInt("idempresa"));
			return usuario;
		}
	}

	
	@SuppressWarnings("deprecation")
	public List<Usuario> findUsuario(String email, String pass) {
		return jdbcTemplate.query(
				"select u.*, e.nombre as nombreempresa from bdfusepong.usuario u LEFT JOIN bdfusepong.empresa e ON e.idempresa = u.idempresa where u.email = ? and u.contrasena = ? ",
				new Object[] { email, pass }, new UsuarioRowMapper());
	}

	
	public int insert(Usuario usuario) {
		return jdbcTemplate.update(
				"insert into bdfusepong.usuario (nombres,apellidos,telefono,email,contrasena,idempresa) "
						+ "values(?, ?, ?, ?, ?, ?)",
				new Object[] { usuario.getNombres(), usuario.getApellidos(), usuario.getTelefono(), usuario.getEmail(),
						usuario.getContrasena(), usuario.getIdEmpresa() });
	}

}
