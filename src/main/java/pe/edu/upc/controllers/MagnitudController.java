package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Magnitud;
import pe.edu.upc.serviceinterfaces.CMagnitudService;

@Named
@RequestScoped
public class MagnitudController {
	@Inject
	private CMagnitudService mService;
	// atributos
	private Magnitud m;
	List<Magnitud> listaMagnituds;

	// métodos
	@PostConstruct
	public void init() {
		this.listaMagnituds = new ArrayList<Magnitud>();
		this.m = new Magnitud();
		this.list();
	}

	public String newMagnitud() {
		this.setM(new Magnitud());
		return "magnitud.xhtml";
	}

	public void insert() {
		try {
			mService.insert(m);
		} catch (Exception e) {
			System.out.println("Error ocurrió en el controlador de persona al insertar!!");
		}
	}

	public void list() {
		try {
			listaMagnituds = mService.list();
		} catch (Exception e) {
			System.out.println("Error al listar personas en el controller!! ");
		}
	}

	public void delete(Magnitud magn) {

		mService.delete(magn.getCodigoMagnitud());
		list();

	}

	// getters & setters
	public Magnitud getM() {
		return m;
	}

	public void setM(Magnitud m) {
		this.m = m;
	}

	public List<Magnitud> getListaMagnituds() {
		return listaMagnituds;
	}

	public void setListaMagnituds(List<Magnitud> listaMagnituds) {
		this.listaMagnituds = listaMagnituds;
	}

}
