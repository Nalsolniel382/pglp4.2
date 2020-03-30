package fr.uvsq.pglp4_2.operation;

public class Division implements Operations{
	public double exeOperation(final double operande1, final double operande2) throws Exception {
		
	

		if(operande2 == 0)
		{
			System.err.println("Il ets impossible de diviser par 0");
			throw  new Exception();
		}
		return operande1 / operande2;
	}
}
