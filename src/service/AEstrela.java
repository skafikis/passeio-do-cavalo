package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Posicao;
import model.Tabuleiro;

/**
 * Implementação do algoritmo A* para resolver o problema do Passeio do Cavalo.
 * 
 * A busca A* utiliza uma heurística (no caso, o número de movimentos válidos restantes),
 * para priorizar movimentos que reduzem a chance de becos sem saída.
 */
public class AEstrela implements PesquisaEstrategica {
    
    /**
     * Método de entrada da estratégia. Marca a posição inicial e inicia a recursão.
     *
     * @param tabuleiro O tabuleiro do passeio do cavalo.
     * @param posicaoInicial A posição onde o cavalo começa.
     * @return true se encontrou uma solução completa, false caso contrário.
     */
    @Override
    public boolean resolucao(Tabuleiro tabuleiro, Posicao posicaoInicial) {
        int linha = posicaoInicial.getLinha();
        int coluna = posicaoInicial.getColuna();
        
        // Marca a posição inicial com 0 (primeiro movimento).
        tabuleiro.marcarPosicao(linha, coluna, 0);
        
        // Chama o algoritmo A* a partir do segundo movimento (valor 1).
        return aEstrela(tabuleiro, linha, coluna, 1);
    }

    /**
     * Método recursivo que aplica a lógica do A* com heurística de Warnsdorff.
     *
     * @param tabuleiro O tabuleiro.
     * @param linha Linha atual do cavalo.
     * @param coluna Coluna atual do cavalo.
     * @param valor O número da jogada atual.
     * @return true se conseguiu completar o passeio, false se falhou.
     */
    private boolean aEstrela(Tabuleiro tabuleiro, int linha, int coluna, int valor) {
        // Caso base: todas as casas foram visitadas
        if (valor == tabuleiro.getTamanho() * tabuleiro.getTamanho()) {
            return true;
        }

        List<MovimentoCandidato> movimentoCandidatos = new ArrayList<>();
        int[][] movimentos = tabuleiro.getMovimentos(); // os 8 movimentos em L do cavalo

        // Para cada movimento possível, verifica se é válido e calcula seu "custo" heurístico
        for (int[] movimento : movimentos) {
            int novaLinha = linha + movimento[0];
            int novaColuna = coluna + movimento[1];

            if (tabuleiro.posicaoEhValida(novaLinha, novaColuna)) {
                // O custo aqui é o número de saídas válidas da nova posição (Warnsdorff)
                int custo = calcularCusto(tabuleiro, novaLinha, novaColuna);
                movimentoCandidatos.add(new MovimentoCandidato(novaLinha, novaColuna, custo));
            }
        }

        // Ordena os movimentos possíveis com base no custo (menos saídas primeiro)
        movimentoCandidatos.sort(Comparator.comparingInt(MovimentoCandidato::getCusto));

        // Tenta cada movimento, seguindo a ordem da heurística
        for (MovimentoCandidato candidato : movimentoCandidatos) {
            tabuleiro.marcarPosicao(candidato.getLinha(), candidato.getColuna(), valor);
            if (aEstrela(tabuleiro, candidato.getLinha(), candidato.getColuna(), valor + 1)) {
                return true;                
            }
            // Se falhar, a posição não é desmarcada (backtracking ausente aqui)
        }

        // Caso nenhum movimento leve à solução, retorna false
        return false;
    }

    /**
     * Calcula a heurística do movimento, baseada em Warnsdorff.
     * 
     * Ou seja, quantas casas o cavalo poderá ir a partir da nova posição.
     * Quanto menor esse número, mais "restrita" a posição é.
     *
     * @param tabuleiro O tabuleiro atual.
     * @param linha Nova linha do cavalo.
     * @param coluna Nova coluna do cavalo.
     * @return Número de movimentos possíveis (grau de liberdade).
     */
    private int calcularCusto(Tabuleiro tabuleiro, int linha, int coluna) {
        int custo = 0;
        int[][] movimentos = tabuleiro.getMovimentos();

        for (int[] movimento : movimentos) {
            int novaLinha = linha + movimento[0];
            int novaColuna = coluna + movimento[1];

            if (tabuleiro.posicaoEhValida(novaLinha, novaColuna)) {
                custo++;
            }
        }

        return custo;
    }

    /**
     * Classe interna que representa um movimento possível do cavalo,
     * com sua posição e o custo heurístico associado.
     */
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
