package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoDistrito;

	@NotEmpty(message = "Ingrese un Distrito")
	@Column(name = "nombreDistrito", nullable = false, length = 45)
	private String nombreDistrito;

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int codigoDistrito, String nombreDistrito) {
		super();
		this.codigoDistrito = codigoDistrito;
		this.nombreDistrito = nombreDistrito;
	}

	public int getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

}
