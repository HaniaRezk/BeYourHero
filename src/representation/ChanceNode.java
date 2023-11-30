package representation;
import java.util.List;
import java.util.Random;

public class ChanceNode extends Node{
	private List<Node> possibilites;
    private Random random;
	 public ChanceNode(int id,int depth, String description, List<Node> possibilites) {
	        super(id, depth,description);
	        this.possibilites=possibilites;
	        this.random=new Random();
	    }

	public  List<Node>getPossibilites() {
			return possibilites;
		}
	public void setPossibilites( List<Node> possibilites) {
			this.possibilites = possibilites;
		}
  //implements random law
	@Override
	public Node chooseNext() {
	    int randomIndex = random.nextInt(possibilites.size());
	    return possibilites.get(randomIndex);
	}
	
	public ChanceNode cloneNode () {
		ChanceNode newnode=new ChanceNode(this.getId(),this.getDepth(),this.getDescription(),this.getPossibilites());
		 return (newnode) ; 
	 }
 

}
