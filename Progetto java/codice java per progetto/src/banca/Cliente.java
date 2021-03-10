package banca;

import banca.conticorrenti.ContoBancario;
import banca.transazioni.ITransazione;
import banca.transazioni.PrelevamentoDiContante;
import banca.transazioni.VersamentoDiContante;

/**
 * @author Giuseppe Emanuele Pezzillo
 * La classe cliente serve appunto per la gestione dei clienti che fanno operazioni in una banca 
 */

public class Cliente implements Cloneable,Comparable {
	
	/**
	 * Costruttore della classe cliente che inizializza il nome,cognome,anno,indirizzoe codicefiscale in base
	 * ai valori inseriti in input alla creazione della classe
	 * @param nome
	 * @param cognome
	 * @param anno
	 * @param indirizzo
	 * @param codiceFiscale
	 * @return non ritorna nessun valore
	 */
	public Cliente( String nome, String cognome, int anno, String indirizzo, String codiceFiscale )
	{
		this.nome = nome;
		this.cognome = cognome;
		this.anno = anno;
		this.indirizzo = indirizzo;
		this.codiceFiscale = codiceFiscale;
	}
	
	
	//  metodi per poter permettere al cliente di fare versamento e prelevamento e visualizzazione saldo
	// su un conto bancario
	/**
	 * Il metodo preleva permette al cliente di fare il prelevamento di contante
	 * @param importo
	 * @return ritorna un Itransazione ossia l'interfaccia in modo tale da poter utilizzare qualsiai Transazione
	 */
	public ITransazione preleva(double importo) 
	{
		PrelevamentoDiContante pc = new PrelevamentoDiContante(this.conto, importo );
		return pc;
	}
	
	/**
	 * Il metodo preleva permette al cliente di fare il versamento di contante
	 * @param importo
	 * @return ritorna un Itransazione ossia l'interfaccia in modo tale da poter utilizzare qualsiai Transazione
	 */
	public ITransazione versa(double importo) 
	{
		VersamentoDiContante vc = new VersamentoDiContante(this.conto, importo);
		return vc;
	}
	
	/**
	 * Il metodo visualizzaSaldo permette di visualizzare il saldo
	 * @return ritorna il saldo
	 */
	public double visualizzaSaldo()
	{
		return conto.getSaldo();
	}
	
	
	/**
	 * Il metodo getNome serve per recuperare il nome del cliente inserito
	 * @return ritorna il nome del cliente 
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * Il metodo setNome serve per settare il nome del cliente
	 * @param nome
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	/**
	 * Il metodo getCognome serve per recuperare il cognome del cliente inserito
	 * @return ritorna cognome del cliente
	 */
	public String getCognome()
	{
		return cognome;
	}
	/**
	 * Il metodo setCognome serve per settare il cognome del cliente
	 * @param cognome
	 */
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	/**
	 * Il metodo getIndirizzo serve a recuperare l'indirizzo del cliente
	 * @return ritorna indirizzo del cliente
	 */
	public String getIndirizzo()
	{
		return indirizzo;
	}
	/**
	 * Il metodo setIndirizzo setta l'indirizzo del cliente
	 * @param indirizzo
	 */
	public void setIndirizzo(String indirizzo)
	{
		this.indirizzo = indirizzo;
	}
	/**
	 * Il metodo getCodiceFiscale serve per recuperare il codice fiscale del cliente
	 * @return ritorna il codice fiscale del cliente
	 */
	public String getCodiceFiscale()
	{
		return codiceFiscale;
	}
	/**
	 * Il metodo setCodiceFiscale serve per settare il codice fiscale del cliente
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}
	/**
	 * Il metodo getAnno serve per recuperare l'anno del cliente
	 * @return ritorna l'anno del cliente
	 */
	public int getAnno()
	{
		return anno;
	}
	/**
	 * Il metodo setAnno serve per settare l'anno del cliente
	 * @param anno
	 */
	public void setAnno(int anno)
	{
		this.anno = anno;
	}

	
    /**
     * Il metodo ContoBancario serve a recuperare il conto bancario a cui il cliente è legato
     * @return ritorna il conto bancario del cliente
     */
	public ContoBancario getConto() 
	{
		return conto;
	}

/**
 * Il metodo setConto serve a settare il conto del cliente
 * @param conto
 */
	public void setConto(ContoBancario conto)
	{
		this.conto = conto;
	}
    
	
	/**
	 * Il metodo toString restituisce l'oggetto cliente sottoforma di stringa
	 * @param non prende nessun parametro in input
	 * @return ritorna l'oggetto sotto forma di stringa
	 */
	public String toString()
	{
	  return getClass().getName() + "[nome: " + nome +" "+"cognome: "+cognome+" "+"indirizzo:"+indirizzo+" "+"anno:"+anno+" "+"codice fiscale:"+codiceFiscale+"]";
	}
	
	/**
	 * Il metodo equals serve per mettere a confronto due oggetti cliente in base al codice fiscale
	 * @param prende in input un oggetto di tipo Object
	 * @return ritorna un boolean: true,false se i due oggetti sono uguali oppure no rispettivamente 
	 */
	public boolean equals(Object c)
	{
		if( !(c instanceof Cliente)) return false;
		  
		Cliente c1 = (Cliente)c;
		
		if( c1.getCodiceFiscale().equals(codiceFiscale) )return true;
		
		return false;	
	}
    
	/**
	 * Il metodo clone serve a clonare la classe cliente
	 * @return ritorna un Object 
	 * @param nessun parametro in input
	 */
	public Object clone()
	{
		try 
		{
			
			return super.clone();
			
		}
		catch (CloneNotSupportedException e)
		{
		
		   return null;
		}
	}
	
/**
 * Il metodo compareTo serve a comparare due oggetti cliete in base all'ordine lesicografico su nome restituisce: 1,0,-1
 *  @param prende un Object come input
 *  @return ritorna un int : 1,0,-1 in base all'odine lessicografico su nome
 */
	public int compareTo(Object o)
	{
		Cliente o1 = (Cliente) o;
			
		return o1.getNome().compareTo(nome)*-1;
	}
	
	private String nome,cognome,indirizzo,codiceFiscale; 
	private ContoBancario conto;
    private int anno;
	
	
}
