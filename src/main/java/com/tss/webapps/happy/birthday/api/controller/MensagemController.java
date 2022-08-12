package com.tss.webapps.happy.birthday.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tss.webapps.happy.birthday.api.dto.InputMensagemDto;
import com.tss.webapps.happy.birthday.api.dto.MensagemDto;
import com.tss.webapps.happy.birthday.api.service.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
	
	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping
	public ResponseEntity<List<MensagemDto>> todasMensagens(){
		List<MensagemDto> dtos = mensagemService.todas();
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MensagemDto> verMensagem(@PathVariable Long id){
		if(id.equals(null)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
		
		MensagemDto dto = mensagemService.trazerUma(id);
		
		return new ResponseEntity<MensagemDto>(dto, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<MensagemDto> deixarMensagem(@RequestBody InputMensagemDto mensagem){
		
		if(mensagem.getNomeOrEmail().equals(null)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
		if(mensagem.getTexto().equals(null)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		MensagemDto dto = mensagemService.salvar(mensagem);		
		return new ResponseEntity<MensagemDto>(dto, HttpStatus.CREATED);
	}
	
	
}
