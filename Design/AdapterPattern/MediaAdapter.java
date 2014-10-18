public class MediaAdapter {
  
  AdvancedMediaPlayer amp;

  MediaAdapter(String fileType) {
    if(fileType.equals("mp4"))
      amp = new CodecMp4();
    else if(fileType.equals("mp3"))
      amp = new CodecMp3();
  }

  public void play(String fileName, String fileType) {
    if(fileType.equals("mp4")) {
      amp.playMp4(fileName);
    }
    else if(fileType.equals("mp3")) {
      amp.playMp3(fileName);
    }
    else {
      System.out.println("Cannot play no codec found");
    }
  }
}
