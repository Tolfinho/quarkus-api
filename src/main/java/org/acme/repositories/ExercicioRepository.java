package org.acme.repositories;

import java.util.ArrayList;
import java.util.List;

import org.acme.models.Exercicio;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExercicioRepository {

    private List<Exercicio> exercicios = new ArrayList<>();

    public ExercicioRepository() {
        exercicios.add(new Exercicio(1L, 1L, "Agachamento", "Exercício para pernas"));
        exercicios.add(new Exercicio(2L, 2L, "Supino", "Exercício para peito"));
        exercicios.add(new Exercicio(3L, 3L, "Corrida", "Cardio leve"));
    }

    public List<Exercicio> listAll() {
        return exercicios;
    }
}
