package pe.edu.upc.majak.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.majak.entities.Usuario;
import pe.edu.upc.majak.serviceinterface.ICiudadService;
import pe.edu.upc.majak.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService uService;

	@Autowired
	private ICiudadService cService;

	@GetMapping("/nuevo")
	public String newUsuario(Model model) {
		model.addAttribute("u", new Usuario());
		model.addAttribute("listaCiudades", cService.list());
		return "/usuario/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveUsuario(@Valid Usuario objUsua, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/usuario/frmRegistro";
		} else {
			uService.insert(objUsua);
			return "redirect:/usuarios/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listUsuarios(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.list());
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/usuario/frmLista";
	}
}
