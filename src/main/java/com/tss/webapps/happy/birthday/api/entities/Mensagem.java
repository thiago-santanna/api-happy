package com.tss.webapps.happy.birthday.api.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.tss.webapps.happy.birthday.api.dto.MensagemDto;

@Entity(name = "td_mensagens")
public class Mensagem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@Column(length = 100, nullable = false)
	private String nomeOrEmail;

	private String texto;

	@CreationTimestamp
	private LocalDate createdAt = LocalDate.now();

	public Long getId() {
		return id;
	}

	public String getNomeOrEmail() {
		return nomeOrEmail;
	}

	public LocalDate getDataMensagem() {
		return createdAt;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeOrEmail(String nomeOrEmail) {
		this.nomeOrEmail = nomeOrEmail;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Mensagem(String nomeOrEmail, String texto) {
		this.nomeOrEmail = nomeOrEmail;
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeOrEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomeOrEmail, other.nomeOrEmail);
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", nomeOrEmail=" + nomeOrEmail + ", dataMensagem=" + createdAt + ", texto="
				+ texto + "]";
	}
	
	public MensagemDto toMensagemDto() {
		return new MensagemDto(this.id, this.nomeOrEmail, this.createdAt, this.texto);
	}
	
	public static List<MensagemDto> mensagensDtoFrom(List<Mensagem> mensagens){
		List<MensagemDto> mensagensDto = mensagens
				.stream()
				.map(msg -> msg.toMensagemDto())
				.collect(Collectors.toList());
		return mensagensDto;
	}

	public Mensagem(Long id, String nomeOrEmail, String texto) {
		this.id = id;
		this.nomeOrEmail = nomeOrEmail;
		this.texto = texto;
	}
	
	public Mensagem() {}

	
}
