package components;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Enemy implements IResizeable, IMovable, Consts{
  public boolean alive=true;
  private BufferedImage img;
  private int x, y, value, sideSteps, downSteps;
  private boolean dir = true;
  private static ArrayList<Fire> enemyFires = new ArrayList<>();            /** vim, ze nejsou static povoleny, zel me nenapada jine elegantni reseni problemu logovani strel*/

  Enemy(int x, int y, int value) throws IOException {
    BufferedImage tmp = ImageIO.read(new File(ENEMY_PATH));
    this.img = resize(tmp, SIZE, SIZE);
    this.x=x;
    this.y=y;
    this.value=value;
  }


  /**https://stackoverflow.com/questions/9417356/bufferedimage-resize**/
  @Override
  public BufferedImage resize(BufferedImage img, int newW, int newH) {
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
  }

  public int getSideStep() { return this.sideSteps;}
  public void incSideStep() { this.sideSteps += 1;}

  public void resetSideStep() {this.sideSteps =0;}

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() { return y; }

  public void setY(int y) {
    this.y = y;
  }

  public BufferedImage getImg() {
    return img;
  }

  public void setImg(BufferedImage img) {
    this.img = img;
  }

  @Override
  public void pohyb() {
    if (sideSteps<300){
      if (dir){
        this.x += STEP;
      }
      if (!dir){
        this.x -=STEP;
      }
    }
    else {
      this.y += 10*STEP;
    }

  }

  public boolean isDir() {
    return dir;
  }

  public void changeDir() {
    this.dir = !dir;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
