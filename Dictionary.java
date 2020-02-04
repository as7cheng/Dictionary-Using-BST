//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Dictionary
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
 * This class is the Interface of Dictionary.
 * 
 * @author
 *
 */
public interface Dictionary {

  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if it is empty. Return false otherwise
   */
  public boolean isEmpty();

  /**
   * Adds this word definition (word and the provided meaning) to the dictionary
   * 
   * @param word Word to be added
   * @param meaning Meaning of this word
   * @return true if the word was successfully added to this dictionary. False if the word
   *         was already in the dictionary
   * @throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  public boolean addWord(String word, String meaning);

  /**
   * Lookup if the argument word is in the dictionary
   * 
   * @param s the word is wanted to lookup
   * @return the meaning of the word s if it is present in this dictionary
   * @throws a NoSuchElementException if the word s was not found in this dictionary
   */
  public String lookup(String s);

  /**
   * Gets the size of this dictionary
   * 
   * @return the number of words stored in this dictionary
   */
  public int size();

}
