package Exceptions;
/**
 *
 * @author Diego Mesquita, diego.mesquita@dce.ufpb.br
 *         Jessyca Ferreira, jessyca.ferreira@dce.ufpb.br
 * 
 */
public class BarcoInvalidoException extends RuntimeException {
    public BarcoInvalidoException(String msg){
        super(msg);
    }
}
