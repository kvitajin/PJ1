package components;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Consts  {
  private Player player;

  public Panel(){
    Player player= new Player(200,200,10, 10);
  }





  @Override
  public void paintComponent(Graphics graphics){
    super.paintComponent(graphics);
    graphics.setColor(BACKGROUND_COLOR);
    graphics.fillRect(0,0, WINDOW_X, WINDOW_Y);


  }
}
