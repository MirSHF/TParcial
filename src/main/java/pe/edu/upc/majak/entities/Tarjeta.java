package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoTarjeta;
	
	//@Digits(integer = 8, fraction = 0)
	
	//@Min(8) 
	//@Max(8)
	
	@Size(min = 8, max = 8 , message="debe tener solo 8 digitos")
	@NotEmpty(message = "Ingrese numero")
	@Column(name = "numeroTarjeta", length = 8, nullable = false)
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