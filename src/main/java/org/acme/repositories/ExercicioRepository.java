package org.acme.repositories;

import java.util.ArrayList;
import java.util.List;

import org.acme.models.Exercicio;
import org.acme.models.ExercicioCategoria;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExercicioRepository {

    private List<Exercicio> exercicios = new ArrayList<>();
    private Long idCounter = 0L;

    public ExercicioRepository() {
        // exercicios.add(new Exercicio(1L, 1L, "Agachamento", "Exercício para pernas"));
        // exercicios.add(new Exercicio(2L, 2L, "Supino", "Exercício para peito"));
        // exercicios.add(new Exercicio(3L, 3L, "Corrida", "Cardio leve"));
    }

    public Exercicio create(Exercicio e) {
        e.setId(this.idCounter++);
        this.exercicios.add(e);
        return e;
    }

    public Exercicio update(Exercicio e) {
        var index = this.getExercicioIndex(e.getId());
        if(index == -1) return null;

        this.exercicios.get(index).setCategoriaId(e.getCategoriaId());
        this.exercicios.get(index).setNome(e.getNome());
        this.exercicios.get(index).setDescricao(e.getDescricao());

        return this.exercicios.get(index);
    }

    public boolean delete(Long id) {
        var index = this.getExercicioIndex(id);
        if(index == -1) return false;

        this.exercicios.remove(index);
        return true;
    }

    public List<Exercicio> listAll() {
        return this.exercicios;
    }

    private int getExercicioIndex(Long id) {
        int index = -1;

        for(var i=0; i<this.exercicios.size(); i++) {
            if(this.exercicios.get(i).getId().equals(id))
                index = i;
        }

        return index;
    }
}
