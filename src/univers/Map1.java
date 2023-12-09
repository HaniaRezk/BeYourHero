package univers;
import java.util.HashMap;
import java.util.Map;

public class Map1 {
	 private Map<Integer, String> map;

	    public Map1() {
	        this.map = new HashMap<>();
	    }

	    /**
	     * Adds a key-value pair to the map.
	     *
	     * @param key   The key to add.
	     * @param value The value to add.
	     */
	    public void add(int key, String value) {
	    	 try {
	             map.put(key, value);
	         } catch (NullPointerException | ClassCastException | UnsupportedOperationException | IllegalArgumentException e) {
	             System.out.println("Erreure: add du map.");
	           
	         }
	        
	    }

	    /**
	     * Displays the content of the map.
	     */
	    public void display() {
	    	try {
	            for (Map.Entry<Integer, String> entry : map.entrySet()) {
	                System.out.println(entry.getKey() + ":" + entry.getValue());
	            }
	        } catch (NullPointerException e) {
	            System.out.println("Erreure: Map est vide.");
	 
	        }catch(IllegalStateException e) {
	        	e.printStackTrace();
	        	
	        }
	        

	    }
	    
	    /**
	     * Gets the element associated with the key.
	     */
	    public String get(int key) {
	    	try {
	            return map.get(key);
	        } catch (ClassCastException |NullPointerException e) {
	            System.out.println("Erreure.");
	            return " ";
	        }
	       
	    }
	    /**
	     * Checks if the map contains the specified key.
	     *
	     * @param key The key to be checked.
	     * @return true if the map contains the key, {@code false} otherwise.
	     */
	    public boolean contains(int key) {
	    	try {
	            return map.containsKey(key);
	        } catch (NullPointerException e) {
	  
	            return false;
	        }
	    }
}
