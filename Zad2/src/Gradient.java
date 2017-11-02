import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Gradient {
    JFrame ramka;

    public void GUI(){
        ramka = new JFrame();

        ramka.setTitle("Zad2 Grafika kompiterowa");


        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 500);
        ramka.setLocation(500,200);

        ramka.setVisible(true);
        ramka.setResizable(true);

        ramka.setLayout(new FlowLayout(FlowLayout.CENTER));

        ramka.add(new Przycisk());
        ramka.add(new MyPanel());
    }
}

class MyPanel extends JPanel {

    private BufferedImage image;

    public MyPanel() {
        super();
        //File imageFile = new File("java.jpg");
        try {
            URL myURL = new URL("http://www.komputerswiat.pl/media/2015/320/4096559/emocjep.jpg");
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