package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ProdutoRepository {
  @PersistenceContext(unitName = "HibernateMaven")
  private EntityManager em;

  public List<Produto> listarTodos() {
    String jpql = "SELECT p FROM Produto p";
    return em.createQuery(jpql, Produto.class).getResultList();
  }

  public Produto buscarPorID(Integer id) {
    return em.find(Produto.class, id);
  }

  public void cadastrar(Produto produto) throws Exception {
    try {
      em.persist(produto);
    } catch (Exception ex) {
      throw new Exception("Produto não pode ser cadastrado");
    }
  }

  public void editar(Produto produto) throws Exception {
    try {
      em.merge(produto);
    } catch (Exception e) {
      throw new Exception("Erro, ao atualizar " + e.getMessage());
    }

  }

  public void deletar(Integer id) throws Exception{
    try{
      Produto produto = em.find(Produto.class, id);

      em.remove(produto);
    }catch (Exception e){
      throw new Exception("Não foi possível deletar esse produto!" + e.getMessage());
    }
  }
}
