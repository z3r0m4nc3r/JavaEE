package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import model.Matricula;
import repository.port.AlumnosRepository;
import repository.port.CursosRepository;

@Service
public class MatriculasServiceImpl implements MatriculasService {
	@Autowired	
	CursosRepository cursosRepository;
	@Autowired	
	AlumnosRepository alumnosRepository;
	@Override
	public void matricularAlumno(String usuario, int idCurso) {
		Curso curso=cursosRepository.cursoPorId(idCurso);
		Alumno alumno=alumnosRepository.buscarAlumnoPorUsuario(usuario);
		if(alumno!=null&&curso!=null) {
			curso.getAlumnos().add(alumno);
			cursosRepository.actualizarCurso(curso);
		}
	}
	@Override
	public List<Matricula> consultarMatriculas(String f1, String f2) {		
		try {
			Date fIni = (new SimpleDateFormat("yyyy-MM-dd")).parse(f1);
			Date fFin=(new SimpleDateFormat("yyyy-MM-dd")).parse(f2);
			if(fIni.before(fFin)) {
				List<Curso> cursos= cursosRepository.cursosEntreFechas(fIni, fFin);
				return cursos.stream()
						.flatMap(curso->curso.getAlumnos()
											.stream()
											.map(alumno->new Matricula(curso,alumno)))
						.collect(Collectors.toList());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
