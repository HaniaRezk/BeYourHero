package representation;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

import duel.Scan;


public class DecisionNode2 extends Node {
    private static final long serialVersionUID = 1L;
    private ArrayList<Node> choices;

    /**
     * Constructs a DecisionNode with the specified ID, depth, description, and choices.
     *
     * @param id          The unique identifier of the node.
     * @param depth       The depth of the node in the game tree.
     * @param description A description of the decision point.
     * @param choices     The list of choices represented by child nodes.
     */
    public DecisionNode2(int id, int depth, String description, ArrayList<Node> choices) {
        super(id, depth, description);
        if (choices == null) {
            throw new InvalidNodeArgument();
        }
        this.choices = choices;
    }

    /**
     * Allows the user to make a decision by displaying the choices and
     * asking the user to enter the corresponding choice number or if the input is invalid.
     *
     * @return The chosen next node based on user input.
     */
    @Override
    public Node chooseNext() {
        Scanner scanner = Scan.getScanner();
        System.out.println(getDescription());

        for (int i = 0; i < choices.size(); i++) {
            System.out.println("Choix " + (i + 1) + ":");
            choices.get(i).display();
        }

        System.out.println("Entrez le numéro correspondant à votre choix:");

        try {
            int userInput = scanner.nextInt();

            if (userInput >= 1 && userInput <= choices.size()) {
                return choices.get(userInput - 1);
            } else {
                System.out.println("Erreur de saisie: choix 1 par défaut.");
                return choices.get(0);
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            System.out.println("Erreur de saisie. Choix 1 par défaut.");
            return choices.get(0);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Erreur de saisie. Choix 1 par défaut.");
            return choices.get(0);
        }
    }

    /**
     * Gets the list of choices represented by child nodes.
     *
     * @return The list of choices.
     */
    public ArrayList<Node> getChoices() {
        return choices;
    }

    /**
     * Sets the list of choices represented by child nodes.
     *
     * @param choices The list of choices to set.
     */
    public void setChoices(ArrayList<Node> choices) {
        if (choices == null) {
            throw new InvalidNodeArgument();
        }
        this.choices = choices;
    }

    /**
     * Creates and returns a clone of the DecisionNode with the same ID, depth, description,
     * and choices.
     *
     * @return A clone of the DecisionNode.
     */
    public DecisionNode2 cloneNode() {
        DecisionNode2 newNode = new DecisionNode2(this.getId(), this.getDepth(), this.getDescription(), this.getChoices());
        return newNode;
    }
}
