import jdk.nashorn.api.scripting.URLReader;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main (String args[]){
  OsobniAuto auto =new OsobniAuto("wtf", "2f2 222", 5);
  NakladniAuto nakladak=new NakladniAuto("tmp", "MAN 1223", 20000);
  auto.prepravuj();
  nakladak.jed();
    String url=IORoutines.readPage("http://blender.vsb.cz/supported-methods/");
    //String[] tmp=url.split("<img\\s.*src\\s*=\\s*\"([^\"]*)\".*>");
    String regex="<img\\s.*src\\s*=\\s*\"([^\"]*)\".*>";
    Pattern pattern= Pattern.compile(regex);
    Matcher matcher=pattern.matcher(url);
    while (matcher.find()){
      System.out.println(url.substring(matcher.start(), matcher.end()));
    }

    //System.out.println(url);
  }

}
