package representation;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageNode extends DecorateurEvent {
    private String imagePath;

    public ImageNode(Event decoratedEvent, String imagePath) {
        super(decoratedEvent);
        this.imagePath = imagePath;
    }
    // Implementation thanks to Internet search and documentation
    private static BufferedImage loadImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
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
    @Override
    public Event chooseNext() {
        System.out.println("Choosing next event with image");
        return super.chooseNext();
    }
}
