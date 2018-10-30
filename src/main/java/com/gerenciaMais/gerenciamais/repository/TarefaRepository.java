package com.gerenciaMais.gerenciamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciaMais.gerenciamais.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
