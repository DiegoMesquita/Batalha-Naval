package Entities;

import Exceptions.*;
import BatalhaNaval.Entities.Tabuleiro;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Diego Mesquita, diego.mesquita@dce.ufpb.br
 *         Jessyca Ferreira, jessyca.ferreira@dce.ufpb.br
 * 
 */
public class TabuleiroTest {

    Tabuleiro tabuleiro;

    public TabuleiroTest() {
        this.tabuleiro = new Tabuleiro();
    }

    @Before
    public void setUp() {
        tabuleiro.criarJogo(20, 10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCriarJogo() {

        try {
            tabuleiro.criarJogo(2, 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura e Altura devem ser maiores que 2", e.getMessage());
        }
        try {
            tabuleiro.criarJogo(3, 2);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura e Altura devem ser maiores que 2", e.getMessage());
        }
        try {
            tabuleiro.criarJogo(-1, 15);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: -1", e.getMessage());
        }
        try {
            tabuleiro.criarJogo(0, 15);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: 0", e.getMessage());
        }
        try {
            tabuleiro.criarJogo(15, -1);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Altura invalida: -1", e.getMessage());
        }
        try {
            tabuleiro.criarJogo(15, 0);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Altura invalida: 0", e.getMessage());
        }
        try {
            tabuleiro.criarJogo(-1, -1);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: -1", e.getMessage());
        }
    }

    @Test
    public void testGetLarguraTabuleiro1() {
        int expResult = 20;
        int result = tabuleiro.getLarguraTabuleiro();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAlturaTabuleiro1() {
        int expResult = 10;
        int result = tabuleiro.getAlturaTabuleiro();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetQuantidadeBarcos0() {
        int expResult = 0;
        assertEquals(expResult, tabuleiro.getQuantidadeBarcos());
    }

    @Test
    public void addBarcoNoJogo() {
        try {
            tabuleiro.addBarcoNoJogo("", 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Nome invalido", e.getMessage());
        }
        try {
            tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 21);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Barco nao cabe no tabuleiro", e.getMessage());
        }
        try {
            tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
            tabuleiro.verificarBarco("BARCO_GRANDE");
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoDuplicadoException e) {
            assertEquals("Ja existe um barco com nome 'BARCO_GRANDE' no jogo", e.getMessage());
        }
    }

    @Test
    public void testGetQuantidadeBarcos1() {
        tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
        int expResult = 1;
        int result = tabuleiro.getQuantidadeBarcos();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetQuantidadeBarcos2() {
        tabuleiro.addBarcoNoJogo("BARCO_GRANDE", 15);
        tabuleiro.addBarcoNoJogo("LANCHA", 3);
        int expResult = 2;
        int result = tabuleiro.getQuantidadeBarcos();
        assertEquals(expResult, result);
    }


    @Test
    public void testAddBarcoNoTabuleiro() {
        try {
            tabuleiro.addBarcoNoJogo("%#", 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)", e.getMessage());
        }

        try {
            tabuleiro.addBarcoNoJogo("&&6", 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)", e.getMessage());
        }
        try {
            tabuleiro.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 1, 16);
            fail("Deveria ter lançado uma exceção!");
        } catch (PosicaoInvalidaException e) {
            assertEquals("Posicao invalida: menor que barco (15 < 16)", e.getMessage());
        }
        try {
            tabuleiro.addBarcoNoTabuleiro(1, "LANCHA", 3, 3, 4, 6);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals(e.getMessage(), "Barco invalido 'LANCHA'");
        }

        try {
            tabuleiro.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 15, 1);
            fail("Deveria ter lançado uma exceção!");
        } catch (PosicaoInvalidaException e) {
            assertEquals(e.getMessage(), "Posicao invalida: fora do tabuleiro linha=15 coluna=1");
        }

        try {
            tabuleiro.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 1, 14);
            fail("Deveria ter lançado uma exceção!");
        } catch (PosicaoInvalidaException e) {
            assertEquals(e.getMessage(), "Posicao invalida: menor que barco (14 < 15)");
        }
        try{
            tabuleiro.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 2, 15);
            fail("Deveria ter lançado uma exceção!");          
        }catch(PosicaoInvalidaException e){
            assertEquals(e.getMessage(),"Posicao invalida: barco deve estar na vertical ou horizontal");
        }
    }
}
