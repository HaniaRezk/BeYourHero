package representation;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The ImageNode class represents an event in a game tree that includes an image.
 */

public class ImageNode extends DecorateurEvent {
	/**
     * The file path to the image.
     */
    private String imagePath;

    /**
     * Constructs an ImageNode with the specified decoratedEvent and image path.
     *
     * @param decoratedEvent The Event to be decorated.
     * @param imagePath      The file path to the image.
     */
    public ImageNode(Event decoratedEvent, String imagePath) {
        super(decoratedEvent);
        this.imagePath = imagePath;
    }
    
    
    /**
     * Loads an image from the specified file path.
     * Implementation thanks to Internet search and documentation.
     *
     * @param filePath The file path of the image.
     * @return The loaded BufferedImage, or null if an error occurs.
     */
    private static BufferedImage loadImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Displays the image in a Swing JFrame and delegates to the decoratedEvent for further display.
     */
    @Override
    public void display() {
        BufferedImage image = loadImage(imagePath);

        if (image != null) {
            JFrame frame = new JFrame("Image Display");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel(new ImageIcon(image));

            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.setSize(image.getWidth(), image.getHeight());
            frame.setVisible(true);
        }
        super.display();
    }
   
}
