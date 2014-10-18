public class GbObserver extends Observer {
  
  GbObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  public void update() {
    System.out.println("Updating Gigabytes : " + subject.getState() * 1000 * 1000 * 1000);
  }
}
