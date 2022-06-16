package pe.edu.upc.majak.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.majak.entities.Evento;
import pe.edu.upc.majak.entities.Usuario;
import pe.edu.upc.majak.serviceinterface.IDistritoService;
import pe.edu.upc.majak.serviceinterface.IEpicentroService;
import pe.edu.upc.majak.serviceinterface.IEventoService;
import pe.edu.upc.majak.serviceinterface.IMagnitudService;

@Controller
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private IEventoService evService;
	
	@Autowired
	private IMagnitudService mService;
	
	@Autowired
	private IEpicentroService epiService;
	
	@Autowired
	private IDistritoService disService;
	
	
	@GetMapping("/nuevo")
	public String newEvento(Model model) {
		model.addAttribute("e", new Evento());
		model.addAttribute("listaMagnituds", mService.list());
		model.addAttribute("listaEpicentros", epiService.list());
		model.addAttribute("listaDistritos", disService.list());
		return "/evento/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveEvento(@Valid Evento objEven, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "/evento/frmRegistro";
		} else {
			evService.insert(objEven);
			return "redirect:/eventos/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listEventos(Model model) {
		try {
			model.addAttribute("listaEventos", evService.list());
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/evento/frmLista";
	}
}
