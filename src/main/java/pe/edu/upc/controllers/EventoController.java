package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Distrito;
import pe.edu.upc.entities.Epicentro;
import pe.edu.upc.entities.Evento;
import pe.edu.upc.entities.Magnitud;
import pe.edu.upc.serviceinterfaces.CDistritoService;
import pe.edu.upc.serviceinterfaces.CEpicentroService;
import pe.edu.upc.serviceinterfaces.CEventoService;
import pe.edu.upc.serviceinterfaces.CMagnitudService;

@Named
@RequestScoped
public class EventoController {
	@Inject
	private CEventoService evService;

	@Inject
	private CEpicentroService eService;

	@Inject
	private CMagnitudService mService;

	@Inject
	private CDistritoService dService;

	private Evento ev;
	private List<Evento> listaEventos;
	private List<Epicentro> listaEpicentros;
	private List<Distrito> listaDistritos;
	private List<Magnitud> listaMagnitudes;

	// Constructor
	@PostConstruct
	public void init() {
		this.ev = new Evento();
		this.listaEventos = new ArrayList<Evento>();
		this.listaMagnitudes = new ArrayList<Magnitud>();
		this.listaEpicentros = new ArrayList<Epicentro>();
		this.listaDistritos = new ArrayList<Distrito>();
		this.listMagnitud();
		this.listEpicentros();
		this.listDistritros();
		this.list();
	}

	// métodos

	public void insert() {
		try {
			evService.insert(ev);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controloador  de evento");
		}
	}

	public void list() {
		try {
			listaEventos = evService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controloador  de evento");
		}
	}

	public void listMagnitud() {
		try {
			listaMagnitudes = mService.list();
		} catch (Exception e) {
			System.out.println("Error al listar magnitud en el controlador Evento");
		}
	}

	public void listEpicentros() {
		try {
			listaEpicentros = eService.list();
		} catch (Exception e) {
			System.out.println("Error al listar epicentros en el controlador Evento");
		}
	}

	public void listDistritros() {
		try {
			listaDistritos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar epicentros en el controlador Evento");
		}
	}

	public void delete(Evento event) {
		evService.delete(event.getCodigoEvento());
		list();
	}

	public void findByNameEvento() {
		try {
			listaEventos = evService.findByNameEvento(this.getEv());
		} catch (Exception e) {
			System.out.println("Error al buscar en el controlador de evento");
		}
	}

	// Getter and Setters
	public Evento getEv() {
		return ev;
	}

	public void setEv(Evento ev) {
		this.ev = ev;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public List<Epicentro> getListaEpicentros() {
		return listaEpicentros;
	}

	public void setListaEpicentros(List<Epicentro> listaEpicentros) {
		this.listaEpicentros = listaEpicentros;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Magnitud> getListaMagnitudes() {
		return listaMagnitudes;
	}

	public void setListaMagnitudes(List<Magnitud> listaMagnitudes) {
		this.listaMagnitudes = listaMagnitudes;
	}

}
