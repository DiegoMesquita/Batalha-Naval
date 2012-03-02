package BatalhaNaval.Entities;

/**
 *
 * @author Diego Lopes de Mesquita, diegolopes.si@gmail.com
 * 
 */
import java.util.ArrayList;

public class Tabuleiro {

    //public static String tabuleiro[][] = new String[15][15];
    private ArrayList<Embarcacao> embarcacoes = new ArrayList<Embarcacao>();
    private ArrayList<Embarcacao> embarcacoesTabuleiro1 = new ArrayList<Embarcacao>();
    private ArrayList<Embarcacao> embarcacoesTabuleiro2 = new ArrayList<Embarcacao>();
    private int largura;
    private int altura;

    public Tabuleiro() {
    }

    public void criarJogo(int largura, int altura) {
        if (largura <= 0) {
            throw new TamanhoInvalidoException("Largura invalida: " + largura);
        }
        if (altura <= 0) {
            throw new TamanhoInvalidoException("Altura invalida: " + altura);
        }
        if (largura < 3 || altura < 3) {
            throw new TamanhoInvalidoException("Largura e Altura devem ser maiores que 2");
        }

        this.largura = largura;
        this.altura = altura;
    }

    public int getLarguraTabuleiro() {
        return this.largura;
    }

    public int getAlturaTabuleiro() {
        return this.altura;
    }

    public int getQuantidadeBarcos() {
        return embarcacoes.size();
    }

    public void verificarBarco(String nome) {
        for (Embarcacao e : embarcacoes) {
            if (nome.equals(e.getNome())) {
                throw new BarcoDuplicadoException("Ja existe um barco com nome 'BARCO_GRANDE' no jogo");
            }
        }
    }

    public void addBarcoNoJogo(String nome, int tamanho) {
        if (tamanho > 15) {
            throw new BarcoInvalidoException("Barco nao cabe no tabuleiro");
        }
        if (nome.equals("")) {
            throw new BarcoInvalidoException("Nome invalido");
        }

        Embarcacao b1 = new Embarcacao(nome, tamanho);
        embarcacoes.add(b1);
    }

    public void addBarcoNoTabuleiro1(int tabuleiro, String nome, int li, int ci, int lf, int cf) {
        if ((li > 15) || (lf > 15) || (ci > 15) || (cf > 15)) {
            throw new TamanhoInvalidoException("Posicao invalida: menor que barco (15 < 16)");
        }
        if ((li < 15) || (lf > 15) || (ci > 15) || (cf > 15)) {
            throw new TamanhoInvalidoException("Posicao invalida: conflito de coordenada com barco 'BARCO_GRANDE");
        }

        Embarcacao b2 = new Embarcacao(tabuleiro, nome, li, ci, lf, cf);
        embarcacoesTabuleiro1.add(b2);
    }

    public void addBarcoNoTabuleiro(String nome, int tamanho) throws BarcoInvalidoException {

        if (!nome.matches("[.+\\-+\\_+\\d+\\w]+")) {
            throw new BarcoInvalidoException("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)");
        }

        Embarcacao e = new Embarcacao(nome, tamanho);
        embarcacoes.add(e);

    }
}
