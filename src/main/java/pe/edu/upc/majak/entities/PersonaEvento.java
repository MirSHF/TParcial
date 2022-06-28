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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="PersonaEvento")
public class PersonaEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoPersonaEvento;
	
	@ManyToOne
	@JoinColumn(name = "codigoPersona")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "codigoEvento")
	private Evento evento;
	
	@NotNull
	@Future(message = "La fecha debe ser posterior al día de hoy")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaPersonaEvento", nullable = false)
	private Date fechaPersonaEvento;

	public PersonaEvento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonaEvento(int codigoPersonaEvento, Persona persona, Evento evento, Date fechaPersonaEvento) {
		super();
		this.codigoPersonaEvento = codigoPersonaEvento;
		this.persona = persona;
		this.evento = evento;
		this.fechaPersonaEvento = fechaPersonaEvento;
	}

	public int getCodigoPersonaEvento() {
		return codigoPersonaEvento;
	}

	public void setCodigoPersonaEvento(int codigoPersonaEvento) {
		this.codigoPersonaEvento = codigoPersonaEvento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getFechaPersonaEvento() {
		return fechaPersonaEvento;
	}

	public void setFechaPersonaEvento(Date fechaPersonaEvento) {
		this.fechaPersonaEvento = fechaPersonaEvento;
	}


	
}
