package representation;
import java.util.Random;

public class ChanceNode extends Node{
	private Node[] possibilites;
    private Random random;
	 public ChanceNode(int id,int depth, String description, Node[] possibilites) {
	        super(id, depth,description);
	        this.possibilites=possibilites;
	        this.random=new Random();
	    }

	public Node[] getPossibilites() {
			return possibilites;
		}
	public void setPossibilites(Node[] possibilites) {
			this.possibilites = possibilites;
		}
  //implements random law
	@Override
	public Node chooseNext() {
		int randomIndex = random.nextInt(possibilites.length);
        return possibilites[randomIndex];
	}
	
	public ChanceNode cloneNode () {
		ChanceNode newnode=new ChanceNode(this.getId(),this.getDepth(),this.getDescription(),this.getPossibilites());
		 return (newnode) ; 
	 }
 

}