package controller;

import model.Posicao;
import model.Tabuleiro;
import view.PesquisaEstrategica;

public class ResolucaoPasseioCavalo {
    private PesquisaEstrategica estrategia;

    public ResolucaoPasseioCavalo(PesquisaEstrategica estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(PesquisaEstrategica estrategia) {
        this.estrategia = estrategia;
    }

    public boolean resolver(Tabuleiro tabuleiro, Posicao posicaoInicial) {
        return estrategia.resolucao(tabuleiro, posicaoInicial);
    }

}
