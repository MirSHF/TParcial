package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Epicentro;

import pe.edu.upc.serviceinterfaces.CEpicentroService;

@Named
@RequestScoped
public class EpicentroController {

	@Inject
	private CEpicentroService eService;
	
	private Epicentro e;
	List<Epicentro> listaEpicentro;
	
	@PostConstruct
	public void init() {
		this.listaEpicentro = new ArrayList<Epicentro>();
		this.e = new Epicentro();
		this.list();
	}
	
	public String newEpicentro() {
		this.setE(new Epicentro());
		return "epicentro.xhtml";
	}
	
	
	public void insert() {
		try {
			eService.insert(e);
		} catch (Exception e) {
			System.out.println("Error ocurri� en el controlador de epicentro al insertar!!");
		}
	}

	public void list() {
		try {
			listaEpicentro = eService.list();
		} catch (Exception e) {
			System.out.println("Error al listar epicentros en el controller!! ");
		}
	}

	public void delete(Epicentro epic) {

		eService.delete(epic.getCodigoEpicentro());
		list();;

	}
	
	
	
	//Getter & Setters
	public Epicentro getE() {
		return e;
	}
	public void setE(Epicentro e) {
		this.e = e;
	}
	public List<Epicentro> getListaEpicentro() {
		return listaEpicentro;
	}
	public void setListaEpicentro(List<Epicentro> listaEpicentro) {
		this.listaEpicentro = listaEpicentro;
	}
	
	
}
