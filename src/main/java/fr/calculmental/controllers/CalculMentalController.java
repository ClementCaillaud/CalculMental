package fr.calculmental.controllers;

import java.util.Scanner; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import fr.calculmental.entities.Utilisateur;
import fr.calculmental.services.CalculMentalService;
import fr.calculmental.entities.Calcul;

@Component
/**
 * Couche présentation de l'application
 * @author Tom
 */
public class CalculMentalController implements CommandLineRunner
{
	@Autowired
	CalculMentalService service;

	@Override
	public void run(String ... args) throws Exception 
	{
		//Ajout de faux utilisateurs dans la bdd
		addFakeUsers();
		
		//Variables
		Scanner sc = new Scanner(System.in);//Scanner pour les entrées utilisateur
		String reponseString = "";//Saisies sous forme de string
		String pseudo = "Nouveau joueur";//Pseudo du joueur
		Calcul calcul = null;//Calcul à résoudre
		float reponseCalcul = 0;//Réponse au calcul
		List<Utilisateur> meilleursScores = null;//Liste des meilleurs joueurs
		boolean rejouer = false;//Rejouer ou arrêter là
		boolean saisieOk = true;//Indique si la saisie du nombre est ok
		
		System.out.println("Bienvenue dans CalculMental");
		
		//Création utilisateur
		do
		{
			System.out.println("Veuillez saisir un pseudo :");
			reponseString = sc.nextLine();
		}
		while(reponseString.trim().length() == 0);//On vérifie que le pseudo n'est pas composé que d'espaces
		
		pseudo = reponseString;
		Utilisateur utilisateur = service.getUtilisateur(pseudo);
		
		System.out.println("Bonjour " + pseudo);
		System.out.println("Vous ne pouvez repondre aux calculs qu'avec des nombres");
		System.out.println("Le separateur decimal est la virgule ,");
		System.out.println();
		
		//Boucle principale
		do 
		{
			//10 calculs
			for (int i=0; i<10; i++) 
			{	
				//Génération calcul
				calcul = service.genererCalcul();
				System.out.println("Calcul "+(i+1)+" : "+calcul.getExpression());
				//Saisie réponse
				do
				{
					//On s'assure que l'entrée est au bon format (xxxx,xx) avec x un chiffre
					try
					{
						reponseCalcul = sc.nextFloat();
						saisieOk  = true;
					}
					catch(Exception e)
					{
						System.out.println("Vous ne pouvez entrer que des nombres, le séparateur décimal est une virgule");
						saisieOk = false;
						sc.nextLine();
					}
				}
				while(!saisieOk);
				
				//Vérification réponse
				if(service.verifierCalcul(calcul, reponseCalcul))
				{
					service.bonneReponse(utilisateur);
					System.out.println("Bonne réponse !");
				}
				else 
				{
					System.out.println("Dommage ... La bonne reponse etait " + calcul.getResultat());
				}
				System.out.println("-----------------------------");
			}
			
			//Comparaison avec le meilleur score
			if (utilisateur.getScore() >= utilisateur.getMeilleurScore())
			{
				service.nouveauMeilleurScore(utilisateur);
				System.out.println("Felicitations ! Vous avez battu ou egaliser votre meilleur score avec "+utilisateur.getScore()+" pts");
			}
			else 
			{
				System.out.println("Votre score est de "+utilisateur.getScore()+" pts, votre record est toujours de "+utilisateur.getMeilleurScore()+" pts");
			}
				
			//Affichage du tableau des scores
			meilleursScores = service.getMeilleursUtilisateurs();
			Utilisateur u = null;
			
			System.out.println("--------------------");
			System.out.println("|TABLEAU DES SCORES|");
			System.out.println("--------------------");
			System.out.println("N°| Pseudo -> Score");
			
			for (int i=0; i<meilleursScores.size();i++)
			{
				u = meilleursScores.get(i);
				System.out.println((i+1)+" |" + u.getPseudo() + " -> " + u.getMeilleurScore());
			}
			System.out.println();
			sc.nextLine();
			
			//Rejouer ?
			do
			{
				System.out.println("Rejouer ? O/N");
				reponseString = sc.nextLine().toUpperCase();
			}
			while(!reponseString.equals("O") && !reponseString.equals("N"));
			
			if(reponseString.equals("O"))
			{
				rejouer = true;
			}
			else
			{
				rejouer = false;
			}
		}
		while(rejouer);
		
		System.out.println("La partie est terminee... A bientot !");
	}
	
	private void addFakeUsers()
	{
		Utilisateur u1 = new Utilisateur("Clem");
		u1.setScore(999);
		service.nouveauMeilleurScore(u1);
		
		Utilisateur u2 = new Utilisateur("Tom");
		u2.setScore(7);
		service.nouveauMeilleurScore(u2);
	}
	
}

