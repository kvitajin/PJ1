/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pl1.lab04;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Date {

  private int dayOfMonth;

  private int month;

  private int year;

  /**
   * @param dayOfMonth
   * @param month
   * @param year
   */
  public Date(int dayOfMonth, int month, int year) {
    super();
    this.dayOfMonth = dayOfMonth;
    this.month = month;
    this.year = year;
  }

  /**
   * @return the dayOfMonth
   */
  public int getDayOfMonth() {
    return dayOfMonth;
  }

  /**
   * @return the month
   */
  public int getMonth() {
    return month;
  }

  /**
   * @return the year
   */
  public int getYear() {
    return year;
  }

}
