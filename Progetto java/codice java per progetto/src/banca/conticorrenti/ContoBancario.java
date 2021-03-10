package banca.conticorrenti;

import banca.Cliente;
import banca.transazioni.Transazione;

/**
 * @author Giuseppe Emanuele Pezzillo
 *La classe astratta conto bancario è la classe generica che serve alla creazione delle varie tipologie di conti bancari
 */
public abstract class ContoBancario implements Cloneable,Comparable
{
	/**
	 * Costruttore di conto bancario inizializza il saldo a 0 e il numero del conto a 0
	 */
	protected ContoBancario()
	{
		saldo=0;
		numeroConto=0;
	}
	
	/**
	 * Secondo costruttore della classe conto bancario inizializza il saldo il cliente e il numero conto in base all'input
	 * @param prende in input un cliente
	 * @param prende in input un saldo
	 * @param prende in input un numeroConto
	 */
    public ContoBancario(Cliente cliente , double saldo, int numeroConto)
	{
	     this.saldo=saldo;
    	 this.numeroConto=numeroConto;
    	 this.cliente=cliente;
    	 this.cliente.setConto(this);
	}
     
     /**
      * Il metodo preleva serve a prelevare un importo specificato dal conto
      * @param prende in input un importo
      * @throws Exception
      */
     public void preleva(double importo) throws Exception
     {
    	 saldo-=importo;
     }
     
	/**
	 * Il metodo deposita serve a depositare un importo specificato sul conto
	 * @param prende in input un importo
	 * @throws Exception
	 */
     public void deposita(double importo) throws Exception
     {
    	 saldo+=importo;
     }
	
     
     /**
      * Il metodo getSaldo serve per recuperare il saldo del conto bancario
      * @return ritorna il saldo
      */
     public double getSaldo() {
		return saldo;
	}

    /**
     * Il metodo setSaldo serve a settare il saldo di un conto bancario
     * @param prende in input il saldo
     */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

    /**
     * Il metodo getNumeroConto serve a recuperare il numero del conto 
     * @return ritorna il numero del conto
     */
	public int getNumeroConto() {
		return numeroConto;
	}

    /**
     * Il metodo setNumeroConto serve a settare il numero del conto
     * @param prende in input il numeroConto
     */
	public void setNumeroConto(int numeroConto) {
		this.numeroConto = numeroConto;
	}
    
	/**
	 * Il metodo getCliente serve a recuperare il cliente del conto bancario
	 * @return ritrona il cliente
	 */
	 public Cliente getCliente() {
		return cliente;
	}
	 
	 /**
	  * Il metodo toString restituisce il conto bancario sotto forma di stringa
	  */
	 public String toString()
	 {
		 
	  return getClass().getName() +"[ cliente:" + cliente +" "+ "numero conto:" + numeroConto+" "+"saldo:"+ saldo;
	  
	 }
	 
	 /**
	  * Il metodo equals confronta due conti bancari in base al numero del conto
	  * @param prende un Object in input
	  * @return ritorna false se i due oggetti sono diversi altrimenti true
	  */
	 public boolean equals(Object cb)
	 {
		 if(!(cb instanceof ContoBancario)) return false;
		 
		 ContoBancario cb1 = (ContoBancario) cb;
		 
		 if(cb1.getNumeroConto() == numeroConto) return true;
		 
		 return false;
		 
	 }
	 
	 /**
	  * Il metodo clone serve a clonare un conto bancario
	  * @return ritorna un Object
	  * 
	  */
	 public Object clone()
	 {
		 try
		 {
			 return super.clone();
		 }
		 
		 catch(CloneNotSupportedException e)
		 {
			 return null;
		 }
	 }
	 
	 /**
	  * Il metodo compareTo serve a comparare due conti bancari in base al valore del saldo crescente
	  * @param prende in input un Object
	  * @return ritorna un intero: 1,0,-1 in base al valore crescente del saldo
	  */ 
	 public int compareTo(Object c)
		{
			ContoBancario c1 = (ContoBancario)c;
			
			if(c1.getSaldo() == saldo) return 0;
			
			if(c1.getSaldo()>saldo)return -1;
			
			return 1;
		}


	 protected double saldo;
     protected int numeroConto;
     protected Cliente cliente;

}
