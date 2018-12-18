package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel implements Runnable, Consts  {
  private Player player;
  Dimension dimension;
  private Thread runBitch;
  private ArrayList<Fire> shots;
  Fire fire;


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
      //fire.pohyb();
      repaint();
      //System.out.println("d");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  class Pohyb extends KeyAdapter implements Consts{
    @Override
    public void keyPressed(KeyEvent e){
      try {
        player.pushKey(e);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      if (e.getKeyCode()==KeyEvent.VK_SPACE){
        try {
          fire= new Fire(PLAYER_SHOT, player.getPosX()+player.getSize()/2, player.getPosY()-SHOT_SIZE_Y);
          //shots.add(tmp);

        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    }
    @Override
    public void keyReleased(KeyEvent e){
      player.holdKey(e);
    }
  }



private void paintPlayer(Graphics graphics){
    graphics.drawImage(player.getImg(), player.getPosX(), player.getPosY(), null);
}

private void paintShot(Graphics graphics){
    graphics.drawImage(fire.getImg(),fire.getX(), fire.getY(), null );
}

  @Override
  public void paintComponent(Graphics graphics){
    super.paintComponent(graphics);

    graphics.setColor(Color.green);
    graphics.drawLine(0, WINDOW_Y-50 , WINDOW_X, WINDOW_Y-50);

    paintPlayer(graphics);
    if (fire!=null){
      paintShot(graphics);


    }

  }
}
