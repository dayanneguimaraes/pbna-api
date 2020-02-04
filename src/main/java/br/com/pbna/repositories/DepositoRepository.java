package br.com.pbna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Deposito;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}
