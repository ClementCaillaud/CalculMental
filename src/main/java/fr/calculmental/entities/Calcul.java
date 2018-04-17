package fr.calculmental.entities;

public class Calcul 
{
	private String expression;
	private int resultat;
	
	public Calcul(String expression, int resultat) 
	{
		super();
		this.expression = expression;
		this.resultat = resultat;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	@Override
	public String toString() {
		return "Calcul [expression=" + expression + ", resultat=" + resultat + "]";
	}
	
}
