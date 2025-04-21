package model;

public class Tabuleiro {

    private int tamanho;
    private int[][] tabuleiro;

    // Defnindo os movimentos possíveis do cavalo
    //
    // Vetor com movimentos possíveis do cavalo
    // Cada movimento é representado por um par de inteiros
    //
    // Cada par representa {linha, coluna}, ou seja, a mudança
    // relativa na linha e na coluna após o movimento.
    //
    // Exemplo: {2, 1} significa que o cavalo pode se mover 2 casas para baixo
    // e 1 casa para a direita
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
        return (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho);
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
     * 
     * @return
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


    /**
     * 
     * @return
     */
    public int getTamanho() {
        return tamanho;
    }


    /**
     * 
     * @return
     */
    public int[][] getMovimentos() {
        return movimentos;
    }
}
