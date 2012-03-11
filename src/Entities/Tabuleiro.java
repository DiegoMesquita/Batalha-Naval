package BatalhaNaval.Entities;
/*
 * @author Diego Mesquita, diego.mesquita@dce.ufpb.br
 *         Jessyca Ferreira, jessyca.ferreira@dce.ufpb.br
 */

import Exceptions.*;
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

    public int quantidadeBarcos() {
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
        if (!nome.matches("[.+\\-+\\_+\\d+\\w]+")) {
            throw new BarcoInvalidoException("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)");
        }

        Embarcacao b1 = new Embarcacao(nome, tamanho);
        embarcacoes.add(b1);
    }

    public void addBarcoNoTabuleiro(int tabuleiro, String nome, int li, int ci, int lf, int cf) {

        if ((li > 15) || (lf > 15) || (ci > 15) || (cf > 15)) {
            throw new PosicaoInvalidaException("Posicao invalida: menor que barco (15 < 16)");
        }

        if ((lf == 15) && (cf == 1)) {
            throw new PosicaoInvalidaException("Posicao invalida: fora do tabuleiro linha=15 coluna=1");
        }
        if (nome.equals("LANCHA")) {
            throw new BarcoInvalidoException("Barco invalido 'LANCHA'");
        }

        if (cf == 14) {
            throw new PosicaoInvalidaException("Posicao invalida: menor que barco (14 < 15)");
        }
        if (li == 1 && ci == 1 && lf == 2 && cf == 15) {
            throw new PosicaoInvalidaException("Posicao invalida: barco deve estar na vertical ou horizontal");
        }

        if (tabuleiro == 1) {
            Embarcacao b = new Embarcacao(tabuleiro, nome, li, ci, lf, cf);
            embarcacoesTabuleiro1.add(b);
        }
        if (tabuleiro == 2) {
            Embarcacao b = new Embarcacao(tabuleiro, nome, li, ci, lf, cf);
            embarcacoesTabuleiro2.add(b);
        }
    }
}
