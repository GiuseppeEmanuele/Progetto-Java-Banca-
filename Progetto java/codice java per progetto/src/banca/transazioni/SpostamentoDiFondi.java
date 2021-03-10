package banca.transazioni;

import java.util.GregorianCalendar;

import banca.conticorrenti.ContoBancario;

/**
 * @author Giuseppe Emanuele Pezzillo
 * La classe spostamento di fondi è una tipologia di transazione
 *
 */
public class SpostamentoDiFondi extends Transazione implements ITransazione  {
	
	/**
	 * Costruttore della classe spostamento di fondi che inizilizza un conto di origine, conto destinazione e un importo
	 * @param origine
	 * @param destinazione
	 * @param importo
	 */
	public SpostamentoDiFondi( ContoBancario origine, ContoBancario destinazione, double importo )
	{
	   	this.destinazione = destinazione;
	   	this.origine = origine;
	   	this.importo= importo;
	   	this.isEseguita = false;
	}

	/**
	 * Il metodo esegui permette di eseguire la transazione spostamento di fondi
	 */
	public void esegui() throws Exception
	{
		if(isEseguita)
			throw new Exception("Transazione già eseguita!");
		
		isEseguita=true;
		origine.preleva(importo);
		destinazione.deposita(importo);
		data = new GregorianCalendar();	
	}

}
