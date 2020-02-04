package br.com.pbna.negocio;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pbna.entidade.Conta;
import br.com.pbna.repositories.ContaRepository;

@Service("contaNegocio")
public class ContaNegocio {

	@Autowired
	private ContaRepository contaRepository;
	
	public Conta obter(Long id) {
		return this.contaRepository.findById(id).get();
	}
	
	public BigDecimal obterValorContaPorId(Long id) {
		return this.contaRepository.obterValorContaPorId(id);
	}
	
	@Transactional
	public void incluir(Conta conta) {
		this.contaRepository.save(conta);
	}

}
