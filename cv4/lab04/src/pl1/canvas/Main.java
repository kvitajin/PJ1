/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pl1.canvas;

import pl1.shapes.Triangle;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Main {

  public static void main(String[] args) {
    Canvas.getInstance();
    new Triangle(10, 10, 50, 60);
  }

}
