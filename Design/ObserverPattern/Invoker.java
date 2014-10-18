public class Invoker {

  public static void main(String[] args) {
    Subject subject = new Subject();
    KbObserver kb = new KbObserver(subject);
    MbObserver mb = new MbObserver(subject);
    GbObserver gb = new GbObserver(subject);

    subject.setState(1);
    subject.setState(2);
  }
}
