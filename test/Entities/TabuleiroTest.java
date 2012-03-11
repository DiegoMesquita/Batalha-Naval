package Entities;

import Exceptions.*;
import BatalhaNaval.Entities.Tabuleiro;
import BatalhaNaval.Facade;
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
    private Facade facade;

    public TabuleiroTest() {
        this.tabuleiro = new Tabuleiro();
        this.facade = Facade.getInstance();
    }

    @Before
    public void setUp() {
        facade.criarJogo(20, 10);
    }

    @Test
    public void testCriarJogo() {

        try {
            facade.criarJogo(2, 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura e Altura devem ser maiores que 2", e.getMessage());
        }
        try {
            facade.criarJogo(3, 2);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura e Altura devem ser maiores que 2", e.getMessage());
        }
        try {
            facade.criarJogo(-1, 15);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: -1", e.getMessage());
        }
        try {
            facade.criarJogo(0, 15);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Largura invalida: 0", e.getMessage());
        }
        try {
            facade.criarJogo(15, -1);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Altura invalida: -1", e.getMessage());
        }
        try {
            facade.criarJogo(15, 0);
            fail("Deveria ter lançado uma exceção!");
        } catch (TamanhoInvalidoException e) {
            assertEquals("Altura invalida: 0", e.getMessage());
        }
        try {
            facade.criarJogo(-1, -1);
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
        assertEquals(expResult, tabuleiro.quantidadeBarcos());
    }

    @Test
    public void addBarcoNoJogo() {
        try {
            facade.addBarcoNoJogo("", 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Nome invalido", e.getMessage());
        }
        try {
            facade.addBarcoNoJogo("BARCO_GRANDE", 21);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Barco nao cabe no tabuleiro", e.getMessage());
        }
        try {
            facade.addBarcoNoJogo("BARCO_GRANDE", 15);
            facade.verificarBarco("BARCO_GRANDE");
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoDuplicadoException e) {
            assertEquals("Ja existe um barco com nome 'BARCO_GRANDE' no jogo", e.getMessage());
        }
    }

    @Test
    public void testGetQuantidadeBarcos1() {
        facade.addBarcoNoJogo("BARCO_GRANDE", 15);
        int expResult = 1;
        int result = tabuleiro.quantidadeBarcos();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetQuantidadeBarcos2() {
        facade.addBarcoNoJogo("BARCO_GRANDE", 15);
        facade.addBarcoNoJogo("LANCHA", 3);
        int expResult = 2;
        int result = tabuleiro.quantidadeBarcos();
        assertEquals(expResult, result);
    }


    @Test
    public void testAddBarcoNoTabuleiro() {
        try {
            facade.addBarcoNoJogo("%#", 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)", e.getMessage());
        }

        try {
            facade.addBarcoNoJogo("&&6", 3);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)", e.getMessage());
        }
        try {
            facade.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 1, 16);
            fail("Deveria ter lançado uma exceção!");
        } catch (PosicaoInvalidaException e) {
            assertEquals("Posicao invalida: menor que barco (15 < 16)", e.getMessage());
        }
        try {
            facade.addBarcoNoTabuleiro(1, "LANCHA", 3, 3, 4, 6);
            fail("Deveria ter lançado uma exceção!");
        } catch (BarcoInvalidoException e) {
            assertEquals(e.getMessage(), "Barco invalido 'LANCHA'");
        }

        try {
            facade.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 15, 1);
            fail("Deveria ter lançado uma exceção!");
        } catch (PosicaoInvalidaException e) {
            assertEquals(e.getMessage(), "Posicao invalida: fora do tabuleiro linha=15 coluna=1");
        }

        try {
            facade.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 1, 14);
            fail("Deveria ter lançado uma exceção!");
        } catch (PosicaoInvalidaException e) {
            assertEquals(e.getMessage(), "Posicao invalida: menor que barco (14 < 15)");
        }
        try{
            facade.addBarcoNoTabuleiro(1, "BARCO_GRANDE", 1, 1, 2, 15);
            fail("Deveria ter lançado uma exceção!");          
        }catch(PosicaoInvalidaException e){
            assertEquals(e.getMessage(),"Posicao invalida: barco deve estar na vertical ou horizontal");
        }
    }
}
