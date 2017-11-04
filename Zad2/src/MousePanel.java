import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {

    private ButtonMenu buttonMenu;      //Panel przycisków
    private Point point;

    public MousePanel() {
    }

    public MousePanel(ButtonMenu buttonMenu) {
        this.buttonMenu = buttonMenu;
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {

    }       //Ruch wcisnieta mysz

    @Override
    public void mouseMoved(MouseEvent e) {
    }       //Poruszanie sie

    @Override
    public void mousePressed(MouseEvent e) {    //Wcisniecie

        System.out.println("tak");
        point = new Point(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {   //Puszczenie
        System.out.println("nie");
        Draw draw = new Draw(point,new Point(e.getX(),e.getY()),
                buttonMenu.getSketchChange().getSelectedItem().toString(),
                    buttonMenu.getColorChange().getSelectedItem());
    }

    @Override
    public void mouseClicked(MouseEvent e) {}    //Klinkiecie w miejscu


    @Override
    public void mouseEntered(MouseEvent e) {}    //Wejscie w panel

    @Override
    public void mouseExited(MouseEvent e) {}     //Wyjscie z panelu
}