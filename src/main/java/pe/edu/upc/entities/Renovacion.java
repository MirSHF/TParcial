package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Renovacion")
public class Renovacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CodigoRenovacion;

	@ManyToOne
	@JoinColumn(name = "codigoTarjeta", nullable = false)
	private Tarjeta tarjeta;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@Column(name = "NumeroTarjeta", nullable = false)
	private String numerotarjeta;

	@Column(name = "fechaRenovacion", nullable = false)
	private Date fecharenovacion;

	public Renovacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Renovacion(int codigoRenovacion, Tarjeta tarjeta, Usuario usuario, String numerotarjeta,
			Date fecharenovacion) {
		super();
		CodigoRenovacion = codigoRenovacion;
		this.tarjeta = tarjeta;
		this.usuario = usuario;
		this.numerotarjeta = numerotarjeta;
		this.fecharenovacion = fecharenovacion;
	}

	public int getCodigoRenovacion() {
		return CodigoRenovacion;
	}

	public void setCodigoRenovacion(int codigoRenovacion) {
		CodigoRenovacion = codigoRenovacion;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumerotarjeta() {
		return numerotarjeta;
	}

	public void setNumerotarjeta(String numerotarjeta) {
		this.numerotarjeta = numerotarjeta;
	}

	public Date getFecharenovacion() {
		return fecharenovacion;
	}

	public void setFecharenovacion(Date fecharenovacion) {
		this.fecharenovacion = fecharenovacion;
	}

	
}
