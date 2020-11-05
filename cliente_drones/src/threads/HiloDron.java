package threads;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import model.Dron;
import service.InfoDronFactory;
import service.InfoDronService;
import util.Utilidades;

@ClientEndpoint
public class HiloDron implements Runnable{
	private String nombre;
	private Session sesion;
	public HiloDron(String nombre, String url) {
		super();
		this.nombre = nombre;
		try {
			URI endPoint=new URI(url);
            WebSocketContainer container = ContainerProvider
                    .getWebSocketContainer();
            container.connectToServer(this, endPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@OnOpen
    public void onOpen(Session sesion) {  
		System.out.println("Sesion creada para dron "+nombre);
        this.sesion = sesion;
    }
	
	@Override
	public void run() {
		//cada cierto tiempo, por ejemplo 6 segundos,
		//el proceso comprueba si el dron está activo
		//y en ese caso, envia su posición al servidor
		InfoDronService service=InfoDronFactory.getInfoDronService();
		Dron dron=service.recuperarDatos(nombre);
		//mientras el estado del dron sea activo,
		//envía los datos al WebSocket del servidor 
		while(dron.getEstado().equals("activo")) {			
			try {
				System.out.println("Mandando datos el dron "+nombre+" : "+dron.getNombre());
				sesion.getBasicRemote().sendText(Utilidades.convertirATexto(dron));
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dron=service.recuperarDatos(nombre);
		}
		System.out.println("Estado del dron "+dron.getNombre()+": "+dron.getEstado());
		try {
			//desconectamos del servidor cuando el dron esté inactivo
			sesion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@OnMessage
	public void onMessage(String message) {
		//recupera el mensaje del servidor con 
		//la actualización del estado
		InfoDronService service=InfoDronFactory.getInfoDronService();
		Dron dron=Utilidades.convertirRespuesta(message);
		service.actualizarEstado(dron.getNombre(), dron.getEstado());
	}
	
	
	

}
