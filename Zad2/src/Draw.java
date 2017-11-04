import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Draw extends JPanel {
    Point xy1;
    Point xy2;
    String sketch;
    Color color;

    public Draw() {
    }

    public Draw(Point xy1, Point xy2, String sketch, Object color) {
        this.xy1 = xy1;
        this.xy2 = xy2;
        this.sketch = sketch;
        this.color = (Color) color;
        System.out.println(sketch);
        repaint();
    }

    protected void paintComponent(Graphics g) {
        System.out.println("Test czy odpala");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // prostokat
        g2d.drawRect(10, 10, 380, 380);
        // kolo
        g2d.drawOval(10, 10, 380, 380);
    }

}
