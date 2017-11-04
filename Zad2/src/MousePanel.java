import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {

    public MousePanel() {
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) { //Ruch wcisnieta
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {    //Wcisniecie
    }

    @Override
    public void mouseReleased(MouseEvent e) {   //Puszczenie
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }     //Poruszanie sie

    @Override
    public void mouseClicked(MouseEvent e) {
    }    //Klinkiecie w miejscu


    @Override
    public void mouseEntered(MouseEvent e) {
    }    //Wejscie w panel

    @Override
    public void mouseExited(MouseEvent e) {
    }     //Wyjscie z panelu
}