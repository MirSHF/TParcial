package pe.edu.upc.majak.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.upc.majak.entities.Persona;
import pe.edu.upc.majak.serviceinterface.ICiudadService;
import pe.edu.upc.majak.serviceinterface.IPersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService pService;

	@Autowired
	private ICiudadService cService;

	@GetMapping("/nuevo")
	public String newUsuario(Model model) {
		model.addAttribute("p", new Persona());
		model.addAttribute("listaCiudades", cService.list());
		return "/persona/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveUsuario(@Valid @ModelAttribute("p") Persona objPers, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/persona/frmRegistro";
		} else {
			pService.insert(objPers);
			return "redirect:/personas/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listUsuarios(Model model) {
		try {
			model.addAttribute("listaPersonas", pService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/persona/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deletePersona(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.delete(id);
				model.put("listaPersonas", pService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "persona/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Persona> objPer = pService.listId(id);
		model.addAttribute("pers", objPer.get());
		model.addAttribute("listaCiudades", cService.list());
		return "persona/frmActualiza";
	}
}
