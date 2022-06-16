package pe.edu.upc.majak.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Notificacion")
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoNotificacion;
	
	@ManyToOne
	@JoinColumn(name = "codigoEvento")
	private Evento evento;

	@NotEmpty(message = "Ingrese Descripcion")
	@Column(name = "descripcionNotificacion", length = 50, nullable = false)
	private String descripcionNotificacion;

	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notificacion(int codigoNotificacion, Evento evento, String descripcionNotificacion) {
		super();
		this.codigoNotificacion = codigoNotificacion;
		this.evento = evento;
		this.descripcionNotificacion = descripcionNotificacion;
	}

	public int getCodigoNotificacion() {
		return codigoNotificacion;
	}

	public void setCodigoNotificacion(int codigoNotificacion) {
		this.codigoNotificacion = codigoNotificacion;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getDescripcionNotificacion() {
		return descripcionNotificacion;
	}

	public void setDescripcionNotificacion(String descripcionNotificacion) {
		this.descripcionNotificacion = descripcionNotificacion;
	}
	
	

}
