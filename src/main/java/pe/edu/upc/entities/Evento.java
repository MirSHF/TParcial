package pe.edu.upc.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoEvento;
	
	@ManyToOne
	@JoinColumn(name = "idMagnitud", nullable = false)
	private Magnitud magnitud;
	
	@ManyToOne
	@JoinColumn(name = "idDistrito", nullable = false)
	private Distrito distrito;
	
	@OneToOne
	@JoinColumn(name = "idEpicentro", nullable = false)
	private Epicentro epicentro;
	
	@Column(name = "nombreEvento", nullable = false)
	private String nombreEvento;
	
	@Column(name = "descripcionEvento", nullable = false)
	private String descripcionEvento;
	
	@Column(name = "fechaEvento", nullable = false)
	private Date fechaEvento;
	
	@Column(name = "cantidadAfectados", nullable = false)
	private int cantidadAfectados;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(int codigoEvento, Magnitud magnitud, Distrito distrito, Epicentro epicentro, String nombreEvento,
			String descripcionEvento, Date fechaEvento, int cantidadAfectados) {
		super();
		this.codigoEvento = codigoEvento;
		this.magnitud = magnitud;
		this.distrito = distrito;
		this.epicentro = epicentro;
		this.nombreEvento = nombreEvento;
		this.descripcionEvento = descripcionEvento;
		this.fechaEvento = fechaEvento;
		this.cantidadAfectados = cantidadAfectados;
	}

	public int getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(int codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public Magnitud getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(Magnitud magnitud) {
		this.magnitud = magnitud;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Epicentro getEpicentro() {
		return epicentro;
	}

	public void setEpicentro(Epicentro epicentro) {
		this.epicentro = epicentro;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getDescripcionEvento() {
		return descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public int getCantidadAfectados() {
		return cantidadAfectados;
	}

	public void setCantidadAfectados(int cantidadAfectados) {
		this.cantidadAfectados = cantidadAfectados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return codigoEvento == other.codigoEvento;
	}

}
