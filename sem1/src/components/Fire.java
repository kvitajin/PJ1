package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Fire implements Consts, IResizeable, IMovable {

  private BufferedImage img, tmp;
  private int x, y;
  String imgSrc;


  Fire(String imgSrc, int x, int y) throws IOException {
      this.tmp = ImageIO.read(new File(imgSrc));
      this.img = resize(tmp, SHOT_SIZE_X, SHOT_SIZE_Y);
      this.x = x;
      this.y = y;
      this.imgSrc=imgSrc;



    //FireSize one= new FireSize();
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
    return this.img;
  }

  public void setImg(BufferedImage img) {
    this.img = img;
  }
 @Override
  public void pohyb() {
    if (this.imgSrc.equals(PLAYER_SHOT)){
      this.y+=2*STEP;
    }
    else if(this.imgSrc.equals(ENEMY_SHOT)){
      this.y-=STEP;
    }
  }
}
