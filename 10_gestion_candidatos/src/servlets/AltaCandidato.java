package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Candidato;

@MultipartConfig //permite al servlet procesar objetos Part (objetos binarios)
@WebServlet("/AltaCandidato")
public class AltaCandidato extends HttpServlet {
	
	private static final long serialVersionUID = 541985293870497585L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();			
		@SuppressWarnings("unchecked")
		List<Candidato> candidatos=(List<Candidato>) sesion.getAttribute("candidatos");
		
		String nombre=request.getParameter("nombre");
		
		int edad=Integer.parseInt(request.getParameter("edad"));
		
		String puesto=request.getParameter("puesto");
		
		Part foto=request.getPart("foto");
		
		String nombreFichero=obtenerNombreFichero(foto);
		
		Candidato cand = new Candidato(nombre,edad,puesto,nombreFichero);

		candidatos.add(cand);	
		
		guardarFicheroEnServidor(request,foto,nombreFichero);
		
		request.getRequestDispatcher("menu.html").forward(request, response);

	}
	
	private String obtenerNombreFichero(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) { 
			if (cd.trim().startsWith("filename")) { 
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", ""); 
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix. 
			} 
		} 
		return null; 
	}
	
	private void guardarFicheroEnServidor(HttpServletRequest request, Part part, String nombreFichero) {
		String url=request.getServletContext().getRealPath("/");
	
		try {
			part.write(url+"\\"+nombreFichero);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
