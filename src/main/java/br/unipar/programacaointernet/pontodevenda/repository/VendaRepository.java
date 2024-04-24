package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class VendaRepository {
  @PersistenceContext(unitName = "HibernateMaven")
  private EntityManager em;

  public void cadastrar(Venda venda) throws Exception {
    try {
      em.persist(venda);
    } catch (Exception ex) {
      throw new Exception("Venda não pode ser cadastrado");
    }
  }
}
