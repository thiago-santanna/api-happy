package com.tss.webapps.happy.birthday.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.webapps.happy.birthday.api.dto.InputMensagemDto;
import com.tss.webapps.happy.birthday.api.dto.MensagemDto;
import com.tss.webapps.happy.birthday.api.entities.Mensagem;
import com.tss.webapps.happy.birthday.api.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository repository;

	public MensagemDto salvar(InputMensagemDto mensagem) {
		Mensagem mensagemCadastrada = repository
				.save(InputMensagemDto
						.toMensagem(mensagem));
		
		return mensagemCadastrada.toMensagemDto();
	}

	public MensagemDto trazerUma(Long id) {
		Optional<Mensagem> mensagem = repository.findById(id);
		if(mensagem.isEmpty()) {
			return null;
		}		
		return mensagem.get().toMensagemDto();
	}

	public List<MensagemDto> todas() {
		List<Mensagem> mensagens = repository.findAll();
		return Mensagem.mensagensDtoFrom(mensagens);
	}
}
