import static org.junit.Assert.*;

public class WordCountTest {

  public static void main(String[] args) {
   getUserTextTest();
   testWordCount();
   testWordCountEmptyText();
   testWordCountEmptyTextWithOtherChars();
  }

  private static void getUserTextTest() {
    String expected = "john";
    String text = WordCount.requestUserText();

    if (expected.equals(text)) {
      System.out.println("Correct " + text);
    } else {
      System.out.println("Wrong " + text);
    }
  }

  /* Word count test */
  private static void testWordCount() {
    String word =  "My  name is.Sam    ";
    int count = WordCount.wordCount(word);
    if (count == 4) {
      System.out.println("Correct " + count);
    } else {
      System.out.println("Wrong " + count);
    }
  }

  /* Word count test */
  private static void testWordCountEmptyText() {
    String word = null;// "My name is Sam";
    int count = WordCount.wordCount(word);
    if (count == 0) {
      System.out.println("Correct " + count);
    } else {
      System.out.println("Wrong " + count);
    }
  }
  /* Word count test */
  private static void testWordCountEmptyTextWithOtherChars() {
    String word = "Always. in, motion\\ the future is";// "My name is Sam";
    int count = WordCount.wordCount(word);
    if (count == 6) {
      System.out.println("Correct " + count);
    } else {
      System.out.println("Wrong " + count);
    }
  }

}