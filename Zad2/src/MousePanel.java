import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {

    private ButtonMenu buttonMenu;      //Panel przycisków
    private Point point;
    private ArrayList<MyShape> arrayListMyShape;
    private ImagePanel imagePanel;

    public MousePanel() {
    }

    public MousePanel(ButtonMenu buttonMenu, ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
        arrayListMyShape = imagePanel.arrayListMyShape;
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
        point = new Point(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {   //Puszczenie
        MyShape myShape = new MyShape(point,new Point(e.getX(),e.getY()),
                buttonMenu.getSketchChange().getSelectedItem().toString(),
                    buttonMenu.getColorChange().getSelectedItem());
        arrayListMyShape.add(myShape);      //Tworzenie tablicy figur narysowanych
        imagePanel.repaint();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}    //Klinkiecie w miejscu


    @Override
    public void mouseEntered(MouseEvent e) {}    //Wejscie w panel

    @Override
    public void mouseExited(MouseEvent e) {}     //Wyjscie z panelu
}