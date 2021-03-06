package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Epicentro")
public class Epicentro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEpicentro;
	
	
	
	@NotEmpty(message = "Ingrese latitud")
	@Column(name = "latitud", nullable = false, length = 44)
	private String latitud;
	
	
	@NotEmpty(message = "Ingrese Altitud")
	@Column(name = "altitud", nullable = false, length = 44)
	private String altitud;
	
	
	@NotEmpty(message = "Ingrese Radio")
	@Column(name = "radioEpicentro", nullable = false, length = 8)
	private String radioEpicentro;

	public Epicentro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Epicentro(int idEpicentro, String latitud, String altitud, String radioEpicentro) {
		super();
		this.idEpicentro = idEpicentro;
		this.latitud = latitud;
		this.altitud = altitud;
		this.radioEpicentro = radioEpicentro;
	}

	public int getIdEpicentro() {
		return idEpicentro;
	}

	public void setIdEpicentro(int idEpicentro) {
		this.idEpicentro = idEpicentro;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getAltitud() {
		return altitud;
	}

	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}

	public String getRadioEpicentro() {
		return radioEpicentro;
	}

	public void setRadioEpicentro(String radioEpicentro) {
		this.radioEpicentro = radioEpicentro;
	}

}
