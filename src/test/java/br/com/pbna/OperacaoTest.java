package br.com.pbna;


import org.junit.Before;
import org.junit.Test;

import br.com.pbna.entidade.Agencia;
import br.com.pbna.entidade.Cliente;
import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.Operacao;
import br.com.pbna.negocio.AgenciaNegocio;
import br.com.pbna.negocio.ClienteNegocio;
import br.com.pbna.negocio.ContaNegocio;
import br.com.pbna.negocio.DepositoNegocio;
import br.com.pbna.negocio.SaqueNegocio;
import br.com.pbna.negocio.TransferenciaNegocio;

public class OperacaoTest {
	
	private AgenciaNegocio agenciaNegocio;
	private ClienteNegocio clienteNegocio;
	private DepositoNegocio depositoNegocio;
	private ContaNegocio contaNegocio;
	private SaqueNegocio saqueNegocio;
	private TransferenciaNegocio transferenciaNegocio;
	
	private Agencia agencia;
	private Cliente cliente;
	private Operacao operacao;
	private Conta conta;

	
	@Before
	public void setup() {
		depositoNegocio = new DepositoNegocio();
		contaNegocio = new ContaNegocio();
		saqueNegocio = new SaqueNegocio();
		transferenciaNegocio = new TransferenciaNegocio();
	}
	
	@Before
	public void criarAgencia() {
		agencia = new Agencia(1L, "Agencia 01");
	}
	
	@Before
	public void criarCliente() {
		cliente = new Cliente(1L, "José");
	}
	
	@Before
	public void criarOperacaoSaque() {
//		saqueNegocio.
	}
	
	@Test
	public void deveSalvarSaldo() {
		
//		Conta conta = 
//				
//				assertTrue(carrinhoComprasFactory.possuiCarrinho(idCliente));
//		
//		assertTrue(carrinhoCompras.getItens().isEmpty());
	}
	
	
}
