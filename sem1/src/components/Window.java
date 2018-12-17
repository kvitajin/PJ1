package components;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window extends JFrame implements Consts{
  private int sizeX = WINDOW_X;
  private int sizeY = WINDOW_Y;
  private String name = "Space Invaders";
  private Pane frame;
  private Dimension dimension;

  Window() throws IOException {
    //this.frame = new Pane();
    add(new Panel());
    setTitle("Space Invaders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(WINDOW_X, WINDOW_Y);
    setBounds(0, 0,WINDOW_X, WINDOW_Y);
    //setResizable(false);
   /* frame.setBounds(760,340,this.sizeX, this.sizeY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setBackground(BACKGROUND_COLOR);
    frame.setForeground(BACKGROUND_COLOR);
*/


  }

  public int getSizeY() {
    return sizeY;
  }

  public void setSizeY(int sizeY) {
    this.sizeY = sizeY;
  }

  public int getSizeX() {
    return sizeX;
  }

  public void setSizeX(int sizeX) {
    this.sizeX = sizeX;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
