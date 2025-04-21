package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Posicao;
import model.Tabuleiro;

public class AEstrela implements PesquisaEstrategica {
    
    @Override
    public boolean resolucao(Tabuleiro tabuleiro, Posicao posicaoInicial) {
        int linha = posicaoInicial.getLinha();
        int coluna = posicaoInicial.getColuna();
        tabuleiro.marcarPosicao(linha, coluna, 0);
        return aEstrela(tabuleiro, linha, coluna, 1);
    }

    private boolean aEstrela(Tabuleiro tabuleiro, int linha, int coluna, int valor) {
        if (valor == tabuleiro.getTamanho() * tabuleiro.getTamanho()) {
            return true;
        }

        List<MovimentoCandidato> movimentoCandidatos = new ArrayList<>();
        int[][] movimentos = tabuleiro.getMovimentos();

        for (int[] movimento : movimentos) {
            int novaLinha = linha + movimento[0];
            int novaColuna = coluna + movimento[1];

            if (tabuleiro.posicaoEhValida(novaLinha, novaColuna)) {
                int custo = calcularCusto(tabuleiro, novaLinha, novaColuna);
                movimentoCandidatos.add(new MovimentoCandidato(novaLinha, novaColuna, custo));
            }
        }

        movimentoCandidatos.sort(Comparator.comparingInt(MovimentoCandidato::getCusto));

        for (MovimentoCandidato candidato : movimentoCandidatos) {
            tabuleiro.marcarPosicao(candidato.getLinha(), candidato.getColuna(), valor);
            if (aEstrela(tabuleiro, candidato.getLinha(), candidato.getColuna(), valor + 1)) {
                return true;                
            }
        }
        return false;
    }

    private int calcularCusto(Tabuleiro tabuleiro, int linha, int coluna) {
        int custo = 0;
        int[][] movimentos = tabuleiro.getMovimentos();

        for (int[] movimento : movimentos) {
            int novaLinha = linha + movimento[0];
            int novaColuna = coluna + movimento[1];

            if (tabuleiro.posicaoEhValida(novaLinha, novaColuna)) {
                custo ++;
            }
        }

        return custo;
    }
    
    private static class MovimentoCandidato {
        int linha;
        int coluna;
        int custo;

        public MovimentoCandidato(int linha, int coluna, int custo) {
            this.linha = linha;
            this.coluna = coluna;
            this.custo = custo;
        }

        public int getLinha() {
            return linha;
        }

        public int getColuna() {
            return coluna;
        }

        public int getCusto() {
            return custo;
        }
    }
}
