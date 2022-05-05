package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Evento;
import pe.edu.upc.entities.Notificacion;
import pe.edu.upc.serviceinterfaces.CEventoService;
import pe.edu.upc.serviceinterfaces.CNotificacionService;

@Named
@RequestScoped
public class NotificacionController {

	@Inject
	private CEventoService evService;
	
	@Inject
	private CNotificacionService nService;

	private Notificacion n;
	private List<Notificacion> listaNotificacion;
	private List<Evento> listaEvento;

	@PostConstruct
	public void init() {
		this.n = new Notificacion();
		this.listaNotificacion = new ArrayList<Notificacion>();
		this.listaEvento = new ArrayList<Evento>();
		this.listEvento();
		this.list();
	}
	
	public void insert() {
		try {
			nService.insert(n);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controloador de las notificaciones");
		}
	}
	
	public void list() {
		try {
			listaNotificacion = nService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controloador de las notificaciones");
		}
	}
	
	public void listEvento() {
		try {
			listaEvento = evService.list();
		} catch (Exception e) {
			System.out.println("Error al listar magnitud en el controlador Evento");
		}
	}
	
	public void delete(Notificacion notif) {
		nService.delete(notif.getCodigoNotificacion());
		list();
	}
	
	public String updatePre(Notificacion not) {
		this.setN(not);
		
		return "PreUpdatenotificacion.xhtml";
	}
	
	public void update() {
		try {
			nService.update(this.n);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controlador de vacunas");
		}
	}

	public Notificacion getN() {
		return n;
	}

	public void setN(Notificacion n) {
		this.n = n;
	}

	public List<Notificacion> getListaNotificacion() {
		return listaNotificacion;
	}

	public void setListaNotificacion(List<Notificacion> listaNotificacion) {
		this.listaNotificacion = listaNotificacion;
	}

	public List<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

}
