package util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Registro;

public class Utilidades {
	static JSONParser parser = new JSONParser();
	public static Registro convertirARegistro(String datos) {
		JSONObject object;
		try {
			System.out.println("--"+datos);
			object = (JSONObject)parser.parse(datos);
			return new Registro(0,(String)object.get("nombre"),
					(Double)object.get("longitud"),
					(Double)object.get("latitud"),
					null
					);
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	@SuppressWarnings("unchecked")
	public static String convertirAJSONRespuesta(String nombre, String estado) {
		JSONObject ob=new JSONObject();
		ob.put("nombre", nombre);
		ob.put("estado", estado);
		return ob.toJSONString();
	}

}
