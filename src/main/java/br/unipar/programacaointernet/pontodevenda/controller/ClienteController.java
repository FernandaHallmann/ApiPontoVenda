package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteController {
  @Inject
  private ClienteService clienteService;

  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listarClientes() {
    return Response.ok(clienteService.listar()).build();
  }

  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response cadastrarCliente(Cliente cliente) {
    try {
      clienteService.cadastrar(cliente);
      return Response.status(201)
              .entity("Cliente cadastrado com sucesso")
              .build();
    } catch (Exception ex) {
      return Response.status(403).entity(ex.getMessage()).build();
    }
  }

  @PUT
  @Path("/{id}")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response editar(
          @PathParam("id") Integer id,
          String nome,
          String telefone
  ) {
    try {
      clienteService.editar(id, nome, telefone);
      return Response.status(200)
              .entity("Cliente editado com sucesso.")
              .build();
    } catch (Exception exception) {
      return Response.status(500).entity(exception.getMessage()).build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response deletarCliente(@PathParam("id") Integer id) {
    try {
      clienteService.deletar(id);
      return Response.status(200)
              .entity("Cliente deletada com sucesso")
              .build();
    } catch (Exception e) {
      return Response.status(500).entity(e.getMessage()).build();
    }
  }
}
