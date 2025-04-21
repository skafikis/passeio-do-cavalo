package view;

import model.Posicao;
import model.Tabuleiro;

public class BuscaProfundidade implements PesquisaEstrategica {
    
    @Override
    public boolean resolucao(Tabuleiro tabuleiro, Posicao posicaoInicial) {
        int linha = posicaoInicial.getLinha();
        int coluna = posicaoInicial.getColuna();
        
        tabuleiro.marcarPosicao(linha, coluna, 0);

        return dfs(tabuleiro, linha, coluna, 1);
    }

    
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

                tabuleiro.desmarcarPosicao(novaLinha, novaColuna);
            }
        }
        return false;
    }
}
