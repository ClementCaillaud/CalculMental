package fr.calculmental.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String pseudo;
	private Integer meilleurScore;
	private Integer score;
	
	protected Utilisateur(){
		
	}
	
	public Utilisateur(String pseudo) {
		super();
		this.pseudo = pseudo;
		this.meilleurScore = 0;
		this.score = 0;
	}

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

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", meilleurScore=" + meilleurScore + ", score=" + score
				+ "]";
	}
	
	
}
