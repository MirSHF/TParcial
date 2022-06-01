package pe.edu.upc.demo.controllers;

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

import pe.edu.upc.demo.entities.Banco;

import pe.edu.upc.demo.serviceinterface.IBancoService;


@Controller
@RequestMapping("/bancos")
public class BancoController {
	@Autowired
	private IBancoService banService;
	
	@GetMapping("/nuevo")
	public String newBanco(Model model) {
		model.addAttribute("b", new Banco());
		return "banco/frmRegistro";
	}
	@PostMapping("/guardar")
	public String saveBanco(@Valid Banco ban, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "banco/frmRegistro";
		} else { 
			banService.insert(ban);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/bancos/nuevo";
		}
	}
	@GetMapping("/listar")
	public String listBanco(Model model) {
		try {
			model.addAttribute("listaBancos", banService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/banco/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String delete(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if (id != null && id > 0) {
				banService.delete(id);// elimina
				model.put("listaBancos", banService.list());
			}

		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}

		return "banco/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Banco> objBan= banService.listId(id);
		model.addAttribute("ban", objBan.get());
		return "banco/frmActualiza";
	}
	}





