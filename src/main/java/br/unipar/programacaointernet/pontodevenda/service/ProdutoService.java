package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.repository.ProdutoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProdutoService {

  @Inject
  private ProdutoRepository produtoRepository;

  public List<Produto> listar() {
    return produtoRepository.listarTodos();
  }
  public void cadastrar(Produto produto) throws Exception {
    produtoRepository.cadastrar(produto);
  }

  public void editar(Integer id, String descricao, Double valor) throws Exception {
    Produto produtoAtual = produtoRepository.buscarPorID(id);

    if (descricao != null) {
      produtoAtual.setDescricao(descricao);
    }

    if (valor != null) {
      produtoAtual.setValorUnitario(valor);
    }

    produtoRepository.editar(produtoAtual);
  }

  public void deletar(Integer id) throws Exception{
    produtoRepository.deletar(id);
  }
}
