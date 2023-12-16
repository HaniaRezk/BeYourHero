package univers;


import java.util.InputMismatchException;
import java.util.Scanner;

import duel.Scan;
/**
 * The Player interface represents a generic player in the context of a sports game or trivia.
 * It provides methods for playing trivia games in different sports.
 */
public interface Player {
	  /**
     * Plays a basketball trivia game.
     *
     * @return The score achieved in the trivia game.
     */
	default int BasketballTrivia() {
		try {
		ArrayListString answers=new ArrayListString();
		Scanner scanner =Scan.getScanner();
			 System.out.println("A chaque fois rentrez la lettre de la bonne reponse");
			 
			 System.out.println(" En quelle année le basketball a-t-il été inventé ?");
		        System.out.println("a) 1891");
		        System.out.println("b) 1900");
		        System.out.println("c) 1923");
		        
	
		        String userGuess = scanner.nextLine();
		        answers.add(userGuess);
		        
		        System.out.println("Quelle équipe de la NBA a remporté le plus de championnats?");
		        System.out.println("a) Los Angeles Lakers");
		        System.out.println("b) Boston Celtics");
		        System.out.println("c) Chicago Bulls");
		        
		        String userGuess1 = scanner.nextLine();
		        answers.add(userGuess1);
		        
		        
		        System.out.println("Combien de joueurs sont sur le terrain pour chaque équipe au début d'un match de basketball?");
		        System.out.println("a) 5");
		        System.out.println("b) 6");
		        System.out.println("c) 7");
		        
		        String userGuess2 = scanner.nextLine();
		        answers.add(userGuess2);
		        
		        System.out.println("Qui détient le record du plus grand nombre de points marqués dans un seul match NBA?");
		        System.out.println("a)  Michael Jordan");
		        System.out.println("b) Kobe Bryant");
		        System.out.println("c)Wilt Chamberlain");
		        
		        String userGuess3 = scanner.nextLine();
		        answers.add(userGuess3);
		
		        
		        ArrayListString CorrectAnswers=new ArrayListString();
		        CorrectAnswers.add("a");
		        CorrectAnswers.add("b");
		        CorrectAnswers.add("a");
		        CorrectAnswers.add("c");
		       

		        int correctCount = 0;
		        if (CorrectAnswers.get(0).equalsIgnoreCase(answers.get(0).trim())) {
		            correctCount++;
		        }

		        if (CorrectAnswers.get(1).equalsIgnoreCase(answers.get(1).trim())) {
		            correctCount++;
		        }

		        if (CorrectAnswers.get(2).equalsIgnoreCase(answers.get(2).trim())) {
		            correctCount++;}
		        if (CorrectAnswers.get(3).equalsIgnoreCase(answers.get(3).trim())) {
		            correctCount++;}
		        
		        
		        System.out.println("Votre score est:"+ correctCount);
		        System.out.println("Les bonnes reponses sont");
		        CorrectAnswers.display();
		    
		        return correctCount;
		}catch(InputMismatchException e) {
			 System.out.println("Erreur de saisie. Vous Sortez du jeu.");
		     return 0;
			
		}
	 
		
	};
	  /**
     * Plays a Football trivia game.
     *
     * @return The score achieved in the trivia game.
     */
    default int FootballTrivia() {
    	try {
    	ArrayListString answers=new ArrayListString();
		  Scanner scanner =Scan.getScanner();
			 System.out.println("A chaque fois rentrez la lettre de la bonne reponse");
			 System.out.println("En quelle année la première Coupe du Monde de football a-t-elle eu lieu?");
		        System.out.println("a) 1928");
		        System.out.println("b) 1934");
		        System.out.println("c) 1950");
		       
		        String userGuess = scanner.nextLine();
		        answers.add(userGuess);
		        
		        System.out.println("Qui détient le record du plus grand nombre de buts marqués en une seule saison de la Ligue des champions de l'UEFA?");
		        System.out.println("a) Lionel Messi");
		        System.out.println("b) Cristiano Ronaldo");
		        System.out.println("c) Robert Lewandowski");
		        String userGuess1 = scanner.nextLine();
		        answers.add(userGuess1);
		        
		        
		        System.out.println("Quelle équipe nationale a remporté le plus grand nombre de Coupes du Monde de la FIFA?");
		        System.out.println("a) Brésil");
		        System.out.println("b) Allemagne");
		        System.out.println("c)  Italie");
		        String userGuess2 = scanner.nextLine();
		        answers.add(userGuess2);
		        
		        System.out.println("Combien de joueurs sont sur le terrain pour chaque équipe au début d'un match?");
		        System.out.println("a) 11");
		        System.out.println("b) 14");
		        System.out.println("c) 6");
		        String userGuess3 = scanner.nextLine();
		        answers.add(userGuess3);
		        
		        ArrayListString CorrectAnswers=new ArrayListString();
		        CorrectAnswers.add("b");
		        CorrectAnswers.add("b");
		        CorrectAnswers.add("a");
		        CorrectAnswers.add("a");
		        

		        int correctCount = 0;
		        if (CorrectAnswers.get(0).equalsIgnoreCase(answers.get(0).trim())) {
		            correctCount++;
		        }

		        if (CorrectAnswers.get(1).equalsIgnoreCase(answers.get(1).trim())) {
		            correctCount++;
		        }

		        if (CorrectAnswers.get(2).equalsIgnoreCase(answers.get(2).trim())) {
		            correctCount++;}
		        if (CorrectAnswers.get(3).equalsIgnoreCase(answers.get(3).trim())) {
		            correctCount++;}
		        
		        
		        System.out.println("Votre score est:"+ correctCount);
		        System.out.println("Les bonnes reponses sont");
		        CorrectAnswers.display();
		        return correctCount;
    	}catch(InputMismatchException e) {
			 System.out.println("Erreur de saisie. Vous Sortez du jeu.");
		     return 0;
			
		}
    	
    };
    /**
     * Plays a tennis trivia game.
     *
     * @return The score achieved in the trivia game.
     */
    default int TennisTrivia() {
    	try {
    	ArrayListString answers=new ArrayListString();
		  Scanner scanner =Scan.getScanner();
			 System.out.println("A chaque fois rentrez la lettre de la bonne reponse");
			 System.out.println(" En quelle année le tennis a-t-il été inclus pour la première fois aux Jeux olympiques modernes?");
		        System.out.println("a) 1896");
		        System.out.println("b) 1900");
		        System.out.println("c) 1924");
		      
		        String userGuess = scanner.nextLine();
		        answers.add(userGuess);
		        
		        System.out.println(" Qui détient le record du plus grand nombre de victoires en simple en Grand Chelem chez les hommes?");
		        System.out.println("a) Roger Federer");
		        System.out.println("b) Rafael Nadal");
		        System.out.println("c) Novak Djokovic");
		        String userGuess1 = scanner.nextLine();
		        answers.add(userGuess1);
		        
		        
		        System.out.println(" Quelle surface de court est utilisée à Roland-Garros lors du tournoi de tennis français?");
		        System.out.println("a) Gazon");
		        System.out.println("b) Terre battue");
		        System.out.println("c) Dur");
		        String userGuess2 = scanner.nextLine();
		        answers.add(userGuess2);
		        
		       
		        ArrayListString CorrectAnswers=new ArrayListString();
		        CorrectAnswers.add("b");
		        CorrectAnswers.add("c");
		        CorrectAnswers.add("b");
		     

		        int correctCount = 0;
		        if (CorrectAnswers.get(0).equalsIgnoreCase(answers.get(0).trim())) {
		            correctCount++;
		        }

		        if (CorrectAnswers.get(1).equalsIgnoreCase(answers.get(1).trim())) {
		            correctCount++;
		        }

		        if (CorrectAnswers.get(2).equalsIgnoreCase(answers.get(2).trim())) {
		            correctCount++;}
		        
		        
		        System.out.println("Votre score est:"+ correctCount);
		        System.out.println("Les bonnes reponses sont");
		        CorrectAnswers.display();
		        return correctCount;
    	}catch(InputMismatchException e) {
			 System.out.println("Erreur de saisie. Vous Sortez du jeu.");
		     return 0;
			
		}
    	
    };
    
    /**
     * Plays a Swimmming trivia game.
     *
     * @return The score achieved in the trivia game.
     */
   default int SwimmingTrivia() {
	   try {
	   ArrayListString answers=new ArrayListString();
	  Scanner scanner =Scan.getScanner();
		
		 System.out.println("A chaque fois rentrez la lettre de la bonne reponse");
		 System.out.println(" Qui détient le record du monde du 100 mètres nage libre masculin?");
	        System.out.println("a) Michael Phelps");
	        System.out.println("b) Cesar Cielo");
	        System.out.println("c) Usain Bolt");
	        
	        String userGuess = scanner.nextLine();
	        answers.add(userGuess);
	        
	        System.out.println(" Quelle épreuve de natation comporte quatre styles différents dans une seule course?");
	        System.out.println("a) 100 mètres nage libre");
	        System.out.println("b) 200 mètres 4 nages");
	        System.out.println("c) 50 mètres dos");
	        String userGuess1 = scanner.nextLine();
	        answers.add(userGuess1);
	        
	        
	        System.out.println("Quels sont les 4 types de nages?");
	        System.out.println("a) Brasse, Dos, Papillon, Crawl");
	        System.out.println("b) Licorne, Dos, Papillon, Crawl");
	        System.out.println("c) Licorne, Dos, Papillon, Pingouin ");
	        String userGuess2 = scanner.nextLine();
	        answers.add(userGuess2);
	        
	        ArrayListString CorrectAnswers=new ArrayListString();
	        CorrectAnswers.add("b");
	        CorrectAnswers.add("b");
	        CorrectAnswers.add("a");
	

	        int correctCount = 0;
	        if (CorrectAnswers.get(0).equalsIgnoreCase(answers.get(0).trim())) {
	            correctCount++;
	        }

	        if (CorrectAnswers.get(1).equalsIgnoreCase(answers.get(1).trim())) {
	            correctCount++;
	        }

	        if (CorrectAnswers.get(2).equalsIgnoreCase(answers.get(2).trim())) {
	            correctCount++;}
	        
	        
	        System.out.println("Votre score est:"+ correctCount);
	        System.out.println("Les bonnes reponses sont");
	        CorrectAnswers.display();
	        
	        return correctCount;
	   }catch(InputMismatchException e) {
			 System.out.println("Erreur de saisie. Vous Sortez du jeu.");
		     return 0;
			
		}
   
   }
   /**
    * Plays a trivia game based on the specified sport.
    *
    * @param sport The sport for which the trivia game is played.
    * @return The score achieved in the trivia game.
    */
	default int play(Sport sport) {
		 try {
		 switch (sport) {
	        case TENNIS:
	            System.out.println("Bienvenue au Trivia de Tennis!");
	            return TennisTrivia();
	        case BASKETBALL:
	            System.out.println("Bienvenue au Trivia de Basketball!");
	            return BasketballTrivia();
	        case FOOTBALL:
	            System.out.println("Bienvenue au Trivia de Foot!");
	            return FootballTrivia();
	        case SWIMMING:
	            System.out.println("Bienvenue au Trivia de Natation!");
	            return SwimmingTrivia();
	        default:
	            System.out.println("Choix de sport invalide");
	            return 0; 
		 }
		 }
		 catch(InputMismatchException e){
			 System.out.println("Choix de sport invalide");
		      return 0;
			 
			 
		 }
		
		
	}
	
	/**
     * Invites the player to play a trivia game at the end of the main game.
     *
     * @param sport The sport for which the trivia game is played.
     * @return The score achieved in the trivia game, or 0 if the player chooses not to play.
     */
	default int EndOfGameTrivia(Sport sport) {
		 Scanner scanner =Scan.getScanner();
		 System.out.println("Est ce que vous voulez jouer une partie de trivia avant de finir le jeu?: 0 pour oui et 1 pour non");
		 try {
		        int rep = scanner.nextInt();
		        scanner.nextLine();
		        if (rep == 0) {
		            return play(sport);
		        } else {
		            return 0;
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Erreur de saisie. Vous Sortez du jeu.");
		        return 0;
		    }
		
	}


}
