package fr.calculmental.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
/**
 * Un utilisateur composé d'un pseudo, de ses scores et d'un id pour l'enregistrement en bdd
 * @author Clément
 */
public class Utilisateur 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//ID pour la base de donnée
	private String pseudo;//Nom de l'utilisateur
	private Integer meilleurScore;//Meilleur score enregistré
	private Integer score;//Score de la partie actuelle
	
	protected Utilisateur(){
		
	}
	
	public Utilisateur(String pseudo) {
		super();
		this.pseudo = pseudo;
		this.meilleurScore = 0;
		this.score = 0;
	}

	/*GET et SET*/
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getMeilleurScore() {
		return meilleurScore;
	}

	public void setMeilleurScore(Integer meilleurScore) {
		this.meilleurScore = meilleurScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	/*toString*/
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", meilleurScore=" + meilleurScore + ", score=" + score
				+ "]";
	}
	
	
}
