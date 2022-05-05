package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Distrito;
import pe.edu.upc.serviceinterfaces.CDistritoService;

@Named
@RequestScoped
public class DistritoController {

	@Inject
	private CDistritoService dService;

	private Distrito d;
	List<Distrito> listaDistritos;

	@PostConstruct
	public void init() {
		this.listaDistritos = new ArrayList<Distrito>();
		this.d = new Distrito();
		this.list();
	}

	public String newDistrito() {

		this.setD(new Distrito());

		return "distrito.xhtml";
	}
	



	public void insert() {
		try {
			dService.insert(d);
		} catch (Exception e) {
			System.out.println("Error ocurri� en el controlador de distrito al insertar!!");
		}
	}
	
	
	public void list() {
		try {
			listaDistritos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar distritos en el controller!! ");
		}
	}
	
	public void delete(Distrito dist) {
		
		dService.delete(dist.getCodigoDistrito());
		list();
	}

	// getter AND setters
	public Distrito getD() {
		return d;
	}

	public void setD(Distrito d) {
		this.d = d;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

}
