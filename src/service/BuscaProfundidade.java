package service;

import model.Posicao;
import model.Tabuleiro;

/**
 * Implementação da busca em profundidade (DFS) para resolver o problema do passeio do cavalo.
 * Esta classe implementa a interface PesquisaEstrategica.
 */
public class BuscaProfundidade implements PesquisaEstrategica {
    
    /**
     * Método que inicia a resolução do problema do passeio do cavalo utilizando busca em profundidade.
     *
     * @param tabuleiro O tabuleiro onde o cavalo se moverá.
     * @param posicaoInicial A posição inicial do cavalo no tabuleiro.
     * @return true se uma solução for encontrada, false caso contrário.
     */
    @Override
    public boolean resolucao(Tabuleiro tabuleiro, Posicao posicaoInicial) {
        int linha = posicaoInicial.getLinha();
        int coluna = posicaoInicial.getColuna();
        
        tabuleiro.marcarPosicao(linha, coluna, 0);

        return dfs(tabuleiro, linha, coluna, 1);
    }

    /**
     * Método recursivo que implementa a busca em profundidade para encontrar uma solução.
     *
     * @param tabuleiro O tabuleiro onde o cavalo se moverá.
     * @param linha A linha atual do cavalo.
     * @param coluna A coluna atual do cavalo.
     * @param valor O valor atual a ser marcado (passo) no tabuleiro.
     * @return true se uma solução for encontrada, false caso contrário.
     */
    private boolean dfs(Tabuleiro tabuleiro, int linha, int coluna, int valor) {
        if (valor == tabuleiro.getTamanho() * tabuleiro.getTamanho()) {
            return true;
        }

        int[][] movimentos = tabuleiro.getMovimentos();
        for (int[] movimento : movimentos) {
            int novaLinha = linha + movimento[0];
            int novaColuna = coluna + movimento[1];

            if (tabuleiro.posicaoEhValida(novaLinha, novaColuna)) {
                tabuleiro.marcarPosicao(novaLinha, novaColuna, valor);

                if (dfs(tabuleiro, novaLinha, novaColuna, valor + 1)) {
                    return true;
                }

                // Desmarcar a posição se não levar a uma solução (Backtracking)
                tabuleiro.desmarcarPosicao(novaLinha, novaColuna);
            }
        }
        return false;
    }
}
