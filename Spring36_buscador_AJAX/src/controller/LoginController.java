package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@PostMapping("doLogin")
	public String login(@RequestParam("usuario") String usuario, 
						@RequestParam("password") String pwd,
						Model model) {
		if(usuario.equals("admin")&&pwd.equals("admin")) {
			model.addAttribute("usuario", usuario);			
			return "buscador";
		}else {
			return "error";
		}
	}
	
}
