package banca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import com.sun.java_cup.internal.runtime.Symbol;

import banca.conticorrenti.CartaDiCredito;
import banca.conticorrenti.ContoBancario;
import banca.transazioni.ITransazione;
import banca.transazioni.LiquidazioneDegliInteressi;
import banca.transazioni.Transazione;

/**
 * @author Giuseppe Emanuele Pezzillo
 * 
 * La classe Banca come variabili di istanza ha lista operatori, lista clienti, lista transazioni di tipo interfaccia
 * ITransazione,lista conti bancari che permettono la simulazione di una banca 
 *
 */

public class Banca {

	/**
	 * Costruttore Banca : inizilizza interesi passivi a 3 , istanzia una lista di operatori, clienti,transazioni e conti
	 * bancari
	 * 
	 */
	
	
	   public Banca()
	   {
		   this.interessiPassivi = 3;
		   this.operatori = new ArrayList<Operatore>();
		   this.clienti = new ArrayList<Cliente>();
		   this.transazioni = new ArrayList<ITransazione>();
		   this.contiBancari = new ArrayList<ContoBancario>();
	   }
	   
	   /**
	    * Il metodo aggiungiOperatore permette di aggiungere un operatore alla lista di operatori
	    * 
	    * @param prede come input un operatore
	    * @return non ritorna nessun valore 
	    */
	   public void aggiungiOperatore(Operatore op)
	   {
		   operatori.add(op);
	   }
	   
	 /**
	  * Il metodo aggiungiCliente permette di aggiungere un cliente alla lista dei clienti
	  */
	   public void aggiungiCliente(Cliente c)
	   {
		   clienti.add(c);
	   }
	   
	   /**
	    * Il metodo aggiungiContoBancario aggiunge un conto bancario alla lista di conti bancari
	    * @param  conto bancario
	    */	   
	   public void aggiungiContoBancario(ContoBancario cb)
	   {
		   contiBancari.add(cb);
	   }
	   
	   
	   /**
	    * Il metodo prelevamentoDelCliente serve per poter eseguire operazioni di prelevamento da parte del cliente
	    * @param cliente
	    * @param importo
	    * @throws Exception: importo massimo del mese raggiunto
	    */
	   public void prelevamentoDelCliente(Cliente cliente, double importo) throws Exception
	   {
			if(cliente.getConto() instanceof CartaDiCredito) 
			{
				if(!verificaImportoMassimoPrelievo((CartaDiCredito)cliente.getConto(), importo))
					throw new Exception("Importo massimo del mese  raggiunto ");
			}

		   
		   ITransazione t = cliente.preleva(importo);
		   transazioni.add(t);
	   }
	   
	   /**
	    * Il metodo versamentoDelCliente serve per poter eseguire operazioni di versamento da parte del cliente
	    * @param cliente
	    * @param importo
	    */
	   public void versamentoDelCliente(Cliente cliente, double importo)
	   {
		   ITransazione t = cliente.versa(importo);
		   transazioni.add(t);
	   }
	   
	   
	   /**
	    * Il metodo getOperatoriOrdinati restituisce gli operatori in base al valore crescente della matricola
	    * @param nessun parametro in input
	    * @return ritorna gli operatori ordinati
	    */
	   public ArrayList<Operatore> getOperatoriOrdinati()              
	   {
		   ArrayList<Operatore> op = (ArrayList<Operatore>) operatori.clone(); 
		   Collections.sort(op);
		   return op;
	   }
	   /**
	    * Il metodo getOperatori restituisce gli operatori in ordine di inserimento
	    * @return operatori 
	    */
	   public ArrayList<Operatore> getOperatori()              
	   {
		   return operatori;
	   }
	   
	   /**
	    * Il metodo getClientiOrdinati restituisce i clienti in base all'ordine lessicografico sui nomi
	    * @param nessun parametro in input
	    * @return ritorna la lista di clienti ordinata
	    */
	   public ArrayList<Cliente> getClientiOrdinati()              
	   {
		   ArrayList<Cliente> a = (ArrayList<Cliente>) clienti.clone(); 
		   Collections.sort(a);
		   return a;
		   
	   }
	   /**
	    * Il metodo getClienti restituisce i clienti in base all'ordine di inserimento
	    * @return clienti
	    */
	   public ArrayList<Cliente> getClienti()              
	   {
		   return clienti;   
	   }
	   
	   /**
	    * Il metodo getContiBancariOrdinati restituisce i conti bacari in base al valore crescente del saldo
	    * @param nessun parametro in input
	    * @return ritorna la lista dei conti bancari ordinati
	    */
	   public ArrayList<ContoBancario> getContiBancariOrdinati()
	   {
		   ArrayList<ContoBancario> contBanc = (ArrayList<ContoBancario>) contiBancari.clone(); 
		   Collections.sort(contBanc);
		   return contBanc;
	   }
	   /**
	    * Il metodo getContiBancari restituisce i conti bancari in base all'ordine di inserimento
	    * @return conti bancari
	    */
	   public ArrayList<ContoBancario> getContiBancari()
	   {
		   return contiBancari;
	   }
	   /**
	    * Il metodo getTransazioniOrdinate restituisce le transazioni  in base al valore crescente dell'importo
	    * @param nessun parametro in input
	    * @return ritorna la lista delle transazioni ordinate
	    */
	   public ArrayList<Transazione> getTransazioniOrdinate()
	   {
		   ArrayList<Transazione> trans = (ArrayList<Transazione>) transazioni.clone();
		   Collections.sort(trans);
		   return trans;
	   }
	   /**
	    * Il metodo getTransazioni restituisce le transazioni in base all'ordine di creazione
	    * @return transazioni
	    */
	   public ArrayList<ITransazione> getTransazioni()
	   {
		   return transazioni;
	   }
	   
	   /**
	    * Il metodo aggiungiSpostamentoDiFondi permette alla banca di aggiungere la transazione spostamento di fondi ,creata
	    * dall'operatore mediante il metodo creaSpostamentoDiFondi, all'ArrayList di ITranazione contenuto nella banca  
	    * @param operatore
	    * @param origine
	    * @param destinazione
	    * @param importo
	    */
		public void aggiungiSpostamentoDiFondi(Operatore op, ContoBancario origine, ContoBancario destinazione, double importo)
		{
			ITransazione t;
			
			try 
			{
				t = op.creaSpostamentoDiFondi(origine, destinazione, importo);
				transazioni.add(t);
			}
			
			catch (Exception e) 
			{
				System.out.println(e);
			}
			
		}
		
		/**
		 * Il metodo aggiungiVersamentoDiContante permette alla banca di aggiungere la transazione
		 * versamento di contante ,creata dall'operatore, nell'ArrayList di ITransazione contenuto nella banca
		 * @param operatore
		 * @param origine
		 * @param sommaDaAccreditare
		 */
		public void aggiungiVersamentoDiContante(Operatore op, ContoBancario origine , double sommaDaAccreditare)
		{
            ITransazione t;
			
			try 
			{
				t = op.creaVersamentoDiContante(origine, sommaDaAccreditare);
				transazioni.add(t);
			}
			
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		/**
		 * Il metodo aggiungiPrelevamentoDiContante peremtte alla banca di poter aggiungere la transazione
		 * prelevamento di contante , creata dall'operatore , nell'ArrayList di ITransazione contenuto in banca
		 * @param operatore
		 * @param origine
		 * @param sommaDaAddebitare
		 * @throws Exception
		 */
		public void aggiungiPrelevamentoDiContante(Operatore op, ContoBancario origine, double sommaDaAddebitare) throws Exception
		{
			
			
			if(origine instanceof CartaDiCredito) 
			{
				if(!verificaImportoMassimoPrelievo((CartaDiCredito)origine, sommaDaAddebitare))
					throw new Exception("Importo massimo del mese  raggiunto ");
			}
			
			
            ITransazione t=null;
			
			try 
			{
				t = op.creaPrelevamentoDiContante(origine, sommaDaAddebitare);
				transazioni.add(t);
			}
			
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		/**
		 * Il metodo verificaImportoMassimoPrelievo verfica che il cliente non  abbia fatto prelievi per un importo 
		 * massimo negli ultimi 30 giorni
		 * @param carta
		 * @param sommaDaAddebitare
		 * @return true se la verifica è giusta altrimenti false
		 */
		private boolean verificaImportoMassimoPrelievo(CartaDiCredito carta, double sommaDaAddebitare)
		{
			ArrayList<Transazione> trans = new ArrayList<Transazione>();
			ArrayList<Transazione> trans1 = (ArrayList)transazioni;
			
			for(int i=0; i<transazioni.size(); i++)
			{
				GregorianCalendar g = new GregorianCalendar();
				g.add(g.DAY_OF_MONTH, -30);

				if(trans1.get(i).getOrigine().getNumeroConto()==carta.getNumeroConto()
					&& trans1.get(i).getData().getTimeInMillis() > g.getTimeInMillis())
				{							
					trans.add(trans1.get(i));
				}
			}
			
			double sommaImporti = sommaDaAddebitare;
			
			for(int i=0; i<trans.size(); i++)
			{
			   sommaImporti += trans.get(i).getImporto(); 
			}
			
			
			if(sommaImporti > carta.getImportoMassimoPrelievi()) 
				return false;
			else
				return true;
			
		
		}
		
		/**
		 * Il metodo aggiungiLiquidazioneDegliInteressi permette alla banca di poter aggiungere la transazione
		 * liquidazione degli interessi, creata dall'operatore , nell'ArrayList di ITransazione contenuto nella banca 
		 * @param operatore
		 * @param origine
		 * @param percInteressi
		 * @param accreditare
		 */
		public void aggiungiLiquidazioneDegliInteressi(Operatore op, ContoBancario origine , double percInteressi, boolean accreditare)
		{
            ITransazione t;
			
			try 
			{
				t = op.creaLiquidazioneDegliInteressi(origine, percInteressi,accreditare); 
				transazioni.add(t);
			}
			
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		/**
		 * Il metodo aggiungiLiquidazioneDelleSpese permette alla banca di poter aggiungere la transazione 
		 * liquidazione delle spese, creata dall'operatore , nell'ArrayList di ITransazione contenuto nella banca
		 * @param operatore
		 * @param origine
		 * @param spese
		 * @param accreditare
		 */
		public void aggiungiLiquidazioneDelleSpese(Operatore op, ContoBancario origine , double spese, boolean accreditare)
		{
            ITransazione t;
			
			try 
			{
				t = op.creaLiquidazioneDelleSpese(origine, spese, accreditare); 
				transazioni.add(t);
			}
			
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		/**
		 * Il metodo aggiungiConcessioneDiFido permette alla banca di aggiungere la transazione 
		 * concessione di fido, creata dall'operatore, nell'ArrayList di ITransazione contenuto nella banca
		 * @param operatore
		 * @param origine
		 * @param importoFido
		 */
		public void aggiungiConcessioneDiFido( Operatore op, ContoBancario origine, double importoFido)
		{
            ITransazione t;
			
			try 
			{
				t = op.creaConcessioneDiFido(origine,importoFido ); 
				transazioni.add(t);
			}
			
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		/**
		 * Il metodo eseguiTransazioni permette di eseguire le transazioni e il parametro isEseguita serve solo
		 * a far eseguire le nuove transazioni se per esempio una transazione è stata già eseguita quindi isEeguita 
		 * è a true la banca non la esegue più
		 * 
		 */
		public void eseguiTransazioni()
		{
	        for(int i=0; i<transazioni.size(); i++)
	        {
	        	
	        	try
	        	{
	        		Transazione tr = (Transazione)transazioni.get(i);
	        		if(tr.isEseguita())
	        			continue;
	        		
					transazioni.get(i).esegui();
				}
	        	
	        	catch (Exception e)
	        	{
					System.out.println(e);
	        	}
	        	
	        }
		}
		
		/**
		 * Il metodo getEstrattoConto restituisce tutte le transazioni di quel conto e serve per la carta di credito 
		 * che vuole gli estatti conto dalla banca ossia sarebbero tutte le operazioni effettuate sul conto bancario 
		 * e quindi le operazioni non sono altro che le transazioni
		 * @param conto
		 * @return
		 */
		public ArrayList<Transazione> getEstrattoConto(ContoBancario conto)
		{
			if(conto instanceof CartaDiCredito)
			{
				if(conto.getSaldo()<0)
				{
					LiquidazioneDegliInteressi l = new LiquidazioneDegliInteressi(conto, interessiPassivi, false);
					transazioni.add(l);
				}
			}
			
			
			ArrayList<Transazione> itr = new ArrayList<Transazione>();
			

			for( int i=0 ; i<transazioni.size() ; i++)
			{
				Transazione t = (Transazione)transazioni.get(i);
				if(t.getOrigine().getNumeroConto()== conto.getNumeroConto())
					itr.add(t);
			}
			
			return itr;
		}


       private final double interessiPassivi;
	   private ArrayList<Operatore> operatori;
	   private ArrayList<Cliente> clienti;
	   private ArrayList<ITransazione> transazioni;
	   private ArrayList<ContoBancario> contiBancari;
	   
}
