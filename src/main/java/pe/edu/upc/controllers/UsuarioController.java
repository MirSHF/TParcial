package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterfaces.CUsuarioService;

@Named
@RequestScoped
public class UsuarioController {
	@Inject
	private CUsuarioService uService;
	private Usuario u;
	List<Usuario> listaUsuarios;

	@PostConstruct
	public void init() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.u = new Usuario();
		this.list();
	}

	public String newUsuario() {
		this.setU(new Usuario());
		return "usuario.xhtml";
	}

	public void insert() {
		try {
			uService.insert(u);
		} catch (Exception e) {
			System.out.println("Error ocurri� en el controlador de usuario al insertar!!");
		}
	}

	public void list() {
		try {
			listaUsuarios = uService.list();
		} catch (Exception e) {
			System.out.println("Error al listar personas en el controller!! ");
		}
	}

	public void delete(Usuario us) {

		uService.delete(us.getIdUsuario());
		list();

	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
