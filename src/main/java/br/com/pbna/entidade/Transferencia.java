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
@Table(name = "transferencia")
public class Transferencia extends SuperEntity<Long> {

	private static final long serialVersionUID = 6217271752661700394L;

	@Id 
	@Column(name = "id")
	@SequenceGenerator(name = "sequencialTransferencia", sequenceName = "transferencia_id_seq", allocationSize = 1)	
    @GeneratedValue(generator = "sequencialTransferencia")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
    
    @Column 
    private BigDecimal valor;    
    
    @Column
    private Date dataTransferencia;
    
	public Transferencia(Long id) {
		this.setId(id);
	}

	public Transferencia() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

}
