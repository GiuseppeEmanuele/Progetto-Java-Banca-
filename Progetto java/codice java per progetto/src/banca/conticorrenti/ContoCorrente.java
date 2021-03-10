package banca.conticorrenti;

import banca.Cliente;
/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 * ContoCorrente una tipologia di conto bancario 
 *
 */
public class ContoCorrente extends ContoBancario {

	/**
	 * Costruttore di conto corrente con un cliente ,saldo e un numero conto poi inizilizza fido a 0 e inizializza
	 * le operazioniGratuite in base all'input dato
	 * @param cliente
	 * @param saldo
	 * @param numeroConto
	 * @param operazioniGratuite
	 */
	public ContoCorrente(Cliente cliente, double saldo, int numeroConto, int operazioniGratuite)
	{
		super(cliente, saldo, numeroConto);	
		this.fido=0;
		this.operazioniGratuite=operazioniGratuite;
	}

	/**
	 * Il metodo preleva serve a prelevare un importo dal conto bancario e lancia un eccezione se il saldo è inferiore al fido
	 */
	public void preleva(double importo) throws Exception
    {
   	    if(saldo-importo < -fido)  throw new Exception("Il conto non può avere un saldo inferiore a:"+fido);
		
		saldo-=importo;
    }
	
	/**
	 * Il metodo getFido serve per recuperare il fido inserito
	 * @return ritorna il fido inserito
	 */
	public double getFido() {
		return fido;
	}

    /**
     * Il metodo setFido serve per settare un fido 
     * @param prende in input un  fido
     */
	public void setFido(double fido) {
		this.fido = fido;
	}
   
    /**
     * Il metodo toString restituisce l'oggetto conto corrente sotto forma di stringa 
     */
	public String toString()
	{
	  return super.toString() +" fido:"+fido+" "+"operazioniGratuite:"+operazioniGratuite+"]";	
	}
	
	/**
	 * Il metodo clone serve per clonare un conto corrente e restituisce un Object
	 */
	public Object clone()
	{
		return super.clone();
	}
	/**
     * Il metodo equals serve a confrontare i due oggetti
     */
    public boolean equals(Object cc)
    {
    	return super.equals(cc);
    }

	private double fido;
	private int operazioniGratuite;
}
