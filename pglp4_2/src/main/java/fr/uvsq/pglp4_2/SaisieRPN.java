package fr.uvsq.pglp4_2;


import java.util.Scanner;
import java.util.Stack;
import fr.uvsq.pglp4_2.commandes.Undo;
import fr.uvsq.pglp4_2.MoteurRPN;

public class SaisieRPN {
	
	private Scanner s;
	private Undo u;
	private Stack<Double> pile;
	
	private MoteurRPN m;
	private Interpreteur i;
	
	
	public SaisieRPN() {
		pile = new Stack<Double>();
		
		u = new Undo(pile);
		m = new MoteurRPN(pile,u);
		i = new Interpreteur(u);
		
		
	}
	
	
	
public void calcul() throws Exception{
		
		System.out.println("Vous Pouvez entrer: un chiffre; un signe, undo ou quit ");
		
		s = new Scanner(System.in);
		String line="";
		
		boolean fin= false;
		
		while(fin!=true) {
			
			try {//ajout chiffre
				double d = s.nextDouble();
				m.addOperande(d);
				u.actualisationPile();
			}
			
			catch(Exception moteurOperande) 
			{
				try//WTF
				{
					line = s.nextLine();
					m.faireOperation(line);
					
				}
				catch(Exception moteurOperation)
				{
					try
					{
						i.exe(line);
					}
					catch(Exception interpreteur) 
					{
						interpreteur.printStackTrace();
					}
				}
				
			}
			
			if(line.equals("quit")) {
				fin =true;
			}
			else {
				m.afficheOperandes();
			}
		}
		s.close();
		
	}


}
