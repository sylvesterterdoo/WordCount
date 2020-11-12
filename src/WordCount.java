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

  public static final String fileName = "./src/stopwords.txt";

  /* Main function */
  public static void main(String[] args) {

    //prompt the user for input
    System.out.print("Enter text: ");
    String userText = requestUserText();
    Set<String> wordsToExclude = getTextToExclude(fileName);
    Result result = wordCount(userText, wordsToExclude);
    System.out.println("Number of words: " + result.getWordCount());
    System.out.println("unique: " + result.getUniquWords());

  }

  /* Returns the set of words from a file */
  public static Set<String> getTextToExclude(String fileName) {

    if (fileName == null || fileName.isEmpty()) return new HashSet<>(); // handle gracefully
    Set<String> wordsToExclude = new HashSet<>();

    try {
      File myObj = new File(fileName);
      Scanner in = new Scanner(myObj);
      while (in.hasNextLine()) {
        String data = in.nextLine();
        wordsToExclude.add(data);
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
    Scanner in = new Scanner(System.in); // assuming the user cooperates TODO: check to string is sensibles
    String text = in.nextLine();
    return text;
  }


  /* Return the number of unique words in the text.
   * Ensure the skip word are also excluded.
   */

  /* Return the Result which contains the wordCount and words in text */
  public static Result wordCount(String text, Set<String> wordsToExclude) {
    Result result = new Result();
    int count = 0;
    Set<String> uniqueWords = new HashSet<>();

    if (text == null || text.isEmpty())  return new Result();

    // count the words that are not alphabets (a-z, A-Z)
    String[] tokens = text.split("[^a-zA-Z-]");
    for (int i=0; i<tokens.length; i++) {
      String word = tokens[i];
      // Don't want to count the words in the set
      if (!word.isEmpty() && (!wordsToExclude.contains(word))) {
        uniqueWords.add(word);
        count += 1;
      }
    }
    result.setWordCount(count);
    result.setUniquWords(uniqueWords.size());
    return result;
  }

  }
