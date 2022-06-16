package pe.edu.upc.majak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.majak.entities.UsuarioRegistroDTO;
import pe.edu.upc.majak.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

	private IUsuarioService usuarioService;

	public RegistroUsuarioController(IUsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	
	@ModelAttribute("usuario")
	public  UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro()	 {
		return "registro";
		
	}
	
	@PostMapping
	public String RegistrarCuentaDeUsuario(@ModelAttribute("usuario")UsuarioRegistroDTO registroDTO) {
			usuarioService.guardar(registroDTO);
			return "redirect:/registro?exito";
	}
}
