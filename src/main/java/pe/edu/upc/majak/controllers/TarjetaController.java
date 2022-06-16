package pe.edu.upc.majak.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.ModelAttribute;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.majak.entities.Tarjeta;
import pe.edu.upc.majak.serviceinterface.IBancoService;
import pe.edu.upc.majak.serviceinterface.ITarjetaService;

@Controller
@RequestMapping("/tarjetas")
public class TarjetaController {

	@Autowired
	private ITarjetaService tService;

	@Autowired
	private IBancoService bService;

	@GetMapping("/nuevo")
	public String newUsuario(Model model) {
		model.addAttribute("t", new Tarjeta());
		model.addAttribute("listaBancos", bService.list());
		return "/tarjeta/frmRegistro";
	}

	@PostMapping("/guardar")
<<<<<<< Updated upstream
	public String saveTarjeta(@Valid Tarjeta objTarj, BindingResult binRes) {
=======
	public String saveTarjeta(@Valid @ModelAttribute("t") Tarjeta objTarj, BindingResult binRes) {
>>>>>>> Stashed changes
		if (binRes.hasErrors()) {
			return "/tarjeta/frmRegistro";
		} else {
			tService.insert(objTarj);
			return "redirect:/tarjetas/nuevo";
		}
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	@GetMapping("/listar")
	public String listTarjetas(Model model) {
		try {
			model.addAttribute("listaTarjetas", tService.list());
<<<<<<< Updated upstream
		}catch (Exception e) {
=======
		} catch (Exception e) {
>>>>>>> Stashed changes
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/tarjeta/frmLista";
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	@RequestMapping("/eliminar")
	public String deleteTarjeta(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.delete(id);
				model.put("listaTarjetas", tService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("Error", e.getMessage());
		}
		return "tarjeta/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Tarjeta> objTar = tService.listId(id);
		model.addAttribute("tarj", objTar.get());
		model.addAttribute("listaBancos", bService.list());
		return "tarjeta/frmActualiza";
	}
	
<<<<<<< Updated upstream
=======
	@PostMapping("/update")
    public String updateSuscripcion(Tarjeta t) {
       tService.update(t);
        return "redirect:/tarjetas/listar";
    }

>>>>>>> Stashed changes
}
