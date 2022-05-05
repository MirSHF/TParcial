package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Epicentro")
public class Epicentro {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoEpicentro;
	
	@Column(name = "latitud", nullable = false, length = 47)
	private String latitud;
	
	@Column(name = "altitud", nullable = false, length = 47)
	private String altitud;
	
	@Column(name = "radioEpicentro", nullable = false, length = 47)
	private String radioEpicentro;
	
	public Epicentro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Epicentro(int codigoEpicentro, String latitud, String altitud, String radioEpicentro) {
		super();
		this.codigoEpicentro = codigoEpicentro;
		this.latitud = latitud;
		this.altitud = altitud;
		this.radioEpicentro = radioEpicentro;
	}

	public int getCodigoEpicentro() {
		return codigoEpicentro;
	}

	public void setCodigoEpicentro(int codigoEpicentro) {
		this.codigoEpicentro = codigoEpicentro;
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
