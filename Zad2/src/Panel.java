import javax.swing.*;
import java.awt.*;

public class Panel {

    JFrame ramka;   //Ekran główny

    public void GUI() {

        ramka = new JFrame();
        ramka.setTitle("Zad2 Grafika kompiterowa");     //Tytuł aplikacji


        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Wyłącz

        JMenuBar menuBar = new JMenuBar();      //Panel Menu
        menuBar.add(new ButtonMenu());

        ramka.setJMenuBar(menuBar);

        //Panele
        ramka.add(new ButtonMenu(), BorderLayout.BEFORE_FIRST_LINE);
        ramka.setContentPane(new ImagePanel());
        ramka.add(new Draw());

        //Glass Panele


        ramka.setVisible(true);     //Ustawienia
        ramka.setResizable(true);
        ramka.pack();
    }

    public static void main(String[] args) {
        Panel grad = new Panel();
        grad.GUI();
    }
}
