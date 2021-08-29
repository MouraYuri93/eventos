package controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.entities.Evento;
import repository.EventoRepository;

@Named
@ViewScoped
public class EventoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EventoRepository eventoRepository;

	private Evento evento;
	private List<Evento> eventos;

	private String data;
	private String hora;

	private DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

	@PostConstruct
	public void init() {
		this.evento = new Evento();
	}

	public void cadastrar() {
		this.hora += ":00";
		LocalDate data = LocalDate.parse(this.data, formatterData);
		LocalTime hora = LocalTime.parse(this.hora, formatterHora);
		evento.setData(data);
		evento.setHora(hora);
		eventoRepository.save(evento);
	}

	public List<Evento> getEventos() {
		if (eventos == null) {
			eventos = new ArrayList<>();
		}
		try {
			eventos = eventoRepository.findAll();
		} catch (Exception e) {
		}
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
