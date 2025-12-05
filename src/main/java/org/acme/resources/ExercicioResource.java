package org.acme.resources;

import java.util.List;

import org.acme.models.Exercicio;
import org.acme.repositories.ExercicioRepository;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/exercicios")
public class ExercicioResource {
    
    @Inject
    ExercicioRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Exercicio e) {
        return Response.ok(repository.create(e)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Exercicio e) {
        return Response.ok(repository.update(e)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(repository.delete(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercicio> list() {
        return repository.listAll();
    }
}
