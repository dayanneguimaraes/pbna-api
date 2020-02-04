package br.com.pbna.negocio;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pbna.entidade.Transferencia;
import br.com.pbna.repositories.TransferenciaRepository;

@Service("transferenciaNegocio")
public class TransferenciaNegocio {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	public Transferencia obter(Long id) {
		return transferenciaRepository.findById(id).get();
	}

	public List<Transferencia> obterTransferencias() {
		return transferenciaRepository.findAll();
	}
	
	@Transactional
	public void incluir(Transferencia transferencia) {
		BigDecimal valorConta = this.contaNegocio.obterValorContaPorId(transferencia.getConta().getId());
		
		if (valorConta.compareTo(transferencia.getValor()) >= 0) {
			transferencia.getConta().setValor(valorConta.subtract(transferencia.getValor()));
			this.transferenciaRepository.save(transferencia);
		} else {
		}
		
	}
	
	@Transactional
	public void alterar(Transferencia transferencia) {
		this.transferenciaRepository.save(transferencia);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.transferenciaRepository.deleteById(id);
	}


}
