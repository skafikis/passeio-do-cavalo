package service;

import model.Posicao;
import model.Tabuleiro;

/**
 * Interface para definir a estratégia de pesquisa a ser utilizada na resolução do problema do passeio do cavalo.
 * As implementações desta interface devem fornecer um método para resolver o problema dado um tabuleiro e uma posição inicial.
 */
public interface PesquisaEstrategica {

    /**
     * Método para resolver o problema do passeio do cavalo.
     *
     * @param tabuleiro O tabuleiro onde o cavalo se moverá.
     * @param posicaoInicial A posição inicial do cavalo no tabuleiro.
     * @return true se uma solução for encontrada, false caso contrário.
     */
    boolean resolucao(Tabuleiro tabuleiro, Posicao posicaoInicial);
}
