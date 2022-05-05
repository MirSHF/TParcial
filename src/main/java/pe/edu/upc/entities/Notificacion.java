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
@Table(name = "Notificacion")
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoNotificacion;

	@ManyToOne
	@JoinColumn(name = "idEvento", nullable = false)
	private Evento codigoEvento;

	@Column(name = "descripcionNotificacion", nullable = false)
	private String descripcionNotificacion;

	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notificacion(int codigoNotificacion, Evento codigoEvento, String descripcionNotificacion) {
		super();
		this.codigoNotificacion = codigoNotificacion;
		this.codigoEvento = codigoEvento;
		this.descripcionNotificacion = descripcionNotificacion;
	}

	public int getCodigoNotificacion() {
		return codigoNotificacion;
	}

	public void setCodigoNotificacion(int codigoNotificacion) {
		this.codigoNotificacion = codigoNotificacion;
	}

	public Evento getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(Evento codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public String getDescripcionNotificacion() {
		return descripcionNotificacion;
	}

	public void setDescripcionNotificacion(String descripcionNotificacion) {
		this.descripcionNotificacion = descripcionNotificacion;
	}

}
