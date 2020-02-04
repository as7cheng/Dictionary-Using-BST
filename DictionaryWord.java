//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DictionaryWord
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

/**
 * This class is NOT a generic class and it models a binary node of a Binary Search Tree.
 * Each binary node (aka instance of DictionaryWord) defines its data consisting of a pair
 * of word and its meaning, and a link to each child (right and left) of the node.
 * 
 * @author Shihan Cheng
 *
 */
public class DictionaryWord {
  private final String word; // Word represents the search key for this dictionary word
  private final String meaning; // The meaning of the word that this dictionary node
                                // defines
  private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

  /**
   * The only constructor for this class. Creates a new dictionary word with the provided
   * word and its meaning pair
   * 
   * @param word Word represents the search key for this dictionary word
   * @param meaning The meaning of the word that this dictionary node defines
   * @throws IllegalArgumentException when the word or meaning are either references to an
   *         empty string or null references. The thrown exception should include a
   *         significant error message describing which of these problems was encounted.
   */
  public DictionaryWord(String word, String meaning) {
    // When the word is null, throw exception
    if (word == null) {
      throw new IllegalArgumentException("Warning: Parameter word is null.");
    }
    // When the meaning is null, throw exception
    if (meaning == null) {
      throw new IllegalArgumentException("Warning: Parameter meaning is null.");
    }
    // When the word is empty, throw exception
    if (word.isEmpty()) {
      throw new IllegalArgumentException("Warning: Parameter word is empty.");
    }
    // when the meaning is empty, throw exception
    if (meaning.isEmpty()) {
      throw new IllegalArgumentException("Warning: Parameter meaning is empty.");
    }
    // Otherwise, create a new DictionaryWord
    this.word = word.trim();
    this.meaning = meaning.trim();
    this.leftChild = null;
    this.rightChild = null;
  }

  /**
   * Getter for the left child of this dictionary word
   * 
   * @return this DictionaryWord's left child
   */
  public DictionaryWord getLeftChild() {
    return this.leftChild;
  }

  /**
   * Setter for the left child of this dictionary word
   * 
   * @param leftChild Word to be set
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Getter for the right child of this dictionary word
   * 
   * @return this DictionaryWord's right child
   */
  public DictionaryWord getRightChild() {
    return this.rightChild;
  }

  /**
   * Setter for the right child of this dictionary word
   * 
   * @param rightChild Word to be set
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * Getter for the word of this dictionary word
   * 
   * @return this DictionaryWord's word
   */
  public String getWord() {
    return this.word;
  }

  /**
   * Getter for the meaning of the word of this dictionary word
   * 
   * @return this DictionaryWord's meaning
   */
  public String getMeaning() {
    return this.meaning;
  }

  /**
   * Create a String be formatted as follows. "<word>: <meaning>"
   * 
   * @return a String representation of this DictionaryWord.
   */
  public String toString() {
    String dictionaryWord = ""; // Declare a String
    // Combine the DictionaryWord's word and meaning, return the String
    dictionaryWord = dictionaryWord + this.word + ": " + this.meaning;
    return dictionaryWord;
  }

}
