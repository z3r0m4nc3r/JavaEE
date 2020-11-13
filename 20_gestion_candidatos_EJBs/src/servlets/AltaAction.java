package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class AltaContacto
 */

@MultipartConfig //permite al servlet procesar objetos Part (objetos binarios)
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {

	private static final long serialVersionUID = -3589411803024933225L;

	@EJB
	CandidatosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre=request.getParameter("nombre");		
		int edad=Integer.parseInt(request.getParameter("edad"));		
		String puesto=request.getParameter("puesto");		
		Part foto=request.getPart("foto");		
		String email=request.getParameter("email");		
		String nombreFichero=obtenerNombreFichero(foto);		
		Candidato cand = new Candidato(0,edad,email,nombreFichero,nombre,puesto);
		service.altaCandidato(cand);		
		guardarFicheroEnServidor(request,foto,nombreFichero);
		//request.getRequestDispatcher("menu.html").forward(request, response);
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
		
		/*try (InputStream input=part.getInputStream();
				FileOutputStream output = new FileOutputStream(url+nombreFichero);){
	        int leido = 0;
	        leido = input.read();        
	        while (leido != -1) {
	            output.write(leido);
	            leido = input.read();
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } */
		try {
			part.write(url+"\\"+nombreFichero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
