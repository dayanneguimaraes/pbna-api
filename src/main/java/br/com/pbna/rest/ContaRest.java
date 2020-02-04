package br.com.pbna.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pbna.entidade.Conta;
import br.com.pbna.negocio.ContaNegocio;

@RestController
@RequestMapping("/conta")
public class ContaRest {
	
	private ContaNegocio contaNegocio;
	
	@GetMapping
	public ResponseEntity<Conta> obterExtrato() {
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
}
