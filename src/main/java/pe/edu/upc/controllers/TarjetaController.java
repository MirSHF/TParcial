package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Banco;

import pe.edu.upc.entities.Tarjeta;
import pe.edu.upc.serviceinterfaces.CBancoService;
import pe.edu.upc.serviceinterfaces.CTarjetaService;

@Named
@RequestScoped
public class TarjetaController {

	@Inject
	private CTarjetaService tService;
	private Tarjeta t;
	List<Tarjeta> listaTarjetas;

	@Inject
	private CBancoService bService;
	List<Banco> lisBancos;

	@PostConstruct
	public void init() {
		this.t = new Tarjeta();
		this.lisBancos = new ArrayList<Banco>();
		this.listaTarjetas = new ArrayList<Tarjeta>();
		this.list();
		this.listBancos();
	}

	public String newTarjeta() {
		this.setT(new Tarjeta());
		return "Tarjeta.xhtml";
	}

	public void insert() {
		try {
			tService.insert(t);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		try {
			listaTarjetas = tService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listBancos() {
		try {
			lisBancos = bService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(Tarjeta t) {
		tService.delete(t.getCodigoTarjeta());
	}

	public CTarjetaService gettService() {
		return tService;
	}

	public void settService(CTarjetaService tService) {
		this.tService = tService;
	}

	public Tarjeta getT() {
		return t;
	}

	public void setT(Tarjeta t) {
		this.t = t;
	}

	public List<Tarjeta> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(List<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}

	public CBancoService getbService() {
		return bService;
	}

	public void setbService(CBancoService bService) {
		this.bService = bService;
	}

	public List<Banco> getLisBancos() {
		return lisBancos;
	}

	public void setLisBancos(List<Banco> lisBancos) {
		this.lisBancos = lisBancos;
	}


	

}
