package com.example.crudproject.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titulo;
    private String descricao;
    private LocalDate dataNova;
    private String status = "A Fazer";
    private String importancia;
    private LocalDate dataLimite;


    public Tarefa() {
        this.dataNova = LocalDate.now();
    }


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataNova() {
        return dataNova;
    }

    public String getStatus() {
        return status;
    }

    public String getImportancia() {
        return importancia;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataNova(LocalDate dataNova) {
        this.dataNova = dataNova;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }
}
