package br.com.pbna.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pbna.entidade.Saque;
import br.com.pbna.negocio.SaqueNegocio;

@RestController
@RequestMapping("/saque")
public class SaqueRest {
	
	@Autowired
	private SaqueNegocio saqueNegocio;
	
	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody Saque saque) {
		saqueNegocio.incluir(saque);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
