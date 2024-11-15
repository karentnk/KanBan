package com.example.crudproject.controller;

import com.example.crudproject.model.Tarefa;
import com.example.crudproject.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }
    @GetMapping
    public List<Tarefa> todasTarefas() {
        return tarefaService.tudoTarefas();
    }

    @PutMapping("/{id}/mover")
    public Tarefa moverTarefa(@PathVariable int id) {
        return tarefaService.moverTarefa(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable int id) {
        tarefaService.deletarTarefa(id);
    }

    @GetMapping("/filtro")
    public List<Tarefa> filtrarTarefas(@RequestParam String prioridade, @RequestParam String dataLimite) {
        return tarefaService.filtrarTarefasPorPrioridadeEData(prioridade, dataLimite);
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> listarTarefasAtrasadas() {
        return tarefaService.listarTarefasAtrasadas();
    }
    @GetMapping("/por-colunas")
    public List<List<Tarefa>> listarPorColunas() {
        return tarefaService.listarTarefasPorColunas();
    }
}