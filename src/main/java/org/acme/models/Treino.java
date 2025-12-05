package org.acme.models;

import java.time.LocalDateTime;
import java.util.List;

public class Treino {
    
    private Long id;
    private String nome;
    private LocalDateTime dataHora;
    private Integer duracao; // em minutos
    private String observacao;
    private List<Long> exercicioIds;

    public Treino() { }

    public Treino(Long id, String nome, LocalDateTime dataHora, Integer duracao, String observacao, List<Long> exercicioIds) {
        this.id = id;
        this.nome = nome;
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.observacao = observacao;
        this.exercicioIds = exercicioIds;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public List<Long> getExercicioIds() { return exercicioIds; }
    public void setExercicioIds(List<Long> exercicioIds) { this.exercicioIds = exercicioIds; }
}
