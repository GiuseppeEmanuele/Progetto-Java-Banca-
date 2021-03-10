package banca.conticorrenti;

import banca.Cliente;
/**
 * @author Giuseppe Emanuele Pezzillo
 * La classe libretto di deposito è una tipologia di conto bancario 
 *
 */

public class LibrettoDiDeposito extends ContoBancario 
{
	/**
	 * Costruttore di libretto di deposito crea un conto bancario con cliente saldo e numero del conto
	 * @param prende in input cliente
	 * @param prende in input saldo
	 * @param prende in input numeroConto
	 */

	public LibrettoDiDeposito(Cliente cliente, double saldo, int numeroConto) 
	{
		super(cliente, saldo, numeroConto);
	}
	
	/**
	 * Il metodo preleva consente di prelevare una somma di denaro dal conto bancario e lancia un eccezione se il 
	 * saldo è negativo
	 * @param prende in input un importo
	 * 
	 */
    public void preleva(double importo) throws Exception
    {
    	if(saldo-importo <0) 
    		throw new Exception("Nel Libretto di Deposito non è consentito avere un saldo negativo");
    	
    	saldo-=importo;
    }
     /**
      * Il metodo toString restituisce l'oggetto libretto di deposito sotto forma di stringa
      */
    public  String toString()
    {
      return super.toString()+"]";	
    }
    
    /**
     * Il metodo clone restituisce un Object e clona un libretto di deposito
     */
    public Object clone()
	{
		return super.clone();
	}
    
    /**
     * Il metodo equals serve a confrontare i due oggetti
     */
    public boolean equals(Object ld)
    {
    	return super.equals(ld);
    }
    
    
}
