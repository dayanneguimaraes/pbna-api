package br.com.pbna.negocio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pbna.entidade.Cliente;
import br.com.pbna.repositories.ClienteRepository;

@Service("clienteNegocio")
public class ClienteNegocio {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	public Cliente obter(Long id) {
		return this.clienteRepository.findById(id).get();
	}

	public List<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}
	
	@Transactional
	public void incluir(Cliente cliente) {
		cliente.getConta().getChavePrimaria().setId(this.contaNegocio.gerarNumeroSequencial());
		this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public void alterar(Cliente cliente) {
		this.contaNegocio.atualizarTipoConta(cliente.getConta().getChavePrimaria().getTipoConta(), cliente.getConta().getChavePrimaria());
		
		this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.clienteRepository.deleteById(id);
	}

}
