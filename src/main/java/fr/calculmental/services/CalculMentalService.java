package fr.calculmental.services;

import java.util.List;

import fr.calculmental.entities.Calcul;
import fr.calculmental.entities.Utilisateur;

public interface CalculMentalService 
{
	public Utilisateur getUtilisateur(Utilisateur utilisateur);
	
	public Calcul genererCalcul();
	
	public boolean verifierCalcul(Calcul calcul, int reponse);
	
	public void bonneReponse(Utilisateur utilisateur);
	
	public void nouveauMeilleurScore(Utilisateur utilisateur);
	
	public List<Utilisateur> getMeilleursUtilisateurs();
}
