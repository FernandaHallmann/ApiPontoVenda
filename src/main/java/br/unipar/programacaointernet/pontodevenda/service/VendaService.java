package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class VendaService {
  @Inject
  private VendaRepository vendaRepository;

  public void cadastrar(Venda venda) throws Exception {
    vendaRepository.cadastrar(venda);
  }
}
