/***********************************
* EECS2011 - Assignment 3
* File name: EmptyDequeException.java
* Author: U. T. Nguyen
************************************/

public class EmptyDequeException extends RuntimeException {

    /**
    * Constructs a new <code>EmptyQueueException</code> 
    */
   public EmptyDequeException( String err ) {
        super( err );}
}