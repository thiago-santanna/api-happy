package com.tss.webapps.happy.birthday.api.dto;

import java.time.LocalDate;

import com.tss.webapps.happy.birthday.api.entities.Mensagem;

public class InputMensagemDto {
	private String nomeOrEmail;
	private LocalDate createdAt;
	private String texto;

	public String getNomeOrEmail() {
		return nomeOrEmail;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public String getTexto() {
		return texto;
	}

	public InputMensagemDto(String nomeOrEmail, LocalDate createdAt, String texto) {
		this.nomeOrEmail = nomeOrEmail;
		this.createdAt = createdAt;
		this.texto = texto;
	}

	public static Mensagem toMensagem(InputMensagemDto mensagem) {
		return new Mensagem(mensagem.nomeOrEmail, mensagem.texto);
	}

}
