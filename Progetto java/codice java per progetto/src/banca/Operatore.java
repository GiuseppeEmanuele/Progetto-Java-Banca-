package banca;

import banca.conticorrenti.ContoBancario;
import banca.transazioni.ConcessioneDiFido;
import banca.transazioni.ITransazione;
import banca.transazioni.LiquidazioneDegliInteressi;
import banca.transazioni.LiquidazioneDelleSpese;
import banca.transazioni.PrelevamentoDiContante;
import banca.transazioni.SpostamentoDiFondi;
import banca.transazioni.VersamentoDiContante;
/**
 * @author Giuseppe Emanuele Pezzillo
 * La classe operatore serve per il funzionamento della banca e fanno da intermediari  con i clienti
 *
 */
public class Operatore implements Cloneable,Comparable {
	
	/**
	 * Il costruttore della classe operatore setta la matricola e il codice autenticazione a false perchè all'inizio
	 * l'operatore non è autenticato
	 * @param prende in input come parametro la matricola
	 */
	public Operatore(String matricola)
	{
		this.matricola = matricola;
		isAutenticato = false;
	}
	
	/**
	 * IL metodo setCodiceAutentica setta il codice autenticazione per l'operatore
	 * @param prende come parametro in input il codice codiceAutenticaOperatore
	 */
	public void setCodiceAutentica(String codiceAutenticaOperatore)
	{
		this.codiceAutenticaOperatore = codiceAutenticaOperatore;
	}
	
	/**
	 * IL metodo autentica verifica se l'operatore è autenticato
	 * @param prende in input il codiceAutenticaDaVerificare
	 * @return ritorna false se l'operatore non è autenticato , true se l'operatore è autenticato
	 */
	public boolean autentica(String codiceAutenticaDaVerificare)
	{
	      
	      if(codiceAutenticaDaVerificare.equals(codiceAutenticaOperatore))
	    	  isAutenticato=true;
	      
	      return isAutenticato;
	}

	/**
	 * Il metodo creaSpostamentoDiFondi permette all'operatore di creare la transazione spostamento di fondi e
	 * restituisce una ITransazione perchè nelle banca aggiungiamo le transazioni in un ArrayList di ITransazione
	 * in modo tale da poter inserire qualsiasi tipo di Transazione e dopo c'è la possibilità di sapere che tipo
	 * di transazione è stata utilizzata(inserita)
	 * @param origine
	 * @param destinazione
	 * @param importo
	 * @return ITransazione
	 * @throws Exception
	 */
	public ITransazione creaSpostamentoDiFondi( ContoBancario origine, ContoBancario destinazione, double importo) throws Exception
	{
		
		if(!isAutenticato) throw new Exception("Non è possibile creare la transazione, operatore non autenticato");

		SpostamentoDiFondi sf = new SpostamentoDiFondi(origine, destinazione, importo);
		return sf;
	}
	
	/**
	 * Il metodo creaVersamentoDiContante permette all'operatoredi creare la tranazione versamento di contante
	 * @param origine
	 * @param sommaDaAccreditare
	 * @return ITransazione
	 * @throws Exception
	 */
	public ITransazione creaVersamentoDiContante( ContoBancario origine , double sommaDaAccreditare) throws Exception
	{
		if(!isAutenticato) throw new Exception("Non è possibile creare la transazione, operatore non autenticato");
		
		VersamentoDiContante vc = new VersamentoDiContante(origine, sommaDaAccreditare);
		return vc;
	}
	
	/**
	 * Il metodo creaPrelevamentoDiContante permette all'operatore di creare la transazione prelevamento di contante
	 * @param origine
	 * @param sommaDaAddebitare
	 * @return ITransazione
	 * @throws Exception
	 */
	public ITransazione creaPrelevamentoDiContante( ContoBancario origine, double sommaDaAddebitare) throws Exception
	{
		if(!isAutenticato) throw new Exception("Non è possibile creare la transazione, operatore non autenticato");
		
		PrelevamentoDiContante pc = new PrelevamentoDiContante(origine, sommaDaAddebitare);
		return pc;
	}
	
	/**
	 * Il metodo creaLiquidazioneDegliInteressi permette all'operatore di creare la transazione liquidazione degli interessi
	 * @param origine
	 * @param percInteressi
	 * @param accreditare
	 * @return ITransazione
	 * @throws Exception
	 */
	public ITransazione creaLiquidazioneDegliInteressi( ContoBancario origine , double percInteressi, boolean accreditare) throws Exception
	{
		if(!isAutenticato) throw new Exception("Non è possibile creare la transazione, operatore non autenticato");
		
		LiquidazioneDegliInteressi li = new LiquidazioneDegliInteressi(origine,percInteressi,accreditare);
		return li;
	}
	
	/**
	 * Il metodo creaLiquidazioneDelleSpese permette all'operatore di creare la transazione liquidazione delle spese
	 * @param origine
	 * @param spese
	 * @param accreditare
	 * @return ITransazione
	 * @throws Exception
	 */
	public ITransazione creaLiquidazioneDelleSpese( ContoBancario origine , double spese, boolean accreditare) throws Exception
	{
		if(!isAutenticato) throw new Exception("Non è possibile creare la transazione, operatore non autenticato");
		
		LiquidazioneDelleSpese ls = new LiquidazioneDelleSpese(origine,spese,accreditare);
		return ls;
	}
	
	/**
	 * Il metodo creaConcessioneDiFido permette all'operatore di creare la transazione concessione di fido
	 * @param origine
	 * @param importoFido
	 * @return ITransazione
	 * @throws Exception
	 */
	public ITransazione creaConcessioneDiFido( ContoBancario origine, double importoFido) throws Exception
	{
		if(!isAutenticato) throw new Exception("Non è possibile creare la transazione, operatore non autenticato");
		
		ConcessioneDiFido cf = new ConcessioneDiFido(origine,importoFido);
		return cf;
	}
	
	
	
	/**
	 * Il metodo getMatricola permette di recuperare la matricola dell'operatore
	 * @return ritorna la matricola dell'operatore
	 */
	public String getMatricola() 
	{
		return matricola;
	}
	
    /**
     * Il metodo setMatricola setta la matricola dell'operatore
     * @param prende come parametro in input la matricola
     */
	public void setMatricola(String matricola)
	{
		this.matricola = matricola;
	}
	
	/**
	 * Il metodo toString restituisce l'oggetto operatore sotto forma di stringa
	 */
	public String toString()
	{
		return getClass().getName() + "["+ "matricola:" + getMatricola()+ "]"; 
	}
	
	/**
	 * Il metodo equals confronta due operatori in base alla matricola
	 * @param prende in input un Object
	 * @return restituisce un boolean true se la matricola è uguale altrimenti false
	 */
	public boolean equals(Object o)
	{
		if( !(o instanceof Operatore) ) return false;
		
		Operatore o1 = (Operatore) o;
		
		if(o1.getMatricola().equals(matricola)) return true;
		
		return false;
	}
	
	/**
	 * Il metodo clone serve per clonare l'oggetto operatore
	 * @param nessun parametro in input
	 * @return ritorna un Object
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
	 * Il metodo compareTo serve per comparare gli operatori in base al valore crescente della matricola
	 * @param prende in input un Object
	 * @return ritorna un intero: 1,0,-1 in base al valore crescente della matricola
	 */
     public int compareTo(Object o)
     {
    	 Operatore o1 = (Operatore) o;
			
 		return o1.getMatricola().compareTo(matricola)*-1;
	 }

    private String codiceAutenticaOperatore;
    private boolean isAutenticato;
	private String matricola;

	
}
