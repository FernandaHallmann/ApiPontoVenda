package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
public class VendaController {

  @Inject
  private VendaService vendaService;

  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response cadastrarVenda(Venda venda) {
    try {
      vendaService.cadastrar(venda);
      return Response.status(201)
              .entity("Venda cadastrada com sucesso")
              .build();
    } catch (Exception ex) {
      return Response.status(403).entity(ex.getMessage()).build();
    }
  }
}
