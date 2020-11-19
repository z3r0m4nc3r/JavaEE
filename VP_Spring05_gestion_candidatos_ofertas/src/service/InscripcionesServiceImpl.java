package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Candidato;
import model.Inscripcion;
@Service
public class InscripcionesServiceImpl implements InscripcionesService {
	@Autowired
	JdbcTemplate template;
	@Override
	public void registrarInscripcion(Inscripcion inscripcion) {
		String sql="Insert into inscripciones(empresa,posicion,salario,idCandidato) values(?,?,?,?)";
		template.update(sql, inscripcion.getEmpresa(),
				inscripcion.getPosicion(),
				inscripcion.getSalario(),
				inscripcion.getCandidato().getIdCandidato());

	}

	@Override
	public List<Inscripcion> obtenerInscripciones() {
		String sql="select * from inscripciones,candidatos where ";
		sql+="inscripciones.idCandidato=candidatos.idCandidato";
		return template.query(sql, (rs,f)->new Inscripcion(rs.getInt("inscripciones.idInscripcion"), 
				rs.getString("inscripciones.empresa"), 
				rs.getString("inscripciones.posicion"), 
				rs.getDouble("inscripciones.salario"), 
				new Candidato(rs.getInt("candidatos.idCandidato"),
						rs.getString("candidatos.nombre"),
						rs.getInt("candidatos.edad"),
						rs.getString("candidatos.puesto"),
						rs.getString("candidatos.email"),
						rs.getString("candidatos.foto"))));
	}

}
