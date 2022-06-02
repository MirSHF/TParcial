package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoUsuario;

	@Column(name = "dniUsuario", length = 15, nullable = false)
	private String dniUsuario;

	@Column(name = "nombreUsuario", length = 15, nullable = false)
	private String nombreUsuario;

	@Column(name = "correoUsuario", length = 15, nullable = false)
	private String correoUsuario;

	@ManyToOne
	@JoinColumn(name = "codigoCiudad")
	private Ciudad ciudad;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int codigoUsuario, String dniUsuario, String nombreUsuario, String correoUsuario, Ciudad ciudad) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.dniUsuario = dniUsuario;
		this.nombreUsuario = nombreUsuario;
		this.correoUsuario = correoUsuario;
		this.ciudad = ciudad;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}
