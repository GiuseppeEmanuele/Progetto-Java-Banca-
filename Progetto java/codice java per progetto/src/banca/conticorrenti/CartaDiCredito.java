package banca.conticorrenti;

import banca.Cliente;

/**
 * @author Giuseppe Emanuele Pezzillo
 * La carta di credito è una tipologia di conto bancario
 *
 */
public class CartaDiCredito extends ContoBancario{

	/**
	 * Costruttore della carta di credito inizializza un importo massimo prelievi e poi inizializza un cliente,saldo e
	 * numero conto
	 * @param cliente
	 * @param saldo
	 * @param numeroConto
	 * @param importoMassimoPrelievi
	 */
	public CartaDiCredito(Cliente cliente, double saldo, int numeroConto, double importoMassimoPrelievi)
	{
		super(cliente, saldo, numeroConto);
		this.importoMassimoPrelievi=importoMassimoPrelievi;
	}
	
	/**
	 * Il metodo toString restituisce l'oggetto carta di credito sotto forma di stringa
	 */
	public String toString()
	{
		return super.toString()+" "+ "importoMassimoPrelievi: " + importoMassimoPrelievi+"]";
	}
	
	/**
	 * Il metodo clone restituisce un Object e serve per clonare una carta di credito
	 */
	public Object clone()
	{
		return super.clone();
	}
	
	/**
     * Il metodo equals serve a confrontare i due oggetti
     */
    public boolean equals(Object ccre)
    {
    	return super.equals(ccre);
    }
	
	
	
	/**
	 * Il metodo getImportoMassimoPrelievi serve a recuperare l'importo massimo prelievi settato all'inizio
	 * @return importo massimo prelievi
	 */
 public double getImportoMassimoPrelievi()
 {
		return importoMassimoPrelievi;
 }



private double importoMassimoPrelievi;

}
