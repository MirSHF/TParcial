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

import pe.edu.upc.majak.entities.Magnitud;
import pe.edu.upc.majak.serviceinterface.IMagnitudService;

@Controller
@RequestMapping("/magnitudes")
public class MagnitudController {

	@Autowired
	private IMagnitudService mService;
	
	@GetMapping("/nuevo")
	public String NewMagnitud(Model model) {
	model.addAttribute("m", new Magnitud());
		return "magnitud/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveCiudad(@Valid Magnitud mag, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "magnitud/frmRegistro";
		} else {
			mService.insert(mag);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/magnitudes/nuevo";
		}
	}
	
	@GetMapping("/listar")
	public String listMagnitud(Model model) {
		try {
			model.addAttribute("listaMagnitudes", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/magnitud/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteMagnitud(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				mService.delete(id);
				model.put("listaMagnitudes", mService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "magnitud/frmLista";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Magnitud>objMag=mService.listId(id);
		model.addAttribute("magn", objMag.get());
		return "magnitud/frmActualiza";
	}
	@PostMapping("/update")
    public String updateSuscripcion(Magnitud m) {
		mService.update(m);
        return "redirect:/tarjetas/listar";
    }
}
