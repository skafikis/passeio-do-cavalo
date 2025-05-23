import controller.ResolucaoPasseioCavalo;
import model.Posicao;
import model.Tabuleiro;
import service.AEstrela;
import service.BuscaProfundidade;

public class App {
    public static void main(String[] args) throws Exception {
        // Definindo o tamanho do tabuleiro e a posição inicial do cavalo
        // Tamanho do tabuleiro (6x6)
        // Caso deseje alterar o tamanho do tabuleiro bastear alterar o valor da variável tabuleiroTamanho
        int tabuleiroTamanho = 6;

        // Posição inicial do cavalo (0, 0)
        // Caso deseje alterar a posição inicial do cavalo bastear alterar o valor da variável posicaoInicial
        Posicao posicaoInicial = new Posicao(0, 0);


        // Executando com Busca em Largura (DFS):
        System.out.println("Executando com Busca em Profundidade (DFS):");
        Tabuleiro tabuleiroDFS = new Tabuleiro(tabuleiroTamanho);
        ResolucaoPasseioCavalo resolucaoPasseioCavaloDFS = new ResolucaoPasseioCavalo(new BuscaProfundidade());

        long tempoInicialDFS = System.currentTimeMillis();
        boolean resolucaoDFS = resolucaoPasseioCavaloDFS.resolver(tabuleiroDFS, posicaoInicial);
        long tempoFinalDFS = System.currentTimeMillis();

        if (resolucaoDFS) {
            System.out.println("Solução encontrada com DFS em " + (tempoFinalDFS - tempoInicialDFS) + " ms.");
            tabuleiroDFS.imprimirTabuleiro();
        } else {
            System.out.println("Nenhuma solução encontrada com DFS.");
        }


        // Executando com A*:
        System.out.println("Executando com A*: ");
        Tabuleiro tabuleiroAEstrela = new Tabuleiro(tabuleiroTamanho);
        ResolucaoPasseioCavalo resolucaoPasseioCavaloAEstrela = new ResolucaoPasseioCavalo(new AEstrela());

        long tempoInicialAEstrela = System.currentTimeMillis();
        boolean resolucaoAEstrela = resolucaoPasseioCavaloAEstrela.resolver(tabuleiroAEstrela, posicaoInicial);
        long tempoFinalAEstrela = System.currentTimeMillis();

        if (resolucaoAEstrela) {
            System.out.println("Solução encontrada com A* em " + (tempoFinalAEstrela - tempoInicialAEstrela) + " ms.");
            tabuleiroAEstrela.imprimirTabuleiro();
        } else {
            System.out.println("Nenhuma solução encontrada com A*.");
        }
    }
}
