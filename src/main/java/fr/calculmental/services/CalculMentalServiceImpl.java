package fr.calculmental.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.calculmental.entities.Calcul;
import fr.calculmental.entities.Utilisateur;
import fr.calculmental.repository.CalculMentalRepository;

@Service
public class CalculMentalServiceImpl implements CalculMentalService {

	@Autowired
	CalculMentalRepository dao;
	
	@Override
	public Utilisateur getUtilisateur(String pseudo) 
	{
		Utilisateur u = null;
		List<Utilisateur> listeUtilisateur = dao.findByPseudo(pseudo);
		
		//Si l'utilisateur n'est pas déjà en BDD, on le créé
		if(listeUtilisateur.isEmpty())
		{
			u = new Utilisateur(pseudo);
		}
		//S'il est déjà présent on le récupère
		else
		{
			u = listeUtilisateur.get(0);
		}
		
		u.setScore(0);
		
		return u;
	}

	@Override
	public Calcul genererCalcul() 
	{
		StringBuffer expression = new StringBuffer();
		float resultat = 0;
		int nbMaxOperations = 4;
		int nb1 = 0;
		int nb2 = 0;
		String ope = "";
		int nbOperations = genererEntierAleatoire(1, nbMaxOperations);
		
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

	@Override
	public boolean verifierCalcul(Calcul calcul, float reponse)
	{
		if(calcul.getResultat() == reponse)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	@Override
	public void bonneReponse(Utilisateur utilisateur) 
	{
		int pointsParBonneReponse = 1;
		utilisateur.setScore(utilisateur.getScore()+pointsParBonneReponse);
	}

	@Override
	public void nouveauMeilleurScore(Utilisateur utilisateur) 
	{
		dao.save(utilisateur);
	}

	@Override
	public List<Utilisateur> getMeilleursUtilisateurs() 
	{
		List<Utilisateur> meilleursScores = dao.findTop5ByOrderByMeilleurScoreDesc();
		return meilleursScores;
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
	
	/*private float calcul(int[] nombres, String[] operateurs)
	{
		List<Integer> nouveauxNombres;
		float resultat = 0;
		
		for(int i=0; i<operateurs.length; i++)
		{
			if(operateurs[i].equals("*"))
			{
				nouveauxNombres.add(nombres[])
			}
		}
		
		return resultat;
	}*/
}
