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

import pe.edu.upc.majak.entities.PersonaEvento;
import pe.edu.upc.majak.serviceinterface.IEventoService;
import pe.edu.upc.majak.serviceinterface.IPersonaEventoService;
import pe.edu.upc.majak.serviceinterface.IPersonaService;

@Controller
@RequestMapping("/personaeventos")
public class PersonaEventoController {

	@Autowired
	private IPersonaEventoService pvService;
	
	@Autowired
	private IPersonaService pService;
	
	@Autowired
	private IEventoService eService;
	
	@GetMapping("/nuevo")
	public String newPersonaEvento(Model model) {
		model.addAttribute("pv", new PersonaEvento());
		model.addAttribute("listaPersonas", pService.list());
		model.addAttribute("listaEventos", eService.list());

		return "/personaevento/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String savePersonaEvento(@Valid @ModelAttribute("pv") PersonaEvento objPerv, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/personaevento/frmRegistro";
		} else {
			pvService.insert(objPerv);
			return "redirect:/personaeventos/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listaPersonaEventos(Model model) {
		try {
			model.addAttribute("listaPersonaEventos", pvService.list());
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/personaevento/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deletePersonaEvento(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pvService.delete(id);
				model.put("listaPersonaEventos", pvService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "personaevento/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<PersonaEvento>objPeEv=pvService.listId(id);
		model.addAttribute("perev", objPeEv.get());
		model.addAttribute("listaPersonas", pService.list());
		model.addAttribute("listaEventos", eService.list());
		return "personaevento/frmActualiza";
	}
}
	

