/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pj1.zt02;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public abstract class BalikSlov {

  Set<Character> vowels =
      new HashSet<>(Arrays.asList("a,e,i,o,u,ú,ů,ě,ý,á,í,é,y".split(","))
          .stream().map(s -> s.charAt(0)).collect(Collectors.toList()));

  public int vratPocetSouhlasek(String string) {
    int result = 0;
    string = string.toLowerCase();
    for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i)) && !vowels.contains(string
				.charAt(i)))
			{
			  result++;
      }
    }
    return result;
  }

  abstract public Collection<String> vratSlova();
}
