package repository.adapter.entity;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import model.Alumno;
import model.Curso;

public class Utilidades {
	public static Alumno alumnoBuilder(AlumnoEntity alumnoEntity) {
		return new Alumno(alumnoEntity.getUsuario(),
				alumnoEntity.getEdad(),
				alumnoEntity.getEmail(),
				alumnoEntity.getNombre(),
				alumnoEntity.getPassword());
	}
	public static AlumnoEntity alumnoEntityBuilder(Alumno alumno) {
		AlumnoEntity entity=new AlumnoEntity();
		entity.setUsuario(alumno.getUsuario());
		entity.setEdad(alumno.getEdad());
		entity.setEmail(alumno.getEmail());
		entity.setNombre(alumno.getNombre());
		entity.setPassword(alumno.getPassword());
		return entity;
	}
	public static Curso cursoBuilder(CursoEntity cursoEntity) {
		return new Curso(cursoEntity.getIdCurso(),
				cursoEntity.getDuracion(),
				Instant.ofEpochMilli(cursoEntity.getFechaInicio().getTime()) 
					.atZone(ZoneId.systemDefault()) 
					.toLocalDate(),
				cursoEntity.getNombre());
				
	}
	public static CursoEntity cursoEntityBuilder(Curso curso) {
		CursoEntity entity=new CursoEntity();
		entity.setIdCurso(curso.getIdCurso());
		entity.setDuracion(curso.getDuracion());
		entity.setFechaInicio(Date.from(
								curso.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		entity.setNombre(curso.getNombre());
		
		return entity;
	}
}
