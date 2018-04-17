package fr.calculmental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.calculmental.entities.Calcul;
import fr.calculmental.entities.GenerateurCalcul;
import fr.calculmental.entities.Utilisateur;
import fr.calculmental.repository.CalculMentalRepository;

@Service
/**
 * Implémentation de la couche métier de CalculMental
 * @author Clément
 */
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
		GenerateurCalcul generateur = new GenerateurCalcul();
		int nbMaxOperations = 4;
		
		return generateur.genererCalcul(nbMaxOperations);	
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
		utilisateur.setMeilleurScore(utilisateur.getScore());
		dao.save(utilisateur);
	}

	@Override
	public List<Utilisateur> getMeilleursUtilisateurs() 
	{
		List<Utilisateur> meilleursScores = dao.findTop5ByOrderByMeilleurScoreDesc();
		return meilleursScores;
	}
}
