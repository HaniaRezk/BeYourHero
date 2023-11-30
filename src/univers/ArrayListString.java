package univers;
import java.util.ArrayList;
import java.util.Iterator;

//This is a very basic ArrayList class that we will use in the Player interface

public class ArrayListString {
	private ArrayList<String> list;
	public ArrayListString(){
		list=new ArrayList<String>();
		
	}
	public void add(String s) {
		list.add(s);
			
		}
	public String get(int n) {
		return list.get(n);
		
		
	}
	public void display() {
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
	}
	
	
	

}
