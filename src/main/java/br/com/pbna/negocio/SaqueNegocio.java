package br.com.pbna.negocio;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pbna.entidade.Saque;
import br.com.pbna.repositories.ContaRepository;
import br.com.pbna.repositories.SaqueRepository;

@Service("saqueNegocio")
public class SaqueNegocio {
	
	@Autowired
	private SaqueRepository saqueRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Saque obter(Long id) {
		return saqueRepository.findById(id).get();
	}

	public List<Saque> obterSaques() {
		return saqueRepository.findAll();
	}
	
	@Transactional
	public void incluir(Saque saque) {
		BigDecimal valorConta = this.contaRepository.obterValorContaPorId(saque.getConta().getId());
		if (valorConta.compareTo(saque.getValor()) >= 0) {
			saque.getConta().setValor(valorConta.subtract(saque.getValor()));
			this.saqueRepository.save(saque);
		} else {
		}
	}
	
	@Transactional
	public void alterar(Saque saque) {
		this.saqueRepository.save(saque);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.saqueRepository.deleteById(id);
	}

}
