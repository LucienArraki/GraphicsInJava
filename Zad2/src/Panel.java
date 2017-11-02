import javax.swing.*;
import java.awt.*;

public class Panel {

    JFrame ramka;   //Ekran główny

    public void GUI() {

        ramka = new JFrame();
        ramka.setTitle("Zad2 Grafika kompiterowa");     //Tytuł aplikacji


        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Wyłącz

        //Panele
        ramka.add(new Buttons(), BorderLayout.BEFORE_FIRST_LINE);
        ramka.add(new ImageArea("http://www.komputerswiat.pl/media/2015/320/4096559/emocjep.jpg"), BorderLayout.CENTER);
        ramka.add(new MousePanel());

        ramka.setVisible(true);     //Ustawienia
        ramka.setResizable(true);
        ramka.pack();
    }

    public static void main(String[] args) {
        Panel grad = new Panel();
        grad.GUI();
    }
}
