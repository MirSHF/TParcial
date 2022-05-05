package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Renovacion;
import pe.edu.upc.entities.Tarjeta;
import pe.edu.upc.entities.Usuario;

import pe.edu.upc.serviceinterfaces.CRenovacionService;
import pe.edu.upc.serviceinterfaces.CTarjetaService;
import pe.edu.upc.serviceinterfaces.CUsuarioService;

@Named
@RequestScoped
public class RenovacionController {

	@Inject
	private CRenovacionService rService;
	private Renovacion r;
	List<Renovacion> listRenovacions;

	@Inject
	private CTarjetaService tService;
	List<Tarjeta> listTarjetas;

	@Inject
	private CUsuarioService uService;
	List<Usuario> lisUsuarios;

	@PostConstruct
	public void init() {
		this.r = new Renovacion();
		this.listRenovacions = new ArrayList<Renovacion>();
		this.listTarjetas = new ArrayList<Tarjeta>();
		this.lisUsuarios = new ArrayList<Usuario>();
		this.list();
		this.listTarjetas();
		this.listUsuario();
	}

	public String newRenovacion() {
		this.setR(new Renovacion());
		return "Renovacion.xhtml";
	}

	public void insert() {
		try {
			rService.insert(r);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		try {
			listRenovacions = rService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listTarjetas() {
		try {
			listTarjetas = tService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listUsuario() {
		try {
			lisUsuarios = uService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(Renovacion r) {
		tService.delete(r.getCodigoRenovacion());
	}

	public CRenovacionService getrService() {
		return rService;
	}

	public void setrService(CRenovacionService rService) {
		this.rService = rService;
	}

	public Renovacion getR() {
		return r;
	}

	public void setR(Renovacion r) {
		this.r = r;
	}

	public List<Renovacion> getListRenovacions() {
		return listRenovacions;
	}

	public void setListRenovacions(List<Renovacion> listRenovacions) {
		this.listRenovacions = listRenovacions;
	}

	public CTarjetaService gettService() {
		return tService;
	}

	public void settService(CTarjetaService tService) {
		this.tService = tService;
	}

	public List<Tarjeta> getListTarjetas() {
		return listTarjetas;
	}

	public void setListTarjetas(List<Tarjeta> listTarjetas) {
		this.listTarjetas = listTarjetas;
	}

	public CUsuarioService getuService() {
		return uService;
	}

	public void setuService(CUsuarioService uService) {
		this.uService = uService;
	}

	public List<Usuario> getLisUsuarios() {
		return lisUsuarios;
	}

	public void setLisUsuarios(List<Usuario> lisUsuarios) {
		this.lisUsuarios = lisUsuarios;
	}

}
