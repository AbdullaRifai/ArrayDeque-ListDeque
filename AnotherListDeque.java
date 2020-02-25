/***********************************
* EECS2011 - Assignment 3
* File name: AnotherListDeque.java
* Author: Shihade Agha El-Rifai, Abdulla
* Email: rifaiabdulla7@gmail.com
* EECS username: abdullar
************************************/


public class AnotherListDeque 
{

   protected DNode head, tail;  // head and tail contain actual data (int)

   protected int size;    // number of elements

   public AnotherListDeque()     // constructor: initialize an empty deque
   {
       head = tail = null;
       size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {

	for ( DNode p = head; p != null; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();

    }


   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
      //Although pretty simple but necessary a get method prevents the user from accessing the field directly (and tampering with it). (Java is return by refrence)
        return this.size;  
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
        return this.size() == 0;   
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {     
        if (this.isEmpty()) {
            throw new EmptyDequeException("This ListDeque contains no nodes!");
        }
        else if (this.head == null) {
            //If we start creating nodes and this.head != this.tail after deleting and inserting elements (and this.tail is the only element) return that.
            return this.tail.getElement();
        }

      return this.head.getElement();      
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
        if (isEmpty()) {
            throw new EmptyDequeException("This ListDeque contains no nodes!");
        }
        else if(this.tail == null) {
            return this.head.getElement();
        }  

      return this.tail.getElement();          
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	if (this.isEmpty()) {
            this.tail = this.head = new DNode(e, null, null);
        }
        else if(this.size == 1) {
            //Make a new object with new address and assign it to head and tail will have the previous value.
            this.head = new DNode(e, null, this.tail);
            this.tail.setPrev(this.head);
        }
        else {
            DNode prevHead = this.head;
            this.head = new DNode(e, null, prevHead);
            prevHead.setPrev(this.head);
        }  
        this.size++;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	if (this.isEmpty()) {
            this.head = this.tail = new DNode(e, null, null);
        }
        else if (this.size == 1) {
            //Here we need to assign a new Tail. (When the size is one both head and tail are the same)
            this.tail = new DNode(e, this.head, null);
            this.head.setNext(this.tail);
        }
        else {
            DNode prevTail = this.tail;
            this.tail = new DNode(e, prevTail, null);
            prevTail.setNext(this.tail);
        }
        this.size++;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
        //this.getFirst() checks for if Empty and throws the exception so we don't need to check again. 
        int prevVal = this.getFirst();

    	if (this.size() == 1) {
            //When there is only one object we remove that its the first and last element. 
            this.head = this.tail = null;
        }
        else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        this.size--;

        return prevVal;   
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
        int prevVal = this.getLast();

        if (this.size() == 1) {
            this.head = this.tail = null;
        }
        else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        this.size--;

        return prevVal; 
    }

    public static void main(String[]args)  {
        AnotherListDeque a = new AnotherListDeque();

        a.insertFirst(1);
        a.printDeque();
        a.insertLast(0);
        a.printDeque();
        System.out.println("FIRST= " + a.removeFirst());
        System.out.println("SIZE= " + a.size());
        System.out.println("FIRST= " + a.removeFirst());
        System.out.println("SIZE= " + a.size());
        a.removeFirst();
        a.printDeque();
    }

}
