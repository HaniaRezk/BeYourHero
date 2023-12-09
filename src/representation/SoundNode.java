package representation;
import javax.sound.sampled.*;
import java.io.File;
/**
 * The SoundNode class represents an event in a game tree that includes playing a sound.
 */
public class SoundNode extends DecorateurEvent {
	/**
     * The file path to the sound.
     */
    private String soundPath;
   
    /**
     * Constructs a SoundNode with the specified decoratedEvent and sound file path.
     *
     * @param decoratedEvent The Event to be decorated.
     * @param soundPath      The file path to the sound.
     */
    public SoundNode(Event decoratedEvent, String soundPath) {
        super(decoratedEvent);
        this.soundPath = soundPath;
    }
    
    /**
     * Plays the sound and delegates to the decoratedEvent for further display.
     * Implementation thanks to Internet search and documentation.
     */
    @Override
    public void display() {
    	 playSound(soundPath);
         super.display();
    }

    
    /**
     * Plays a sound from the specified file path.
     * will be used in the method display();
     *
     * @param filePath The file path of the sound.
     */
    protected void playSound(String filePath) {
        try {
        	File file = new File(filePath);
        	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
            e.printStackTrace();
        }
}
}
