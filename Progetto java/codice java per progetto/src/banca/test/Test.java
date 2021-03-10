package banca.test;

import java.util.ArrayList;
import banca.Banca;
import banca.Cliente;
import banca.Operatore;
import banca.conticorrenti.CartaDiCredito;
import banca.conticorrenti.CartaDiDebito;
import banca.conticorrenti.ContoCorrente;
import banca.conticorrenti.LibrettoDiDeposito;

/**
 * @author Giuseppe Emanuele Pezzillo
 *La classe Test permette la simulazione della banca istanziando operatori clienti transazioni e conti bancari
 *
 */  
public class Test 
{
	private Banca banca;
	
	/**
	 * Costruttore della classe test e non fa altro che eseguire il metodo esegui e tale metodo non fa altro che 
	 * inizializzare gli oggetti necessari per la simulazione della banca
	 */
	public Test()
	{
		esegui();
	}
	
	/**
	 * Per poter avviare la simulazione della banca senza grafica
	 * 
	 */
	public static void main(String[] args) 
	{
		new Test();
	}
	
	/**
	 * Il metodo esegui è il corpo del main ed è sviluppato in questo modo se per caso bisogna implementare 
	 * dei metodi da utilizzare nel main non li faccio statici ma li creo dopo il metodo esegui e li posso
	 * utilizzare 
	 */
	public void esegui() 
	{
		banca = new Banca();
		
		System.out.println("Registrando una serie di operatori ");
		
		Operatore op = new Operatore("0512103476");
		Operatore op1 = new Operatore("0512103899");
		Operatore op2 = new Operatore("0512105888");
		Operatore op3 = new Operatore("0512109999");
		Operatore op4 = new Operatore("0512104663");
				
		banca.aggiungiOperatore(op);
		banca.aggiungiOperatore(op1);
		banca.aggiungiOperatore(op2);
		banca.aggiungiOperatore(op3);
		banca.aggiungiOperatore(op4);
		
		System.out.println("Gli operatori presenti sono:\n");
		stampaLista(banca.getOperatori());
		
		
		System.out.println("\n\nRegistrando una serie di clienti");
		
		Cliente c = new Cliente("Mario", "Rossi", 1989, "VIA ROMA", "MARO989M");
		Cliente c1 = new Cliente("Giuseppe", "Napolitano",1995 , "VIA VERDI", "GINA564M");
		Cliente c2 = new Cliente("Veronica", "De Simone", 1969, "VIA MARCONI", "VEDE821F");
		Cliente c3 = new Cliente("Elisabetta", "Napolitano", 1992, "VIA DEI CADUTI", "ELNA854F");
		Cliente c4 = new Cliente("Giacomo", "De Palma", 1969, "VIA LEONARDO DA VINCI", "GIDE999M");
		
		banca.aggiungiCliente(c);
		banca.aggiungiCliente(c1);
		banca.aggiungiCliente(c2);
		banca.aggiungiCliente(c3);
		banca.aggiungiCliente(c4);
		
		System.out.println("I clienti presenti sono:\n");
		stampaLista(banca.getClienti());
		
		System.out.println("\n\nRegistrando una serie di conti");
		
		LibrettoDiDeposito ld = new LibrettoDiDeposito(c, 5000, 1);
		ContoCorrente cc = new ContoCorrente(c1, 8000, 2, 4);
		CartaDiCredito ccre = new CartaDiCredito(c2, 10000, 3, 4000);
		
		CartaDiDebito cd=null;
		CartaDiDebito cd1=null;
		
		try
		{
			cd = new CartaDiDebito(cc, 3000);
		    cd1 = new CartaDiDebito(ld, 1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		banca.aggiungiContoBancario(ld);
		banca.aggiungiContoBancario(cc);
		banca.aggiungiContoBancario(ccre);
		banca.aggiungiContoBancario(cd);
		banca.aggiungiContoBancario(cd1);
		
		System.out.println("I conti bancari presenti sono:\n");
	    stampaLista(banca.getContiBancari());
		
		// Simulazione della banca
		
		System.out.println("\n\nInizio simulazione della banca \n\n ");	
		
      
		System.out.println("Autenticando gli operatori perchè se non sono autenticati non si possono eseguire transazioni e tutte le altre operazioni bancarie \n");
		
	    op.setCodiceAutentica("3");
	    op.autentica("3");
	    
	    op1.setCodiceAutentica("5");
		op1.autentica("5");
		
		op2.setCodiceAutentica("10");
		op2.autentica("10");
		
		
		
	    
        System.out.println("Simulazione prelevamento del cliente all'interno della banca:");
	    	try 
	    	{
				banca.prelevamentoDelCliente(c, 5000);
			} 
	    	catch (Exception e1)
	    	{
				System.out.println(e1);
			}
	    	
			System.out.println("Saldo del cliente:"+c.getConto().getSaldo());
		    banca.eseguiTransazioni();   

		    System.out.println("Saldo dopo prelevamento da parte del cliente di 5000 è di :"+ c.getConto().getSaldo());
	   
		    System.out.println("\n\n");
		  
		    System.out.println("Simulazione spostamento di fondi in cui il conto di origine è un conto corrente e la destinazione è un libretto di deposito\n");
		    System.out.println("Spostare 1000 euro da conto origine a conto detinazione: \n");
	    	banca.aggiungiSpostamentoDiFondi(op, cc, ld, 1000);
			System.out.println("Saldo del conto origine dello spostamento di fondi: "+cc.getSaldo());
			System.out.println("Saldo del conto destinazione dello spostamento di fondi: "+ld.getSaldo());
			banca.eseguiTransazioni();
			System.out.println("Saldo conto origine dopo l'esecuzione della transazione: "+cc.getSaldo());		
			System.out.println("Saldo conto destinazione dopo l'esecuzione della transazione: "+ld.getSaldo());
	    
			System.out.println("\n eseguendo di nuovo prelevamento da parte del cliente come fatto prima ossia vogliamo prelevare 5000");
			System.out.println("ma il conto attuale del cliete è a 1000");
			
		try
		{
			banca.prelevamentoDelCliente(c, 5000);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("Saldo attuale cliente: "+c.getConto().getSaldo());
	    System.out.println("dopo transazione viene lanciata l'eccezione:");
		banca.eseguiTransazioni();	
		System.out.println("proprio perchè il conto del cliete essendo a 1000 non consente di prelevare 5000");
	    System.out.println("Saldo del cliente dopo transazione: "+c.getConto().getSaldo()+"\n");
		
	    
	    System.out.println("Ora simulando di nuovo lo spostamento di fondi con conto origine: conto corrente e conto destinazione:libretto di deposito ");
	    System.out.println("in questo caso però preleviamo 1000 \n");
		banca.aggiungiSpostamentoDiFondi(op, cc, ld, 1000);
		System.out.println("Saldo conto origine: "+cc.getSaldo());
		System.out.println("Saldo conto destinazione: "+ld.getSaldo());
		System.out.println("Dopo transazione:");
		banca.eseguiTransazioni();
		System.out.println("Saldo conto origine dopo transazione: "+cc.getSaldo());		
		System.out.println("Saldo conto destinazione dopo transazione: "+ld.getSaldo());
		
		
		System.out.println("\n Simulazione versamento di contante e abbiamo come conto di origine un conto corrente e come somma da accreditare abbiamo 3500:");
		banca.aggiungiVersamentoDiContante(op1, cc, 3500);
		System.out.println("Saldo iniziale conto origine: "+cc.getSaldo());
		System.out.println("Esecuzione della transazione: ");
		banca.eseguiTransazioni();
	    System.out.println("Saldo dopo esecuzione della transazione: "+cc.getSaldo());
	
	    
		System.out.println("\n Simulazione prelevamento di contante e abbiamo come conto origine una carta di credito e come somma da addebitare abbiamo 1500:");
		try
		{
			banca.aggiungiPrelevamentoDiContante(op2, ccre, 1500);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("Saldo iniziale conto origine: "+ccre.getSaldo());
		System.out.println("Esecuzione della transazione: ");
		banca.eseguiTransazioni();
		System.out.println("Saldo dopo l'esecuzione della transazione: "+ccre.getSaldo());
		
		
		
		System.out.println("\nSimulazione liquidazione degli interessi con boolean accreditare a true e quindi si effetua il deposito dell'importo specificato sul conto ");
		System.out.println("come conto di origine abbiamo un libretto di deposito e la percentuale degli interessi è 10 e in questo caso vengono depositati sul conto: \n");
		banca.aggiungiLiquidazioneDegliInteressi(op, ld, 10, true);
		System.out.println("Saldo iniziale conto origine: "+ld.getSaldo());
		System.out.println("Esecuzione delle transazione: ");
		banca.eseguiTransazioni();
		System.out.println("Saldo dopo l'esecuzione della transazione: "+ld.getSaldo());
		
		
		
		System.out.println("\nSimulazione liquidazione degli interessi con boolean accreditare a false e quindi si effetua il prelievo dell'importo specificato sul conto ");
		System.out.println("come conto di origine abbiamo un libretto di deposito e la percentuale degli interessi è 10 e in questo caso vengono prelevati dal conto : \n");
		banca.aggiungiLiquidazioneDegliInteressi(op1, ld, 10, false);
		System.out.println("Saldo inizile conto di origine: "+ld.getSaldo());
		System.out.println("Esecuzione della transazione: ");
		banca.eseguiTransazioni();
		System.out.println("Saldo dopo esecuzione della transazione: "+ld.getSaldo());
		
		
		System.out.println("\nSimulazione liquidazione delle spese con boolean accreditare a true e quindi si effetua il deposito dell'importo specificato sul conto ");
		System.out.println("come conto di origine abbiamo una carta di debito e le spese sono di 500 in questo caso da depositare: \n");
		banca.aggiungiLiquidazioneDelleSpese(op2, cd, 500, true);
		System.out.println("Saldo iniziale del conto origine: "+cd.getSaldo());
		System.out.println("Esecuzione della transazione: ");
		banca.eseguiTransazioni();
		System.out.println("Saldo dopo esecuzione della transazione: "+cd.getSaldo());
		
		
		System.out.println("\nSimulazione liquidazione delle spese con boolean accreditare a false e quindi si effetua il prelievo dell'importo specificato sul conto ");
		System.out.println("come conto di origine abbiamo una carta di debito e le spese sono di 500 in questo caso da prelevare: \n");
	    banca.aggiungiLiquidazioneDelleSpese(op, cd, 500, false);
	    System.out.println("Saldo iniziale del conto origine: "+cd.getSaldo());
	    System.out.println("Esecuzione della transazione: ");
		banca.eseguiTransazioni();
		System.out.println("Saldo dopo esecuzione della transazione: "+cd.getSaldo());
		
		
		System.out.println("\n\n Le transazioni create sono:\n");
		stampaLista(banca.getTransazioni());
		System.out.println("\nTermine simulazione della banca");
	
	}
	
	/**
	 * Il metodo stampaLista serve appunto per stampare lista di clienti operatori transazioni conti bancari in base
	 * a quello richiesto dall'utente e questo metodo viene utilizzato nel metodo esegui 
	 * @param lista di oggetti 
	 */
	public void stampaLista(ArrayList lista)
	{
		for(int i=0; i<lista.size(); i++)
		{
	      System.out.println(lista.get(i));
		}
	}
	
	/**
	 * Il metodo getBanca serve a recuperare la banca istanziata e questo metodo viene utilizzato nella classe Grafica
	 * @return banca
	 */
	public Banca getBanca()
	{
		return banca;
	}
	

}
