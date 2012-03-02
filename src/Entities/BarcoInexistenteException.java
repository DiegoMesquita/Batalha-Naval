package BatalhaNaval.Entities;

/**
 *
 * @author Diego Lopes de Mesquita, diegolopes.si@gmail.com
 * 
 */
public class BarcoInexistenteException extends RuntimeException {
	public BarcoInexistenteException (String s ){
		super(s);
	}
}
