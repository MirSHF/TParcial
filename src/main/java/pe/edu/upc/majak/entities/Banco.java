package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "Banco")
 
public class Banco {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoBanco;
    
	@NotEmpty(message = "Ingresa el nombre")
    @Column(name = "nombreBanco", nullable = false, length = 20)
	private String nombreBanco;
	public Banco() {
		super();
	
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
