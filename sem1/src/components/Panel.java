package components;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Panel extends JPanel implements Consts  {
  private Player player;
  Dimension dimension;

  public Panel() throws IOException {
    dimension = new Dimension(WINDOW_X, WINDOW_Y);
    setBackground(BACKGROUND_COLOR);
    player= new Player(300,320,30);

  }



private void paintPlayer(Graphics graphics){
    graphics.drawImage(player.img, player.getPosX(), player.getPosY(), null);
}

  @Override
  public void paintComponent(Graphics graphics){
    super.paintComponent(graphics);

    graphics.setColor(Color.green);
    graphics.drawLine(0, WINDOW_Y-50 , WINDOW_X, WINDOW_Y-50);

    paintPlayer(graphics);


  }
}
