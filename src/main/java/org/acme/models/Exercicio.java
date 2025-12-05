package org.acme.models;

public class Exercicio {
    
    private Long id;
    private Long categoriaId;
    private String nome;
    private String descricao;

    public Exercicio() {  }

    public Exercicio(Long id, Long categoriaId, String nome, String descricao) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
