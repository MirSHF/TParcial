package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoPersona;

	@Size(min = 8, max = 8)
	@NotEmpty(message = "Ingresa DNI")
	@Column(name = "dniPersona", length = 15, nullable = false)
	private String dniPersona;

	@NotEmpty(message = "Ingresa Nombre")
	@Column(name = "nombrePersona", length = 25, nullable = false)
	private String nombrePersona;

	@NotEmpty(message = "Ingresa Correo")
	@Column(name = "correoPersona", length = 25, nullable = false)
	private String correoPersona;

	@ManyToOne
	@JoinColumn(name = "codigoCiudad")
	private Ciudad ciudad;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int codigoPersona, String dniPersona, String nombrePersona, String correoPersona, Ciudad ciudad) {
		super();
		this.codigoPersona = codigoPersona;
		this.dniPersona = dniPersona;
		this.nombrePersona = nombrePersona;
		this.correoPersona = correoPersona;
		this.ciudad = ciudad;
	}

	public int getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(int codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public String getDniPersona() {
		return dniPersona;
	}

	public void setDniPersona(String dniPersona) {
		this.dniPersona = dniPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getCorreoPersona() {
		return correoPersona;
	}

	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}