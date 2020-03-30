package fr.uvsq.pglp4_2;


import fr.uvsq.pglp4_2.commandes.Commandes;
import fr.uvsq.pglp4_2.commandes.Undo;
import fr.uvsq.pglp4_2.commandes.Quit;

import fr.uvsq.pglp4_2.operation.Addition;
import fr.uvsq.pglp4_2.operation.Soustraction;
import fr.uvsq.pglp4_2.operation.Multiplication;
import fr.uvsq.pglp4_2.operation.Division;
import fr.uvsq.pglp4_2.operation.Operations;

import java.util.Stack;
import java.util.HashMap;

public class MoteurRPN {
	
	private HashMap<String,Operations> mapO;
	private Stack<Double> pile;
	private Undo u;
	
	private MoteurRPN(final Stack<Double> pileOperandes, final Undo upara) {
		pile = pileOperandes;
		u = upara;
		mapO = new HashMap<String, Operations>();
		
		this.mapO.put("+",new Addition());
		this.mapO.put("-",new Soustraction());
		this.mapO.put("*",new Multiplication());
		this.mapO.put("/",new Division());
	}


	public void addOperande(final Double operande1) {
		pile.push(operande1);
	}
	
	
	public void faireOperation(final String operation)throws Exception{
		
	if( pile.size()<2) {
		throw new Exception();
	}
	else {
		if(mapO.containsKey(operation))
		{
			double operande2=this.pile.pop();
			double operande1=this.pile.pop();
			
			try {
				double resultat = this.mapO.get(operation).exeOperation(operande1, operande2);
				this.pile.push(resultat);
				//u.actualisationStack(); fait le undo

			}
			catch(Exception  e) {
				this.pile.push(operande1);
				this.pile.push(operande2);
				
				//e.printStackTrace();
			}
		}
		else {
			throw new Exception();
		}
	}
		
	}
	

	public void afficheOperandes() 
	{
		int i;
		for( i=0;i<this.pile.size();i++){
			
			System.out.println(this.pile.get(i));
		}
	}
	

}

