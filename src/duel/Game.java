package duel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import univers.PersonnageDeBase;
import univers.Sport;
import representation.Event;
import representation.SoundNode;
import representation.ImageNode;
import representation.InnerNode;
import representation.Node;
import representation.DecisionNode;
import representation.ChanceNode;


public class Game implements Serializable{
    private static final long serialVersionUID = 1L;

    
    private Node currentStoryNode;
    private PersonnageDeBase chosenCharacter;
    private Sport chosenSport;
    List<Node> EmptyNodeList= new ArrayList<>();
    Event basicEvent1= new InnerNode(00,0,"",EmptyNodeList);
    ArrayList<Node> aleatoire=new ArrayList<Node>();

    public Game( PersonnageDeBase chosenCharacter, Sport chosenSport) {
         this.chosenCharacter = chosenCharacter;
        this.chosenSport = chosenSport;
        this.currentStoryNode=new InnerNode(0,0,"", EmptyNodeList);
    }

    public PersonnageDeBase getChosenCharacter() {
		return chosenCharacter;
	}

	public void setChosenCharacter(PersonnageDeBase chosenCharacter) {
		this.chosenCharacter = chosenCharacter;
	}

	public Node getCurrentStoryNode() {
		return currentStoryNode;
	}

	public void setCurrentStoryNode(Node currentStoryNode) {
		this.currentStoryNode = currentStoryNode;
	}

	public void start() {
    	 InnerNode bienvenue = new InnerNode(0,0, "Bienvenue aux JO 20244.", EmptyNodeList);
         bienvenue.display();
         Event soundEvent = new SoundNode(basicEvent1, "essai.wav");
         soundEvent.display();
         Event imageEvent= new ImageNode(basicEvent1,"bienvenue.png");
         imageEvent.display();
        
    }

    public Node playNext( int id1, int depth,String story,Node node1, Node node2) {
        DecisionNode gameDecisionNode = new DecisionNode(id1, depth++,story, node1, node2);
        currentStoryNode = gameDecisionNode.chooseNext();
        return currentStoryNode;
    }
    public Node RandomChoice( int id1, int depth,String story,ArrayList<Node> aleatoire) {
        ChanceNode gameDecisionNode = new ChanceNode(id1, depth , story, aleatoire);
        currentStoryNode = gameDecisionNode.chooseNext();
        return currentStoryNode ;
    } 

    // Add other methods related to the game logic, such as handling choices, displaying information, etc.

    public void end(int idF, int depthF) {
    	 chosenCharacter.EndOfGameTrivia(chosenSport);
    	 
         Event closing= new ImageNode(basicEvent1, "closing1.jpeg");
         closing.display();
         InnerNode closing1 = new InnerNode(idF,depthF, "C'est la fin des jeux! Au revoir.", EmptyNodeList);
         closing1.display();
    }
    
    public Sport getChosenSport() {
		return chosenSport;
	}

	public void setChosenSport(Sport chosenSport) {
		this.chosenSport = chosenSport;
	}

	public void saveGame(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Partie sauvegardée avec succès !");
         
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static Game loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Game loadedGame = (Game) ois.readObject();
            System.out.println("Partie chargée avec succès !");
            return loadedGame;
        } catch (IOException | ClassNotFoundException e) {
        	 System.out.println("fichier existe pas!");
            return null;
        }
    }
    
}
