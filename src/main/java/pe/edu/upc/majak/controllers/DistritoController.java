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

import pe.edu.upc.majak.entities.Distrito;
import pe.edu.upc.majak.serviceinterface.IDistritoService;

@Controller
@RequestMapping("/distritos")
public class DistritoController {

	@Autowired
	private IDistritoService disService;

	@GetMapping("/nuevo")
	public String newDistrito(Model model) {
		model.addAttribute("d", new Distrito());

		return "distrito/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveDistrito(@Valid @ModelAttribute("d") Distrito dis, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "distrito/frmRegistro";
		} else {
			disService.insert(dis);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/distritos/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listDistrito(Model model) {
		try {
			model.addAttribute("listaDistritos", disService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/distrito/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleterDistrito(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				disService.delete(id);
				model.put("listaDistritos", disService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "distrito/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Distrito>objDis=disService.listId(id);
		model.addAttribute("dist", objDis.get());
		return "distrito/frmActualiza";
	}
}
