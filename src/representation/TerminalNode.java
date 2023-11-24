package representation;

public class TerminalNode extends Node{
	public TerminalNode(int id, int depth, String description) {
        super(id, depth,description);
    }
   
	@Override
    public TerminalNode chooseNext() {
        return this;
    }
	
	public TerminalNode cloneNode () {
		 TerminalNode newnode=new TerminalNode(this.getId(),this.getDepth(),this.getDescription());
		 return (newnode) ; 
	 }

}
