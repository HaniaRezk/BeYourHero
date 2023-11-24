package representation;
import java.util.Scanner;

public class DecisionNode extends Node{
	private Node choix1;
	private Node choix2;
	private Scanner scanner;
	
	 public DecisionNode(int id, int depth, String description,Node choix1, Node choix2) {
	        super(id,depth, description);
	        this.choix1=choix1;
	        this.choix2=choix2;
	        this.scanner = new Scanner(System.in);
	        
	 }
	 @Override
	 public Node chooseNext() {
		 System.out.println(getDescription());
		 System.out.println("Choix 1:");
		 this.choix1.display();
		 System.out.println("Choix 2:");
		 this.choix2.display();
		 System.out.println("Entrez 1 pour le choix 1 et 2 pour le choix 2");
	     int ChoixUtlisateur = scanner.nextInt();

	     if (ChoixUtlisateur==1) {
	    	 return choix1;
	    	 
	     }else {
	    	 return choix2;
	    	 
	     }

	 }

	public Node getChoix1() {
		return choix1;
	}
	public void setChoix1(Node choix1) {
		this.choix1 = choix1;
	}
	public Node getChoix2() {
		return choix2;
	}
	public void setChoix2(Node choix2) {
		this.choix2 = choix2;
	}
	 public DecisionNode cloneNode () {
		 DecisionNode newnode=new DecisionNode(this.getId(),this.getDepth(),this.getDescription(),this.getChoix1(),this.getChoix2());
		 return (newnode) ; 
	 }
}
