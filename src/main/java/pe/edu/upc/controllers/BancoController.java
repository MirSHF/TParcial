package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Banco;
import pe.edu.upc.serviceinterfaces.CBancoService;

@Named
@RequestScoped
public class BancoController {

	@Inject
	private CBancoService bService;

	private Banco b;
	List<Banco> listaBancos;

	@PostConstruct
	public void init() {
		this.listaBancos = new ArrayList<Banco>();
		this.b = new Banco();
		this.list();
	}

	public String newBanco() {

		this.setB(new Banco());

		return "banco.xhtml";
	}

	public void insert() {
		try {
			bService.insert(b);
		} catch (Exception e) {
			System.out.println("Error ocurri� en el controlador de banco al insertar!!");
		}
	}

	public void list() {
		try {
			listaBancos = bService.list();
		} catch (Exception e) {
			System.out.println("Error al listar bancos en el controller!! ");
		}
	}

	public void delete(Banco banc) {

		bService.delete(banc.getCodigoBanco());
		list();
	}

	// GETTER & SETTTERS
	public Banco getB() {
		return b;
	}

	public void setB(Banco b) {
		this.b = b;
	}

	public List<Banco> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<Banco> listaBancos) {
		this.listaBancos = listaBancos;
	}

}
