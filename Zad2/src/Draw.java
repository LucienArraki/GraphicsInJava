import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    public Draw() {
        setPreferredSize(new Dimension(570,350));
    }

    //public Draw(Point xy1,Point xy2){
    public Draw(Dimension dimension){
        setPreferredSize(dimension);

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // prostokat
        g2d.drawRect(10, 10, 380, 380);
        // kolo
        g2d.drawOval(10, 10, 380, 380);
    }
}
