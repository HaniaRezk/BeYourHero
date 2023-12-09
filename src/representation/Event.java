package representation;
/**
 * Events represent nodes in the tree and have methods for displaying information
 * and choosing the next event in the game.
 */
public interface Event {
	/**
     * Displays information about the event.
     */
	void display();
	

    /**
     * Chooses the next event in the game.
     *
     * @return The next event chosen.
     */
    public Event chooseNext();

}
