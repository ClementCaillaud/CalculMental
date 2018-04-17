package fr.calculmental.entities;

/**
 * Une représentation du calcul, composée d'une expression et d'un résultat
 * @author Clément
 */
public class Calcul 
{
	private String expression;//L'expression du calcul
	private float resultat;//Le résultat du calcul
	
	public Calcul(String expression, float resultat) 
	{
		super();
		this.expression = expression;
		this.resultat = resultat;
	}

	/*GET et SET*/
	
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

	/*toString*/
	
	@Override
	public String toString() {
		return "Calcul [expression=" + expression + ", resultat=" + resultat + "]";
	}
	
}
