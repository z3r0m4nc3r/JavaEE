package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Candidato;
@Service
public class CandidatosServiceImpl implements CandidatosService {
	@Autowired
	JdbcTemplate template;
	@Override
	public void altaCandidato(Candidato candidato) {
		
		String sql="Insert into candidatos(nombre,edad,puesto,foto,email) values(?,?,?,?,?)";
		template.update(sql, candidato.getNombre(),
							candidato.getEdad(),
							candidato.getPuesto(),
							candidato.getFoto(),
							candidato.getEmail());
		
		
	}
	
	@Override
	public void eliminarCandidato(int idCandidato) {
		String sql="delete from candidatos where idCandidato=?";
		template.update(sql,idCandidato);
	}
	
	@Override
	public List<Candidato> recuperarCandidatos(){
		
		String sql="select * from candidatos";
		return template.query(sql, (rs,f)->new Candidato(rs.getInt("idCandidato"), 
				rs.getString("nombre"), 
				rs.getInt("edad"), 
				rs.getString("puesto"), 
				rs.getString("foto"), 
				rs.getString("email")));
		
		
	}
}
