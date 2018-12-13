public class NakladniAuto extends Auto{
  private int hmotnostNakladu;

  NakladniAuto(String typ, int hmotnostNakladu){
    super(typ);
    this.hmotnostNakladu=hmotnostNakladu;
  }
  @Override
  public void jed() {
    System.out.println(super.getTyp()+": jedu a veznu naklad "+ this.hmotnostNakladu/1000.0 +" tun");
  }
}
