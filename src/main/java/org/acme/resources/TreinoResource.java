package org.acme.resources;

import java.util.List;

import org.acme.models.Treino;
import org.acme.repositories.TreinoRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/treinos")
public class TreinoResource {
    
    @Inject
    TreinoRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Treino> list() {
        return repository.listAll();
    }
}
