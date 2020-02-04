package br.com.pbna.entidade;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.pbna.converter.TipoContaConverter;
import br.com.pbna.deserializer.TipoContaDeserializer;
import br.com.pbna.enums.TipoContaEnum;
import br.com.pbna.serialize.TipoContaSerializer;

@Entity
@Table(name = "conta")
public class Conta extends SuperEntity<Long> {

	private static final long serialVersionUID = 6217271752661700394L;

	@Id 
    @Column(name = "id")
	@SequenceGenerator(name = "sequencialConta", sequenceName = "conta_id_seq", allocationSize = 1)	
    @GeneratedValue(generator = "sequencialConta")
	private Long id;
	
    @Column(length = 1)
    @Convert(converter = TipoContaConverter.class)
    @JsonSerialize(using = TipoContaSerializer.class)
    @JsonDeserialize(using = TipoContaDeserializer.class)
    private TipoContaEnum tipoConta;
    
    @Column 
    private BigDecimal valor;      
    
    @OneToMany
    @JoinColumn(name = "id")
    private List<Saque> saques;
    
    @OneToMany
    @JoinColumn(name = "id")
    private List<Deposito> depositos;
    
    @OneToMany
    @JoinColumn(name = "id")
    private List<Transferencia> transferencias;
    
	public Conta(Long id) {
		this.setId(id);
	}

	public Conta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Saque> getSaques() {
		return saques;
	}

	public void setSaques(List<Saque> saques) {
		this.saques = saques;
	}

	public List<Deposito> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

}
