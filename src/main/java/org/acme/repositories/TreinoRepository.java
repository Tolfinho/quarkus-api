package org.acme.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.acme.models.Treino;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TreinoRepository {

    private List<Treino> treinos = new ArrayList<>();

    public TreinoRepository() {
        treinos.add(new Treino(
                1L,
                "Treino A",
                LocalDateTime.now(),
                45,
                "Treino inicial",
                List.of(1L, 2L)
        ));
    }

    public List<Treino> listAll() {
        return treinos;
    }
}
