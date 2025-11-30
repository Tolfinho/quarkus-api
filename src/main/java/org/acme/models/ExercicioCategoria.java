package org.acme.models;

public class ExercicioCategoria {
    private Long id;
    private String nome;

    public ExercicioCategoria() {}

    public ExercicioCategoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
