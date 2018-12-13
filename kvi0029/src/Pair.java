public class Pair<T1, T2> {
  private T1 val1;
  private T2 val2;


  Pair(T1 T1, T2 T2){
  this.val2=T2;
  this.val1=T1;
  }

  public void setVal1(T1 T1){
    this.val1=T1;
  }
  public void setVal2(T2 T2){
    this.val2=T2;
  }

  public T1 getVal1() {
    return val1;
  }

  public T2 getVal2() {
    return val2;
  }
}
