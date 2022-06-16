package pe.edu.upc.majak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.upc.majak.serviceinterface.IUsuarioService;

@Controller
public class RegistroController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "master/master";
	}
}
