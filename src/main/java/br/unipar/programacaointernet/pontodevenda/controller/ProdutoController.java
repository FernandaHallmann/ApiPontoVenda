package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class ProdutoController {
  @Inject
  private ProdutoService produtoService;

  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response listarProdutos() {
    return Response.ok(produtoService.listar()).build();
  }

  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response cadastrarProduto(Produto produto) {
    try {
      produtoService.cadastrar(produto);
      return Response.status(201)
              .entity("Produto cadastrado com sucesso")
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
          String descricao,
          Double valor
  ) {
    try {
      produtoService.editar(id, descricao, valor);
      return Response.status(200)
              .entity("Produto editado com sucesso.")
              .build();
    } catch (Exception exception) {
      return Response.status(500).entity(exception.getMessage()).build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response deletarProduto(@PathParam("id") Integer id) {
    try {
      produtoService.deletar(id);
      return Response.status(200)
              .entity("Produto deletada com sucesso")
              .build();
    } catch (Exception e) {
      return Response.status(500).entity(e.getMessage()).build();
    }
  }
}
