import controller.ResolucaoPasseioCavalo;
import model.Posicao;
import model.Tabuleiro;
import view.AEstrela;
import view.BuscaProfundidade;

public class App {
    public static void main(String[] args) throws Exception {
        int tabuleiroTamanho = 8;
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
