import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gradient {
    JFrame ramka;

    public void GUI(){
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setTitle("Gradient: Red - Blue");
        MojPanelRysunkowy panelR = new MojPanelRysunkowy();
        ramka.getContentPane().add(panelR);
        ramka.setSize(300, 300);
        ramka.setVisible(true);
    }

}

class MojPanelRysunkowy extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(70, 70,
                Color.RED, 150, 150, Color.BLUE);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
}