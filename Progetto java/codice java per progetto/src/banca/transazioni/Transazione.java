package banca.transazioni;
import java.util.GregorianCalendar;
import banca.conticorrenti.ContoBancario;

/**
 * 
 * @author Giuseppe Emanuele Pezzillo
 * La classe astratta Transazione è la classe generica per le diverse tipologie di transazioni esistenti
 *
 */
public abstract class Transazione implements Comparable
{
	/**
	 * Costruttore della classe transazione che inizializza una data
	 */
        public Transazione()
        {
        	this.data=new GregorianCalendar();
        }
	  
/**
 * Il metodo getOrigine permette di far recuperare il conto di origine
 * @return conto di origine
 */
	public ContoBancario getOrigine() 
	{
		return origine;
	}
	
	/**
	 * Il metodo setOrigine setta il conto di origine
	 * @param conto di origine
	 */
	public void setOrigine(ContoBancario origine)
	{
		this.origine = origine;
	}
	
	/**
	 * Il metodo getDestinazione permette di far recuperare il conto destinazione
	 * @return conto destinazione
	 */
	public ContoBancario getDestinazione()
	{
		return destinazione;
	}
	
	/**
	 * Il metodo setDestinazione serve a settare la destinazione 
	 * @param destinazione
	 */
	public void setDestinazione(ContoBancario destinazione)
	{
		this.destinazione = destinazione;
	}
	
	/**
	 * Il metodo getImporto permette di far recuperare l'importo
	 * @return importo
	 */
	public double getImporto() 
	{
		return importo;
	}
	
	/**
	 * Il metodo setImporto setta l'importo
	 * @param importo
	 */
	public void setImporto(double importo) 
	{
		this.importo = importo;
	}
	
    /**
     * Il metodo isEseguita serve per verificare se la transazione è stata eseguita
     * @return isEseguita true se eseguita false se non eseguita
     */
	public boolean isEseguita()
	{
		return isEseguita;
	}

	/**
	 * Il metodo getData permette di recuperare la data
	 * @return data
	 */
	public GregorianCalendar getData()
	{
		return data;
	}
	
	/**
	 * Il metodo setData setta la data
	 * @param data
	 */
	public void setData(GregorianCalendar data)
	{
		this.data = data;
	}
	
	/**
	 * IL metodo compareTo mette in comparazione due transazioni e restituisce 1,-1,0 in base al valore crescente 
	 * dell'importo
	 */
	public int compareTo(Object o)
	{
		Transazione o1 = (Transazione)o;
		
		if(o1.getImporto()== importo) return 0;
		
		if(o1.getImporto()>importo)return -1;
		
		return 1;
	}
	
	
	
	

	
/**
 * Il metodo toString retituisce l'oggetto transazione sotto forma di stringa
 */
	public String toString()
	{
		return "Transazione [origine=" + origine + ", destinazione=" + destinazione + ", importo=" + importo + ", data="
				+ data.getTime() + "]";
	}





	protected boolean isEseguita;
	protected ContoBancario origine;
	protected ContoBancario destinazione;
	protected double importo;
	protected GregorianCalendar data;

}
