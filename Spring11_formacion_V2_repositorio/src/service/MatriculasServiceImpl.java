package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import repository.AlumnosRepository;
import repository.CursosRepository;
@Service
public class MatriculasServiceImpl implements MatriculasService {

	@Autowired
	CursosRepository cursosRepository;
	@Autowired
	AlumnosRepository alumnosRepository;
	
	@Override
	public void MatricularAlumno(String usuario, int idCurso) {
		Curso curso = cursosRepository.cursoPorId(idCurso);
		Alumno alumno = alumnosRepository.buscarAlumnoPorUsuario(usuario);
		
		if(alumno!=null&&curso!=null) {
			alumno.getCursos().add(curso);
			curso.getAlumnos().add(alumno);
			alumnosRepository.actualizarAlumno(alumno);
		}

	}

}
