package representation;

public abstract class Node implements Event{
	private int id;
	private String description;
	private Node nextNode;
	private int depth;
	// I will use this to keep track of the depth of each node in the graph
    static int nbNode=0; 
	
	public Node(int id,int depth, String description) {
		this.description=description;
		this.id=id;
		this.setDepth(depth);
		nbNode++;
		
	}	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	//still deciding if there is a better way to bind the nodes
	
	
	//this method will be redefined for each of the subclasses
	public abstract Node chooseNext();


	
	
	// setNext used to bind the nodes when the player is making choices 
	 public void setNext(Node nextNode) {
	        this.nextNode=nextNode;
	    }
	
	 public void display() {
			System.out.println(description);
			
		}
	 
	 @Override
	 public boolean equals(Object obj) {
		 if(obj instanceof Node) {
			 Node n=(Node) obj;
			 if ((n.id==id) && description.equals(n.description)) {
				 return true;
				 
			 }
		 }
		 return false;
		 }
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
}

