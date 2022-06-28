package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoCiudad;

	@NotEmpty(message = "Ingresa  una Ciudad")
	@Column(name = "nombreCiudad", nullable = false, length = 40)
	private String nombreCiudad;

	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudad(int codigoCiudad, String nombreCiudad) {
		super();
		this.codigoCiudad = codigoCiudad;
		this.nombreCiudad = nombreCiudad;
	}

	public int getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(int codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	

}
