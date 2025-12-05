package org.acme;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.acme.repositories.ExercicioRepository;

import java.util.List;

import org.acme.models.Exercicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExercicioRepositoryTest {

    private ExercicioRepository repository;

    @BeforeEach
    void setup() {
        repository = new ExercicioRepository();
    }

    @Test
    void testCreate() {
        Exercicio exercicio = mock(Exercicio.class);

        when(exercicio.getId()).thenReturn(null);
        doNothing().when(exercicio).setId(anyLong());

        Exercicio created = repository.create(exercicio);

        assertNotNull(created);
        verify(exercicio).setId(0L);
    }

    @Test
    void testUpdateSuccess() {
        Exercicio original = mock(Exercicio.class);
        doNothing().when(original).setId(anyLong());
        repository.create(original);

        when(original.getId()).thenReturn(0L);

        Exercicio updated = mock(Exercicio.class);
        when(updated.getId()).thenReturn(0L);
        when(updated.getCategoriaId()).thenReturn(10L);
        when(updated.getNome()).thenReturn("Novo Nome");
        when(updated.getDescricao()).thenReturn("Nova Desc");

        Exercicio result = repository.update(updated);

        assertNotNull(result);
        verify(repository.listAll().get(0)).setCategoriaId(10L);
        verify(repository.listAll().get(0)).setNome("Novo Nome");
        verify(repository.listAll().get(0)).setDescricao("Nova Desc");
    }

    @Test
    void testUpdateFailWhenNotFound() {
        Exercicio exercicio = mock(Exercicio.class);
        when(exercicio.getId()).thenReturn(999L);

        Exercicio result = repository.update(exercicio);

        assertNull(result);
    }

    @Test
    void testDeleteSuccess() {
        Exercicio exercicio = mock(Exercicio.class);
        doNothing().when(exercicio).setId(anyLong());

        repository.create(exercicio);
        when(exercicio.getId()).thenReturn(0L);

        assertTrue(repository.delete(0L));
        assertEquals(0, repository.listAll().size());
    }

    @Test
    void testDeleteFail() {
        assertFalse(repository.delete(55L));
    }

    @Test
    void testListAll() {
        Exercicio e1 = mock(Exercicio.class);
        Exercicio e2 = mock(Exercicio.class);

        doNothing().when(e1).setId(anyLong());
        doNothing().when(e2).setId(anyLong());

        repository.create(e1);
        repository.create(e2);

        List<Exercicio> list = repository.listAll();

        assertEquals(2, list.size());
    }
}
