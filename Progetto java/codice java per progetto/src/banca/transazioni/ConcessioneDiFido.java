package banca.transazioni;

import banca.conticorrenti.ContoBancario;
import banca.conticorrenti.ContoCorrente;

/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 * 
 * La classe concessione di fido è una tipologia di transazione
 *
 */
public class ConcessioneDiFido extends Transazione implements ITransazione {
	
	/**
	 * Costruttore delle transazione concessione di fido che inizializza un conto di origine ed un importo
	 * @param origine
	 * @param importoFido
	 * @throws Exception
	 */
	public ConcessioneDiFido( ContoBancario origine, double importoFido) throws Exception 
	{
		
		if( !(origine instanceof ContoCorrente) ) throw new Exception("Solo in conto corrente può avere un fido");
		
		this.origine=origine;
		this.importo=importoFido;
		this.isEseguita=false;
	}

/**
 * Il metodo eegui permette di eseguire la transazione concessione di fido 
 * @throws Exception 
 */
	public void esegui() throws Exception
	{
		if(isEseguita)
			throw new Exception("Transazione già eseguita!");
		isEseguita=true;
		
		ContoCorrente origine_contoCorrente = (ContoCorrente)origine;
		origine_contoCorrente.setFido(importo);
		
	}

}
