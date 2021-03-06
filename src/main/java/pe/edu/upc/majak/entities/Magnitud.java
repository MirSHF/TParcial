package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Magnitud")
public class Magnitud {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CodigoMagnitud;

	@NotEmpty(message = "Ingrese Nombre")
	@Column(name = "NombreMagnitud", nullable = false, length = 44)
	private String NombreMagnitud;

	
	@NotEmpty(message = "Ingrese Escala")
	@Column(name = "EscalaMagnitud", nullable = false, length = 44)
	private String EscalaMagnitud;

	public Magnitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magnitud(int codigoMagnitud, String nombreMagnitud, String escalaMagnitud) {
		super();
		CodigoMagnitud = codigoMagnitud;
		NombreMagnitud = nombreMagnitud;
		EscalaMagnitud = escalaMagnitud;
	}

	public int getCodigoMagnitud() {
		return CodigoMagnitud;
	}

	public void setCodigoMagnitud(int codigoMagnitud) {
		CodigoMagnitud = codigoMagnitud;
	}

	public String getNombreMagnitud() {
		return NombreMagnitud;
	}

	public void setNombreMagnitud(String nombreMagnitud) {
		NombreMagnitud = nombreMagnitud;
	}

	public String getEscalaMagnitud() {
		return EscalaMagnitud;
	}

	public void setEscalaMagnitud(String escalaMagnitud) {
		EscalaMagnitud = escalaMagnitud;
	}

}