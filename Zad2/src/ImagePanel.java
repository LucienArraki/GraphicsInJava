import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {

    private BufferedImage image;    //Obraz
    private MousePanel mousePanel;  //Panel myszy

    public ImagePanel() {
    }

    public ImagePanel(ButtonMenu buttonMenu, String name) {

        //Nasluchiwanie na myszy
        mousePanel = new MousePanel(buttonMenu);
        addMouseListener(mousePanel);
        addMouseMotionListener(mousePanel);

        //Wczytanie obrazu
        File imageFile = new File(name);
        try {
            URL myURL = new URL("http://www.komputerswiat.pl/media/2015/320/4096559/emocjep.jpg");
            image = ImageIO.read(myURL);

        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

        //Ustawienie rozmiaru panelu
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {    //Ustawienie obrazu
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }
}
