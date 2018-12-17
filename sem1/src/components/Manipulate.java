package components;

import java.awt.*;

public class Manipulate {
  private Image shape;
  private int posX;
  private int posY;
  private boolean alive;


  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public boolean isAlive() {
    return alive;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public Image getShape() {
    return shape;
  }

  public void setShape(Image shape) {
    this.shape = shape;
  }


}
