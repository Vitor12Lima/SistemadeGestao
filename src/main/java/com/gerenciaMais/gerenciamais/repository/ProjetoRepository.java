package com.gerenciaMais.gerenciamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciaMais.gerenciamais.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{

}
