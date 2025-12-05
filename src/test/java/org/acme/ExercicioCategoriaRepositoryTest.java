package org.acme;

import org.acme.repositories.ExercicioCategoriaRepository;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.acme.models.ExercicioCategoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExercicioCategoriaRepositoryTest {

    private ExercicioCategoriaRepository repository;

    @BeforeEach
    public void setup() {
        repository = new ExercicioCategoriaRepository();
    }

    @Test
    public void testCreate() {
        ExercicioCategoria cat = new ExercicioCategoria();
        cat.setNome("Pernas");

        ExercicioCategoria created = repository.create(cat);

        assertNotNull(created.getId());
        assertEquals("Pernas", created.getNome());
        assertEquals(1, repository.listAll().size());
    }

    @Test
    public void testListAllInitiallyEmpty() {
        List<ExercicioCategoria> list = repository.listAll();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetById() {
        ExercicioCategoria cat = new ExercicioCategoria();
        cat.setNome("Peito");

        ExercicioCategoria created = repository.create(cat);

        ExercicioCategoria found = repository.getById(created.getId());

        assertNotNull(found);
        assertEquals("Peito", found.getNome());
    }

    @Test
    public void testGetByIdNotFound() {
        ExercicioCategoria found = repository.getById(999L);
        assertNull(found);
    }

    @Test
    public void testUpdate() {
        ExercicioCategoria cat = new ExercicioCategoria();
        cat.setNome("Cardio");

        ExercicioCategoria created = repository.create(cat);

        ExercicioCategoria updated = new ExercicioCategoria();
        updated.setId(created.getId());
        updated.setNome("Cardio Intenso");

        ExercicioCategoria result = repository.update(updated);

        assertNotNull(result);
        assertEquals("Cardio Intenso", result.getNome());
    }

    @Test
    public void testUpdateNotFound() {
        ExercicioCategoria fake = new ExercicioCategoria();
        fake.setId(999L);
        fake.setNome("Inexistente");

        ExercicioCategoria result = repository.update(fake);

        assertNull(result);
    }

    @Test
    public void testDelete() {
        ExercicioCategoria cat = new ExercicioCategoria();
        cat.setNome("Ombros");

        ExercicioCategoria created = repository.create(cat);

        boolean deleted = repository.delete(created.getId());

        assertTrue(deleted);
        assertTrue(repository.listAll().isEmpty());
    }

    @Test
    public void testDeleteNotFound() {
        boolean deleted = repository.delete(999L);
        assertFalse(deleted);
    }
}
