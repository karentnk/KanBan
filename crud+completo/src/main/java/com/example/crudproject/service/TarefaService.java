package com.example.crudproject.service;

import com.example.crudproject.model.Tarefa;
import com.example.crudproject.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setStatus("A Fazer");
        tarefa.setDataNova(LocalDate.now());
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> tudoTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa moverTarefa(int id) {
        Tarefa tarefa = obterTarefaPorId(id);
        if ("A Fazer".equals(tarefa.getStatus())) {
            tarefa.setStatus("Em Progresso");
        } else if ("Em Progresso".equals(tarefa.getStatus())) {
            tarefa.setStatus("Concluída");
        } else {
            throw new RuntimeException("tarefa feita :)");
        }
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(int id, Tarefa tarefaAtualizada) {
        Tarefa tarefa = obterTarefaPorId(id);
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setImportancia(tarefaAtualizada.getImportancia());
        tarefa.setDataLimite(tarefaAtualizada.getDataLimite());
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(int id) {
        tarefaRepository.deleteById(id);
    }

    public Tarefa obterTarefaPorId(int id) {
        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Sem tarefa :("));
    }

    public List<Tarefa> filtrarTarefasPorPrioridadeEData(String prioridade, String dataLimite) {
        LocalDate data = LocalDate.parse(dataLimite);
        return tarefaRepository.findByImportanciaAndDataLimite(prioridade, data);
    }

    public List<Tarefa> listarTarefasAtrasadas() {
        LocalDate hoje = LocalDate.now();
        return tarefaRepository.findByStatusNotAndDataLimiteBefore("Concluída", hoje);
    }
    public List<List<Tarefa>> listarTarefasPorColunas() {
        List<Tarefa> aFazer = tarefaRepository.findByStatus("A Fazer");
        List<Tarefa> emProgresso = tarefaRepository.findByStatus("Em Progresso");
        List<Tarefa> concluido = tarefaRepository.findByStatus("Concluído");

        return List.of(aFazer, emProgresso, concluido);
    }

}
