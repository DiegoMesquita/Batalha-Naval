package BatalhaNaval;

import BatalhaNaval.Entities.Tabuleiro;
/**
 *
 * @author Diego Mesquita, diego.mesquita@dce.ufpb.br
 *         Jessyca Ferreira, jessyca.ferreira@dce.ufpb.br
 * 
 */
public class Facade {

    Tabuleiro tabuleiro;
    private static Facade instance;
    
    public Facade() {
        tabuleiro = new Tabuleiro();        
    }
    
    public void criarJogo(int largura, int altura) {
        tabuleiro.criarJogo(largura, altura);
    }
    
    public void addBarcoNoJogo(String nome, int tamanho) {
        tabuleiro.addBarcoNoJogo(nome, tamanho);
    }
    
    public void addBarcoNoTabuleiro(int tabu, String nome, int li, int ci, int lf, int cf) {
        tabuleiro.addBarcoNoTabuleiro(tabu, nome, li, ci, lf, cf);
    }
    
    public void verificarBarco(String nome) {
        tabuleiro.verificarBarco(nome);
    }
    
    //singleton
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }
}
