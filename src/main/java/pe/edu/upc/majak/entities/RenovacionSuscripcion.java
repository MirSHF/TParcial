package pe.edu.upc.majak.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RenovacionSuscripcion")
public class RenovacionSuscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoSuscripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaRenovacion", nullable = false)
	private Date fechaRenovacion;
	
	@ManyToOne
	@JoinColumn(name="codigoPersona")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="codigoTarjeta")
	private Tarjeta tarjeta;

	public RenovacionSuscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RenovacionSuscripcion(int codigoSuscripcion, Date fechaRenovacion, Persona persona, Tarjeta tarjeta) {
		super();
		this.codigoSuscripcion = codigoSuscripcion;
		this.fechaRenovacion = fechaRenovacion;
		this.persona = persona;
		this.tarjeta = tarjeta;
	}

	public int getCodigoSuscripcion() {
		return codigoSuscripcion;
	}

	public void setCodigoSuscripcion(int codigoSuscripcion) {
		this.codigoSuscripcion = codigoSuscripcion;
	}

	public Date getFechaRenovacion() {
		return fechaRenovacion;
	}

	public void setFechaRenovacion(Date fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	
}
