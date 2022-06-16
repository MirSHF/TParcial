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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoEvento;

	@NotEmpty(message = "Ingrese Nombre")
	@Column(name = "nombreEvento", length = 20, nullable = false)
	private String nombreEvento;

	@NotEmpty(message = "Ingrese Descripcion")
	@Column(name = "descripcionEvento", length = 100, nullable = false)
	private String descripcionEvento;

	@NotNull
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaEvento", nullable = false)
	private Date fechaEvento;

	
	@Column(name = "cantidadAfectados", length = 10, nullable = false)
	private int cantidadAfectados;

	@ManyToOne
	@JoinColumn(name = "CodigoMagnitud")
	private Magnitud magnitud;

	@ManyToOne
	@JoinColumn(name = "codigoDistrito")
	private Distrito distrito;

	@ManyToOne
	@JoinColumn(name = "idEpicentro")
	private Epicentro epicentro;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(int codigoEvento, String nombreEvento, String descripcionEvento, Date fechaEvento,
			int cantidadAfectados, Magnitud magnitud, Distrito distrito, Epicentro epicentro) {
		super();
		this.codigoEvento = codigoEvento;
		this.nombreEvento = nombreEvento;
		this.descripcionEvento = descripcionEvento;
		this.fechaEvento = fechaEvento;
		this.cantidadAfectados = cantidadAfectados;
		this.magnitud = magnitud;
		this.distrito = distrito;
		this.epicentro = epicentro;
	}

	public int getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(int codigoEvento) {
		this.codigoEvento = codigoEvento;
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

}
