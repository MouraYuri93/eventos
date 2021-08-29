package repository;

import javax.inject.Named;

import dao.DAOForImplementation;
import model.entities.Evento;

@Named
public class EventoRepository extends DAOForImplementation<Evento> {

	private static final long serialVersionUID = 1L;

	public EventoRepository() {
		super(Evento.class);
	}

	@Override
	protected void doUpdate(Evento entityManaged, Evento entity) {

	}

	@Override
	protected void veriFyIfValid(Evento entity) {

	}

	@Override
	protected boolean veriFyIfAlreadyExists(Evento entity) {

		return false;
	}

}
