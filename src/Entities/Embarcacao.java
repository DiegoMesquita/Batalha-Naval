package BatalhaNaval.Entities;

/**
 *
 * @author Diego Lopes de Mesquita, diegolopes.si@gmail.com
 * 
 */
public class Embarcacao {

    private String nome;
    private int tamanho;
    private int li;
    private int lf;
    private int ci;
    private int cf;
    private int tabuleiro;

    public Embarcacao(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public Embarcacao(int tabuleiro,String nome, int li, int ci, int lf, int cf) {
        this.nome = nome;
        this.tabuleiro = tabuleiro;
        this.ci = ci;
        this.cf = cf;
        this.li = li;
        this.lf = lf;
    }

    public String getNome() {
        return nome;
    }

    public int getCf() {
        return cf;
    }

    public void setCf(int cf) {
        this.cf = cf;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getLf() {
        return lf;
    }

    public void setLf(int lf) {
        this.lf = lf;
    }

    public int getLi() {
        return li;
    }

    public void setLi(int li) {
        this.li = li;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
