package banca.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import banca.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Grafica extends JFrame
{

	private Banca banca;
	
	private JPanel contentPane;
	
	private JTextArea textArea;
	
	

	/**
	 * Lanciare l'applicazione
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Grafica frame = new Grafica();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creare il frame.
	 */
	public Grafica()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Print");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmClienti = new JMenuItem("Clienti");
		mnNewMenu.add(mntmClienti);
		
		JMenuItem mntmContiBancari = new JMenuItem("Conti Bancari");
		mnNewMenu.add(mntmContiBancari);
		
		JMenuItem mntmOperatori = new JMenuItem("Operatori");
		mnNewMenu.add(mntmOperatori);
		
		JMenuItem mntmTransazioni = new JMenuItem("Transazioni");
		mnNewMenu.add(mntmTransazioni);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		Test test = new Test(); // creo un nuovo oggetto test per recuperare la banca con gli operatori, clienti, conti 
		                        // transazioni già inizializzate
		
		banca = test.getBanca();// recupero la banca già con tutti gli oggetti inizilizzati con il metodo getBanca
		                        // chiamato sull'oggetto test
		
		creaAzione(banca.getClientiOrdinati(), mntmClienti);
		creaAzione(banca.getContiBancariOrdinati(), mntmContiBancari);
		creaAzione(banca.getOperatoriOrdinati(), mntmOperatori);
		creaAzione(banca.getTransazioniOrdinate(), mntmTransazioni);
	}
	
	/**
	 * Im metodo creaAzione prende in input un ArrayList ed un menù item per creare l'azione in base al click del
	 * mouse su clienti, operatori, conti bancari, transazioni per poter retituire in base al click del mouse
	 * operatori ordinati, clienti ordinati, transazioni ordinate oppure conti bancari ordinati, il ciclo for permette
	 * di scorrere l'ArrayList e di mostrare a video i dati però c'è come primo parametro Object perchè essendo un
	 * metodo generico non si sa inizialmente di che oggetto si tratta
	 * @param ArrayList 
	 * @param item menù
	 */
	private void creaAzione(final ArrayList al, JMenuItem m)
	{
		m.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText("");
				
				for(Object o : al)
				{
					textArea.setText(textArea.getText()+o.toString()+"\n");
				}
				
			}
		});
	}
	
}
