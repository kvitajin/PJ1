

public class Main {
  public static void main (String args[]){
    Auto auto =new OsobniAuto("tmp", 6);
    Auto nakladak = new NakladniAuto("BFR", 50000);
    ((OsobniAuto) auto).transportuj();
    nakladak.jed();

    PevnyBalikSlov shit= new PevnyBalikSlov();
    System.out.println(shit.zjistiPocetSlov(shit.vratSlova()));
    System.out.println(shit.spocitejPrumernouDelkuSlova(shit.vratSlova()));
    shit.tiskniPoctySouhlasek(shit.vratSlova());


  }
}
