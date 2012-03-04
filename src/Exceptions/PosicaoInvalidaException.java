package Exceptions;
/**
 *
 * @author Diego Mesquita, diego.mesquita@dce.ufpb.br
 *         Jessyca Ferreira, jessyca.ferreira@dce.ufpb.br
 * 
 */
public class PosicaoInvalidaException extends RuntimeException {

    public PosicaoInvalidaException(String msg) {
        super(msg);
    }
}
