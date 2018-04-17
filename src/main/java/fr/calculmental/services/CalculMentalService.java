package fr.calculmental.services;

import java.util.List;

import fr.calculmental.entities.Calcul;
import fr.calculmental.entities.Utilisateur;

/**
 * La couche métier de l'application de calcul mental
 * @author Clément
 */
public interface CalculMentalService 
{
	/**
	 * Récupère les infos d'un utilisateur dans la BDD s'il existe
	 * Sinon création d'un nouvel utilisateur
	 * @param pseudo Le pseudo du joueur
	 * @return L'utilisateur
	 */
	public Utilisateur getUtilisateur(String pseudo);
	
	/**
	 * Génère un calcul aléatoire
	 * @return Un calcul
	 */
	public Calcul genererCalcul();
	
	/**
	 * Vérifier la réponse de l'utilisateur
	 * @param calcul Le calcul à résoudre
	 * @param reponse La réponse de l'utilisateur
	 * @return Correct ou Incorrect
	 */
	public boolean verifierCalcul(Calcul calcul, float reponse);
	
	/**
	 * Incrémente le score de l'utilisateur
	 * @param utilisateur Le joueur
	 */
	public void bonneReponse(Utilisateur utilisateur);
	
	/**
	 * Sauvegarde le score actuel du joueur s'il a battu son meilleur score
	 * @param utilisateur
	 */
	public void nouveauMeilleurScore(Utilisateur utilisateur);
	
	/**
	 * Récupère la liste des meilleurs scores
	 * @return La liste des meilleurs joueurs
	 */
	public List<Utilisateur> getMeilleursUtilisateurs();
}
