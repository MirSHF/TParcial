package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Magnitud;
import pe.edu.upc.demo.serviceinterface.IMagnitudService;

@Controller
@RequestMapping("/magnituds")
public class MagnitudController {

	@Autowired
	private IMagnitudService magService;

	@GetMapping("/nuevo")
	public String newMagnitud(Model model) {
		model.addAttribute("m", new Magnitud());
		return "magnitud/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveMagnitud(@Validated Magnitud mag, BindingResult binRes, Model model) {
		
		if (binRes.hasErrors()) {
			return "magnitud/frmRegistro";
		} else {
			magService.insert(mag);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/magnituds/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listMagnitud(Model model) {
		try {
			model.addAttribute("listaMagnituds", magService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "magnitud/frmLista";
	}

	@RequestMapping("/eliminar")
	public String delete(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if (id != null && id > 0) {
				magService.delete(id);// elimina
				model.put("listaMagnituds", magService.list());
			}

		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}

		return "magnitud/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Magnitud> objMag = magService.listId(id);
		model.addAttribute("magn", objMag.get());
		return "magnitud/frmActualiza";
	}

}
