import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class WordCountTest {

  public static void main(String[] args) {
   //getUserTextTest();
   testWordCountWithDash();
   testWordCount();
   testWordCountEmptyText();
   testWordCountEmptyTextWithOtherChars();
   getTextToExcludeTest();
   wordCountWithExcludeWords();
  }

  /* word count test with unique words */
  private static void testWordCountWithDash() {
    Set<String> words = new HashSet<>();
    words.add("the");
    words.add("a");
    words.add("on");
    words.add("off");

    String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
   int result = WordCount.wordCount(text, words).getWordCount();
   int uniquResult = WordCount.wordCount(text, words).getUniquWords();
   Assert.assertEquals(9, result);
   Assert.assertEquals(7, uniquResult);
  }



  /* Test the word count with some words to exclude */
  private static void wordCountWithExcludeWords() {
    Set<String> words = new HashSet<>();
    words.add("the");
    words.add("a");
    words.add("on");
    words.add("off");

    String text = "Mary had a little lamb";
    int result = WordCount.wordCount(text, words).getWordCount();
    Assert.assertEquals(4, result);
  }

  /* Test the exclude words are not counted. */
  private static void getTextToExcludeTest() {
    Set<String> words = new HashSet<>();
    words.add("the");
    words.add("a");
    words.add("on");
    words.add("off");

    Set<String> result= WordCount.getTextToExclude("./src/stopwords.txt");

    for (String word : result) {
      if (!words.contains(word)) {
        System.out.println("Wrong " + word);
      }
    }
    System.out.println("Correct");
  }

  private static void getUserTextTest() {
    String expected = "john";
    System.out.println("Enter text: ");
    String text = WordCount.requestUserText();

    Assert.assertEquals(expected, text);
  }

  /* Word count test */
  private static void testWordCount() {
    String word =  "My  name is.Sam    ";
    int count = WordCount.wordCount(word, new HashSet<>()).getWordCount();
    Assert.assertEquals(4, count);
  }

  /* Word count test */
  private static void testWordCountEmptyText() {
    String word = null;// "My name is Sam";
    int count = WordCount.wordCount(word, new HashSet<>()).getWordCount();
    Assert.assertEquals(0, count);
  }

  /* Word count test */
  private static void testWordCountEmptyTextWithOtherChars() {
    String word = "Always. in, motion\\ the future is";// "My name is Sam";
    int count = WordCount.wordCount(word, new HashSet<>()).getWordCount();
    Assert.assertEquals(6, count);
  }

}