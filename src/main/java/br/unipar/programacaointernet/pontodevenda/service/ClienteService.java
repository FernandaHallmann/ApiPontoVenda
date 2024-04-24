package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {
  @Inject
  private ClienteRepository clienteRepository;

  public List<Cliente> listar() {
    return clienteRepository.listarTodos();
  }
  public void cadastrar(Cliente cliente) throws Exception {
    clienteRepository.cadastrar(cliente);
  }

  public void editar(Integer id, String nome, String telefone) throws Exception {
    Cliente clienteAtual = clienteRepository.buscarPorID(id);

    if (nome != null) {
      clienteAtual.setNome(nome);
    }

    if (telefone != null) {
      clienteAtual.setTelefone(telefone);
    }

    clienteRepository.editar(clienteAtual);
  }

  public void deletar(Integer id) throws Exception{
    clienteRepository.deletar(id);
  }
}
