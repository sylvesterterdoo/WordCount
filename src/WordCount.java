/*
 * File: WordCount
 * Program to count the words in a text.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCount {


  public static void main(String[] args) {
    String fileName = "./src/stopwords.txt";
    //prompt the user for input
    System.out.print("Enter text: ");
    String userText = requestUserText();
    Set<String> wordsToExclude = getTextToExclude(fileName);
    int count = wordCount(userText, wordsToExclude);
    System.out.println("Number of words: " + count);
    //getTextToExcludeTest();
  }

  /* Returns the set of words from a file */
  public static Set<String> getTextToExclude(String fileName) {
    /* assumption file name is provided */

    if (fileName == null || fileName.isEmpty()) return new HashSet<>(); // handle gracefully
    Set<String> wordsToExclude = new HashSet<>();

    try {
      File myObj = new File(fileName);
      Scanner in = new Scanner(myObj);
      while (in.hasNextLine()) {
        String data = in.nextLine();
        wordsToExclude.add(data);
        //System.out.println(data);
      }
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return wordsToExclude;
  }

  /* Return the input of the user */
  public static String requestUserText() {
    Scanner in = new Scanner(System.in);
    // assuming the user cooperates [strings is sensibles] :)
    String text = in.nextLine();
    return text;
  }

  /* Return the number of words in a text
   * split the word into tokens
   * iterate through and count.
   */
  public static int wordCount(String text, Set<String> wordsToExclude) {
    int count = 0;
    // if text is null or empty return 0
    if (text == null || text.isEmpty())  return 0;
    String[] tokens = text.split("[^a-zA-Z]");

    // count the words that are not alphabets (a-z, A-Z)
    for (int i=0; i<tokens.length; i++) {
      String word = tokens[i];
      // Don't want to count the specified words in the set
      if (!word.isEmpty() && (!wordsToExclude.contains(word))) {
        count += 1;
      }
    }
    return count;
  }

  }
