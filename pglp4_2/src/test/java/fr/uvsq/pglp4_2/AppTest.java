package fr.uvsq.pglp4_2;

import org.junit.Test;
import static org.junit.Assert.*;
import fr.uvsq.pglp4_2.operation.*;
import fr.uvsq.pglp4_2.commandes.*;
import java.util.Stack;

import fr.uvsq.pglp4_2.commandes.Commandes;
import fr.uvsq.pglp4_2.commandes.Undo;
import fr.uvsq.pglp4_2.commandes.Quit;

import fr.uvsq.pglp4_2.operation.Addition;
import fr.uvsq.pglp4_2.operation.Soustraction;
import fr.uvsq.pglp4_2.operation.Multiplication;
import fr.uvsq.pglp4_2.operation.Division;
import fr.uvsq.pglp4_2.operation.Operations;


/**
 * Unit test for simple App.
 */
public class AppTest 
  
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
 
	@Test
	public void TestUdo() {
		Stack <Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		pile.push(1.0);
		u.actualisationPile();
		u.exeCommande();
		assertTrue(pile.size() == 0);
	}

	@Test
	public void TestAddition() 
	{
		Addition a = new Addition();
		assertTrue(a.exeOperation(1.0,1.0) == 2.0);
	}

	@Test
	public void Testoustraction() 
	{
		Soustraction a = new Soustraction();
		assertTrue(a.exeOperation(2.0,1.0) == 1.0);
	}

	@Test
	public void TestMultiplicartion() 
	{
		Multiplication a = new Multiplication();
		assertTrue(a.exeOperation(2.0,1.0) == 2.0);
	}

	@Test(expected=Exception.class)
	public void TestDivision() throws Exception
	{
		Division a = new Division();
		assertTrue(a.exeOperation(4.0,2.0) == 2.0);
	}




}