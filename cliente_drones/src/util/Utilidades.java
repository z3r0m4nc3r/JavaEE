package util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Dron;

public class Utilidades {
	static JSONParser parser = new JSONParser();
	public static synchronized Dron convertirADron(String datos) {
		JSONObject object;
		try {
			object = (JSONObject)parser.parse(datos);
			return new Dron((String)object.get("nombre"),
					(String)object.get("estado"),
					(Double)object.get("longitud"),
					(Double)object.get("latitud"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public static synchronized String convertirATexto(Dron dron) {
		JSONObject ob=new JSONObject();
		ob.put("nombre", dron.getNombre());
		ob.put("estado", dron.getEstado());
		ob.put("longitud", dron.getLongitud());
		ob.put("latitud", dron.getLatitud());
		return ob.toJSONString();
	}
	public static synchronized Dron convertirRespuesta(String respuesta) {
		JSONObject object;
		try {
			//la respuesta del servidor no incluye la posición
			object = (JSONObject)parser.parse(respuesta);
			return new Dron((String)object.get("nombre"),
					(String)object.get("estado"),
					0,
					0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
