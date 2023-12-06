package duel;
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
	        map.put(key, value);
	    }

	    /**
	     * Displays the content of the map.
	     */
	    public void display() {
	        for (Map.Entry<Integer, String> entry : map.entrySet()) {
	            System.out.println(entry.getKey() + ":" + entry.getValue());
	        }

	    }
	    
	    /**
	     * Gets the element associated with the key.
	     */
	    public String get(int key) {
	        return map.get(key);
	    }
	    /**
	     * Checks if the map contains the specified key.
	     *
	     * @param key The key to be checked.
	     * @return {@code true} if the map contains the key, {@code false} otherwise.
	     */
	    public boolean contains(int key) {
	        return map.containsKey(key);
	    }
}
