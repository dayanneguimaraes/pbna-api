package br.com.pbna.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "deposito")
public class Deposito extends SuperEntity<Long> {

	private static final long serialVersionUID = 6217271752661700394L;

	@Id 
	@SequenceGenerator(name = "sequencialDeposito", sequenceName = "deposito_id_seq", allocationSize = 1)	
    @GeneratedValue(generator = "sequencialDeposito")
    @Column(name = "id")
	private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
    
    @Column 
    private BigDecimal valor;   
    
    @Column
    private Date dataDeposito = new Date();
    
	public Deposito(Long id) {
		this.setId(id);
	}

	public Deposito() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
