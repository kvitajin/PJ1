import jdk.nashorn.api.scripting.URLReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main (String args[]) throws Exception  {
  OsobniAuto auto =new OsobniAuto("wtf", "2f2 222", 5);
  NakladniAuto nakladak=new NakladniAuto("tmp", "MAN 1223", 20000);
  auto.prepravuj();
  nakladak.jed();
  String url=IORoutines.readPage("http://blender.vsb.cz/supported-methods/");
  //String[] tmp=url.split("<img\\s.*src\\s*=\\s*\"([^\"]*)\".*>");
  String regex="<img\\s.*src\\s*=\\s*\"([^\"]*)\".*>";
  Pattern pattern= Pattern.compile(regex);
  Matcher matcher=pattern.matcher(url);
  int begin=0, end;
  int flagBegin=0;
  int i=0;
  while (matcher.find()){
    //System.out.println(url.substring(matcher.start(), matcher.end()));
    while (true){
      if (url.charAt(matcher.start()+i)=='\"' && url.charAt(matcher.start()+i+1)=='h' && flagBegin==0){
        flagBegin=1;
        begin=matcher.start()+i+1;
      }
      else if (url.charAt(matcher.start()+i)=='\"' && flagBegin==1){
        flagBegin=0;
        end=matcher.start()+i;
        i=0;
        break;
      }
      i++;
    }
//    System.out.println(url.substring(begin, end));
    String separatedUrlString=url.substring(begin, end);
    URL separatedUrl= new URL(separatedUrlString);
    int beginFile=separatedUrlString.length()-1;
    int endFile=separatedUrlString.length();
    while (true){
      if (separatedUrlString.charAt(beginFile)=='/'){
        ++beginFile;
        break;
      }
      beginFile--;
      if (beginFile==begin){
        System.out.println("se zesralo");
        break;//tak tu se to posere
      }

    }
System.out.println( separatedUrlString);
    try(InputStream in = separatedUrl.openStream()){
      Files.copy(in, Paths.get("../photos/"+separatedUrlString.substring(beginFile, endFile)));
    }
    catch (IOException e){
      System.out.println("a zase je to v prdeli \t"+e);
    }

  }

  //System.out.println(url);
}

}
