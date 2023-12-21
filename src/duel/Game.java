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

/**
 * This class represents the main game engine for our Olympics game.
 * It handles player choices, story progression, and game state management.
 *
 */
public class Game implements Serializable{
    private static final long serialVersionUID = 1L;

    
    private Node currentStoryNode;
    private PersonnageDeBase chosenCharacter;
    private Sport chosenSport;
    List<Node> EmptyNodeList= new ArrayList<>();
    Event basicEvent1= new InnerNode(00,0,"",EmptyNodeList);
    ArrayList<Node> aleatoire=new ArrayList<Node>();
    
    /**
     * Constructs a new Game with the specified chosen character and sport.
     *
     * @param chosenCharacter The player's chosen character.
     * @param chosenSport     The chosen sport for the game.
     */

    public Game( PersonnageDeBase chosenCharacter, Sport chosenSport) {
         this.chosenCharacter = chosenCharacter;
        this.chosenSport = chosenSport;
        this.currentStoryNode=new InnerNode(0,0,"", EmptyNodeList);
    }
    
    // Getter and setter methods

    /**
     * Gets the chosen character for the game.
     *
     * @return The chosen character.
     */

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
	 // Other getter and setter methods...
	public Sport getChosenSport() {
			return chosenSport;
		}

	 public void setChosenSport(Sport chosenSport) {
			this.chosenSport = chosenSport;
		}

    /**
     * Displays the welcome message and initializes the new game.
     */
	public void start() {
    	 InnerNode bienvenue = new InnerNode(0,0, "Vous Commencez le jeu:", EmptyNodeList);
         bienvenue.display();
         Event soundEvent = new SoundNode(basicEvent1, "essai.wav");
         soundEvent.display();
         Event imageEvent= new ImageNode(basicEvent1,"bienvenue.png");
         imageEvent.display();
        
    }
	/**
     * Plays the next part of the story based on the Player's choices.
     *
     * @param id1    The ID of the decision node.
     * @param depth  The depth of the decision node.
     * @param story  The story text for the decision node.
     * @param node1  The first option node.
     * @param node2  The second option node.
     * @return The current story node after making the decision.
     */
    public Node playNext( int id1, int depth,String story,Node node1, Node node2) {
        DecisionNode gameDecisionNode = new DecisionNode(id1, depth++,story, node1, node2);
        currentStoryNode = gameDecisionNode.chooseNext();
        return currentStoryNode;
    }
    
    /**
     * Makes a random choice in the story based on a random event.
     *
     * @param id1       The ID of the chance node.
     * @param depth     The depth of the chance node.
     * @param story     The story text for the chance node.
     * @param aleatoire The list of nodes for random selection.
     * @return The current story node after making the random choice.
     */
    public Node RandomChoice( int id1, int depth,String story,ArrayList<Node> aleatoire) {
        ChanceNode gameDecisionNode = new ChanceNode(id1, depth , story, aleatoire);
        currentStoryNode = gameDecisionNode.chooseNext();
        return currentStoryNode ;
    } 

    
    /**
     * End of game trivia.
     *
     * @param idF    The ID of the closing node.
     * @param depthF The depth of the closing node.
     */
    public void end(int idF, int depthF) {
    	 chosenCharacter.EndOfGameTrivia(chosenSport);
     
    
    }
    /**
     * Displays the end-of-game messages 
     */
    public void quit() {
    
        Event closing= new ImageNode(basicEvent1, "closing1.jpeg");
        closing.display();
        InnerNode closing1 = new InnerNode(0,0, "C'est la fin des jeux! C'était un plaisir de vous avoir comme joueur. Au revoir!", EmptyNodeList);
        closing1.display();
   }
    
   
    /**
     * Saves the current game state to a file with the specified filename.
     *
     * @param filename The name of the file to save the game to.
     */
	public void saveGame(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Partie sauvegardée avec succès !");
         
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	/**
     * Loads a saved game state from the specified filename.
     *
     * @param filename The name of the file containing the saved game.
     * @return The loaded Game object.
     */

    public static Game loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Game loadedGame = (Game) ois.readObject();
            System.out.println("Partie chargée avec succès!");
            return loadedGame;
        } catch (IOException | ClassNotFoundException e) {
        	 System.out.println("Fichier existe pas!");
            return null;
        }
    }
    
}
