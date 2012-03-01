/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BatalhaNavalTests;

import BatalhaNaval.Entities.BarcoInvalidoException;
import BatalhaNaval.Entities.BarcoDuplicadoException;
import BatalhaNaval.Entities.BarcoInexistenteException;
import BatalhaNaval.Entities.TamanhoInvalidoException;
import BatalhaNaval.Entities.Tabuleiro;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lopes
 */
public class TabuleiroTest {

    Tabuleiro tabuleiro = new Tabuleiro();

    public TabuleiroTest() {
    }

    @Before
    public void setUp() {
        tabuleiro.criarJogo(20, 10);
        tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCriarJogo() {

        try {
            //ok
            System.out.println("Criar Jogo. Largura: 2, Altura: 3");
            tabuleiro.criarJogo(2, 3);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura e Altura devem ser maiores que 2", e.getMessage());
        }
        try {
            //ok
            System.out.println("Criar Jogo. Largura: 3, Altura: 2");
            tabuleiro.criarJogo(3, 2);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura e Altura devem ser maiores que 2", e.getMessage());
        }
        try {
            //ok
            System.out.println("Criar Jogo. Largura: -1, Altura: 15");
            tabuleiro.criarJogo(-1, 15);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: -1", e.getMessage());
        }
        try {
            //ok
            System.out.println("Criar Jogo. Largura: 0, Altura: 15");
            tabuleiro.criarJogo(0, 15);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: 0", e.getMessage());
        }
        try {
            //ok
            System.out.println("Criar Jogo. Largura: 15, Altura: -1");
            tabuleiro.criarJogo(15, -1);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Altura invalida: -1", e.getMessage());
        }
        try {
            //ok
            System.out.println("Criar Jogo. Largura: 15, Altura: 0");
            tabuleiro.criarJogo(15, 0);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Altura invalida: 0", e.getMessage());
        }
        try {
            //ok
            System.out.println("Criar Jogo. Largura: -1, Altura: -1");
            tabuleiro.criarJogo(-1, -1);

        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: -1", e.getMessage());
        }
    }

    @Test
    //ok
    public void testGetLarguraTabuleiro() {
        System.out.println("getLarguraTabuleiro");
        int expResult = 20;
        int result = tabuleiro.getLarguraTabuleiro();
        assertEquals(expResult, result);
    }

    @Test
    //ok
    public void testGetAlturaTabuleiro() {
        System.out.println("getAlturaTabuleiro");
        int expResult = 10;
        int result = tabuleiro.getAlturaTabuleiro();
        assertEquals(expResult, result);
    }

    @Test
    //ok
    public void testGetQuantidadeBarcos() {
        System.out.println("getQuantidadeBarcos");
        int expResult = 0;
        assertEquals(expResult, tabuleiro.getQuantidadeBarcos());
    }

    /*@Test
    public void testAddBarcoNoJogo() {
    System.out.println("addBarcoNoJogo");
    tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
    }*/
    @Test
    public void testGetQuantidadedeBarcos() {
        System.out.println("getQuantidadeBarcos");
        tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
        int expResult = 1;
        assertEquals(expResult, tabuleiro.getQuantidadeBarcos());
    }

    @Test
    public void testAddBarcoNoJogo() {
        try {
            //ok
            System.out.println("Adicionar barco já existente");
            tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
        } catch (BarcoDuplicadoException e) {
            assertEquals("Ja existe uma barco com nome 'BARCO_GRANDE' no jogo", e.getMessage());
        }
        try {
            System.out.println("Barco muito grande (>15)");
            tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 21);
        } catch (BarcoInvalidoException e) {
            assertEquals("Barco nao cabe no tabuleiro", e.getMessage());
        }
        try {
            System.out.println("Nome invalido (Vazio)");
            tabuleiro.addBarcoNoJogo("", 3);
        } catch (BarcoInexistenteException e) {
            assertEquals("Nome invalido", e.getMessage());
        }
        
    }
}
