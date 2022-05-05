package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CodigoTarjeta;

	@Column(name = "NumeroTarjeta", nullable = false)
	private String numerotarjeta;

	@ManyToOne
	@JoinColumn(name = "codigoBanco", nullable = false)
	private Banco codigobanco;

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarjeta(int codigoTarjeta, String numerotarjeta, Banco codigobanco) {
		super();
		CodigoTarjeta = codigoTarjeta;
		this.numerotarjeta = numerotarjeta;
		this.codigobanco = codigobanco;
	}

	public int getCodigoTarjeta() {
		return CodigoTarjeta;
	}

	public void setCodigoTarjeta(int codigoTarjeta) {
		CodigoTarjeta = codigoTarjeta;
	}

	public String getNumerotarjeta() {
		return numerotarjeta;
	}

	public void setNumerotarjeta(String numerotarjeta) {
		this.numerotarjeta = numerotarjeta;
	}

	public Banco getCodigobanco() {
		return codigobanco;
	}

	public void setCodigobanco(Banco codigobanco) {
		this.codigobanco = codigobanco;
	}

}
