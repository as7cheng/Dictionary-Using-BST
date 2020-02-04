//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DictionaryBST
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

/**
 * This class is a dictionary with the structure of binary search tree implements the
 * Interface Dictionary. Create a dictionary to access DictionaryWord
 * 
 * @author Shihan Cheng
 *
 */
public class DictionaryBST implements Dictionary {

  private DictionaryWord root; // The only field DictionaryWord in this class, stores the
                               // root of BST

  /**
   * This should be the only constructor of this class. Creates an empty dictionaryBST.
   */
  public DictionaryBST() {
    this.root = null;
  }

  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if it is empty. Return false otherwise
   */
  @Override
  public boolean isEmpty() {
    return this.root == null;
  }

  /**
   * Adds this word definition (word and the provided meaning) to the dictionary
   * 
   * @returns true if the word was successfully added to this dictionary Returns false if
   *          the word was already in the dictionary
   * @Throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  @Override
  public boolean addWord(String word, String meaning) {
    // If the dictionary is empty, set the new DictionaryWord as root, return true
    if (isEmpty()) {
      this.root = new DictionaryWord(word, meaning);
      return true;
    }
    // Otherwise, call the helper method
    return addWordHelper(new DictionaryWord(word, meaning), this.root);
  }

  /**
   * Lookup if the argument word is in the dictionary
   * 
   * @param s the word is wanted to lookup
   * @return the meaning of the word s if it is present in this dictionary
   * @throws a NoSuchElementException if the word s was not found in this dictionary
   */
  @Override
  public String lookup(String s) {
    // If the dictionary is empty, throw exception to display the error message
    if (this.root == null) {
      throw new NoSuchElementException("There are no definitions in this empty dictionary.");
    }
    return lookupHelper(s, this.root);
  }

  /**
   * Gets the size of this dictionary
   * 
   * @return the number of words stored in this dictionary
   */
  @Override
  public int size() {
    return sizeHelper(this.root);
  }

  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from
   * root to the deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord
   *         nodes
   */
  public int height() {
    return heightHelper(this.root);
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the
   *         ascendant order
   */
  public ArrayList<String> getAllWords() {
    return getAllWordsHelper(this.root);
  }

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current the current DictionaryWord that is the root of the subtree where
   *        newWord will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false
   *         otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode,
      DictionaryWord current) {
    // Base case. If current word is null, set it with the argument's data
    if (current == null) {
      current = new DictionaryWord(newWordNode.getWord(), newWordNode.getMeaning());
      // Adding word successfully
      return true;
    } else { // Recursive cases
      // When current word equals the argument, then argument is already in the dictionary
      if (current.getWord().toLowerCase()
          .compareTo(newWordNode.getWord().toLowerCase()) == 0) {
        // Adding word unsuccessfully
        return false;
      }
      // When the current word is lexicographically greater than argument word
      if (current.getWord().toLowerCase()
          .compareTo(newWordNode.getWord().toLowerCase()) > 0) {
        // Check current word's left child
        // If current word's left child is null
        if (current.getLeftChild() == null) {
          // Then set the argument as current word's left child
          current.setLeftChild(newWordNode);
          // Adding word successfully
          return true;
        } else { // Otherwise, do the recursion with current word's left child
          return addWordHelper(newWordNode, current.getLeftChild());
        }
      } else { // When the current word is lexicographically less than argument word
        // Check current word's right child
        // If current word's right child is null
        if (current.getRightChild() == null) {
          // Then set the argument as current word's right child
          current.setRightChild(newWordNode);
          // Adding word successfully
          return true;
        } else { // Otherwise, do the recursion with current word's right child
          return addWordHelper(newWordNode, current.getRightChild());
        }
      }
    }
  }

  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    // Base case. If current word is null, then lookup failed. Throw exception
    if (current == null) {
      throw new NoSuchElementException("No definition found for the word " + s);
    }
    // When current word matches the argument string, return current word's meaning
    if (current.getWord().toLowerCase().compareTo(s.toLowerCase().trim()) == 0) {
      return current.getMeaning();
    }
    // When current word is lexicographically greater than the argument string
    if (current.getWord().toLowerCase().compareTo(s.toLowerCase().trim()) > 0) {
      // Do the recursion with current word's left child
      return lookupHelper(s, current.getLeftChild());
    } else { // Otherwise, do the recursion with current word's right child
      return lookupHelper(s, current.getRightChild());
    }
  }

  /**
   * Recursive helper method that returns the number of dictionary words stored in the
   * subtree rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    // Base case. When current word is null, return 0
    if (current == null) {
      return 0;
    }
    // Recursion. Check all the children and return value
    return 1 + sizeHelper(current.getLeftChild()) + sizeHelper(current.getRightChild());
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord
   *         nodes from the current node to the deepest leaf in the subtree rooted at
   *         current
   */
  private static int heightHelper(DictionaryWord current) {
    // Base case. When current word is null, return 0
    if (current == null) {
      return 0;
    }
    // Recursion with all the children
    // Return the max number at the end
    return java.lang.Math.max(1 + heightHelper(current.getLeftChild()),
        1 + heightHelper(current.getRightChild()));
  }

  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree
   * rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    // Create a new array list to store all the words
    ArrayList<String> allWords = new ArrayList<String>();
    // Base case. When current word is null, return the empty array list
    if (current == null) {
      return allWords;
    } else { // If current word is not null, add it to the array list
      // Then check all children from left to right
      // Do the recursion with all words' left child, add them into list
      allWords.addAll(getAllWordsHelper(current.getLeftChild()));
      // Once recursion stops, add the word into the array list
      allWords.add(current.getWord());
      // Then do the recursion with all words' right child, add them into list
      allWords.addAll(getAllWordsHelper(current.getRightChild()));
      // Then return the array list with all elements in the dictionary
      return allWords;
    }
  }

}
