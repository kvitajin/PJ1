/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPOutputStream;

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

  public int zjistiPocetSlov(){
    Collection<String> words=vratSlova();
    return words.size();
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
  public void tiskniPoctySouhlasek(){
    Collection<String> strings=vratSlova();
    int tmp=0;
    char a;
    Map<String, Integer> bullshitList= new LinkedHashMap<>();
    for (String word : strings) {
      bullshitList.put(word, vratPocetSouhlasek(word));
    }
    for (String word: bullshitList.keySet()  ) {
      System.out.println(word+" - "+ bullshitList.get(word));
    }

    System.out.println(bullshitList.entrySet());
  }
public void  vratSlovaPodleSouhlasek() {
  Collection<String> strings = vratSlova();
  int tmp = 0;
  char a;
  Map<String, Integer> unsorted = new LinkedHashMap<>();

  for (String word : strings) {
    unsorted.put(word, vratPocetSouhlasek(word));
  }


//  Stream<Map.Entry<String, Integer>> sorted =
//          unsorted.entrySet().stream()
//                  .sorted(Map.Entry.comparingByValue());
//
//  return sorted;

  unsorted.entrySet().stream()
          .sorted(Map.Entry.comparingByValue())
          .forEach(System.out::println);
  //System.out.println(sorted);
}


public void web(){
  try {
    readUrl(new URL("https://docs.oracle.com/javase/tutorial/"));
  } catch (MalformedURLException e) {e.printStackTrace();}
  catch (IOException e) {e.printStackTrace();}
  catch(Exception e) {}
}


  public static void readUrl(URL url) throws IOException {
    InputStream is = url.openStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String tmp;
    char a;

    FileOutputStream outfile = new FileOutputStream("out.html.gz ");
    PrintWriter lo = new PrintWriter(new OutputStreamWriter(new GZIPOutputStream(outfile), StandardCharsets.UTF_8));

    while ((tmp = br.readLine()) != null) {
      lo.printf("%s", tmp);
    }
    lo.close();
    outfile.close();
  }

  abstract public Collection<String> vratSlova();
}
