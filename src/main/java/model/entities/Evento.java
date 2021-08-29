package model.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Evento extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private LocalDate data;
	private LocalTime hora;
	private String descricao;
	private String endereco;

	@ManyToMany(mappedBy = "eventos", cascade = CascadeType.ALL)
	private List<Usuario> usuarios = new ArrayList<>();

	public Evento() {

	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void adicionarParticipante(Usuario usuario) {
		if(this.usuarios == null) {
			this.usuarios = new ArrayList<>();
		}
		this.usuarios.add(usuario);
		if(usuario.getEventos() == null) {
			usuario.setEventos(new ArrayList<>());
		}
		usuario.getEventos().add(this);
	}

}
