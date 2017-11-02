import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageArea extends JPanel {
    private BufferedImage image;

    public ImageArea() {
        super();
    }

    public ImageArea(String img) {
        super();

        //File imageFile = new File("java.jpg");
        try {
            URL myURL = new URL(img);
            image = ImageIO.read(myURL);

        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }
}
