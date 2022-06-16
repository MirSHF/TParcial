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

import pe.edu.upc.majak.entities.RenovacionSuscripcion;
import pe.edu.upc.majak.entities.Tarjeta;
import pe.edu.upc.majak.serviceinterface.IPersonaService;
import pe.edu.upc.majak.serviceinterface.IRenovacionSuscripcionService;
import pe.edu.upc.majak.serviceinterface.ITarjetaService;

@Controller
@RequestMapping("/renovacionsuscripcions")
public class RenovacionSuscripcionController {

	
	@Autowired
	private IRenovacionSuscripcionService rService;

	@Autowired
	private IPersonaService pService;
	
	@Autowired
	private ITarjetaService tService;
	
	@GetMapping("/nuevo")
	public String newUsuario(Model model) {
		model.addAttribute("r", new RenovacionSuscripcion());
		model.addAttribute("listaPersonas", pService.list());
		
		model.addAttribute("t", new Tarjeta());
		model.addAttribute("listaTarjetas", tService.list());
		
		return "/renovacionsuscripcion/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveRenovacionSuscripcion(@Valid @ModelAttribute("r") RenovacionSuscripcion objRenov, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/renovacionsuscripcion/frmRegistro";
		} else {
			rService.insert(objRenov);
			return "redirect:/renovacionsuscripcions/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listRenovacionSuscripcions(Model model) {
		try {
			model.addAttribute("listaRenovacionSuscripcions", rService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/renovacionsuscripcion/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteSuscripcion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.delete(id);
				model.put("listaRenovacionSuscripcions", rService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "renovacionsuscripcion/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<RenovacionSuscripcion>objRev=rService.listId(id);
		model.addAttribute("susc", objRev.get());
		model.addAttribute("listaPersonas", pService.list());
		model.addAttribute("listaTarjetas", tService.list());
		return "renovacionsuscripcion/frmActualiza";
	}
}
