public class OsobniAuto extends Auto implements TransportOsob {
  private int pocetOsob;
  OsobniAuto(String typ, int pocetOsob){
    super(typ);
    this.pocetOsob=pocetOsob;
  }
  @Override
  public void jed() {
    System.out.println(super.getTyp()+": Jede a vezu "+ this.pocetOsob+ "osob");
  }

  @Override
  public void transportuj() {
    jed();
  }
}
