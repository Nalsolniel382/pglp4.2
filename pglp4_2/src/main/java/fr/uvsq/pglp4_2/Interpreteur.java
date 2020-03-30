package fr.uvsq.pglp4_2;


import java.util.HashMap;
import java.util.Map;



import fr.uvsq.pglp4_2.commandes.Commandes;
import fr.uvsq.pglp4_2.commandes.Quit;
import fr.uvsq.pglp4_2.commandes.Undo;


public class Interpreteur {

	

	private HashMap<String,Commandes> map;
	
	public Interpreteur(Undo u) {
		map = new HashMap<String,Commandes>();
		
		Quit q = new Quit();
		this.map.put("undo",u);
		this.map.put("quit",q);
	}
	
	
	public void addCommand(final String name,final Commandes command) {
		this.map.put(name,command);
	}
	
	
	public void exe(final String name) throws Exception {
		
		if (map.containsKey(name))
		{
			
			try {
				map.get(name).exeCommande();
			} catch (Exception e) {
				System.err.println("impossible de faire la commande ");
			}
			
		}
		
		else 
		{
			throw new Exception();
		}
	}
	
}
