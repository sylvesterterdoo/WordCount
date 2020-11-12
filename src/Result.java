import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Result {
  private int wordCount;
  private int uniquWords;


  public int getUniquWords() {
    return uniquWords;
  }

  public void setUniquWords(int uniquWords) {
    this.uniquWords = uniquWords;
  }

  public Result() {
    wordCount = 0;
    uniquWords = 0;
  }

  public int getWordCount() {
    return wordCount;
  }

  public void setWordCount(int wordCount) {
    this.wordCount = wordCount;
  }


}
