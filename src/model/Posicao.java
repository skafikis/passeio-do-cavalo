package model;

/**
 * Classe que representa uma posição no tabuleiro do passeio do cavalo.
 * Contém as coordenadas da linha e coluna.
 */
public class Posicao {
    private int linha;
    private int coluna;

    /**
     * Construtor da classe Posicao.
     *
     * @param linha A linha da posição.
     * @param coluna A coluna da posição.
     */
    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
