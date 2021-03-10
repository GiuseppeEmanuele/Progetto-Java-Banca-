package banca.transazioni;

import banca.conticorrenti.ContoBancario;
/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 * 
 * La classe liquidazione degli interessi è una tipologia di transazione
 *
 */

public class LiquidazioneDegliInteressi extends Transazione implements ITransazione {
	
	/**
	 * Costruttore della transazione liquidazione degli interessi che inizializza un conto di origine, una percentuale 
	 * di interessi e il boolean accredita permette di capire e bisogna accreditare o addebitare
	 * @param origine
	 * @param percInteressi
	 * @param accreditare
	 */
	public LiquidazioneDegliInteressi( ContoBancario origine , double percInteressi, boolean accreditare)
	{
		this.origine=origine;
		this.accreditare=accreditare;
		this.importo=percInteressi*origine.getSaldo()/100;
		this.isEseguita=false;
	}

	/**
	 * Il metodo esegui permette di eseguire la transazione liquidazione degli interessi
	 */
	public void esegui() throws Exception
	{		
		if(isEseguita)
			throw new Exception("Transazione già eseguita!");

		isEseguita=true;
		
		if(accreditare)
			origine.deposita(importo);
		else 
			origine.preleva(importo);
	}
	
	private boolean accreditare;
}
