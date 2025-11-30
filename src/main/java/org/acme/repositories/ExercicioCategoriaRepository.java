package org.acme.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.models.ExercicioCategoria;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExercicioCategoriaRepository {
    
    private List<ExercicioCategoria> categorias = new ArrayList<>();
    private Long idCounter = 1L;

    public ExercicioCategoriaRepository() {
        // categorias.add(new ExercicioCategoria(1L, "Pernas"));
        // categorias.add(new ExercicioCategoria(2L, "Peito"));
        // categorias.add(new ExercicioCategoria(3L, "Cardio"));
    }

    public ExercicioCategoria create(ExercicioCategoria c) {
        c.setId(idCounter++);
        this.categorias.add(c);
        return c;
    }

    public ExercicioCategoria update(ExercicioCategoria c) {
        var index = this.getCategoriaIndex(c.getId());
        if(index == -1) return null;

        this.categorias.get(index).setNome(c.getNome());

        return this.categorias.get(index);
    }

    public boolean delete(Long id) {
        var index = this.getCategoriaIndex(id);
        if(index == -1) return false;

        this.categorias.remove(index);
        return true;
    }

    public List<ExercicioCategoria> listAll() {
        return this.categorias;
    }

    public ExercicioCategoria getById(Long id) {
        ExercicioCategoria foundCategoria = null;

        for(var i=0; i<this.categorias.size(); i++) {
            if(this.categorias.get(i).getId().equals(id))
                foundCategoria = this.categorias.get(i);
        }

        return foundCategoria;
    }

    private int getCategoriaIndex(Long id) {
        int index = -1;

        for(var i=0; i<this.categorias.size(); i++) {
            if(this.categorias.get(i).getId().equals(id))
                index = i;
        }

        return index;
    }
}
