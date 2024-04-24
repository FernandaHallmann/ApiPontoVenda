package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteRepository {
  @PersistenceContext(unitName = "HibernateMaven")
  private EntityManager em;

  public List<Cliente> listarTodos() {
    String jpql = "SELECT c FROM Cliente c";
    return em.createQuery(jpql, Cliente.class).getResultList();
  }

  public Cliente buscarPorID(Integer id) {
    return em.find(Cliente.class, id);
  }

  public void cadastrar(Cliente cliente) throws Exception {
    try {
      em.persist(cliente);
    } catch (Exception ex) {
      throw new Exception("Cliente não pode ser cadastrado");
    }
  }

  public void editar(Cliente cliente) throws Exception {
    try {
      em.merge(cliente);
    } catch (Exception e) {
      throw new Exception("Erro, ao atualizar " + e.getMessage());
    }

  }

  public void deletar(Integer id) throws Exception{
    try{
      Cliente cliente = em.find(Cliente.class, id);

      em.remove(cliente);
    }catch (Exception e){
      throw new Exception("Não foi possível deletar esse cliente!" + e.getMessage());
    }
  }
}
