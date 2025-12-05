package org.acme;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.acme.repositories.TreinoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.acme.models.Treino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TreinoRepositoryTest {

    private TreinoRepository treinoRepository;
    private List<Treino> mockList; 

    @BeforeEach
    void setup() {
        treinoRepository = new TreinoRepository();
        
        // Spy da lista interna
        mockList = Mockito.spy(new ArrayList<>());
        
        // Injeta a lista mock via reflexão
        try {
            var field = TreinoRepository.class.getDeclaredField("treinos");
            field.setAccessible(true);
            field.set(treinoRepository, mockList);
        } catch (Exception e) {
            fail("Erro ao injetar mock na lista interna.");
        }
    }

    @Test
    void testCreate() {
        Treino t = new Treino();
        t.setNome("Treino A");
        t.setDataHora(LocalDateTime.now());
        t.setDuracao(30);
        t.setObservacao("Obs");
        t.setExercicioIds(List.of(1L, 2L));

        Treino result = treinoRepository.create(t);

        assertNotNull(result.getId());
        assertEquals("Treino A", result.getNome());
        verify(mockList, times(1)).add(t);
    }

    @Test
    void testUpdateSuccess() {
        Treino original = new Treino();
        original.setId(0L);
        original.setNome("Original");
        mockList.add(original);

        Treino updated = new Treino();
        updated.setId(0L);
        updated.setNome("Novo Nome");
        updated.setDataHora(LocalDateTime.now());
        updated.setDuracao(50);
        updated.setObservacao("Nova Obs");
        updated.setExercicioIds(List.of(5L));

        Treino result = treinoRepository.update(updated);

        assertNotNull(result);
        assertEquals("Novo Nome", result.getNome());
        assertEquals(50, result.getDuracao());
        verify(mockList, atLeast(1)).get(0);
    }

    @Test
    void testUpdateNotFound() {
        Treino t = new Treino();
        t.setId(999L);

        Treino result = treinoRepository.update(t);

        assertNull(result);
    }

    @Test
    void testDeleteSuccess() {
        Treino t = new Treino();
        t.setId(0L);
        mockList.add(t);

        boolean result = treinoRepository.delete(0L);

        assertTrue(result);
        verify(mockList, times(1)).remove(0);
    }

    @Test
    void testDeleteNotFound() {
        boolean result = treinoRepository.delete(123L);

        assertFalse(result);
        verify(mockList, never()).remove(anyInt());
    }

    @Test
    void testListAll() {
        Treino t = new Treino();
        mockList.add(t);

        List<Treino> list = treinoRepository.listAll();

        assertEquals(1, list.size());
        assertSame(mockList, list);
    }
}
