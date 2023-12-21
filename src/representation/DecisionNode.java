package representation;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import duel.Scan;

/**
 * The DecisionNode class represents a node in a game tree where the player makes
 * a decision between two possible choices. It extends the Node class and allows
 * the user to input their decision via the console.
 */

public class DecisionNode extends Node{
	private static final long serialVersionUID = 1L;
	private Node choix1;
	private Node choix2;
	
	/**
     * Constructs a DecisionNode with the specified ID, depth, description, and two choices.
     *
     * @param id          The unique identifier of the node.
     * @param depth       The depth of the node in the game tree.
     * @param description A description of the decision point.
     * @param choix1      The first choice represented by a child node.
     * @param choix2      The second choice represented by a child node.
     */
	 public DecisionNode(int id, int depth, String description,Node choix1, Node choix2) {
	        super(id,depth, description);
	        if (choix1 == null || choix2 == null) {
	            throw new InvalidNodeArgument();
	        }
	        this.choix1=choix1;
	        this.choix2=choix2;
	        
	 }
	 
	 
	 /**
	     * Allows the user to make a decision by displaying the choices and
	     * prompting the user to enter 1 for the first choice or 2 for the second choice or if the input is invalid.
	     *
	     * @return The chosen next node based on user input.
	     */
	 @Override
	 public Node chooseNext() {
	     Scanner scanner = Scan.getScanner();
	     System.out.println(getDescription());
	     System.out.println("Choix 1:");
	     this.choix1.display();
	     System.out.println("Choix 2:");
	     this.choix2.display();
	     System.out.println("Entrez 1 pour le choix 1 et 2 pour le choix 2");

	     try {
	         int ChoixUtlisateur = scanner.nextInt();

	         if (ChoixUtlisateur == 1) {
	             return choix1;
	         } else if(ChoixUtlisateur == 2) {
	             return choix2;
	         }
	         else {
	        	  System.out.println("Erreure de saisie: le choix 2 est choisi par defaut ");
	        	  return choix2;
	        	 
	         }
	     } catch (InputMismatchException e) {
	    	    scanner.nextLine(); // Consume the invalid input 
	    	    System.out.println("Erreur de saisie. Choix 2 par défaut.");
	    	    return choix2;
	    	} catch (NoSuchElementException | IllegalStateException e) {
	    	    System.out.println("Erreur de saisie. Choix 2 par défaut.");
	    	    return choix2;
	    	}
	 }
	 
	 /**
	     * Gets the first choice represented by a child node.
	     *
	     * @return The first choice.
	     */
	public Node getChoix1() {
		 if (choix1 == null) {
	            throw new InvalidNodeArgument();
	        }
		
		return choix1;
	}
	
	/**
     * Sets the first choice represented by a child node.
     *
     * @param choix1 The first choice to set.
     */
	public void setChoix1(Node choix1) {
		 if (choix1 == null) {
	            throw new InvalidNodeArgument();
	        }
		this.choix1 = choix1;
	}
	
	
	/**
     * Gets the second choice represented by a child node.
     *
     * @return The second choice.
     */
	public Node getChoix2() {
		if (choix2 == null) {
            throw new InvalidNodeArgument();
        }
		return choix2;
	}
	
	
	/**
     * Sets the second choice represented by a child node.
     *
     * @param choix2 The second choice to set.
     */
	public void setChoix2(Node choix2) {
		 if (choix2 == null) {
	            throw new InvalidNodeArgument();
	        }
		this.choix2 = choix2;
	}
	
	/**
     * Creates and returns a clone of the DecisionNode with the same ID, depth, description,
     * and choices (choix1 and choix2).
     *
     * @return A clone of the DecisionNode.
     */
	 public DecisionNode cloneNode () {
		 DecisionNode newnode=new DecisionNode(this.getId(),this.getDepth(),this.getDescription(),this.getChoix1(),this.getChoix2());
		 return (newnode) ; 
	 }
	 
	
}
