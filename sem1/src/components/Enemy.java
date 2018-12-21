package components;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy implements IResizeable, Consts{
  public boolean alive=true;
  private BufferedImage img;
  private int x, y, value;

  Enemy(int x, int y, int value) throws IOException {
    BufferedImage tmp = ImageIO.read(new File(ENEMY_PATH));
    this.img = resize(tmp, SIZE, SIZE);
    this.x=x;
    this.y=y;
    this.value=value;
  }
  void moveSide(int step){
    this.x+=step;
  }
  void modeDown(int step){
    this.y+=step;
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

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public BufferedImage getImg() {
    return img;
  }

  public void setImg(BufferedImage img) {
    this.img = img;
  }
}
