/***********************************
* EECS2011 - Assignment 3
* File name: ListDeque.java
* Author: Shihade Agha El-Rifai, Abdulla
* Email: rifaiabdulla7@gmail.com
* EECS username: abdullar
************************************/


public class ListDeque 
{

   protected DNode header, trailer;  // dummy nodes

   protected int size;    // number of elements

   public ListDeque()     // constructor: initialize an empty deque
   {
      header = new DNode( 0, null, null );
      trailer = new DNode( 0, null, null );
      header.setNext(trailer);  // make header point to trailer
      trailer.setPrev(header);  // make trailer point to header
      size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {
	for ( DNode p = header.getNext(); p != trailer; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();
    }



   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection. (Excluding head and tail ofcourse)
     * @return the number of items in this collection.
     */
    public int size( )
    {
      return this.size;   
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
      //Another concrete way of displaying this is if header.next == trailer. 
      return this.size() == 0;   
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {
      if(this.isEmpty()) {
        throw new EmptyDequeException("This List is Empty!");
      }
      else {
        return this.header.getNext().getElement();
      }
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
      if(this.isEmpty()) {
        throw new EmptyDequeException("This List is Empty!");
      }
      else {
        return this.trailer.getPrev().getElement();
      }
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
      //Made prevFirst for clarity and since DNode uses Aggregation so prevFirst and the this.head.getNext() are pointing to the same DNode. (Not a copy of a Node) 
      DNode prevFirst = this.header.getNext();
      DNode insertedElem = new DNode(e, this.header, prevFirst);

      this.header.setNext(insertedElem);
      prevFirst.setPrev(insertedElem);

      this.size++;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
      DNode prevLast = this.trailer.getPrev();
      DNode insertedElem = new DNode(e, prevLast, this.trailer);

      prevLast.setNext(insertedElem);
      this.trailer.setPrev(insertedElem);

      this.size++;
    }


    /**
     * Removes and returns the first element of the deque
     * *Abdulla:  I also considered the corner case where if there is 1 element and this.header.getNext().getNext() points to this.trailer.
     */
    public int removeFirst( ) throws EmptyDequeException
    {
      //this.getFirst() if It is empty we throw an EmptyDequeException (So no need to check again)
      int prevElem = this.getFirst();
      DNode newFirst = this.header.getNext().getNext();
      DNode prevFirst = this.header.getNext();

      //Now since it points at nothing the garbage collection will take care of it. 
      prevFirst.setNext(null);
      prevFirst.setPrev(null);

      this.header.setNext(newFirst);
      newFirst.setPrev(this.header);

      this.size--;

      return prevElem;
      
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
      //this.getLast() will take care of the case where it is empty and throw an EmptyDequeException (So no need to check again)
      int prevElem = this.getLast();
      DNode newLast = this.trailer.getPrev().getPrev();
      DNode prevLast = this.trailer.getPrev();

      prevLast.setNext(null);
      prevLast.setPrev(null);

      this.trailer.setPrev(newLast);
      newLast.setNext(this.trailer);

      this.size--;

      return prevElem;   
    }

    public static void main(String[] args) {
      ListDeque a = new ListDeque();
      a.insertFirst(1);
      a.insertLast(2);
      a.insertFirst(0);
      a.removeFirst();
      a.removeFirst();
      a.removeFirst();
      a.removeFirst();
      //Should be EmptyDequeException. 
      a.printDeque();
      System.out.println(a.size());
    }
} 
