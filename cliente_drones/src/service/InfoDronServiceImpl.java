package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Dron;
import util.Utilidades;

public class InfoDronServiceImpl implements InfoDronService {

	@Override
	public Dron recuperarDatos(String nombre) {
		Path pt=Paths.get(nombre+".txt");
		String datos;
		try {
			datos = Files.readString(pt);
			System.out.println(datos);
			return Utilidades.convertirADron(datos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void actualizarEstado(String nombre, String estado) {
		Dron dron=recuperarDatos(nombre);
		dron.setEstado(estado);
		salvarDatos(dron);
	}

	@Override
	public void actualizarPosicion(String nombre, double longitud, double latitud) {
		Dron dron=recuperarDatos(nombre);
		dron.setLatitud(latitud);
		dron.setLongitud(longitud);
		salvarDatos(dron);

	}
	private void salvarDatos(Dron dron) {
		//actualiza el fichero con los datos del Dron
		Path pt=Paths.get(dron.getNombre()+".txt");
		try {
			Files.writeString(pt, Utilidades.convertirATexto(dron));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
