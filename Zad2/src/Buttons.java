import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Buttons extends JButton implements ActionListener{

    private JButton saveImage;
    private JButton openImage;


    public Buttons() {
        saveImage = new JButton("Blue");
        openImage = new JButton("Red");

        saveImage.addActionListener(this);
        openImage.addActionListener(this);

        setLayout(new FlowLayout());
        add(saveImage);
        add(openImage);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Object source = arg0.getSource();


        if(source == saveImage)
            setBackground(Color.BLUE);

        else if(source == openImage)
            setBackground(Color.RED);
    }
}

class MyPanel extends JPanel {

    private BufferedImage image;

    public MyPanel() {
    }

    public MyPanel(String web){
        super();

        //File imageFile = new File("java.jpg");
        try {
            URL myURL = new URL(web);
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