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
@Table(name = "Tarjeta")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoTarjeta;
	
	@Column(name = "numeroTarjeta", length = 16, nullable = false)
	private String numeroTarjeta;
	
	@ManyToOne
	@JoinColumn(name="codigoBanco")
	private Banco banco;

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarjeta(int codigoTarjeta, String numeroTarjeta, Banco banco) {
		super();
		this.codigoTarjeta = codigoTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.banco = banco;
	}

	public int getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public void setCodigoTarjeta(int codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

}