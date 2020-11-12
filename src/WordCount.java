/*
 * File: WordCount
 * Program to count the words in a text.
 */

import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

  public static void main(String[] args) {
    /*
    testWordCount();
    testWordCountEmptyText();
    testWordCountEmptyTextWithOtherChars();
    getUserTextTest();
     */
    //prompt the user for input
    System.out.print("Enter text: ");
    String userText = requestUserText();
    int count = wordCount(userText);
    System.out.println("Number of words: " + count);

  }

  /* Return the input of the user */
  public static String requestUserText() {
    Scanner in = new Scanner(System.in);
    // assuming the user cooperates [strings is sensibles] :)
    String text = in.nextLine();
    return text;
  }

  /* Return the number of words in a text
  *
   * split the word into tokens
   * iterate through and count.
   *
   */
  public static int wordCount(String text) {
    int count = 0;
    // if text is null or empty return 0
    if (text == null || text.isEmpty())  return 0;
    String[] tokens = text.split("[^a-zA-Z]");

    // count the words that are not alphabets (a-z, A-Z)
    for (int i=0; i<tokens.length; i++) {
      if (!tokens[i].isEmpty()) {
        count += 1;
      }
    }
    return count;
  }

  // TESTS
  private static void getUserTextTest() {
    String expected = "john";
    String text = requestUserText();

    if (expected.equals(text)) {
      System.out.println("Correct " + text);
    } else {
      System.out.println("Wrong " + text);
    }
  }

  /* Word count test */
  private static void testWordCount() {
    String word =  "My  name is.Sam    ";
    int count = wordCount(word);
    if (count == 4) {
      System.out.println("Correct " + count);
    } else {
      System.out.println("Wrong " + count);
    }
  }

  /* Word count test */
  private static void testWordCountEmptyText() {
    String word = null;// "My name is Sam";
    int count = wordCount(word);
    if (count == 0) {
      System.out.println("Correct " + count);
    } else {
      System.out.println("Wrong " + count);
    }
  }
  /* Word count test */
  private static void testWordCountEmptyTextWithOtherChars() {
    String word = "Always. in, motion\\ the future is";// "My name is Sam";
    int count = wordCount(word);
    if (count == 6) {
      System.out.println("Correct " + count);
    } else {
      System.out.println("Wrong " + count);
    }
  }

  }
