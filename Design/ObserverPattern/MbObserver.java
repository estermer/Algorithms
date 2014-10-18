public class MbObserver extends Observer {

  MbObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  public void update() {
    System.out.println("Updating Megabytes : " + subject.getState() * 1000 * 1000);
  }
}
