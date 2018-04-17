package fr.calculmental.entities;

public class Calcul 
{
	private String expression;
	private float resultat;
	
	public Calcul(String expression, float resultat) 
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

	public float getResultat() {
		return resultat;
	}

	public void setResultat(float resultat) {
		this.resultat = resultat;
	}

	@Override
	public String toString() {
		return "Calcul [expression=" + expression + ", resultat=" + resultat + "]";
	}
	
}
