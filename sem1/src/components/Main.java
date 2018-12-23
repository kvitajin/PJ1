package components;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {
  public static void main (String args[]){

    EventQueue.invokeLater(() -> {
      Window win = null;
      try {
        win = new Window();
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (win != null) {
        win.setVisible(true);
      }
    });
  }
}
//TODO1 pohyb enemaku
//TODO2 pri sestrelu pridat score a vypsat
//TODO 3 cas prebijeni
//TODO 4 enemy strelba
//TODO 5 (bunkry)