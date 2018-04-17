package fr.calculmental.services;

import java.util.List;

import fr.calculmental.entities.Calcul;
import fr.calculmental.entities.Utilisateur;

public class CalculMentalServiceImpl implements CalculMentalService {

	@Override
	public Utilisateur getUtilisateur(String pseudo) 
	{
		return null;
	}

	@Override
	public Calcul genererCalcul() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifierCalcul(Calcul calcul, int reponse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void bonneReponse(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nouveauMeilleurScore(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> getMeilleursUtilisateurs() {
		// TODO Auto-generated method stub
		return null;
	}

}
