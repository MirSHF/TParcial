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

import pe.edu.upc.majak.entities.Notificacion;
import pe.edu.upc.majak.serviceinterface.IEventoService;
import pe.edu.upc.majak.serviceinterface.INotificacionService;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionController {

	@Autowired
	private INotificacionService nService;
	
	@Autowired
	private IEventoService eService;
	
	@GetMapping("/nuevo")
	public String newNotificacion(Model model) {
		model.addAttribute("n", new Notificacion());
		model.addAttribute("listaEventos", eService.list());
		return "/notificacion/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveNotificacion(@Valid @ModelAttribute("n") Notificacion objnoti, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/notificacion/frmRegistro";
		} else {
			nService.insert(objnoti);
			return "redirect:/notificaciones/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listNotificacion(Model model) {
		try {
			model.addAttribute("listaNotificaciones", nService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/notificacion/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteNotificacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				nService.delete(id);
				model.put("listaNotificaciones", nService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "notificacion/frmLista";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Notificacion> objNot = nService.listId(id);
		model.addAttribute("noti", objNot.get());
		model.addAttribute("listaEventos", eService.list());
		return "notificacion/frmActualiza";
	}

}
