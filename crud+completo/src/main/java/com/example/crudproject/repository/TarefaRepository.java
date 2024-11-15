package com.example.crudproject.repository;

import com.example.crudproject.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    List<Tarefa> findByImportanciaAndDataLimite(String importancia, LocalDate dataLimite);
    List<Tarefa> findByStatusNotAndDataLimiteBefore(String status, LocalDate dataLimite);
    List<Tarefa> findByStatus(String status);

}
