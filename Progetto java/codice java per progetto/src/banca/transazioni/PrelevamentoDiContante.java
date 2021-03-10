package banca.transazioni;

import banca.conticorrenti.ContoBancario;

/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 *
 *La classe prelevamento di contante è una tipologia di transazione
 */

public class PrelevamentoDiContante extends Transazione implements ITransazione {
	
	/**
	 * Costruttore della tranazione prelevamneto di contante che inizializza un conto di origine e una somma da addebitare
	 * @param origine
	 * @param sommaDaAddebitare
	 */
	public PrelevamentoDiContante( ContoBancario origine, double sommaDaAddebitare)
	{
		this.origine=origine;
		this.importo=sommaDaAddebitare;
		this.isEseguita=false;
	}

	/**
	 * Il metodo esegui permette di eseguire la transazione prelevamento di contante
	 */
	public void esegui() throws Exception
	{
		if(isEseguita)
			throw new Exception("Transazione già eseguita!");
		
		isEseguita = true;
		origine.preleva(importo);
	}

}
