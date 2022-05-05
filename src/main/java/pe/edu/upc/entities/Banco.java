package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Banco")
public class Banco {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoBanco;
	
	@Column(name="nombeBanco", nullable=false, length=47)
	private String nombreBanco;

	public Banco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banco(int codigoBanco, String nombreBanco) {
		super();
		this.codigoBanco = codigoBanco;
		this.nombreBanco = nombreBanco;
	}

	public int getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(int codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

}
