package components;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Player extends Manipulate implements Consts {
  private int posX;
  private int posY;
  private int size;

  public ImageIcon playerShape;
  public BufferedImage imgSmall;
  public BufferedImage img;
  private int dir;

  Player(int posX, int posY, int size) throws IOException {
    this.posY=posY;
    this.posX=posX;
    imgSmall= ImageIO.read(new File("images/player.png"));
    img=resize(imgSmall, size, size);
  }

  /**https://stackoverflow.com/questions/9417356/bufferedimage-resize**/
  private static BufferedImage resize(BufferedImage img, int newW, int newH) {
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
  }
  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void pohyb(){
    if (this.getPosX()+this.dir+this.getSize()<WINDOW_X && this.getPosX()+this.dir>0) {
      this.setPosX(this.getPosX() + this.dir);
    }
    else{
      System.out.println("o kurwa");
    }

  }
  public void pushKey(KeyEvent e){
    if (e.getKeyCode()==KeyEvent.VK_RIGHT){
      dir=STEP;
    }
    else if (e.getKeyCode()==KeyEvent.VK_LEFT){
      dir=-STEP;
    }
    else if (e.getKeyCode()==KeyEvent.VK_SPACE){
      //todo faya!!
    }
  }
  public void holdKey(KeyEvent e){
    if (e.getKeyCode()==KeyEvent.VK_RIGHT){
      dir=0;
    }
    else if (e.getKeyCode()==KeyEvent.VK_LEFT){
      dir=0;
    }
  }




  @Override
  public int getPosX() {
    return posX;
  }

  @Override
  public void setPosX(int posX) {
    this.posX = posX;
  }

  @Override
  public int getPosY() {
    return posY;
  }

  @Override
  public void setPosY(int posY) {
    this.posY = posY;
  }
}

