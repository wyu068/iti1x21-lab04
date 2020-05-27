public class PhotoPost extends Post {

  private String fileName;
  private String caption;

  public PhotoPost(String userName, String fileName, String caption) {

    // YOUR CODE HERE

  }

  public String getCaption() {
    return caption;
  }

  public String getFileName() {
    return fileName;
  }

  public String toString() {
  	String str = new String();
  	str = super.toString() + ", " + fileName + ", " + caption;
  	return str;
  }
}
