import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage image;
    public MousePanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);

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

    public MousePanel(String selected) {
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) { //Ruch wcisnieta
    }

    @Override
    public void mousePressed(MouseEvent e) {    //Wcisniecie
    }

    @Override
    public void mouseReleased(MouseEvent e) {   //Puszczenie
    }

    @Override
    public void mouseMoved(MouseEvent e) {}     //Poruszanie sie

    @Override
    public void mouseClicked(MouseEvent e) {}    //Klinkiecie w miejscu


    @Override
    public void mouseEntered(MouseEvent e) {}    //Wejscie w panel

    @Override
    public void mouseExited(MouseEvent e) {}     //Wyjscie z panelu
}