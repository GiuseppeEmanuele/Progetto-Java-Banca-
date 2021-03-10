package banca.conticorrenti;

import banca.Cliente;

/**
 * @author Giuseppe Emanuele Pezzillo
 * La carta di debito è una tipologia di conto bancario
 *
 */
public class CartaDiDebito extends ContoBancario{

	/**
	 * Il costruttore della carta di debito inizializza un conto bancario di origine ed inizializza l'importo massimo di
	 * prelievi e se il conto bacario di origine non è ne un conto corrente ne un libretto di deposito viene lanciata
	 * un eccezione perchè la carta di debito deve essere collegata ad un conto corrente o un libretto di deposito
	 * @param origine
	 * @param importoMassimoPrelievi
	 * @throws Exception
	 */
	public CartaDiDebito(ContoBancario origine, double importoMassimoPrelievi) throws Exception
	{
		super();
		
		if( !(origine instanceof ContoCorrente) && !(origine instanceof LibrettoDiDeposito) )
			throw new Exception("La carta di debito deve essere collegata ad un conto corrente o libretto di deposito ");
		
		this.origine=origine;
		this.importoMassimoPrelievi=importoMassimoPrelievi;
	}
	
	/**
	 * Il metodo preleva serve a prelevare un importo dato in input da una carta di debito
	 */
	public void preleva(double importo) throws Exception
	{
		origine.preleva(importo);
	}
	 
	/**
	 * Il metodo depoita serve per depositare un importo dato in input su una carta di debito e lancia un eccezione perchè
	 * non è possibile depositare su una carta di debito
	 */
	public void deposita(double importo) throws Exception
	{
		throw new Exception("Non è possibile depositare su una Carta di Debito.");
	}
	

	/**
	 * Il metodo getCliente serve per recuperare il cliente inserito in input
	 */
	 public Cliente getCliente() 
	 {
		return origine.getCliente();
	 }

	 /**
	  * Il metodo toString restituisce la carta di debito sotto forma di stringa
	  */
	 public String toString()
	 {
	   return getClass().getName()+"["+" origine:"+  origine + " "+ "importoMassimoPrelievi: "+ importoMassimoPrelievi + "]";
	 }
	 
	 /**
	  * Il metodo clone serve per clonare una Carta Di Debito e restituisce un Object
	  */
	 public Object clone()
	 { 
	   return super.clone();
   	 } 
	 
	 /**
	     * Il metodo equals serve a confrontare i due oggetti
	     */
	    public boolean equals(Object cd)
	    {
	    	return super.equals(cd);
	    }
	 
	ContoBancario origine;
	private double importoMassimoPrelievi;

}
