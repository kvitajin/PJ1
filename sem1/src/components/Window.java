package components;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Window extends Application implements Consts{
  private int sizeX = WINDOW_X;
  private int sizeY = WINDOW_Y;
  private String name = "Space Invaders";
  private JFrame frame;

  Window(int sizeX, int sizeY){
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.frame = new JFrame(this.name);

    frame.setBounds(760,340,this.sizeX, this.sizeY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setBackground(BACKGROUND_COLOR);
    frame.setForeground(BACKGROUND_COLOR);


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

  @Override
  public void start(Stage primaryStage) throws Exception {





  }
}
