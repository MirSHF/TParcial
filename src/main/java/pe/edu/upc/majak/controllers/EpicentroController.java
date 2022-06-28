package pe.edu.upc.majak.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.majak.entities.Epicentro;
import pe.edu.upc.majak.serviceinterface.IEpicentroService;

@Controller
@RequestMapping("/epicentros")
public class EpicentroController {

	@Autowired
	private IEpicentroService epiService;
	
	@GetMapping("/nuevo")
	public String newEpicentro(Model model) {
		model.addAttribute("e", new Epicentro());

		return "epicentro/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveEpicentro(@Valid Epicentro epi, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "epicentro/frmRegistro";
		} else {
			epiService.insert(epi);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/epicentros/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listEpicentro(Model model) {
		try {
			model.addAttribute("listaEpicentros", epiService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/epicentro/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleterEpicentro(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				epiService.delete(id);
				model.put("listaEpicentros", epiService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "epicentro/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Epicentro>objEpi=epiService.listId(id);
		model.addAttribute("epic", objEpi.get());
		return "epicentro/frmActualiza";
	}
	
	
	@PostMapping("/update")
    public String updateSuscripcion(Epicentro e) {
		epiService.update(e);
        return "redirect:/tarjetas/listar";
    }
}
