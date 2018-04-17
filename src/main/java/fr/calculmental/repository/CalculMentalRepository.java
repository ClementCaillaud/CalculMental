package fr.calculmental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.calculmental.entities.Utilisateur;

public interface CalculMentalRepository extends JpaRepository<Utilisateur, Integer>
{
	public List<Utilisateur> findByPseudo(String pseudo);
}
