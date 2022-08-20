package com.tss.webapps.happy.birthday.api.dto;

import java.time.LocalDateTime;

public class MensagemDto {
	private Long id;
	private String nomeOrEmail;
	private LocalDateTime createdAt;
	private String texto;

	public Long getId() {
		return id;
	}

	public String getNomeOrEmail() {
		return nomeOrEmail;
	}

	public LocalDateTime getDataMensagem() {
		return createdAt;
	}

	public String getTexto() {
		return texto;
	}

	public MensagemDto(Long id, String nomeOrEmail, LocalDateTime dataMensagem, String texto) {
		this.id = id;
		this.nomeOrEmail = nomeOrEmail;
		this.createdAt = dataMensagem;
		this.texto = texto;
	}

}
