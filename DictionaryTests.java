//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DictionaryTests
// Files: DictionaryTests.java, Dictionary.java, DictionaryWord.java, DictionaryBST.java,
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

/**
 * This class tests if the classes DictionaryWord(), DictionaryBST work well by using
 * methods to implement their behaviors
 * 
 * @author Shihan Cheng
 *
 */
public class DictionaryTests {

  /**
   * This method tests if the class DictionaryWord() works well
   * 
   * @return true if once the DictionaryWord is created, its word, meaning, left child and
   *         right child are correct. Otherwise, return false
   */
  public static boolean testDictionaryWord() {
    // Create three new words with mixed upper and lower case letters
    DictionaryWord word = new DictionaryWord("a", "b");
    DictionaryWord left = new DictionaryWord("l", "Left");
    DictionaryWord right = new DictionaryWord("R", "Right");
    // Set word's left child and right child
    word.setLeftChild(left);
    word.setRightChild(right);
    // If the word's word is not "a", display the error message and return false
    if (!word.getWord().equals("a")) {
      System.out.println("DictionaryWord's word is incorrect");
      return false;
    }
    // If the word's meaning is not "b", display the error message and return false
    if (!word.getMeaning().equals("b")) {
      System.out.println("DictionaryWord's meaning is incorrect");
      return false;
    }
    // If the word's left child is displayed in ruled format, display the error message
    // and return false
    if (!word.getLeftChild().toString().equals("l: Left")) {
      System.out.println(word.getLeftChild().toString());
      return false;
    }
    // If the word's right child does not match the one we create, display the error
    // message and return false
    if (!word.getRightChild().equals(right)) {
      return false;
    }
    // Otherwise, it works well. Return true
    return true;
  }

  /**
   * This method tests if the methods addWord() and addWordHelper() in class DictionaryBST
   * work well
   * 
   * @return true if the word is added successfully, duplicated word added unsuccessfully.
   *         Otherwise, return false
   */
  public static boolean testDictionaryBSTAddWord() {
    DictionaryBST list = new DictionaryBST(); // Create a new dictionaryBST
    list.addWord("large", "big"); // Add two new words in
    list.addWord("Tiney", "sMall");

    // If the list is still empty, add words unsuccessfully, display error message and
    // return false
    if (list.isEmpty()) {
      System.out.println("List is empty.");
      return false;
    }
    // If the list's size is not 2, add two words unsuccessfully, display size and return
    // false
    if (list.size() != 2) {
      System.out.println(list.size());
      return false;
    }
    // If adding duplicated word successfully, addWord() works failed, display error
    // message and return false
    if (list.addWord("large", "big") != false) {
      System.out.println("Duplicated word added.");
      return false;
    }
    // Otherwise, two methods work well
    return true;
  }

  /**
   * This method tests if the lookup() and lookupHelper() work well in class
   * DictionaryBST() work well
   * 
   * @return true if return correct meaning when word exists in the dictionary, or throw
   *         NoSuchElementException when word does not exist. Otherwise, return false
   */
  public static boolean testDictionaryBSTLookup() {
    DictionaryBST list = new DictionaryBST(); // Create a new dictionaryBST
    list.addWord("word", "meaning"); // Add two words in
    list.addWord("big", "large");

    try { // Try to lookup a word which is not in the dictionary
      list.lookup("normal"); // If lookupHelper throws exception, return false
      return false;
    } catch (NoSuchElementException e) {
    }
    // Lookup first word and check if the returned value matches the first word's meaning
    if (list.lookup("word").compareTo("meaning") != 0) {
      System.out.println("Lookup for \"word\" failed.");
      return false;
    }
    // Lookup second word and check if the returned value matches the second word's
    // meaning
    if (list.lookup("big").compareTo("large") != 0) {
      System.out.println("Lookup for \"big\" failed.");
      return false;
    }
    // Otherwise, two methods work well
    return true;
  }

  /**
   * This method uses two cases to check if height() and heightHealper() methods in class
   * DictionaryBST work well
   * 
   * @return true if the height is correct. Otherwise, return false
   */
  public static boolean testDictionaryBSTHeight() {
    { // Case 1. Make the nodes in BST only have right child, then it is a linear
      // structure
      // The height would be as same as size
      DictionaryBST list = new DictionaryBST(); // Create a new DictionaryBST
      // Add words in
      list.addWord("a", "1");
      list.addWord("b", "2");
      list.addWord("c", "3");
      list.addWord("d", "4");
      // Check if height equals size. If not, display the error message and return false
      if (list.height() != list.size()) {
        System.out.println(
            "height should be equal to size, but acctual height is " + list.height());
        return false;
      }
    }
    { // Case 2. Make a general BST, height should be number of root to the deepest leaf
      // inclusively
      DictionaryBST list = new DictionaryBST(); // Create a new DictionaryBST
      // Add words in
      list.addWord("f", "1");
      list.addWord("e", "2");
      list.addWord("a", "3");
      list.addWord("c", "4");
      list.addWord("g", "5");
      list.addWord("b", "6");
      // Check if height equals 5. If not, display the error message and return false
      if (list.height() != 5) {
        System.out.println("height should be 5, but acctual height is " + list.height());
        return false;
      }
    }
    return true; // Otherwise, methods work well
  }

  /**
   * This method check if getAllWords() in class DictionaryBST work well
   * 
   * @return true if getAllWords() return an ArrayList contains all words sorted in order
   *         from lexicographically small to large. Otherwise, return false
   */
  public static boolean testDictionaryBSTGetALlWords() {
    DictionaryBST list = new DictionaryBST(); // Create a new DictionaryBST
    // Add words in
    list.addWord("ad", "4");
    list.addWord("ab", "2");
    list.addWord("aa", "1");
    list.addWord("ac", "3");
    // Create a new ArrayList to store above words in expected order
    ArrayList<String> match = new ArrayList<String>();
    match.add("aa");
    match.add("ab");
    match.add("ac");
    match.add("ad");
    // In this case, the ArrayList returned by getAllWords() should contain all four words
    // and sort them in order aa, ab, ac, ad
    // First, check if the ArrayList has the correct size
    if (list.size() != match.size()) {
      System.out.println("getAllWords() returned ArrayList should have size of "
          + match.size() + ", but size is " + list.size());
      return false;
    }
    // Create a for loop to check if the words is at correct position
    for (int i = 0; i < list.getAllWords().size(); i++) {
      // If words are not at correct position, display the error message and return false
      if (list.getAllWords().get(i).compareTo(match.get(i)) != 0) {
        System.out.print("The index " + i + " should be " + match.get(i) + ", but it is "
            + list.getAllWords().get(i));
        return false;
      }
    }
    return true; // Otherwise, getAllWords() works well
  }

  /**
   * The main method calls all the test methods above and print the messages for
   * displaying the test outcomes
   * 
   * @param arg (input arguments if any)
   */
  public static void main(String arg[]) {
    if (testDictionaryWord()) { // Call method 1
      System.out.println("testDictionaryWord(): passed");
    } else {
      System.out.println("testDictionaryWord(): failed");
    }
    if (testDictionaryBSTAddWord()) { // Call method 2
      System.out.println("testDictionaryBSTAddWord(): passed");
    } else {
      System.out.println("testDictionaryBSTAddWord(): failed");
    }
    if (testDictionaryBSTGetALlWords()) { // Call method 3
      System.out.println("testDictionaryBSTGetALlWords(): passed");
    } else {
      System.out.println("testDictionaryBSTGetALlWords(): failed");
    }
    if (testDictionaryBSTLookup()) { // Call method 4
      System.out.println("testDictionaryBSTLookup(): passed");
    } else {
      System.out.println("testDictionaryBSTLookup(): failed");
    }
    if (testDictionaryBSTHeight()) { // Call method 5
      System.out.println("testDictionaryBSTHeight(): passed");
    } else {
      System.out.println("testDictionaryBSTHeight(): failed");
    }
  }

}
