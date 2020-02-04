package br.com.pbna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Saque;

@Repository
public interface SaqueRepository extends JpaRepository<Saque, Long> {
}
