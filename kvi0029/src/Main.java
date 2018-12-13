public class Main {
  public static void main (String args[]){
    OsobniAuto auto =new OsobniAuto("tmp", 6);
    NakladniAuto nakladak = new NakladniAuto("BFR", 50000);
    auto.transportuj();
    nakladak.jed();

    PevnyBalikSlov balikSlov= new PevnyBalikSlov();
    System.out.println(balikSlov.zjistiPocetSlov());
    System.out.println(balikSlov.spocitejPrumernouDelkuSlova(balikSlov.vratSlova()));
    balikSlov.tiskniPoctySouhlasek();
    balikSlov.vratSlovaPodleSouhlasek();

    Pair<NakladniAuto, Integer> autoPair= new Pair<NakladniAuto, Integer>(nakladak, 50000);
    balikSlov.web();


  }
}
