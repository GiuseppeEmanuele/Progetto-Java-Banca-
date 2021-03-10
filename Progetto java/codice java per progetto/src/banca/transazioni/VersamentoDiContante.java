package banca.transazioni;

import banca.conticorrenti.ContoBancario;

/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 *
 *La classe versamento di contante è una tipologia di transazione
 */
public class VersamentoDiContante extends Transazione implements ITransazione {
	
	/**
	 * Costruttore della transazione versamento di contante che iniziliazza un conto di origine ed una somma da accreditare 
	 * @param origine
	 * @param sommaDaAccreditare
	 */
	public VersamentoDiContante( ContoBancario origine , double sommaDaAccreditare)
	{
		this.origine = origine;
		this.importo = sommaDaAccreditare;
		this.isEseguita = false;
	}

/**
 * Il metodo esegui permette di eseguire la transazione versamneto di contante
 */
	public void esegui() throws Exception
	{
		if(isEseguita)
			throw new Exception("Transazione già eseguita!");
			
		origine.deposita(importo);		
		isEseguita = true;
	}

}
