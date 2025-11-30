package org.acme.resources;

import java.util.List;

import org.acme.models.Exercicio;
import org.acme.repositories.ExercicioRepository;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/exercicios")
public class ExercicioResource {
    
    @Inject
    ExercicioRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercicio> list() {
        return repository.listAll();
    }
}
