package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Panel extends JPanel implements Runnable, Consts  {
  private Player player;
  Dimension dimension;
  private Thread runBitch;
  public ArrayList<Fire> shots;
  public Fire fire;
  public ArrayList<Enemy> enemies;


  public Panel() throws IOException {
    addKeyListener(new Pohyb());
    setFocusable(true);
    dimension = new Dimension(WINDOW_X, WINDOW_Y);
    setBackground(BACKGROUND_COLOR);
    this.shots=new ArrayList<>();
    player= new Player(SHIP_POS_X,SHIP_POS_Y,SIZE);
    enemies = new ArrayList<>();
    for (int i = 0; i < 5; ++i){
      for(int j = 0; j < 3; ++j){
        Enemy enemy = new Enemy(50+i*3*SIZE/2,50+j*3*SIZE/2, 10*j);
        this.enemies.add(enemy);

      }
    }
    runBitch= new Thread(this);
    runBitch.start();
  }

  @Override
  public void run() {
    while (true) {
      player.pohyb();
      if (shots.size() > 0) {
        for (Fire tmp : shots) {
          tmp.pohyb();
        }
      }
      collision();
      repaint();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  private void collision(){
  ArrayList <Enemy> eraseEnemy = new ArrayList<>();
  ArrayList <Fire> eraseFire = new ArrayList<>();
    for (Enemy enemy : enemies) {
      for (Fire f : shots) {
        if (f.getX() < enemy.getX() + SIZE &&
            f.getX() > enemy.getX()        &&
            f.getY() < enemy.getY() + SIZE &&
            f.getY() > enemy.getY()) {
          eraseEnemy.add(enemy);
          eraseFire.add(f);
        }
      }
    }
    enemies.removeAll(eraseEnemy);
    shots.removeAll(eraseFire);
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
          shots.add(fire);
          long time, time2;
          time=System.currentTimeMillis();

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
    for (Fire f : shots) {
      graphics.drawImage(f.getImg(), f.getX(), f.getY(), null);
    }
  }
  private void paintEnemies(Graphics graphics) {

    for (Enemy enemy : enemies){

      graphics.drawImage(enemy.getImg(), enemy.getX(), enemy.getY(), null);
    }
  }


  @Override
  public void paintComponent(Graphics graphics){
    super.paintComponent(graphics);

    graphics.setColor(Color.green);
    graphics.drawLine(0, WINDOW_Y-50 , WINDOW_X, WINDOW_Y-50);

    paintPlayer(graphics);
    if (fire!=null) {
      paintShot(graphics);
    }
    if (enemies!=null) {
      paintEnemies(graphics);
    }



  }

}
