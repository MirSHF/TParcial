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

import pe.edu.upc.majak.entities.Evento;
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
	public String saveEvento(@Valid @ModelAttribute("e") Evento objEven, BindingResult binRes) {
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
	
	@RequestMapping("/eliminar")
	public String deleteSuscripcion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				evService.delete(id);
				model.put("listaEventos", evService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "evento/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Evento>objEve=evService.listId(id);
		model.addAttribute("even", objEve.get());
		model.addAttribute("listaMagnituds", mService.list());
		model.addAttribute("listaEpicentros", epiService.list());
		model.addAttribute("listaDistritos", disService.list());
		return "evento/frmActualiza";
	}
	
	@PostMapping("/update")
    public String updateSuscripcion(Evento e) {
		evService.update(e);
        return "redirect:/tarjetas/listar";
    }
	
	@RequestMapping("/reporte2")
	public String eventodistrito(Map<String, Object>model) {
		model.put("CantidadDistritos", evService.eventodistrito());
		return "evento/vista";
	}
}
