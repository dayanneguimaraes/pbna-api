package br.com.pbna.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	@Query("select c.valor from Conta c where c.id = :id")
	BigDecimal obterValorContaPorId(@Param("id") Long id);
}
