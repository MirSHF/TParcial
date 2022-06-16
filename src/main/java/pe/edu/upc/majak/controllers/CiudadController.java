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

import pe.edu.upc.majak.entities.Ciudad;
import pe.edu.upc.majak.serviceinterface.ICiudadService;

@Controller
@RequestMapping("/ciudades")
public class CiudadController {

	@Autowired
	private ICiudadService ciuService;
	
	@GetMapping("/nuevo")
	public String newCiudad(Model model) {
		model.addAttribute("c", new Ciudad());

		return "ciudad/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveCiudad(@Valid @ModelAttribute("c") Ciudad ciu, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "ciudad/frmRegistro";
		} else {
			ciuService.insert(ciu);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ciudades/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listCiuadad(Model model) {
		try {
			model.addAttribute("listaCiudades", ciuService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/ciudad/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteCiudad(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				ciuService.delete(id);
				model.put("listaCiudades", ciuService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "ciudad/frmLista";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Ciudad>objCiu=ciuService.listId(id);
		model.addAttribute("ciud", objCiu.get());
		return "ciudad/frmActualiza";
	}
}
