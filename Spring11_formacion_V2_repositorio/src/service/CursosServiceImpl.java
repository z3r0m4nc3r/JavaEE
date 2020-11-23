package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Curso;
import repository.AlumnosRepository;
import repository.CursosRepository;
@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosRepository cursosRepository;
	@Autowired
	AlumnosRepository alumnosRepository;
	
	@Override
	public void altaCurso(Curso curso) {
		if(cursosRepository.cursoPorId(curso.getIdCurso())==null) {
			cursosRepository.altaCurso(curso);
		}
		
	}

	@Override
	public List<Curso> obtenerCursos() {
		return cursosRepository.todosCursos();
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		if(alumnosRepository.buscarAlumnoPorUsuario(usuario)!=null) {
			return cursosRepository.cursosAlumno(usuario);
		}else return null;
	}

	@Override
	public List<Curso> cursosDisponibles(String usuario) {
		if(alumnosRepository.buscarAlumnoPorUsuario(usuario)!=null) {
			return cursosRepository.cursosDisponiblesAlumno(usuario);
		}else return null;
	}

	@Override
	public Curso recuperarCurso(int idCurso) {
		if(cursosRepository.cursoPorId(idCurso)!=null) {
			return cursosRepository.cursoPorId(idCurso);
		}else return null;
	}
	
}
