// Dummy Apple iPlayer 
public class IPlay implements MediaPlayer {

  MediaAdapter ma;

  public void play(String fileName, String fileType) {
    if(fileType.equals("mov")) {
      System.out.println("Playing " + fileName + "...");
    }
    else {
      // We need a codec for filetypes other than mov
      // Use mediaadapter to invoke these adapters
      ma = new MediaAdapter(fileType);
      ma.play(fileName, fileType); 
    }
  }
}
