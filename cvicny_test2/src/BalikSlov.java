/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/

import java.util.*;
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

  public int zjistiPocetSlov(Collection<String> tmp){
    return tmp.size();
  }
  public int spocitejPrumernouDelkuSlova(Collection<String> tmp){
    int numberOfWords=0;
    int sumSize=0;
    int result;
    for (String word:tmp){
      sumSize+=word.length();
      ++numberOfWords;
      }
      result=sumSize/numberOfWords;
    return result;
  }
  public void tiskniPoctySouhlasek(Collection<String> strings){
    int tmp=0;
    char a;
    Map<String, Integer> bullshitList= new HashMap<>();

//    for (String word : strings) {
//      for (int j = 0; j < word.length(); j++) {
//        if (!vowels.contains(word.charAt(j))){
//          ++tmp;
//        }
//      }
//      bullshitList.put(word, tmp);
//      tmp=0;
//    }
    for (String word : strings) {
      bullshitList.put(word, vratPocetSouhlasek(word));
    }
    for (String word: bullshitList.keySet()  ) {
      System.out.println(word+" - "+ bullshitList.get(word));
    }

    System.out.println(bullshitList.entrySet());
  }

  abstract public Collection<String> vratSlova();
}
