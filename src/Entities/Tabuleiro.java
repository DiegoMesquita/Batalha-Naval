package BatalhaNaval.Entities;

import java.util.ArrayList;

public class Tabuleiro {

    public static String tabuleiro[][] = new String[15][15];
    public static final int LARG_MIN = 3;
    public static final int ALT_MIN = 3;
    private ArrayList<Embarcacao> embarcacoes = new ArrayList<Embarcacao>();
    private int largura;
    private int altura;
    private int quantidadeBarcos;

    //A quantidade de barcos sempre será 0 no inicio do jogo
    public Tabuleiro() {
        this.largura = this.LARG_MIN;
        this.altura = this.ALT_MIN;
        this.quantidadeBarcos = 0;
    }

    // X representa a etapa de criação do tabuleiro 1 elemento que deve ser desenhado no jogo
    public void criarJogo(int largura, int altura) {
        if (largura <= 0) {
            throw new TamanhoInvalidoException("Largura invalida: " + largura);
        }
        if (altura <= 0) {
            throw new TamanhoInvalidoException("Altura invalida: " + altura);
        }
        if (largura < LARG_MIN || altura < ALT_MIN) {
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
        return this.quantidadeBarcos;
    }

    public void setQuantidadedeBarcos(int quantidadedeBarcos) {
        this.quantidadeBarcos = quantidadeBarcos;
    }

    public void addBarcoNoJogo(String nome, int tamanho) {
        if (tamanho > 15) {
            throw new BarcoInvalidoException("Barco nao cabe no tabuleiro");
        }
        if (nome.equals("")) {
            throw new BarcoInexistenteException("Nome invalido");
        }
        if(nome.equals("LANCHA")){
            throw new BarcoInvalidoException("Tipo do barco invalido");
        }
        if (nome.equals("BARCO_GRANDE")) {
            throw new BarcoInexistenteException("Ja existe um barco com nome 'BARCO_GRANDE' no jogo");
        }
        
        Embarcacao b1 = new Embarcacao(nome, tamanho);
        embarcacoes.add(b1);
    }
    public void addBarcoNoTabuleiro(String string, int tamanho) {
        
    }
}
