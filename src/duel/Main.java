package duel;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

import univers.PersonnageDeBase;
import univers.Sport;
import representation.DecisionNode2;
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
import  javax.swing.*;
import  java.awt.*;
/**
 * The `Main` class represents the main entry point for the game .
 * It includes the initialization of game elements, such as the storylines for different
 * characters (Sportif, Supporteur, Coach, Juge), loading and saving game files, and creating
 * the welcome frame.
 *
 * The game is structured as an acyclic non-oriented graph of possible storylines, where each
 * character has their own set of decision nodes and terminal nodes that determine the outcomes
 * of their respective stories.
 */
public class Main {
	private static int id=0;
	private static List<String> savedGameFiles =  loadSavedGameFiles();
	
	 
   private static List<Node> EmptyNodeList= new ArrayList<>(); // to initialize all the inner nodes.
   private static Event basicEvent1= new InnerNode(00,0,"",EmptyNodeList);
   
   //we will first create an acyclic non oriented graph of the possible story line for the "sportif"
   static int depthsportif=0;
   //level 0 node
   InnerNode startingSportif=new InnerNode(id++,depthsportif++,"C'est le jour tant attendue de la grande compétition sportive."
   		+"\n"+ "Les athlètes se préparent à donner le meilleur d'eux-mêmes. Les supporters se rassemblent, prêts à vivre intensément chaque moment de l'épreuve."
   		+"\n"+ "Les coachs se préparent à guider leurs équipes vers la victoire. "
   		+ "\n"+"Le jury se prépare à évaluer chaque performance avec précision et impartialité.",EmptyNodeList);
  
   //level 1 nodes
   private static InnerNode Snode1= new InnerNode(id++,depthsportif,"Vous décidez de sortir et de participer à une soirée festive.", EmptyNodeList);
   private static InnerNode Snode2= new InnerNode(id++,depthsportif++,"Vous Choisissez d'aller s'entraîner pour se préparer au mieux à la compétition.", EmptyNodeList);

   //level 2 nodes
   // first branch of the story where the player goes to train
   private static InnerNode Snode21= new InnerNode(id++,depthsportif,"Vous optez pour une alimentation légère et saine en Choisissant de manger une salade pour le dîner.", EmptyNodeList);
   private static InnerNode Snode22= new InnerNode(id++,depthsportif,"Vous préférez une option plus copieuse et Choisissez de vous faire plaisir en mangeant un hamburger pour le dîner.", EmptyNodeList);
  
   //second branch of the story where the player goes to party 
   private static InnerNode Snode11= new InnerNode(id++,depthsportif,"Vous décidez de ne pas vous fatiguer excessivement et vous rentrez en Uber.", EmptyNodeList);
   private static InnerNode Snode12= new InnerNode(id++,depthsportif++,"Vous préférez prolonger votre soirée afin de vous détendre et de relâcher la pression avant le grand jour.", EmptyNodeList);
   
   //level 3
   //branch of the story where the player goes to party
   private static TerminalNode Snode6= new TerminalNode(id++,depthsportif,"Épuisé de votre sortie la veille, vous ratez malheureusement la compétition."+"\n"+"Vos proches, votre coach, vos supporters, TOUS sont déçus et en colère contre vous. C'EST UN ECHEC!");

   private static TerminalNode Snode7= new TerminalNode(id++,depthsportif,"Vous avez fait de bons choix, vous partez vers la compétition prêt à relever le défi. C'EST À VOUS DE JOUER !");

   //branch of the story where the player goes to train
   private static  TerminalNode Snode3= new TerminalNode(id++,depthsportif,"Malheureusement vous tombez malade le jour de la compétition, vous empêchant de réussir votre épreuve. C'EST UN ECHEC !");
   
   private static InnerNode Snode4= new InnerNode(id++,depthsportif++,"Conscient de l'importance de la compétition, en rentrant de votre entraînement, vous programmez une alarme pour garantir un réveil à temps.", EmptyNodeList);

   //level 4
   //branch of the story where the player goes to train
   private static  TerminalNode Snode41= new TerminalNode(id++,depthsportif,"Vous avez fait de bons choix, vous partez vers la compétition prêt à relever le défi. C'EST À VOUS DE JOUER !");

   private static  InnerNode Snode5= new InnerNode(id++,depthsportif,"Vous optez pour une matinée sans alarme, préférant vous réveiller naturellement", EmptyNodeList);
   private static  InnerNode Snode511= new InnerNode(id++,depthsportif,"Vous demandez à votre coach de vous reveiller", EmptyNodeList);
   private static TerminalNode Snode51= new TerminalNode(id++,depthsportif++,"Malheureusement, vos choix vous a empêché d'arriver à temps pour l'épreuve, entraînant ainsi votre disqualification. C'EST UN ECHEC !");

   
   //we will create an acyclic non oriented graph of the possible story line for the "Supporteur"
   private static int depthSupporteur=0;
  
   //level 0 nodes
   private static  InnerNode SSnode1= new InnerNode(id++,depthSupporteur,"Vous avez du temps avant d'assister à l'épreuve des Jeux Olympique qui vous intéresse."+"\n"+"Donc vous décidez de sortir et de participer à une soirée festive.", EmptyNodeList);
   private static  InnerNode SSnode2= new InnerNode(id++,depthSupporteur++,"Vous préférez visiter Paris et découvrir ses plus grands monuments.", EmptyNodeList);

 
   //level 1 nodes
   // first branch of the story where the fan goes to discover Paris
   private static InnerNode SSnode21= new InnerNode(id++,depthSupporteur,"Vous optez pour une visite de la Tour Eiffel pour admirer la vue panoramique.", EmptyNodeList);
   private static  InnerNode SSnode22= new InnerNode(id++,depthSupporteur,"Vous préférez visiter l'Arc de Triomphe et ses merveilleurs alentours.", EmptyNodeList);

   
   //second branch of the story where the fan goes to party 
   private static InnerNode SSnode11= new InnerNode(id++,depthSupporteur,"Vous décidez de rentrer chez vous en utilisant les transports en commun.", EmptyNodeList);
   private static InnerNode SSnode12= new InnerNode(id++,depthSupporteur++,"Vous préférez rester à la fête afin de profitez de cette merveilleuse ambiance d'été en vacances.", EmptyNodeList);

   //level 2
   //branch of the story where the fan goes to party
   private static TerminalNode SSnode121= new TerminalNode(id++,depthSupporteur,"Épuisé de votre sortie la veille, vous vous réveillez trop tard et ne pouvez pas aller voir l'épreuve. VOUS ÊTES DEÇU!");

   private static  InnerNode SSnode111= new InnerNode(id++,depthSupporteur,"Les transports fonctionnent normalement, il n'y a aucune perturbation donc vous rentrez chez vous sans problème.", EmptyNodeList);

   private static  InnerNode SSnode112= new InnerNode(id++,depthSupporteur,"Malheureusement, il y a de fortes perturbations dans les transports."+"\n"+"Cela complique le retour, vous prenez plus de temps que prévu.", EmptyNodeList);

   //branch of the story where the fan goes to discover Paris
   private static  InnerNode SSnode4= new InnerNode(id++,depthSupporteur++,"Vous êtes ébloui par la beauté de Paris et de ses monuments.", EmptyNodeList);
 
   //level 3
   //branch of the story where the fan goes to discover Paris
   private static  TerminalNode SSnode41= new TerminalNode(id++,depthSupporteur,"Vous partez voir l'épreuve qui vous intéresse et vous êtes ravi de voir votre équipe favorite remporter le prix. Vous êtes totalement satisfait !");

   //branch of the story where the fan goes to party

   private static TerminalNode SSnode1121= new TerminalNode(id++,depthSupporteur,"En raison des perturbations dans les transports, vous êtes beaucoup trop en retard et ne pouvez pas assister à l'épreuve! VOUS ÊTES DEÇU!");

   
   //we will create an acyclic non oriented graph of the possible story line for the "coach"
   private static int depthCoach=0;
  
   //level 0 nodes
   private static InnerNode Cnode1= new InnerNode(id++,depthCoach,"Conscient du niveau de des athlètes et de leurs besoins, vous décidez de leur préparer une séance de relaxation."+"\n"+"L'objectif est de les aider à relâcher la pression et à se recentrer avant l'épreuve tant attendue.", EmptyNodeList);
   private static InnerNode Cnode2= new InnerNode(id++,depthCoach++,"La compétition approchant, vous planifiez une séance d'entraînement intensive pour renforcer les compétences des joueurs et maximiser leurs performances.", EmptyNodeList);

   
   //level 1 nodes
   // first branch of the story where the coach prepares an intensive training session.
   private static InnerNode Cnode21= new InnerNode(id++,depthCoach,"Après avoir observé les performances, vous remarquez qu'une séance d'entraînement supplémentaire est nécessaire pour les perfectionner. ", EmptyNodeList);
   private static InnerNode Cnode22= new InnerNode(id++,depthCoach,"Suite à cette séance intensive, vous estimez que les joueurs ont besoin de récupération, donc vous leur accorder du repos pour le reste de la soirée.", EmptyNodeList);

   
   //second branch of the story where the coach organizes a relaxation session 
   private static  InnerNode Cnode11= new InnerNode(id++,depthCoach,"Pour détendre au plus l'équipe, vous décidez d'organiser une séance de méditation. Cela va permettre de relâcher la pression dans un environnement calme.", EmptyNodeList);
   private static  InnerNode Cnode12= new InnerNode(id++,depthCoach++,"Vous décidez d'embaucher des masseurs sportifs afin de les détendre tout en relâchant les tensions musculaires."+"\n"+"Cela permet de les apaiser mentalement et des les préparer physiquement.", EmptyNodeList);
  
   //level 2
   //branch of the story where the coach organizes a relaxation session 
   private static TerminalNode Cnode6= new TerminalNode(id++,depthCoach,"Malheureusement malgré vos efforts, la tension persiste et entrave leur performance. Par conséquent, ils ratent l'épreuve. C'EST UN ECHEC !");

   private static InnerNode Cnode71= new InnerNode(id++,depthCoach,"Cette session de relaxation est un échec et crée plus de tension, une dispute éclate dans l'équipe.", EmptyNodeList);
   private static  InnerNode Cnode72= new InnerNode(id++,depthCoach,"La séance de relaxation s'est très bien déroulée et a eu l'effet escompté. Tout les monde est apaisé et au maximum de sa forme.", EmptyNodeList);
 
   //branch of the story where coach organizes another training session
   private static TerminalNode Cnode4= new TerminalNode(id++,depthCoach,"Cette deuxième séance d'entraînement a été de trop, les joueurs sont beaucoup trop épuisés."+"\n"+"Malheureusement, cela a été contre-productif et les joueurs ratent leur épreuve. C'EST UN ECHEC ! ");
  
  //branch of the story where coach gives a break after the first training session
   private static TerminalNode Cnode5= new TerminalNode(id++,depthCoach++,"Cette séance d'entraînement a été efficace, vous avez fait le bon choix de les se reposer après cet effort."+"\n"+"Malgré une légère tension, l'équipe est bien entraînée et remporte la compétition. Vous êtes totalement satisfait ! ");

   //level 3
   //branch of the story where the coach organizes another a group meditation session
   private static  TerminalNode Cnode41= new TerminalNode(id++,depthCoach,"Les athlètes n'ont pas été assez entraîné, malheureusement cela a des impacts lors de la compétition."+"\n"+"Par conséquent, ils se blessent et perdent. C'EST UN ECHEC !");

   private static TerminalNode Cnode42= new TerminalNode(id++,depthCoach++,"Cette séance de relaxation a porté ses fruits, vous avez fait le bon choix de les reposer."+"\n"+"Les joueurs attaquent la compétition détendus et gagnent. Vous êtes totalement satisfait !");

   
   
   
   //we will create an acyclic non oriented graph of the possible story line for the "Juge"
   private static int depthJuge=0;
  
   //level 0 nodes
   private static InnerNode Jnode1= new InnerNode(id++,depthJuge,"Vous décidez de vous préparer au mieux votre jugement en relisant le règlement une dernière fois.", EmptyNodeList);
   private static InnerNode Jnode2= new InnerNode(id++,depthJuge++,"Connaissant déjà suffisamment l'ensemble des règles, vous optez pour la préparation du dossier du verdict à l'aide des informations que vous avez à disposition.", EmptyNodeList);

   //level 1 nodes
   // first branch of the story where the judge reads the verdict file
   private static InnerNode Jnode21= new InnerNode(id++,depthJuge,"Lors de cette préparation, vous trouvez une information cruciale et pour vous il semble impératif de noter chaque détail pertinent afin de pouvoir les utiliser.", EmptyNodeList);
   private static InnerNode Jnode22= new InnerNode(id++,depthJuge,"Vous décidez qu'il n'est pas nécessaire de noter toutes les informations, vous vous en souviendrez sans soucis lors de votre évaluation.", EmptyNodeList);
 
   //second branch of the story where the judge reads the rules
   private static  InnerNode Jnode11= new InnerNode(id++,depthJuge,"En explorant le règlement, vous repérez une règle ambiguë qui nécessite d'être analysée et approfondie.", EmptyNodeList);
   private static  InnerNode Jnode12= new InnerNode(id++,depthJuge++,"Vous n'avez pas le temps de vous arrêter sur chaque incompréhension, vous décidez de l'ignorer et de poursuivre la mémorisation du règlement.", EmptyNodeList);
   
   //level 2
   //branch of the story where the judge reads the rules and find the rule
   private static InnerNode Jnode6=new InnerNode(id++,depthJuge,"Face à une règle ambiguë, vous décidez de consulter un collègue afin qu'il vous éclaire.",EmptyNodeList);

   private static  InnerNode Jnode7=new InnerNode(id++,depthJuge,"N'ayant pas le temps de faire des recherches poussées, vous décidez d'interpréter cette règle à votre manière.",EmptyNodeList);

   //memorise the rules 
   private static TerminalNode Jnode8=new TerminalNode (id++,depthJuge,"Grâce à votre mémorisation du règlement, vous vous rappelez correctement des règles nécessaires lors de l'évaluation de l'épreuve."+"\n"+"Vous avez fait un bon jugement !");
   
   private static TerminalNode  Jnode9=new TerminalNode(id++,depthJuge,"Malheureusement cet apprentissage n'a pas été très efficace, vous mélangez les informations ce qui conduit à un mauvais jugement de la compétition."+"\n"+"Vous échouez complètement et ne pouvez plus participer aux Jeux Olympiques !");

   
   //branch of the story where  the judge reads the verdict file
   private static TerminalNode Jnode4= new TerminalNode(id++,depthJuge,"En utilisant habilement cette information cruciale, vous avez pu établir un excellent dossier du verdict. Vous avez fait un bon travail ! ");
   private static TerminalNode Jnode41= new TerminalNode(id++,depthJuge++,"L'information que vous avez ignoré était nécessaire pour évaluer les performances des sportifs, elle jouait un rôle clé lors de cet épreuve."+"\n"+"Cela a conduit à un travail très mitigé, vous avez échoué!");

   //level 3
   //branch of the story where the judge reads the rules
   private static  TerminalNode Jnode61= new TerminalNode(id++,depthJuge,"Le collègue donne une très bonne clarification qui vous permet de juger correctement l'épreuve sans erreur."+"\n"+"Vous avez fait un bon travail !");

   private static TerminalNode Jnode62= new TerminalNode(id++,depthJuge,"Malheureusement, votre collègue se trompe totalement et donne une mauvaise interprétation."+"\n"+"Ainsi, votre analyse de l'épreuve sportive est erronée. Vous avez échoué et ne pouvez plus participer aux Jeux Olympiques !");

   private static TerminalNode Jnode71= new TerminalNode(id++,depthJuge++,"Malheureusement, votre interprétation personnelle a été un échec, vous avez mal compris la règle."+"\n"+"Cela a entrainé des évaluations totalement incohérentes de l'épreuve. Vous avez échoué et ne pouvez plus participer aux Jeux Olympiques !");
  
   /**
    * Loads the list of saved game filenames from a file.
    *
    * @return The list of saved game filenames.
    */
 @SuppressWarnings("unchecked")
private static List<String> loadSavedGameFiles() {
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savedGameFiles.dat"))) {
           return (List<String>) ois.readObject();
       } catch (IOException | ClassNotFoundException e) {
           System.out.println("Impossible de télécharger des fichiers. Vous commencez avec une liste de fichiers vide.");
           return new ArrayList<>();
       }
   }

   /**
    * Saves the list of saved game filenames to a file.
    */
   private static void saveSavedGameFiles() {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savedGameFiles.dat"))) {
           oos.writeObject(savedGameFiles);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   /**
    * Adds a filename to the list of saved games and saves the updated list to a file.
    *
    * @param filename The filename to be added to the list.
    */
   private static void addSavedGameFile(String filename) {
       savedGameFiles.add(filename);
       saveSavedGameFiles(); // Save the updated list to a file
   }

   /**
    * Prints the list of all saved game filenames, with the latest save displayed first.
    */
   public static void printAllGameSaves() {
	    System.out.println("Liste des parties sauvegardées (dernière sauvegarde en premier) :");
	    for (int i = savedGameFiles.size() - 1; i >= 0; i--) {
	        System.out.println("- " + savedGameFiles.get(i));
	    }
	}

   /**
    * Creates and displays the welcome frame for the Olympics game.
    *
    * @return The JFrame representing the welcome frame.
    */
   private static JFrame createWelcomeFrame() {
       JFrame f1 = new JFrame("Start");

       Icon i0 = new ImageIcon(new ImageIcon("bienvenue.png").getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
       JLabel iconLabel = new JLabel(i0);
       JLabel l1 = new JLabel("BIENVENUE AUX JEUX OLYMPIQUES", JLabel.CENTER);
       l1.setOpaque(false);
       l1.setFont(new Font("Arial", Font.PLAIN, 28));
       l1.setForeground(Color.BLUE);
      
       JPanel textPanel = new JPanel(new GridBagLayout());
       textPanel.setOpaque(false);
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.gridx = 0;
       gbc.gridy = 0;
       textPanel.add(l1, gbc);

       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       buttonPanel.setOpaque(false);

       f1.setLayout(new BorderLayout());
       f1.add(textPanel, BorderLayout.NORTH);
       f1.add(iconLabel, BorderLayout.CENTER);
       f1.add(buttonPanel, BorderLayout.SOUTH);

       f1.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
       f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f1.setVisible(true);

       return f1;
   }

   /**
    * The main method of the Olympic game. It displays a menu for the user to choose from
    * options like starting a new game, loading a saved game, or quitting the program.
    *
    */
	public static void main(String[] args) {
 
		boolean quit = false;
		Scanner scanner =Scan.getScanner();
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
                    //create a random game to display end messages 
                	Game game=new Game(new Sportif("julie", Sport.TENNIS, 0), Sport.TENNIS);
                	game.quit();
                    quit = true;
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez choisir une option valide.");
            }
        }
        scanner.close();
        
    }
	 /**
     * Starts a new game, allowing the player to choose a character and initiate the story.
     * This method displays a welcome frame and prompts the player to choose a character (sportif, coach, juge, supporteur).
     *
     * @param scanner The Scanner object used to get player input.
     */
	 private static void startNewGame(Scanner scanner) {
		 	
		   //GUI for character selection
		   Frame f1=createWelcomeFrame();
	       JFrame f2 = new JFrame("Choix De Personnage");

	        Icon i1 = new ImageIcon(new ImageIcon("sportif.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
	        Icon i2 = new ImageIcon(new ImageIcon("coach.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
	        Icon i3 = new ImageIcon(new ImageIcon("judge.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
	        Icon i4 = new ImageIcon(new ImageIcon("supporteur.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));

	        JLabel l2 = new JLabel("Choisissez votre personnage:", JLabel.CENTER);
	        l2.setFont(new Font("Arial", Font.PLAIN, 28));
	        f2.add(l2);

	        JPanel p2 = new JPanel();
	        JButton btn1 = new JButton("Sportif", i1);
	        JButton btn2 = new JButton("Coach", i2);
	        JButton btn3 = new JButton("Jury", i3);
	        JButton btn4 = new JButton("Supporteur", i4);


	  
	        btn1.setFont(new Font("Arial", Font.BOLD, 18));
	        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btn1.setHorizontalTextPosition(SwingConstants.CENTER);

	        btn2.setFont(new Font("Arial", Font.BOLD, 18));
	        btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btn2.setHorizontalTextPosition(SwingConstants.CENTER);

	        btn3.setFont(new Font("Arial", Font.BOLD, 18));
	        btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btn3.setHorizontalTextPosition(SwingConstants.CENTER);
	        
	        btn4.setFont(new Font("Arial", Font.BOLD, 18));
	        btn4.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btn4.setHorizontalTextPosition(SwingConstants.CENTER);

	        p2.add(btn1);
	        p2.add(btn2);
	        p2.add(btn3);
	        p2.add(btn4);

	      
	       f2.setLayout(new GridLayout(2, 1));
	       f2.add(p2);
	      
	       f2.pack();
	       f2.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
	       f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       JButton continueButton = new JButton("Cliquer pour continuer");
	       continueButton.addActionListener(e -> {
	       
            f1.dispose();
            f2.setVisible(true);
     
       });
	  continueButton.setPreferredSize(new Dimension(150,100));
	  continueButton.setFont(new Font("Arial", Font.PLAIN, 20));
	  continueButton.setBackground(Color.YELLOW);
      f1.add(continueButton, BorderLayout.SOUTH);
	       
	   CharacterSelectionListener defaut=new CharacterSelectionListener();
	 
	   btn1.addActionListener(e -> {
	       defaut.setChoix(1);
	  
	       f2.dispose();
	             
	       });
	   btn2.addActionListener(e -> {
	        defaut.setChoix(2);
	   
	        f2.dispose();
	            
	       });
	   btn3.addActionListener(e -> {
	        defaut.setChoix(3);
	     
	         f2.dispose();
	              
	        });
	   btn4.addActionListener(e -> {
	        defaut.setChoix(4);
	         f2.dispose();
	              
	        });
	   // wait for the player to press a button
	   int playerChoice=0;
	    while(playerChoice==0) {
	       int a1=defaut.getChoix();
	             try {
	                 Thread.sleep(2000);
	             } catch (InterruptedException e) {
	                   e.printStackTrace();
	               }
	              playerChoice=a1;		 
	     
	             }
	       //System.out.println("Choice:"+playerChoice);
	         
	            
	           
	       
	      
	      
        int depth=0;
        List<Node> EmptyNodeList= new ArrayList<>(); // to initialize all the inner nodes.
        List<Node> GameList= new ArrayList<>();
        
        // Create a map of countries
        Map1 countries = new Map1();
        countries.add(1, "France");
        countries.add(2, "Chine");
        countries.add(3, "Etats-Unis");
        countries.add(4, "Royaume-Uni");
        countries.add(5, "Vietnam");
       
        Event basicEvent1= new InnerNode(id++,0,"",EmptyNodeList);
        InnerNode Storynode1 = new InnerNode(id++,depth++,"Nous sommes en juillet 2024 à Paris, "
        		+ "et vous avez l'opportunité exceptionnelle de participer à l'événement sportif le plus attendu."
        		+ "\n"+"Vous aurez la possibilité de sélectionner le rôle que vous souhaitez incarner parmi quatre options: un jury, un supporter, un coach ou un sportif, ainsi que le sport que vous désirez. "
        		+ "\n"+"Vous allez ensuite avoir la possibilité de faire des choix qui détermineront le déroulement et dénouement de votre propre expérience.",EmptyNodeList);
        Storynode1.display();
       
        
        String playerName = "Julie";
        try {
            System.out.print("Choisissez le nom de votre personnage: ");
            playerName = scanner.nextLine();

        } catch ( NoSuchElementException | IllegalStateException exception) {
            System.out.println("Une erreur est survenue. Le nom du personnage est défini par défaut à 'Julie'");
            //exception.printStackTrace();
        }
            
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
              e.printStackTrace();
          }
        
        //display all the sport choices for the player to choose
        System.out.println("Choisissez votre sport");
        Sport.displayAllSports();
        Sport chosenSport=Sport.TENNIS; //default value of sport
       try {
    	   int chosenSportIndex = scanner.nextInt();
    	   if (!(chosenSportIndex >= 1 && chosenSportIndex <= Sport.values().length)) {
    		   throw new InputException("Choix non valide! Le Tennis est choisi par defaut");
               
    	   }
    
    	   chosenSport = Sport.values()[chosenSportIndex - 1];
    	   
       }catch (InputMismatchException e) {
   	    	scanner.nextLine(); // Consume the invalid input 
   	    	System.out.println("Erreure est survenue: Le Tennis est choisi par defaut");
   	   }catch( IllegalArgumentException| NoSuchElementException | IllegalStateException e) {
    	   System.out.println("Erreure est survenue: Le Tennis est choisi par defaut");
    	 
    	  
       } 
       try {
           Thread.sleep(200);
       } catch (InterruptedException e) {
             e.printStackTrace();
         }
       
       
        //give the player options and let him choose his character
        System.out.println("Choississez le Pays que vous voulez répresenter:");
        countries.display();
        try {
        	int choice = scanner.nextInt();
            if (countries.contains(choice)) {
                String chosenCountry = countries.get(choice);
                System.out.println("Vous avez choisi: " + chosenCountry);
            } else {
            	 throw new InputException("Choix Invalide: Vous répresentez la France ");
            }
         }catch (InputMismatchException e) {
           	    scanner.nextLine(); // Consume the invalid input 
           	    System.out.println("Erreure: Vous répresentez la France par défaut");}
          catch( IllegalArgumentException| NoSuchElementException | IllegalStateException e) {
     	   System.out.println("Erreure: Vous répresentez la France par défaut");
     	
     	   
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
              e.printStackTrace();
          }
      
       PersonnageDeBase chosenCharacter = new Sportif(playerName, chosenSport, 0);
      //default character in case of an error
       if (playerChoice == 1) {
             System.out.print("Choisissez votre niveau: 0,1,2 ");
             int level=0;
             try {
             level=  scanner.nextInt();
             if (!(level >= 0 && level <= 2)) {
               level=0;
                throw new InputException("Choix non valide: Niveau 0 est affecté par défaut");
  
            
                }
             }catch (InputMismatchException e) {
            	    scanner.nextLine(); // Consume the invalid input 
               	    System.out.println("Erreure de saisie: Niveau 0 est affecté par défaut");
             }
             catch( IllegalArgumentException| NoSuchElementException | IllegalStateException e) {
           	   System.out.println("Erreure: Niveau 0 est affecté par défaut");
           	   e.printStackTrace();
           	
           	   
              }
                chosenCharacter = new Sportif(playerName, chosenSport, level);
       } 
       else if (playerChoice == 2) {
                 chosenCharacter = new Coach(playerName, chosenSport); 
             }
       
       else if(playerChoice==3) {
                  chosenCharacter = new Juge(playerName, chosenSport); 	
             }
       
       else if(playerChoice==4) {
                  chosenCharacter = new Supporteur(playerName, chosenSport); 	
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
            Node Storynode2=game.playNext(id++, depth++,"C'est la grande soirée de l'épreuve ! Que voulez-vous faire ?",Snode1,Snode2);
            Storynode2.display();
            GameList.add(Storynode2);
            if (Storynode2.equals(Snode2)) {
            	Node Storynode3=game.playNext(id++, depth++, "Vous avez fini votre entraînement, que voulez-vous manger?",Snode21,Snode22);
            	Storynode3.display();
            	GameList.add(Storynode3);
            	System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
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
                            System.out.println("Une erreur est survenue. Le nom de la partie: partie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreure: Vous continuez de jouer");
                  }
            	
            	
            	if (Storynode3.equals(Snode22)) {
            		TerminalNode Storynode4=Snode3.cloneNode(); 
                	Storynode4.display();
                	GameList.add(Storynode4);
                	game.setCurrentStoryNode(Storynode4);
            		
            	}else {// le sportif chooses to eat a salad
            		ArrayList<Node> choices=new ArrayList<Node>();
            		choices.add(Snode4);
            		choices.add(Snode5);
            		choices.add(Snode511);
            		DecisionNode2 S=new DecisionNode2(id++,depth,"",choices);
            		Node Storynode4=S.chooseNext();
            		GameList.add(Storynode4);
            		game.setCurrentStoryNode(Storynode4);
            		if (Storynode4.equals(Snode4)) {
            			TerminalNode Storynode5=Snode41.cloneNode(); 
                	    Storynode5.display();
                	    GameList.add(Storynode5);
                	    game.setCurrentStoryNode(Storynode5);
                	    scanner.nextLine();
                	    chosenCharacter.play(chosenSport);
            			
            		}
            		else {
            			TerminalNode Storynode5=Snode51.cloneNode(); 
                	    Storynode5.display();
                	    GameList.add(Storynode5);
                	    game.setCurrentStoryNode(Storynode5);
                	 
            			
            		}
            		
            	}
            }else {
            	Node Storynode3=game.playNext(id++,depth++, "Vous êtes dans la fête",Snode11,Snode12);
            	Storynode3.display();
            	GameList.add(Storynode3);
            	System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
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
                            System.out.println("Une erreur est survenue. Le nom de la partie: partie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreur: Vous continuez de jouer");
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
        	Node Storynode2 = game.playNext(id++, depth++, "C'est la grande soirée de l'épreuve ! Que voulez-vous faire ?",Cnode1,Cnode2);
        	GameList.add(Storynode2);
            if (Storynode2.equals(Cnode2)) {// intensive training 
            	Node Storynode3=game.playNext(id++, depth++, "Vos sportifs ont fini leur seance intensive. Que voulez-vous faire ensuite? ",Cnode21,Cnode22);
            	GameList.add(Storynode3);
            	System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
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
                            System.out.println("Une erreur est survenue. Le nom de la partie: partie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreur: Vous continuez de jouer");
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
            	Node Storynode3=game.playNext(id++,depth++, "Vous allez organiser une séance de relaxation: ",Cnode11,Cnode12);
            	GameList.add(Storynode3);
            	System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
   
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
                            System.out.println("Une erreur est survenue. Le nom de la partie: partie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreur: Vous continuez de jouer");
                  }
            	if (Storynode3.equals(Cnode12)) { 
            		Storynode3.display();
      
            		TerminalNode Storynode4=Cnode6.cloneNode();
            		Storynode4.display();
            		GameList.add(Storynode4);
            		game.setCurrentStoryNode(Storynode4);
            	}
            	else {
            		Storynode3.display();
            		//Random event: create a list
            		ArrayList<Node> aleatoire=new ArrayList<Node>();
            		aleatoire.add(Cnode71);
            		aleatoire.add(Cnode72);
            		Node Storynode4 = game.RandomChoice(id++, depth++, "",aleatoire);
            		Storynode4.display();
            		GameList.add(Storynode4);
            		System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
 
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
                                System.out.println("Une erreur est survenue. Le nom de la partie: patie.txt'");
                                
                            }
                     
                        }
                     }catch (InputMismatchException e) {
                       	    scanner.nextLine(); // Consume the invalid input 
                       	    System.out.println("Erreur: Vous continuez de jouer");
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
        	Node Storynode2 = game.playNext(id++, depth++, "C'est la grande soirée de l'épreuve ! Que voulez-vous faire ?",Jnode1,Jnode2);
        	GameList.add(Storynode2);
                     if (Storynode2.equals(Jnode2)) {// read verdict 
                    	 Node Storynode3 = game.playNext(id++, depth++, "Vous trouvez une info cruciale. Que voulez-vous faire? ",Jnode21,Jnode22);
                    	 GameList.add(Storynode3);
                    	 System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
                    	   
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
                                     System.out.println("Une erreur est survenue. Le nom de la partie: patie.txt'");
                                     
                                 }
                          
                             }
                          }catch (InputMismatchException e) {
                            	    scanner.nextLine(); // Consume the invalid input 
                            	    System.out.println("Erreur: Vous continuez de jouer");
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
                    	 Node Storynode3 = game.playNext(id++,depth++, "En lisant le règlement est-ce que vous: ",Jnode11,Jnode12);
                    	 GameList.add(Storynode3);
                    	 System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
                    	   
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
                                     System.out.println("Une erreur est survenue. Le nom de la partie: partie.txt'");
                                     
                                 }
                          
                             }
                          }catch (InputMismatchException e) {
                            	    scanner.nextLine(); // Consume the invalid input 
                            	    System.out.println("Erreur: Vous continuez de jouer");
                           }
                     	if (Storynode3.equals(Jnode11)) { //ambiguous rule
                     		Storynode3.display();
                     		Node Storynode4=game.playNext(id++, depth++, "Que voulez-vous faire ?",Jnode6,Jnode7);
                     		GameList.add(Storynode4);
                     		if (Storynode4.equals(Jnode6)) {//consult a colleague
                     			Storynode4.display();
                     			//Random event: create a list
                        		ArrayList<Node> aleatoire=new ArrayList<Node>();
                        		aleatoire.add(Jnode61);
                        		aleatoire.add(Jnode62);
                        		Node Storynode5= game.RandomChoice(id++, depth++, "",aleatoire);
                        		Storynode5.display();
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
            Node Storynode2 = game.playNext(id++, depth++, "C'est la grande soirée de l'épreuve ! Que voulez-vous faire ?",SSnode1,SSnode2);
        	GameList.add(Storynode2);
           
            if (Storynode2.equals(SSnode2)) {// discover Paris
            	Node Storynode3= game.playNext(id++, depth++, "Que voulez-vous visiter?",SSnode21,SSnode22);
            	GameList.add(Storynode3);
            	System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
            	   
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
                            System.out.println("Une erreur est survenue. Le nom de la partie: partie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreur: Vous continuez de jouer");
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
            	Node Storynode3= game.playNext(id++,depth++, "Vous êtes dans la fête. Que voulez-vous faire ensuite? ",SSnode11,SSnode12);
            	GameList.add(Storynode3);
            	System.out.println("Est-ce que vous voulez sauvegarder et quitter la partie?: 0 si oui, autre chiffre si non");
         	   
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
                            System.out.println("Une erreur est survenue.Le nom de la partie: partie.txt'");
                            
                        }
                 
                    }
                 }catch (InputMismatchException e) {
                   	    scanner.nextLine(); // Consume the invalid input 
                   	    System.out.println("Erreur: Vous continuez de jouer");
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
               			TerminalNode Storynode5=SSnode41.cloneNode();
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
	 
	 /**
	     * Loads a saved game from a specified file, allowing the player to resume the game.
	     * The method asks the player to enter the filename, loads the game, and continues the story.
	     *
	     * @param scanner The Scanner object used to get player input.
	     */

private static void loadSavedGame(Scanner scanner) {
    System.out.print("Entrez le nom du fichier de sauvegarde : ");
    String filename = scanner.nextLine();
    Game loadedGame = Game.loadGame(filename);
    List<Node> GameList= new ArrayList<>();

    if (loadedGame != null) {
    	Node current=loadedGame.getCurrentStoryNode();
		int depth=current.getDepth();
		current.display();
		 // Handle different character types
    	if (loadedGame.getChosenCharacter() instanceof Sportif) {
    		 // Handle sportif-specific story progression
    		
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
    		 // Handle coach-specific story progression
    		
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
    		 // Handle juge-specific story progression
    		
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
         		Node Storynode4=loadedGame.playNext(id++, depth++, "Que voulez-vous faire ?",Jnode6,Jnode7);
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
    		 // Handle supporteur-specific story progression
    		
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
           			TerminalNode Storynode5=SSnode41.cloneNode();
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
	

