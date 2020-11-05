package servidor;

import java.io.IOException;
import java.util.Map;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import listener.RespuestaDronListener;
import model.Registro;
import service.DronesService;
import service.DronesServiceFactory;
import service.SingletonSesiones;
import util.Utilidades;

@ServerEndpoint("/dron")
public class ServidorDrones implements RespuestaDronListener{
	@OnClose
	public void close(Session sesion) {
		System.out.println("Elimina sesion "+sesion);
		//busca la sesión y la elimina de la colección
		SingletonSesiones singleton=SingletonSesiones.getInstance();
		singleton.recuperarSesiones()
			.entrySet()
			.removeIf(entry->entry.getValue().equals(sesion));
		
	}
	
	@OnMessage
	public void recepcion(String message,Session sesion) {	
		//cuando llega un mensaje desde el cliente, se registra el mensaje
		//y se guarda su sesión sino se ha guardado ya
		DronesService service=DronesServiceFactory.getDronesService();
		Registro registro=Utilidades.convertirARegistro(message);
		SingletonSesiones.getInstance()
			.agregarSesion(sesion, registro.getDron());
		if(registro!=null) {
			service.altaRegistro(registro);
		}
		
	}

	@Override
	public void send(String dron, String estado) {
		//envía al cliente los datos de actualización de su estado
		Map<String,Session> sesiones=SingletonSesiones.getInstance().recuperarSesiones();
		try {
			sesiones.get(dron).getBasicRemote().sendText(Utilidades.convertirAJSONRespuesta(dron, estado));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
