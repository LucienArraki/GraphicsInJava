import javax.swing.*;
import java.awt.*;

public class Panel {

    JFrame ramka;   //Ekran główny

    public void GUI(){

        ramka = new JFrame();
        ramka.setTitle("Zad2 Grafika kompiterowa");     //Tytuł aplikacji


        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Wyłącz

        //Panele
        ramka.setLayout(new BorderLayout());
        ramka.add(new Buttons(), BorderLayout.EAST);
        ramka.add(new MyPanel("http://www.komputerswiat.pl/media/2015/320/4096559/emocjep.jpg"), BorderLayout.CENTER);

        ramka.setVisible(true);     //Ustawienia
        ramka.setResizable(false);
        ramka.setSize(800, 500);
    }

    public static void main(String[] args) {
        Panel grad = new Panel();
        grad.GUI();
    }
}
