package fr.calculmental.controllers;

import java.util.Scanner; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import fr.calculmental.entities.Utilisateur;
import fr.calculmental.services.CalculMentalService;
import fr.calculmental.services.CalculMentalServiceImpl;
import fr.calculmental.entities.Calcul;

@Component
public class CalculMentalController implements CommandLineRunner{

	
	@Autowired
	CalculMentalService service;
	
	

	@Override
	public void run(String ... args) throws Exception {
		
			
			System.out.println("Bienvenue dans CalculMental");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un pseudo :");
			String pseudo  = sc.nextLine();
			System.out.println("Bonjour : " + pseudo);
			Utilisateur u1 = service.getUtilisateur(pseudo);
			
			
			for (int i=0; i<3; i++) {
				
				Calcul c = service.genererCalcul();
				System.out.println(c.getExpression());
				float reponse = sc.nextFloat();
				if(service.verifierCalcul(c, reponse))
				{
					service.bonneReponse(u1);
					System.out.println("Bien joue");
				}
				else 
				{
					System.out.println("Dommage la bonne réponse etait " + c.getResultat());
				}
				
			}
			
			System.out.println(u1);
			if (u1.getScore()>=u1.getMeilleurScore())
			{
				service.nouveauMeilleurScore(u1);
				System.out.println("Nouveau meilleur score");
			}
			else 
				System.out.println("Dommage");
			
			
			List<Utilisateur> meilleurscores = service.getMeilleursUtilisateurs();
			
			for (int i=0; i<meilleurscores.size();i++)
			{
				Utilisateur u =meilleurscores.get(i);
				System.out.println((i+1)+" -> " + u.getPseudo() + " score " + u.getMeilleurScore());
				
			}
	}
	
}

