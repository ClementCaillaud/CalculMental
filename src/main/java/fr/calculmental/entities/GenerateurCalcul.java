package fr.calculmental.entities;

import java.util.Random;

/**
 * Permet de générer un calcul aléatoire
 * @author Clément
 */
public class GenerateurCalcul 
{
	public GenerateurCalcul()
	{
		
	}
	
	/**
	 * Génère un calcul aléatoire
	 * @param nbMaxOperations Nombre maximum d'opérations dans le calcul
	 * @return Un calcul aléatoire
	 */
	public Calcul genererCalcul(int nbMaxOperations)
	{
		StringBuffer expression = new StringBuffer();//Expression du calcul
		float resultat = 0;//Le résultat
		int nb1 = 0;//Le premier nombre de l'expression
		int nb2 = 0;//Les autres nombres de l'expression
		String ope = "";//L'opérateur
		int nbOperations = genererEntierAleatoire(1, nbMaxOperations);//Le nombre d'opérations de l'expression
		
		//Ajout des parenthèses au début de l'expression
		for(int i=0; i<nbOperations; i++)
		{
			expression.append("(");
		}
		
		//Génération du premier nombre
		nb1 = genererEntierAleatoire(0, 99);
		expression.append(nb1);
		resultat = nb1;
		
		//Génération des opérations
		for(int i=0; i < nbOperations; i++)
		{
			//Opérateur
			ope = genererOperateurAleatoire();
			expression.append(ope);
			//Nombre
			nb2 = genererEntierAleatoire(0, 99);
			expression.append(nb2+")");
			//Calcul du sous-résultat
			resultat = calcul(resultat, nb2, ope);
		}
		
		return new Calcul(expression.toString(), resultat);
	}
	
	/**
	 * Génère un entier aléatoire compris entre deux nombre
	 * @param valeurMin Valeur minimum
	 * @param valeurMax Valeur maximum
	 * @return Un entier aléatoire
	 */
	private int genererEntierAleatoire(int valeurMin, int valeurMax)
	{
		Random rand = new Random();
		int nb = rand.nextInt(valeurMax - valeurMin + 1) + valeurMin;
		return nb;
	}
	
	/**
	 * Génère un opérateur aléatoire
	 * @return Un opérateur aléatoire
	 */
	private String genererOperateurAleatoire()
	{
		Random rand = new Random();
		String operateur = null;
		int idOperateur = rand.nextInt(4);
		
		switch(idOperateur)
		{
		case 0:	
			operateur = "+";
			break;
		case 1:
			operateur = "-";
			break;
		case 2:
			operateur = "*";
			break;
		case 3:
			operateur = "/";
			break;
		}
 
		return operateur;
	}
	
	/**
	 * Calcul le résultat intermédiaire
	 * @param nb1 Premier nombre
	 * @param nb2 Second nombre
	 * @param operation Opérateur
	 * @return Le résultat
	 */
	private float calcul(float nb1, float nb2, String operation)
	{
		float resultat = 0;
		
		switch(operation)
		{
		case "+":
			resultat = nb1 + nb2;
			break;
		case "-":
			resultat = nb1 - nb2;
			break;
		case "*":
			resultat = nb1 * nb2;
			break;
		case "/":
			resultat = nb1 / nb2;
			break;
		}
		resultat = (float)Math.round(resultat * 100)/100;
		
		return resultat;
	}
}
