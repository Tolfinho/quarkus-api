package org.acme.resources;

import java.util.List;
import org.acme.models.ExercicioCategoria;
import org.acme.repositories.ExercicioCategoriaRepository;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExercicioCategoriaResource {
    
    @Inject
    ExercicioCategoriaRepository repository;

    @POST
    public Response create(ExercicioCategoria c) {
        return Response.ok(repository.create(c)).build();
    }

    @GET
    public List<ExercicioCategoria> list() {
        return repository.listAll();
    }
}
