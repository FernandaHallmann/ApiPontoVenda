package br.unipar.programacaointernet.pontodevenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItensVenda implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Double valorUnitario;

  private Double valorTotal;

  private Integer quantidade;

  private Integer produto;

  private Integer idVenda;
}
