package representation;
import javax.sound.sampled.*;
import java.io.File;

public class SoundNode extends DecorateurEvent {
    private String soundPath;
   

    public SoundNode(Event decoratedEvent, String soundPath) {
        super(decoratedEvent);
        this.soundPath = soundPath;
    }
    // Implementation thanks to internet search and documentation
    @Override
    public void display() {
    	 playSound(soundPath);
         super.display();
    }

    @Override
    public Event chooseNext() {
        System.out.println("Choosing next event with sound");
        return super.chooseNext();
    }
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
