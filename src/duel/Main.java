package duel;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

import univers.PersonnageDeBase;
import univers.Sport;
import representation.Event;
import representation.ImageNode;
import representation.InnerNode;
import representation.Node;
import representation.TerminalNode;

import univers.Coach;
import univers.Sportif;
import univers.Juge;
import univers.Supporteur;
import univers.Map1;

public class Main {
	private static int id=0;
	private static List<String> savedGameFiles =  loadSavedGameFiles();
	
	 
   private static List<Node> EmptyNodeList= new ArrayList<>(); // to initialize all the inner nodes.
   private static Event basicEvent1= new InnerNode(00,0,"",EmptyNodeList);
	 //we will first create an acyclic non oriented graph of the possible story line for the "sportif"
   static int depthsportif=0;
   InnerNode startingSportif=new InnerNode(id++,depthsportif++,"C'est le soir de la competition ",EmptyNodeList);
  
   //here the id in the graphs of possibilities will represent the depth of the nodes in the graph
   //level 1 nodes
   private static InnerNode Snode1= new InnerNode(id++,depthsportif,"Partir faire la fete", EmptyNodeList);
   private static InnerNode Snode2= new InnerNode(id++,depthsportif++,"Partir et s'entrainer", EmptyNodeList);

   //level 2 nodes
   // first branch of the story where the player goes to train
   private static InnerNode Snode21= new InnerNode(id++,depthsportif,"Manger une salade comme son diner", EmptyNodeList);
   private static InnerNode Snode22= new InnerNode(id++,depthsportif,"Manger un burger comme son diner", EmptyNodeList);
  
   //second branch of the story where the player goes to party 
   private static InnerNode Snode11= new InnerNode(id++,depthsportif,"Vous decidez de prendre un uber pour rentrer chez vous", EmptyNodeList);
   private static InnerNode Snode12= new InnerNode(id++,depthsportif++,"Vous decidez de rester dans la fete", EmptyNodeList);
   
   //level 3
   //branch of the story where the player goes to party
   private static TerminalNode Snode6= new TerminalNode(id++,depthsportif,"Hop! vous etes trop fatigue et vous ratez la competition");

   private static TerminalNode Snode7= new TerminalNode(id++,depthsportif,"Vous partez a la competition: C'est a vous de jouer");

   //branch of the story where the player goes to train
   private static  TerminalNode Snode3= new TerminalNode(id++,depthsportif,"Hop! vous etes malade le jour de la competition");
   
   private static InnerNode Snode4= new InnerNode(id++,depthsportif++,"Vous mettez un reveil la soiree de la competition", EmptyNodeList);

   //level 4
   //branch of the story where the player goes to train
   private static  TerminalNode Snode41= new TerminalNode(id++,depthsportif,"Vous partez a la competition: C'est a vous de jouer!");

   private static  InnerNode Snode5= new InnerNode(id++,depthsportif,"Vous oubliez de mettre votre reveil", EmptyNodeList);
   private static TerminalNode Snode51= new TerminalNode(id++,depthsportif++,"Vous dormez et vous ratez la competition!");

   
   //we will create an acyclic non oriented graph of the possible story line for the "Supporteur"
   private static int depthSupporteur=0;
   //private static InnerNode startingSupporteur1=new InnerNode(id++,depthSupporteur++,"C'est le soir de la competition ",EmptyNodeList);

   //here the id in the graphs of possibilities will represent the depth of the nodes in the graph
   //level 1 nodes
   private static  InnerNode SSnode1= new InnerNode(id++,depthSupporteur,"Partir faire la fete", EmptyNodeList);
   private static  InnerNode SSnode2= new InnerNode(id++,depthSupporteur++,"Partir decouvrir les monuments de Paris", EmptyNodeList);

 
   //level 2 nodes
   // first branch of the story where the fan goes to discover Paris
   private static InnerNode SSnode21= new InnerNode(id++,depthSupporteur,"Visiter la tour eiffel", EmptyNodeList);
   private static  InnerNode SSnode22= new InnerNode(id++,depthSupporteur,"Visiter l'arc de triomphe", EmptyNodeList);

   
   //second branch of the story where the fan goes to party 
   private static InnerNode SSnode11= new InnerNode(id++,depthSupporteur,"Vous decidez de prendre les transports pour rentrer chez vous", EmptyNodeList);
   private static InnerNode SSnode12= new InnerNode(id++,depthSupporteur++,"Vous decidez de rester dans la fete", EmptyNodeList);

   //level 3
   //branch of the story where the fan goes to party
   private static TerminalNode SSnode121= new TerminalNode(id++,depthSupporteur,"Hop! vous etes trop fatigue et vous vous reveillez pas en temps pour la competition!");

   private static  InnerNode SSnode111= new InnerNode(id++,depthSupporteur,"Les transports ne sont pas en retard.", EmptyNodeList);

   private static  InnerNode SSnode112= new InnerNode(id++,depthSupporteur,"Les transports sont perturbes.", EmptyNodeList);

   //branch of the story where the fan goes to discover Paris
   private static  InnerNode SSnode4= new InnerNode(id++,depthSupporteur++,"Vous etes ebloui par sa beaute ", EmptyNodeList);
 
   //level 4
   //branch of the story where the fan goes to discover Paris
   private static  TerminalNode SSnode41= new TerminalNode(id++,depthSupporteur,"Vous partez a la competition et vous voyez votre sportif favori remporter le prix");

   //branch of the story where the fan goes to party
   private static TerminalNode SSnode1111= new TerminalNode(id++,depthSupporteur,"Vous partez a la competition et vous voyez votre sportif favori remporter le prix");

   private static TerminalNode SSnode1121= new TerminalNode(id++,depthSupporteur,"Vous ratez competition!");

   
   //we will create an acyclic non oriented graph of the possible story line for the "coach"
   private static int depthCoach=0;
  // private static  InnerNode startingCoach1=new InnerNode(id++,depthCoach++,"C'est le soir de la competition ",EmptyNodeList);
  
   //here the id in the graphs of possibilities will represent the depth of the nodes in the graph
   //level 1 nodes
   private static InnerNode Cnode1= new InnerNode(id++,depthCoach,"Preparer une seance de relaxation", EmptyNodeList);
   private static InnerNode Cnode2= new InnerNode(id++,depthCoach++,"Preparer une seance d'entrainement intensive", EmptyNodeList);

   
   //level 2 nodes
   // first branch of the story where the coach prepares an intensive training session.
   private static InnerNode Cnode21= new InnerNode(id++,depthCoach,"Faire une autre seance d'entrainement ", EmptyNodeList);
   private static InnerNode Cnode22= new InnerNode(id++,depthCoach,"Donner le reste de la soiree comme repos", EmptyNodeList);

   
   //second branch of the story where the coach organizes a relaxation session 
   private static  InnerNode Cnode11= new InnerNode(id++,depthCoach,"Vous decidez d'organiser une meditation en groupe", EmptyNodeList);
   private static  InnerNode Cnode12= new InnerNode(id++,depthCoach++,"Vous decidez d'embaucher un masseur sportif", EmptyNodeList);
  
   //level 3
   //branch of the story where the coach organizes a relaxation session 
   private static TerminalNode Cnode6= new TerminalNode(id++,depthCoach,"Hop! Vos joueurs sont trop tendus et ils ratent la competition!");

   private static InnerNode Cnode71= new InnerNode(id++,depthCoach,"Une bagarre eclate entre vos joueurs et ils se battent!", EmptyNodeList);
   private static  InnerNode Cnode72= new InnerNode(id++,depthCoach,"La seance se passe tres bien!", EmptyNodeList);
 
   //branch of the story where coach organizes another training session
   private static TerminalNode Cnode4= new TerminalNode(id++,depthCoach,"Vous epuisez vos joueurs et ils ratent la competition ");
  
  //branch of the story where coach gives a break after the first training session
   private static TerminalNode Cnode5= new TerminalNode(id++,depthCoach++,"Vos joueurs sont bien tendus mais aussi entraines et emportent la competition! ");

   //level 4
   //branch of the story where the coach organizes another a group meditation session
   private static  TerminalNode Cnode41= new TerminalNode(id++,depthCoach,"Vos joueurs partent a la competition blesses et perdent!");

   private static TerminalNode Cnode42= new TerminalNode(id++,depthCoach++,"Vos joueurs partent a la competition relaxes et gagnent!");

   
   
   
 //we will create an acyclic non oriented graph of the possible story line for the "Juge"
   private static int depthJuge=0;
   //private static InnerNode startingJuge1=new InnerNode(id++,depthJuge++,"C'est le soir de la competition ",EmptyNodeList);
  
   //here the id in the graphs of possibilities will represent the depth of the nodes in the graph
   //level 1 nodes
   private static InnerNode Jnode1= new InnerNode(id++,depthJuge,"Relire le reglement ", EmptyNodeList);
   private static InnerNode Jnode2= new InnerNode(id++,depthJuge++,"Preparer le dossier du verdict ", EmptyNodeList);

   //level 2 nodes
   // first branch of the story where the judge reads the verdict file
   private static InnerNode Jnode21= new InnerNode(id++,depthJuge,"Noter l'info", EmptyNodeList);
   private static InnerNode Jnode22= new InnerNode(id++,depthJuge,"Ignorer l'info", EmptyNodeList);
 
   //second branch of the story where the judge reads the rules
   private static  InnerNode Jnode11= new InnerNode(id++,depthJuge,"Vous trouvez une regle ambigue", EmptyNodeList);
   private static  InnerNode Jnode12= new InnerNode(id++,depthJuge++,"Vous memorisez le reglement!", EmptyNodeList);
   
   //level 3
   //branch of the story where the judge reads the rules and find the rule
   private static InnerNode Jnode6=new InnerNode(id++,depthJuge,"Vous consultez un collegue",EmptyNodeList);

   private static  InnerNode Jnode7=new InnerNode(id++,depthJuge,"Vous interpretez la regle a votre maniere",EmptyNodeList);

   //memorise the rules 
   private static TerminalNode Jnode8=new TerminalNode (id++,depthJuge,"Vous vous rappelez correctment de l'info et vous jugez bien la competition");
   
   private static TerminalNode  Jnode9=new TerminalNode(id++,depthJuge,"Vous melangez les informations et vous jugez mal la comptition");

   
   //branch of the story where  the judge reads the verdict file
   private static TerminalNode Jnode4= new TerminalNode(id++,depthJuge,"Vous utilisez l'info pour le verdict et vous notez bien les performances des sportifs! ");
   private static TerminalNode Jnode41= new TerminalNode(id++,depthJuge++,"L'info que vous ignorez vous fait mal juger les performances des sportifs et vous etes vires du reste des JO!");

   //level 4
   //branch of the story where the judge reads the rules
   private static  TerminalNode Jnode61= new TerminalNode(id++,depthJuge,"Vous obtenez une clarification et vous notez bien les performances des sportifs! ");

   private static TerminalNode Jnode62= new TerminalNode(id++,depthJuge,"Votre collegue vous donne la mauvaise info: vous juger mal les performances des sportifs et vous etes vires du reste des JO!");

   private static TerminalNode Jnode71= new TerminalNode(id++,depthJuge++,"Vous interpretez mal l'info: vous juger mal les performances des sportifs et vous etes vires du reste des JO!");
   

   private static List<String> loadSavedGameFiles() {
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savedGameFiles.dat"))) {
           return (List<String>) ois.readObject();
       } catch (IOException | ClassNotFoundException e) {
           System.out.println("Could not load saved game files. Starting with an empty list.");
           return new ArrayList<>();
       }
   }

   // Method to save the list of saved game filenames to a file
   private static void saveSavedGameFiles() {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savedGameFiles.dat"))) {
           oos.writeObject(savedGameFiles);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   // Method to add a filename to the list of saved games
   private static void addSavedGameFile(String filename) {
       savedGameFiles.add(filename);
       saveSavedGameFiles(); // Save the updated list to a file
   }

   public static void printAllGameSaves() {
	    System.out.println("Liste des parties sauvegardées (dernière sauvegarde en premier) :");
	    for (int i = savedGameFiles.size() - 1; i >= 0; i--) {
	        System.out.println("- " + savedGameFiles.get(i));
	    }
	}

   

	public static void main(String[] args) {
		Scanner scanner =Scan.getScanner();
		
		boolean quit = false;
        while (!quit) {
            System.out.println("Menu :");
            System.out.println("1. Nouvelle partie");
            System.out.println("2. Charger partie");
            System.out.println("3. Quitter");
            int choice=3;
            try {
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            }catch (InputMismatchException e) {
       	    	scanner.nextLine(); // Consume the invalid input 
       	    	System.out.println("Erreure de saisie: Vous quittez le jeu");
       	   }

            switch (choice) {
                case 1:
                    startNewGame(scanner);
               
                    break;
                case 2:
                	if (savedGameFiles.isEmpty()) {
                        System.out.println("Aucune partie sauvegardée.");
                        break;
                    } else {
      
                	printAllGameSaves();
                    loadSavedGame(scanner);
                    }
                    break;
                case 3:
                    //quit
                    quit = true;
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez choisir une option valide.");
            }
        }
        scanner.close();
        
    }
	 private static void startNewGame(Scanner scanner) {
        int id=0;
        int depth=0;
        List<Node> EmptyNodeList= new ArrayList<>(); // to initialize all the inner nodes.
        List<Node> GameList= new ArrayList<>();
        
        // Create a map of countries
        Map1 countries = new Map1();
        countries.add(1, "France");
        countries.add(2, "China");
        countries.add(3, "US");
        countries.add(4, "UK");
        countries.add(5, "Vietnam");
       
        Event basicEvent1= new InnerNode(id++,0,"",EmptyNodeList);
        InnerNode Storynode1 = new InnerNode(id++,depth++,"On est en juillet 2024 a Paris, et t'as la chance de participer a l'evenement sportif le plus important au monde. Vous allez choisir le personnage que vous souhaitez etre: un juge , un supporteur, un coach ou un sportif et le sport que vous desirez, vous allez ensuite avoir la possibilite de faire des choix et determiner l'issue de votre propre histoire",EmptyNodeList);
        Storynode1.display();
       
        
        String playerName = "Julie";
        try {
            System.out.print("Choisis le nom de ton personnage: ");
            playerName = scanner.nextLine();

        } catch ( NoSuchElementException | IllegalStateException exception) {
            System.out.println("Une erreur est survenue. Le nom du personnage est défini par défaut à 'Julie'");
            exception.printStackTrace();
        }
            
        
        
        //display all the sport choices for the player to choose
        System.out.println("Choisissez votre sport");
        Sport.displayAllSports();
        Sport chosenSport=Sport.TENNIS; //default value of sport
       try {
    	   int chosenSportIndex = scanner.nextInt();
    	   if (!(chosenSportIndex >= 1 && chosenSportIndex <= Sport.values().length)) {
    		   throw new InputException("Choix non valide!: Le Tennis est choisi par defaut");
               
    	   }
    
    	   chosenSport = Sport.values()[chosenSportIndex - 1];
    	   
       }catch (InputMismatchException e) {
   	    	scanner.nextLine(); // Consume the invalid input 
   	    	System.out.println("Erreure est survenue: Le Tennis est choisi par defaut");
   	   }catch( IllegalArgumentException| NoSuchElementException | IllegalStateException e) {
    	   System.out.println("Erreure est survenue: Le Tennis est choisi par defaut");
    	   e.printStackTrace();
    	  
       } 
       
       
        //give the player options and let him choose his character
        System.out.println("Choississez le Pays que vous voulez represente:");
        countries.display();
        try {
        	int choice = scanner.nextInt();
            if (countries.contains(choice)) {
                String chosenCountry = countries.get(choice);
                System.out.println("Vous avez choisi: " + chosenCountry);
            } else {
            	 throw new InputException("Choix Invalide: Vous representez la France ");
            }
         }catch (InputMismatchException e) {
           	    scanner.nextLine(); // Consume the invalid input 
           	    System.out.println("Erreure: Vous representez la France par defaut");}
          catch( IllegalArgumentException| NoSuchElementException | IllegalStateException e) {
     	   System.out.println("Erreure: Vous representez la France par defaut");
     	   e.printStackTrace();
     	
     	   
        }
      

        System.out.println("Choisis ton rôle :");
        System.out.println("1. Sportif");
        Event imageSportif= new ImageNode(basicEvent1,"sportif.jpeg");
        imageSportif.display();
        try {
            // Sleep for 2 seconds 
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("2. Coach");
        Event imageCoach= new ImageNode(basicEvent1,"coach.jpeg");
        imageCoach.display();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3. Juge");
        Event imageJuge= new ImageNode(basicEvent1,"judge.jpeg");
        imageJuge.display();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4. Supporteur");
        Event imageSupporteur= new ImageNode(basicEvent1,"supporteur.jpeg");
        imageSupporteur.display();
        PersonnageDeBase chosenCharacter = new Sportif(playerName, chosenSport, 0);
        int playerChoice=1; //Default value in case an error happens
        try {
        	  playerChoice = scanner.nextInt();
             //if the choice of the player is not valid
             if (!(playerChoice >= 1 && playerChoice <= 4)) {
            	 playerChoice=1;
            	 throw new InputException("Choix non valide: le personnage par defaut vous serez affecte");
             	
             	}

             if (playerChoice == 1) {
                 System.out.print("Choisis ton niveau: 0,1,2 ");
                 int level=  scanner.nextInt();
                 if (!(level >= 0 && level <= 2)) {
                	 level=0;
                	 throw new InputException("Choix non valide: Niveau 0 vous affecte par defaut");
                	 
            
                 	}
                 chosenCharacter = new Sportif(playerName, chosenSport, level);
             } else if (playerChoice == 2) {
                 chosenCharacter = new Coach(playerName, chosenSport); 
             }
              else if(playerChoice==3) {
                  chosenCharacter = new Juge(playerName, chosenSport); 	
             }
              else if(playerChoice==4) {
                  chosenCharacter = new Supporteur(playerName, chosenSport); 	
             }
        	
        }catch (InputMismatchException e) {
       	    scanner.nextLine(); // Consume the invalid input 
       	    System.out.println("Erreure de saisie: Vous etes un personnage par defaut");}
        catch ( IllegalArgumentException| NoSuchElementException | IllegalStateException e) {
        	System.out.println("Vous etes un personnage par defaut");
        	 e.printStackTrace();
        	
        }
       
        System.out.println("Le personnage choisi: "+ "\n" + chosenCharacter.toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Game game = new Game( chosenCharacter, chosenSport);
        game.start();
        
        
     
        
       //the game according to what the player chooses to be
        if (playerChoice==1) {
        	int choice=1;
            Node Storynode2=game.playNext(id++, depth++,"C'est la soiree du grand match ! Que veux-tu faire ?",Snode1,Snode2);
            Storynode2.display();
            GameList.add(Storynode2);
            if (Storynode2.equals(Snode2)) {
            	Node Storynode3=game.playNext(id++, depth++, "Vous avez finit votre entrainement, que voulez vous manger?",Snode21,Snode22);
            	Storynode3.display();
            	GameList.add(Storynode3);
            	System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
            	try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice==0) {
                    	String nom = "partie.txt";
                    	try {
                    		System.out.println("Veuillez entrez le nom de la partie");
                        	nom= scanner.nextLine();
                        	game.saveGame(nom);
                        	//savedGameFiles.add(nom);
                        	addSavedGameFile(nom);
                        	return;

                        } catch ( NoSuchElementException | IllegalStateException exception) {
                            System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuer de jouer");
                  }
            	
            	
            	if (Storynode3.equals(Snode22)) {
            		TerminalNode Storynode4=Snode3.cloneNode(); 
                	Storynode4.display();
                	GameList.add(Storynode4);
                	game.setCurrentStoryNode(Storynode4);
            		
            	}else {
            		InnerNode Storynode4=Snode4.cloneNode();
            		GameList.add(Storynode4);
            		game.setCurrentStoryNode(Storynode4);
            		TerminalNode Storynode5=Snode41.cloneNode(); 
            	    Storynode5.display();
            	    GameList.add(Storynode5);
            	    game.setCurrentStoryNode(Storynode5);
            	    chosenCharacter.play(chosenSport);
            		
            	}
            }else {
            	Node Storynode3=game.playNext(id++,depth++, "Vous etes dans la fete",Snode11,Snode12);
            	Storynode3.display();
            	GameList.add(Storynode3);
            	System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
            	choice=1;
            	try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice==0) {
                    	String nom = "partie.txt";
                    	try {
                    		System.out.println("Veuillez entrez le nom de la partie");
                        	nom= scanner.nextLine();
                        	game.saveGame(nom);
                        	addSavedGameFile(nom);
                        	return;

                        } catch ( NoSuchElementException | IllegalStateException exception) {
                            System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuer de jouer");
                  }
            	if (Storynode3.equals(Snode11)) {
            		TerminalNode Storynode4=Snode7.cloneNode();
            		Storynode4.display();
            		GameList.add(Storynode4);
            		 game.setCurrentStoryNode(Storynode4);
            		chosenCharacter.play(chosenSport);
       
            		
            	}else {
            		TerminalNode Storynode4=Snode6.cloneNode(); 
            		Storynode4.display();
            		game.setCurrentStoryNode(Storynode4);
            		GameList.add(Storynode4);
            		
            	}
    	
            }
     	   
        }
        else if(playerChoice==2) {
        	int choice=1;
        	Node Storynode2 = game.playNext(id++, depth++, "C'est la soiree du grand match ! Que veux-tu faire ?",Cnode1,Cnode2);
        	GameList.add(Storynode2);
            if (Storynode2.equals(Cnode2)) {// intensive training 
            	Node Storynode3=game.playNext(id++, depth++, "Vos sportifs ont finit leur seance intensive. Que veux-tu faire ensuite? ",Cnode21,Cnode22);
            	GameList.add(Storynode3);
            	System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
            	try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice==0) {
                    	String nom = "partie.txt";
                    	try {
                    		System.out.println("Veuillez entrez le nom de la partie");
                        	nom= scanner.nextLine();
                        	game.saveGame(nom);
                        	addSavedGameFile(nom);
                        	return;

                        } catch ( NoSuchElementException | IllegalStateException exception) {
                            System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuer de jouer");
                  }
            	if (Storynode3.equals(Cnode22)) {
            		TerminalNode Storynode4=Cnode5.cloneNode(); 
            		Storynode4.display();
            		GameList.add(Storynode4);
            		game.setCurrentStoryNode(Storynode4);
            		
            	}else {
            		TerminalNode Storynode4=Cnode4.cloneNode();
            	    Storynode4.display();
            	    GameList.add(Storynode4);
            	    game.setCurrentStoryNode(Storynode4);
            	
            		
            	}
            }else {
            	Node Storynode3=game.playNext(id++,depth++, "Vous allez organiser une seance de relaxation: ",Cnode11,Cnode12);
            	GameList.add(Storynode3);
            	System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
   
            	try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice==0) {
                    	String nom = "partie.txt";
                    	try {
                    		System.out.println("Veuillez entrez le nom de la partie");
                        	nom= scanner.nextLine();
                        	game.saveGame(nom);
                        	addSavedGameFile(nom);
                        	return;

                        } catch ( NoSuchElementException | IllegalStateException exception) {
                            System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuer de jouer");
                  }
            	if (Storynode3.equals(Cnode12)) { 
            		Storynode3.display();
            		//masseuse
            		TerminalNode Storynode4=Cnode6.cloneNode();
            		Storynode4.display();
            		GameList.add(Storynode4);
            		game.setCurrentStoryNode(Storynode4);
            	}
            	else {//groupe meditation
            		Storynode3.display();
            		//Random event: create a list
            		ArrayList<Node> aleatoire=new ArrayList<Node>();
            		aleatoire.add(Cnode71);
            		aleatoire.add(Cnode72);
            		Node Storynode4 = game.RandomChoice(id++, depth++, "",aleatoire);
            		Storynode4.display();
            		GameList.add(Storynode4);
            		System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
 
                	try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice==0) {
                        	String nom = "partie.txt";
                        	try {
                        		System.out.println("Veuillez entrez le nom de la partie");
                            	nom= scanner.nextLine();
                            	game.saveGame(nom);
                            	addSavedGameFile(nom);
                            	return;

                            } catch ( NoSuchElementException | IllegalStateException exception) {
                                System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                                
                            }
                     
                        }
                     }catch (InputMismatchException e) {
                       	    scanner.nextLine(); // Consume the invalid input 
                       	    System.out.println("Erreure: Vous continuer de jouer");
                      }
            		if(Storynode4.equals(Cnode71)) {
            			TerminalNode Storynode5=Cnode41.cloneNode();
            			Storynode5.display();
            			GameList.add(Storynode5);
            			game.setCurrentStoryNode(Storynode5);
            			
            		}else {
            			TerminalNode Storynode5=Cnode42.cloneNode();
            			Storynode5.display();
            			GameList.add(Storynode5);
            			game.setCurrentStoryNode(Storynode5);
            		}
            	}
            }
        }
        else if(playerChoice==3) {
        	int choice=1;
        	Node Storynode2 = game.playNext(id++, depth++, "C'est la soiree du grand match ! Que veux-tu faire ?",Jnode1,Jnode2);
        	GameList.add(Storynode2);
                     if (Storynode2.equals(Jnode2)) {// read verdict 
                    	 Node Storynode3 = game.playNext(id++, depth++, "Vous trouvez une info cruciale. Que veux-tu faire? ",Jnode21,Jnode22);
                    	 GameList.add(Storynode3);
                    	 System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
                    	   
                     	try {
                             choice = scanner.nextInt();
                             scanner.nextLine();
                             if (choice==0) {
                             	String nom = "partie.txt";
                             	try {
                             		System.out.println("Veuillez entrez le nom de la partie");
                                 	nom= scanner.nextLine();
                                 	game.saveGame(nom);
                                 	addSavedGameFile(nom);
                                 	return;

                                 } catch ( NoSuchElementException | IllegalStateException exception) {
                                     System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                                     
                                 }
                          
                             }
                          }catch (InputMismatchException e) {
                            	    scanner.nextLine(); // Consume the invalid input 
                            	    System.out.println("Erreure: Vous continuer de jouer");
                           }
                     	if (Storynode3.equals(Jnode22)) {
                     		TerminalNode Storynode4=Jnode41.cloneNode(); 
                     		Storynode4.display();
                     		GameList.add(Storynode4);
                     		game.setCurrentStoryNode(Storynode4);
                     		
                     	}else {
                     		TerminalNode Storynode4=Jnode4.cloneNode();
                     		Storynode4.display();
                    		GameList.add(Storynode4);
                    		game.setCurrentStoryNode(Storynode4);
                     
                     	}
                     }else { //read rules
                    	 Node Storynode3 = game.playNext(id++,depth++, "En lisant le reglement est ce que vous: ",Jnode11,Jnode12);
                    	 GameList.add(Storynode3);
                    	 System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
                    	   
                     	try {
                             choice = scanner.nextInt();
                             scanner.nextLine();
                             if (choice==0) {
                             	String nom = "partie.txt";
                             	try {
                             		System.out.println("Veuillez entrez le nom de la partie");
                                 	nom= scanner.nextLine();
                                 	game.saveGame(nom);
                                 	addSavedGameFile(nom);
                                 	return;

                                 } catch ( NoSuchElementException | IllegalStateException exception) {
                                     System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                                     
                                 }
                          
                             }
                          }catch (InputMismatchException e) {
                            	    scanner.nextLine(); // Consume the invalid input 
                            	    System.out.println("Erreure: Vous continuer de jouer");
                           }
                     	if (Storynode3.equals(Jnode11)) { //ambiguous rule
                     		Storynode3.display();
                     		Node Storynode4=game.playNext(id++, depth++, " Que veux-tu faire ?",Jnode6,Jnode7);
                     		GameList.add(Storynode4);
                     		if (Storynode4.equals(Jnode6)) {//consult a colleague
                     			Storynode4.display();
                     			//Random event: create a list
                        		ArrayList<Node> aleatoire=new ArrayList<Node>();
                        		aleatoire.add(Jnode61);
                        		aleatoire.add(Jnode62);
                        		Node Storynode5= game.RandomChoice(id++, depth++, "",aleatoire);
                        		Storynode4.display();
                        		GameList.add(Storynode5);
                        		
                         	}else {// interpret it how the player wants
                         		TerminalNode Storynode5=Jnode71.cloneNode();
                         		GameList.add(Storynode5);
                         	    Storynode5.display();
                         	   game.setCurrentStoryNode(Storynode5);
                         	}
                     	}
                     	else {//memorise the rules 
                     		ArrayList<Node> aleatoire=new ArrayList<Node>();
                    		aleatoire.add(Jnode9);
                    		aleatoire.add(Jnode8);
                    		Node Storynode4=game.RandomChoice(id++, depth++, "",aleatoire);
                    		Storynode4.display();
                    		GameList.add(Storynode4);
                     			
                     		}
         

                     }
        }
        else {//player is a "supporteur" 
        	int choice=1;
            Node Storynode2 = game.playNext(id++, depth++, "C'est la soiree du grand match ! Que veux-tu faire ?",SSnode1,SSnode2);
        	GameList.add(Storynode2);
           
            if (Storynode2.equals(SSnode2)) {// discover Paris
            	Node Storynode3= game.playNext(id++, depth++, "Que veux-tu visiter? ",SSnode21,SSnode22);
            	GameList.add(Storynode3);
            	System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
            	   
            	try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice==0) {
                    	String nom = "partie.txt";
                    	try {
                    		System.out.println("Veuillez entrez le nom de la partie");
                        	nom= scanner.nextLine();
                        	game.saveGame(nom);
                        	addSavedGameFile(nom);
                        	return;

                        } catch ( NoSuchElementException | IllegalStateException exception) {
                            System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuer de jouer");
                  }
            	if ( Storynode3.equals(SSnode21)) {
            		  Event Tour= new ImageNode(basicEvent1,"tour.jpeg");
            		  Tour.display();
            		
            	}else {
            		 Event Arc= new ImageNode(basicEvent1,"arc.png");
           		     Arc.display();
            		
            		
            	}
            	InnerNode Storynode4=SSnode4.cloneNode(); 
            	Storynode4.display();
            	GameList.add(Storynode4);
            	game.setCurrentStoryNode(Storynode4);
            	TerminalNode Storynode5=SSnode41.cloneNode(); 
            	Storynode5.display();
            	GameList.add(Storynode5);
            	game.setCurrentStoryNode(Storynode5);
            	
            
            }else { //goes to party
            	Node Storynode3= game.playNext(id++,depth++, "Vous etes dans la fete. Que veux-tu faire ensuite? ",SSnode11,SSnode12);
            	GameList.add(Storynode3);
            	System.out.println("Est ce que vous voulez sauvgarder et quitter la partie?: 0 si oui, 1 si non");
         	   
            	try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); 
                    if (choice==0) {
                    	String nom = "partie.txt";
                    	try {
                    		System.out.println("Veuillez entrez le nom de la partie");
                        	nom= scanner.nextLine();
                        	game.saveGame(nom);
                        	addSavedGameFile(nom);
                        	return;

                        } catch ( NoSuchElementException | IllegalStateException exception) {
                            System.out.println("Une erreur est survenue.Le nom de la partie: patie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuer de jouer");
                  }
            	if (Storynode3.equals(SSnode11)) {//go back home using public transportation
            		Storynode3.display();
            		//Random event: create a list
               		ArrayList<Node> aleatoire=new ArrayList<Node>();
               		aleatoire.add(SSnode111);
               		aleatoire.add(SSnode112);
               		Node Storynode4=game.RandomChoice(id++, depth++, "",aleatoire);
               		Storynode4.display();
               		GameList.add(Storynode4);
               	
               		if (Storynode4.equals(SSnode111)) {//public transport is punctual
               			TerminalNode Storynode5=SSnode1111.cloneNode();
                	    Storynode5.display();
                	    GameList.add(Storynode5);
                	    game.setCurrentStoryNode(Storynode5);

               			
               		}
               		else {
               			TerminalNode Storynode5=SSnode1121.cloneNode();
               			Storynode5.display();
                	    GameList.add(Storynode5);
                	    game.setCurrentStoryNode(Storynode5);
               		}
            	}
            	else {//player stays at the party
            		TerminalNode Storynode4=SSnode121.cloneNode();
            	    Storynode4.display();
            	    GameList.add(Storynode4);
            	    game.setCurrentStoryNode(Storynode4);
               		
                	}
            	}
        }	
       game.end(id,depth);
      
      


 
    }

private static void loadSavedGame(Scanner scanner) {
    System.out.print("Entrez le nom du fichier de sauvegarde : ");
    String filename = scanner.nextLine();
    Game loadedGame = Game.loadGame(filename);
    List<Node> GameList= new ArrayList<>();

    if (loadedGame != null) {
    	Node current=loadedGame.getCurrentStoryNode();
		int depth=current.getDepth();
		current.display();
    	if (loadedGame.getChosenCharacter() instanceof Sportif) {
    		
    		if (current.equals(Snode22)) {
            		TerminalNode Storynode4=Snode3.cloneNode(); 
                	Storynode4.display();
                	GameList.add(Storynode4);
                	loadedGame.setCurrentStoryNode(Storynode4);
            		
            	}else if (current.equals(Snode21)) {
            		InnerNode Storynode4=Snode4.cloneNode();
            		GameList.add(Storynode4);
            		loadedGame.setCurrentStoryNode(Storynode4);
            		TerminalNode Storynode5=Snode41.cloneNode(); 
            	    Storynode5.display();
            	    GameList.add(Storynode5);
            	    loadedGame.setCurrentStoryNode(Storynode5);
            	    loadedGame.getChosenCharacter().play(loadedGame.getChosenSport());
            		
            	}
            	else if (current.equals(Snode11)) {
            		TerminalNode Storynode4=Snode7.cloneNode();
            		Storynode4.display();
            		GameList.add(Storynode4);
            		loadedGame.setCurrentStoryNode(Storynode4);
            		loadedGame.getChosenCharacter().play(loadedGame.getChosenSport());
            		
    		}
            	else  if (current.equals(Snode12)){
            		TerminalNode Storynode4=Snode6.cloneNode(); 
            		Storynode4.display();
            		loadedGame.setCurrentStoryNode(Storynode4);
            		GameList.add(Storynode4);
            		
            	}
    		
    		
    	}
    	else if (loadedGame.getChosenCharacter() instanceof Coach) {
    		
    		
    		if (current.equals(Cnode22)) {
    			TerminalNode Storynode4=Cnode5.cloneNode(); 
        		Storynode4.display();
        		GameList.add(Storynode4);
        		loadedGame.setCurrentStoryNode(Storynode4);
        		
        	
        	}else if (current.equals(Cnode21)) {
        		TerminalNode Storynode4=Cnode4.cloneNode();
        	    Storynode4.display();
        	    GameList.add(Storynode4);
        	    loadedGame.setCurrentStoryNode(Storynode4);
        
        	}
        	else if (current.equals(Cnode12)) {
        		TerminalNode Storynode4=Cnode6.cloneNode();
        		Storynode4.display();
        		GameList.add(Storynode4);
        		loadedGame.setCurrentStoryNode(Storynode4);
        		
		}
        	else  if (current.equals(Cnode11)){
        		ArrayList<Node> aleatoire=new ArrayList<Node>();
        		aleatoire.add(Cnode71);
        		aleatoire.add(Cnode72);
        		Node Storynode4 = loadedGame.RandomChoice(id++,depth++, "",aleatoire);
        		Storynode4.display();
        		GameList.add(Storynode4);
        		loadedGame.setCurrentStoryNode(Storynode4);
        		if(Storynode4.equals(Cnode71)) {
        			TerminalNode Storynode5=Cnode41.cloneNode();
        			Storynode5.display();
        			GameList.add(Storynode5);
        			loadedGame.setCurrentStoryNode(Storynode5);
        			
        		}else {
        			TerminalNode Storynode5=Cnode42.cloneNode();
        			Storynode5.display();
        			GameList.add(Storynode5);
        			loadedGame.setCurrentStoryNode(Storynode5);
        		}
        	}
    		
    	}
    	else if (loadedGame.getChosenCharacter() instanceof Juge) {
    		
    		if (current.equals(Jnode22)) {
    			TerminalNode Storynode4=Jnode41.cloneNode(); 
         		Storynode4.display();
         		GameList.add(Storynode4);
         		loadedGame.setCurrentStoryNode(Storynode4);
         	
         
    		}
    		else if(current.equals(Jnode21)) {
    			TerminalNode Storynode4=Jnode4.cloneNode();
         		Storynode4.display();
        		GameList.add(Storynode4);
        		loadedGame.setCurrentStoryNode(Storynode4);
    			
    		} 
    		else if (current.equals(Jnode11)) {
         		Node Storynode4=loadedGame.playNext(id++, depth++, " Que veux-tu faire ?",Jnode6,Jnode7);
         		GameList.add(Storynode4);
         		if (Storynode4.equals(Jnode6)) {//consult a colleague
         			Storynode4.display();
         			//Random event: create a list
            		ArrayList<Node> aleatoire=new ArrayList<Node>();
            		aleatoire.add(Jnode61);
            		aleatoire.add(Jnode62);
            		Node Storynode5= loadedGame.RandomChoice(id++, depth++, "",aleatoire);
            		Storynode4.display();
            		GameList.add(Storynode5);
            		
             	}else {// interpret it how the player wants
             		TerminalNode Storynode5=Jnode71.cloneNode();
             		GameList.add(Storynode5);
             	    Storynode5.display();
             	   loadedGame.setCurrentStoryNode(Storynode5);
             	}
    			
    		}
    		else if(current.equals(Jnode12)) {
    			ArrayList<Node> aleatoire=new ArrayList<Node>();
        		aleatoire.add(Jnode9);
        		aleatoire.add(Jnode8);
        		Node Storynode4=loadedGame.RandomChoice(id++, depth++, "",aleatoire);
        		Storynode4.display();
        		GameList.add(Storynode4);
    			
    		}
    		
    		
    		
    	}else if (loadedGame.getChosenCharacter() instanceof Supporteur) {
    		
    		if (current.equals(SSnode21)) {
    			 Event Tour= new ImageNode(basicEvent1,"tour.jpeg");
       		     Tour.display();
       		     InnerNode Storynode4=SSnode4.cloneNode(); 
       		  	Storynode4.display();
          		GameList.add(Storynode4);
          		loadedGame.setCurrentStoryNode(Storynode4);
          		TerminalNode Storynode5=SSnode41.cloneNode(); 
          		Storynode5.display();
          		GameList.add(Storynode5);
          		loadedGame.setCurrentStoryNode(Storynode5);
         	
         
    		}
    		else if(current.equals(SSnode22)) {
    			 Event Arc= new ImageNode(basicEvent1,"arc.png");
       		     Arc.display();
       		     InnerNode Storynode4=SSnode4.cloneNode(); 
       		  	Storynode4.display();
          		GameList.add(Storynode4);
          		loadedGame.setCurrentStoryNode(Storynode4);
          		TerminalNode Storynode5=SSnode41.cloneNode(); 
          		Storynode5.display();
          		GameList.add(Storynode5);
          		loadedGame.setCurrentStoryNode(Storynode5);
    			
    			
    		} 
    		else if(current.equals(SSnode11)) {
    			
        		//Random event: create a list
           		ArrayList<Node> aleatoire=new ArrayList<Node>();
           		aleatoire.add(SSnode111);
           		aleatoire.add(SSnode112);
           		Node Storynode4=loadedGame.RandomChoice(id++, depth++, "",aleatoire);
           		Storynode4.display();
           		GameList.add(Storynode4);
           	
           		if (Storynode4.equals(SSnode111)) {//public transport is punctual
           			TerminalNode Storynode5=SSnode1111.cloneNode();
            	    Storynode5.display();
            	    GameList.add(Storynode5);
            	    loadedGame.setCurrentStoryNode(Storynode5);

           			
           		}
           		else {
           			TerminalNode Storynode5=SSnode1121.cloneNode();
           			Storynode5.display();
            	    GameList.add(Storynode5);
            	    loadedGame.setCurrentStoryNode(Storynode5);
           		}
        	
        	}
    		
    		else if(current.equals(SSnode12)) {
    			TerminalNode Storynode4=SSnode121.cloneNode();
        	    Storynode4.display();
        	    GameList.add(Storynode4);
        	    loadedGame.setCurrentStoryNode(Storynode4);
    			
    		}
    	}
    	loadedGame.end(id,depth);
    	 
    }
    else {
        System.out.println("Impossible de charger la partie. Veuillez réessayer.");
    	}
	}
}
	

