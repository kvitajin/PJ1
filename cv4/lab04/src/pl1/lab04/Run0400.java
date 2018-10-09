/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pl1.lab04;

import pl1.canvas.Canvas;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Run0400 {
  public static void main(String[] args) {
    Canvas.getInstance();


  String x="hello";
  String y= new String(new char[]{'h','e','l','l','o'}) ;
  String z= new String("hello");

  System.out.println(x==y);
  System.out.println(x.equals(y));


  Date d1= new Date(9,10,2020);
  Date d2= new Date( 9,10,2020);


  System.out.println(d1==d2);

  System.out.println(d1.equals(d2));
  System.out.println(d1.compareTo(d2));
  }
}
//todo hw pacman new pacman()
//p.animate p1, p2, p3 int neco , int milis )
//edvard kubanda