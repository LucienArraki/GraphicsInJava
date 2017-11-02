import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {

    public MousePanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    public MousePanel(String selected) {
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) { //Ruch wcisnieta
        System.out.println("mouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {      //Poruszanie sie
        //System.out.println("mouseMoved");
    }

    @Override
    public void mouseClicked(MouseEvent e) {    //Klinkiecie w miejscu
        System.out.println("mouseClicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {    //Wcisniecie
        System.out.println("mousePressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {   //Puszczenie
        System.out.println("mouseReleased");

    }

    @Override
    public void mouseEntered(MouseEvent e) {    //Wejscie w panel
        System.out.println("mouseEntered");

    }

    @Override
    public void mouseExited(MouseEvent e) {     //Wyjscie z panelu
        System.out.println("mouseExited");

    }
}