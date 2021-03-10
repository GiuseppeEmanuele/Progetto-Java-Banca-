package banca.transazioni;

/**
 * @author Giuseppe Emanuele Pezzillo
 * 
 * Interfaccia ITransazione con metodo esegui che permette di eeguire una transazione
 *
 */
public interface ITransazione {

	/**
	 * Il metodo esegui permette di eseguire una transazione
	 * @throws Exception
	 */
	public void esegui() throws Exception;

}
