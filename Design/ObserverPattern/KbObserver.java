public class KbObserver extends Observer {

  KbObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  public void update() {
    System.out.println("Updating kilobytes : " + subject.getState() * 1000);
  }
}
