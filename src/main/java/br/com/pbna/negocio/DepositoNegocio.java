package br.com.pbna.negocio;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pbna.entidade.Deposito;
import br.com.pbna.repositories.DepositoRepository;

@Service("depositoNegocio")
public class DepositoNegocio {
	
	@Autowired
	private DepositoRepository depositoRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	public Deposito obter(Long id) {
		return depositoRepository.findById(id).get();
	}

	public List<Deposito> obterDepositos() {
		return depositoRepository.findAll();
	}
	
	@Transactional
	public void incluir(Deposito deposito) {
		BigDecimal valor = contaNegocio.obterValorContaPorId(deposito.getConta().getId());
		deposito.getConta().setValor(valor.add(deposito.getValor()));
		this.depositoRepository.save(deposito);
	}
	
	@Transactional
	public void alterar(Deposito deposito) {
		this.depositoRepository.save(deposito);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.depositoRepository.deleteById(id);
	}

}
