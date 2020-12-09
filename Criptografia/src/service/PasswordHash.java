package service;

import java.security.MessageDigest;
import java.util.Map;

public class PasswordHash {
	protected Map usuarios;
	
	public boolean login(String usuario, String password) {
		
		MessageDigest md = MessageDigest.getInstance("SHA256");
		String huella_password = usuarios.get(usuario);
		
		if(huella_password==null) {
			return false;
		}else {
			String huella = new String(md.digest(password.getBytes()));
			return huella_password.equals(huella);
		}
		
	}
}
