package view;

import model.Posicao;
import model.Tabuleiro;

public interface PesquisaEstrategica {
    boolean resolucao(Tabuleiro tabuleiro, Posicao posicaoInicial);
}
