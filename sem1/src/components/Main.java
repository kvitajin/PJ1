package components;

import java.awt.*;
import java.io.IOException;

public class Main {
  public static void main (String args[]){
//    Window window = new Window();
//    window.setVisible(true);

    EventQueue.invokeLater(() -> {
      Window win = null;
      try {
        win = new Window();
      } catch (IOException e) {
        e.printStackTrace();
      }
      win.setVisible(true);
    });
  }
}