/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pj1.zt02;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
abstract public class Auto {

  private String typ;

  /**
   * @param jmeno
   * @param hmotnost
   */
  public Auto(String typ) {
    super();
    this.typ = typ;
  }

  /**
   * @return the maxRychlost
   */
  protected String getTyp() {
    return typ;
  }

  abstract public void jed();

}
