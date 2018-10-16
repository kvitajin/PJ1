package pl1.shapes;
/*******************************************************************************
 * Kozusznik Jan
 * Copyright (c) 2014 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/

import pl1.types.Direction8;
import pl1.types.MyColor;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Pacman {

  private static final int SIZE = 30;

  private static final double SIZE_OF_EYE_PORTION = 0.15;

  private static final int ANGLE = 40;

  private int xPos;

  private int yPos;

  private Direction8 direction;
  private Arc head;
  private Ellipse eye;

  public Pacman(int x, int y, Direction8 direction) {
    xPos = x;
    yPos = y;
    this.direction = direction;
    head = new Arc(x, y, SIZE, SIZE, MyColor.YELLOW, direction.celemVzad(),
        computeAngle());
    eye = new Ellipse(getEyeX(), getEyeY(), getEyeSize(), getEyeSize(),
        MyColor.BLACK);
    paint();
  }

  public void setDirection(Direction8 direction8) {
    erase();
    direction = direction8;
    head.setDirection(direction8.celemVzad());
    paint();
  }

  public void setPosition(int x, int y) {
    erase();
    xPos = x;
    yPos = y;
    head.setPosition(x, y);
    eye.setPosition(getEyeX(), getEyeY());
    paint();
  }

  public void erase() {
    head.erase();

  }

  public void paint() {
    head.paint();
    eye.paint();
  }

  public void moveRight(int step) {
    setPosition(xPos + step, yPos);

  }

  public void moveDown(int step) {
    setPosition(xPos, yPos + step);
  }

  public boolean isInBound(int x, int y) {
    return (xPos <= x) && (x <= (xPos + SIZE)) && (yPos <= y)
        && (y <= (yPos + SIZE));
  }

  private int getEyeSize() {
    return (int) getEyeSizeD();
  }

  private double getEyeSizeD() {
    return SIZE_OF_EYE_PORTION * SIZE;
  }

  private int computeAngle() {
    return 360 - ANGLE;
  }

  private int getEyeX() {
    switch (direction) {
      case EAST:
        return ((xPos + (SIZE / 2)) - (getEyeSize() / 2)) + (getEyeSize() / 4);
      case WEST:
        return (((xPos + SIZE) - getEyeSize() - (SIZE / 2))
            + (getEyeSize() / 2)) - (getEyeSize() / 4);
      case NORTH:
      case SOUTH:
        return xPos + (SIZE / 4);
      default:
        return 0;
    }

  }

  private int getEyeY() {
    switch (direction) {
      case EAST:
      case WEST:
        return yPos + (SIZE / 4);
      case NORTH:
        return (((yPos + SIZE) - getEyeSize() - (SIZE / 2))
            + (getEyeSize() / 2)) - (getEyeSize() / 4);
      case SOUTH:
        return ((yPos + (SIZE / 2)) - (getEyeSize() / 2)) + (getEyeSize() / 4);
      default:
        return 0;
    }

  }
}
