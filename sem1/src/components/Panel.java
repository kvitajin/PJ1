package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Panel extends JPanel implements Runnable, Consts  {
  private Player player;
  Dimension dimension;
  private Thread runBitch;

  public Panel() throws IOException {
    addKeyListener(new Pohyb());
    setFocusable(true);
    dimension = new Dimension(WINDOW_X, WINDOW_Y);
    setBackground(BACKGROUND_COLOR);
    player= new Player(300,320,30);       //todo tohle do consts
    runBitch= new Thread(this);
    runBitch.start();
  }

  @Override
  public void run(){
    while (true){
      player.pohyb();
      repaint();
      System.out.println("d");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  class Pohyb extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e){
      player.pushKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e){
      player.holdKey(e);
    }
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
