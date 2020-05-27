/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

  private Post[] messages;
  private int size;
  public static final int MAX_SIZE = 25;

  public NewsFeed() {

    // YOUR CODE HERE

  }

  public void add(Post message) {

    // YOUR CODE HERE

  }

  public Post get(int index) {
    return messages[index];
  }

  public int size() {
    return size;
  }

  public void sort(){
    int i, j, argMin;
    Post tmp;
    for (i = 0; i < size - 1; i++) {
      argMin = i;
      for (j = i + 1; j < size(); j++) {
        if (messages[j].compareTo(messages[argMin]) < 0) {
          argMin = j;
        }
      }

      tmp = messages[argMin];
      messages[argMin] = messages[i];
      messages[i] = tmp;
    }

  }

  public NewsFeed getPhotoPost(){

    // YOUR CODE HERE

  }

  public NewsFeed plus(NewsFeed other){

    // YOUR CODE HERE

  }

}
