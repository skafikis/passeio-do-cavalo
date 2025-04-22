package model;

public class Tabuleiro {

    private int tamanho;
    private int[][] tabuleiro;


    /**
     * Movimentos possíveis do cavalo no tabuleiro
     * 
     * O cavalo pode se mover em forma de "L", ou seja, duas casas em uma direção
     * e uma casa em outra direção. Os movimentos são representados por pares de
     * inteiros, onde o primeiro inteiro representa a mudança na linha e o segundo
     * inteiro representa a mudança na coluna.
     * 
     * Os movimentos são:
     * 2 casas para baixo e 1 casa para a direita
     * 2 casas para baixo e 1 casa para a esquerda
     * 2 casas para cima e 1 casa para a direita
     * 2 casas para cima e 1 casa para a esquerda
     * 1 casa para baixo e 2 casas para a direita
     * 1 casa para baixo e 2 casas para a esquerda
     * 1 casa para cima e 2 casas para a direita
     * 1 casa para cima e 2 casas para a esquerda  
     * 
     */
    private final int[][] movimentos = {
        {2, 1}, {2, -1},{-2, -1},{-2, 1},
        {1, 2}, {1, -2},{-1, -2},{-1, 2}
    };


    /**
     * Construtor da classe {@code Tabuleiro}.
     * 
     * Cria um tabuleiro de tamanho {@code n x n} e inicializa
     * todas as posições com {@code -1}, indicando que estão vazias.
     * 
     * @param tamanho o tamanho do lado do tabuleiro (número de linhas e colunas)
     */
    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new int [tamanho][tamanho];
        
        // Inicializa o tabuleiro com -1, indicando que todas as casas estão vazias
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiro[i][j] = -1;
            }
        }
    }


    /**
     * Método responsável por verificar se a posição é válida
     * 
     * Verifica se a linha e a coluna estão dentro dos limites do tabuleiro
     * e se a casa está vazia 
     * 
     * @param linha
     * @param coluna
     * @return true se a posição é válida
     */
    public boolean posicaoEhValida(int linha, int coluna) {
        return (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho && tabuleiro[linha][coluna] == -1);
    }


    /**
     * Método responsável por verificar se a casa está vazia, ou seja, 
     * se o valor da casa é -1, indicando que a casa ainda não foi visitada
     * 
     * @param linha
     * @param coluna
     * @param valor
     */
    public void marcarPosicao(int linha, int coluna, int valor) {
        tabuleiro[linha][coluna] = valor;
    }
    

    /**
     * Método responsável por verificar se a casa está vazia, ou seja,
     * se o valor da casa é -1, indicando que a casa ainda não foi visitada
     * 
     * @param linha
     * @param coluna
     */
    public void desmarcarPosicao(int linha, int coluna) {
        tabuleiro[linha][coluna] = -1;
    }


    /**
     * Método responsável por imprimir o tabuleiro
     * 
     * Imprime o tabuleiro na tela, mostrando as posições visitadas
     * e as casas vazias
     */
    public void imprimirTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    System.out.println();
    }

    
    public int getTamanho() {
        return tamanho;
    }

    public int[][] getMovimentos() {
        return movimentos;
    }
}
