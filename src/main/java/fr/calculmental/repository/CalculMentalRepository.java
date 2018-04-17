package fr.calculmental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.calculmental.entities.Utilisateur;

/**
 * La couche d'accès aux données de l'application CalculMental
 * @author Clément
 */
public interface CalculMentalRepository extends JpaRepository<Utilisateur, Integer>
{
	/**
	 * Trouve un utilisateur en fonction de son pseudo
	 * @param pseudo Le pseudo de l'utilisateur
	 * @return La liste des utilisateurs ayant ce pseudo (un seul ou aucun normalement)
	 */
	public List<Utilisateur> findByPseudo(String pseudo);
	
	/**
	 * Récupère les 5 meilleurs scores
	 * @return La liste des 5 meilleurs utilisateurs, classés du premier au cinquième
	 */
	public List<Utilisateur> findTop5ByOrderByMeilleurScoreDesc();
}
