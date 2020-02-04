//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DictionaryDriver
// Files: DictionaryTests.java, Dictionary.java, DictionaryWord.java, DictionaryBST.java
// DictionaryDriver.java
// Course: Comp Sci 300, LEC-005, Spring 2019
//
// Author: Shihan Cheng
// Email: scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NA
// Partner Email: NA
// Partner Lecturer's Name: NA
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NA
// Online Sources: NA
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is a driver driving the Dictionary application to make use of the Dictionary
 * implemented using BST.
 * 
 * @author Shihan Cheng
 *
 */
public class DictionaryDriver {

  /**
   * This method is a helper method to create a new word to add in by user's input
   * 
   * @param word The word that user wants to add into the dictionary
   * @param meaning The meaning of the word
   * @return a new DictionaryWord
   */
  private static DictionaryWord createWord(String word, String meaning) {
    try { // Try to create a new word with user's input
      DictionaryWord newWord = new DictionaryWord(word, meaning);
      // If create word successfully, return the DictionayWord
      return newWord;
    } catch (IllegalArgumentException e) { // Otherwise, catch the exception from
                                           // DictionaryWord's constructor
      System.out.println(e.getMessage()); // Display the error message
    }
    // Once create the DictionaryWord unsuccessfully, return null to the main method
    return null;
  }

  /**
   * This method is a helper class to add the word that user wants to add into the
   * dictionary
   * 
   * @param dictionary The dictionary created by the user
   * @param word The word that user wants to add into the dictionary
   */
  private static void dictionaryAddWord(DictionaryBST dictionary, DictionaryWord word) {
    // Use dictionary to call addWord() method in DicationaryBST, see if add the word
    // successfully.
    if (dictionary.addWord(word.getWord(), word.getMeaning())) {
      return;
    }
    // Once add the word unsuccessfully, display the error message
    System.out.println("WARNING: failed to add duplicate word: " + word.getWord() + ".");
  }

  /**
   * This method is a helper method to help user lookup a word
   * 
   * @param dictionary The dictionary created by the user
   * @param word The word that user wants to lookup
   */
  private static void dictionaryLookup(DictionaryBST dictionary, String word) {
    try { // Try to call lookup() method in DictionaryBST to lookup the word
      // If find the word successfully, display the word and its meaning
      System.out.println(word + ": " + dictionary.lookup(word));
    } catch (NoSuchElementException e) { // Otherwise, catch the exception
      // Display the error message
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is a helper method to display all words stored in the dictionary in
   * specific form
   * 
   * @param dictionary The dictionary created by the user
   */
  private static void printDictionary(DictionaryBST dictionary) {
    // Create an array list with the reference of dictionary calls getAllWords()
    ArrayList<String> list = dictionary.getAllWords();
    if (list.isEmpty()) { // If dictionary is empty, display the message
      System.out.println("Dictionary is empty.");
    } else { // If dictionary is not empty
      // Iterate the array list by indices, display them in specific form
      for (int i = 0; i < list.size(); i++) {
        if (i == list.size() - 1) {
          System.out.println(list.get(i));
          break;
        }
        System.out.print(list.get(i) + ", ");
      }
    }
  }

  /**
   * This method is a helper method to accesses the user's command, recognize if the
   * command is valid
   * 
   * @param command Array stores user's commands
   * @return true if the command is valid. Otherwise, return false
   */
  private static boolean commandAccessor(String[] command) {
    // When command is null or command is empty
    if (command == null || command.length == 0) {
      System.out.println("WARNING: Unrecognized command.");
      return false;
    }
    // When command is "a"
    if (command[0].toLowerCase().trim().equals("a")) {
      // If the command "a" is not followed by 2 arguments, display warning, return false
      if (command.length != 3) {
        System.out
            .println("WARNING: Syntax Error for [A <word> <meaning>] command line.");
        return false;
      } else { // Otherwise, the command is valid, return true
        return true;
      }
    }
    // When command is "l"
    if (command[0].toLowerCase().trim().equals("l")) {
      // If the command "l" is not followed by 1 arguments, display warning, return false
      if (command.length != 2) {
        System.out.println("WARNING: Syntax Error for [L <word>] command line.");
        return false;
      } else { // Otherwise, the command is valid, return true
        return true;
      }
    }
    // When the command is "g"
    if (command[0].toLowerCase().trim().equals("g")) {
      // If the command has other arguments, display warning, return false
      if (command.length > 1) {
        System.out.println("WARNING: Unrecognized command.");
        return false;
      }
      return true; // Otherwise, command is valid, return true;
    }
    // When the command is "s"
    if (command[0].toLowerCase().trim().equals("s")) {
      // If the command has other arguments, display warning, return false
      if (command.length > 1) {
        System.out.println("WARNING: Unrecognized command.");
        return false;
      }
      return true; // Otherwise, command is valid, return true;
    }
    // When the command is "h"
    if (command[0].toLowerCase().trim().equals("h")) {
      // If the command has other arguments, display warning, return false
      if (command.length > 1) {
        System.out.println("WARNING: Unrecognized command.");
        return false;
      }
      return true; // Otherwise, command is valid, return true;
    }
    // When the command is "q"
    if (command[0].toLowerCase().trim().equals("q")) {
      // If the command has other arguments, display warning, return false
      if (command.length > 1) {
        System.out.println("WARNING: Unrecognized command.");
        return false;
      }
      return true; // Otherwise, command is valid, return true;
    }
    // If command is other letter, display warning, return false
    System.out.println("WARNING: Unrecognized command.");
    return false;
  }

  /**
   * This method is a helper method to displays the menu's content
   */
  private static void menuDisplay() {
    String menu =
        "\n=========================== Dictionary ============================\n"
            + "Enter one of the following options:\n"
            + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n"
            + "[L <word>] to search a word in the dictionary and display its definition\n"
            + "[G] to print all the words in the dictionary in sorted order\n"
            + "[S] to get the count of all words in the dictionary\n"
            + "[H] to get the height of this dictionary implemented as a binary search tree\n"
            + "[Q] to quit the program\n"
            + "======================================================================\n";
    System.out.println(menu);
    System.out.print("Please enter your command: ");
  }

  /**
   * This is a helper method to print the quit message when user quits the application
   */
  private static void quitMessage() {
    System.out.println(
        "============================== END ===================================");
  }

  /**
   * The main method is a driver of the dictionary application, to create a dictionary
   * which can provide user with function of adding, lookup, etc. by calling above methods
   * and some other methods in other classes
   * 
   * @param arg (input arguments if any)
   */
  public static void main(String arg[]) {
    // Create a new dictionary
    DictionaryBST dictionary = new DictionaryBST();
    // Create a scanner
    Scanner sc = new Scanner(System.in);
    // Declare a string type string to store user's commands
    String[] command;
    // A mark that to end the loop when user wants to quit the application
    boolean stop = false;

    // When user start the application, the loop starts as well
    while (!stop) {
      menuDisplay(); // First display the menu
      // Access user's input, turn it to lower case, remove front and rear white spaces
      // Split the whole input to at most three part if they can be separated
      command = sc.nextLine().split(" ", 3);
      // Call commandAccessor() to check if the user's command is valid with correct
      // format. Then start access user's requests
      if (commandAccessor(command) == true) {
        // Then check the user's command's type
        // When user's very first input is "a"
        if (command[0].toLowerCase().trim().equals("a")) {
          // Call createWord() with the second and third input to create a word
          // If the returned value is null, then the commands are invalid, continue the
          // loop
          if (createWord(command[1].trim(), command[2].trim()) == null) {
            continue;
          }
          // Otherwise, call helper method to add the word created successfully
          dictionaryAddWord(dictionary, createWord(command[1], command[2]));
        } else if (command[0].toLowerCase().trim().equals("l")) { // When user's first
                                                                  // input is "l"
          // Call the helper method dictionaryLoopup to find the word
          dictionaryLookup(dictionary, command[1].trim());
        } else if (command[0].toLowerCase().trim().equals("g")) { // When user's first
                                                                  // input is "g"
          // Call the helper method printDictionary() to print all words in the dictionary
          printDictionary(dictionary);
        } else if (command[0].toLowerCase().trim().equals("s")) { // When user's first
                                                                  // input is "s"
          // Display the number of words that already are in the dictionary
          System.out.println(dictionary.size());
        } else if (command[0].toLowerCase().trim().equals("h")) { // When user's first
                                                                  // input is "h"
          // Display the height of the dictionary, which is a BST
          System.out.println(dictionary.height());
        } else { // Otherwise, user's first input will be "q"
          // Change the boolean type mark, quit the application
          // Print the quit message
          stop = true;
          quitMessage();
        }
      }
    }
    sc.close(); // Close the scanner
  }

}
