package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import service.CursoService;
import service.FormacionFactory;

@WebServlet("/AltaCursoAction")
public class AltaCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoService service = FormacionFactory.getCursoService();
		try {
		String fechaInicio = request.getParameter("fechaInicio");
		String nombre = request.getParameter("nombre");
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Curso curso = new Curso(0,format.parse(fechaInicio), duracion, nombre);
		service.altaCurso(curso);
		}
		catch(ParseException ex) {
			ex.printStackTrace();
		}
	}

}
