package org.acme.repositories;

import java.util.ArrayList;
import java.util.List;

import org.acme.models.Treino;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TreinoRepository {

    private List<Treino> treinos = new ArrayList<>();
    private Long idCounter = 0L;

    public TreinoRepository() {
        // treinos.add(new Treino(
        //         1L,
        //         "Treino A",
        //         LocalDateTime.now(),
        //         45,
        //         "Treino inicial",
        //         List.of(1L, 2L)
        // ));
    }

    public Treino create(Treino t) {
        t.setId(this.idCounter++);
        this.treinos.add(t);
        return t;
    }

    public Treino update(Treino t) {
        final var index = this.getTreinoIndex(t.getId());
        if (index == -1) { return null; };

        this.treinos.get(index).setNome(t.getNome());
        this.treinos.get(index).setDataHora(t.getDataHora());
        this.treinos.get(index).setDuracao(t.getDuracao());
        this.treinos.get(index).setObservacao(t.getObservacao());
        this.treinos.get(index).setExercicioIds(t.getExercicioIds());

        return this.treinos.get(index);
    }

    public boolean delete(Long id) {
        final var index = this.getTreinoIndex(id);
        if (index == -1) { return false; };

        this.treinos.remove(index);
        return true;
    }

    public List<Treino> listAll() {
        return this.treinos;
    }

    private int getTreinoIndex(Long id) {
        int index = -1;

        for (var i = 0; i < this.treinos.size(); i++) {
            if (this.treinos.get(i).getId().equals(id)) {
                index = i;
            }
        }

        return index;
    }
}
