package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoDistrito;

	@Column(name = "nombreDistrito", nullable = false, length=47)
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

	@Override
	public int hashCode() {
		return Objects.hash(codigoDistrito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distrito other = (Distrito) obj;
		return codigoDistrito == other.codigoDistrito;
	}

	
	
}
