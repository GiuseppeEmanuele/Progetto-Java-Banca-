package banca.transazioni;

import banca.conticorrenti.ContoBancario;
import banca.conticorrenti.LibrettoDiDeposito;

/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 * 
 * La classe liquidazione delle spese è una tipologia di transazione
 *
 */
public class LiquidazioneDelleSpese extends Transazione implements ITransazione {
	
	/**
	 * Costruttore della transazione liquidazione delle spese ed inizializza un conto di origine , le spese da 
	 * accreditare o addebitare in base al valore del boolean accreditare 
	 * @param origine
	 * @param spese
	 * @param accreditare
	 * @throws Exception
	 */
	public LiquidazioneDelleSpese( ContoBancario origine , double spese, boolean accreditare) throws Exception
	{
		if(origine instanceof LibrettoDiDeposito) throw new Exception("Il Libretto di Deposito non ha spese");
			
		this.origine=origine;
		this.importo=spese;
		this.accreditare=accreditare;
		this.isEseguita=false;
	}

	
	/**
	 * IL metodo esegui permette di eseguire la transazione liquidazione delle spese
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
