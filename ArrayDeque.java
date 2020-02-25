/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Shihade Agha El-Rifai, Abdulla
* Email: rifaiabdulla7@gmail.com
* EECS username: abdullar
************************************/


public class ArrayDeque
{
   public static final int INIT_CAPACITY = 8;	// initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected int[] A;	    // array deque

   public ArrayDeque( )      // constructor method
   {
      A = new int[ INIT_CAPACITY ];
      capacity = INIT_CAPACITY;
      front = rear = 0;
   }


    /**
     * Display the content of the deque
     * 
     */
    public void printDeque( )
    {
      for ( int i = front; i != rear; i = (i+1) % capacity )
	System.out.print( A[i] + " " );
      System.out.println();
    }


    /**
     * Display the content of the whole array
     *
     */
    public void printArray( )
    {
	for ( int i = 0; i < capacity; i++ )
	   System.out.print( A[i] + " " );
	System.out.println();
    }


   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection. (Including the first element)
     * @return the number of items in this collection.
     */
    public int size( )
    {
      return (this.capacity - this.front + this.rear) % this.capacity; 
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
        return this.front == this.rear;
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException
    {
        if (this.isEmpty()) {
            throw new EmptyDequeException("This Array containes no elements!");
        }
        return this.A[this.front];      
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
        int result = 0;
    	if (!this.isEmpty()) {
            result = this.A[this.rear - 1];
        }
        else {
            throw new EmptyDequeException("This Circular Array is Empty!");
        }
        
        return result;
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
        //If rear == front we move it to the next valid index (which is 1 after the front)
        if (this.isEmpty()) {
            this.A[this.front] = e;
            this.rear++;
        }
        else {
            if (this.size() == this.capacity - 1) {
                this.handleFull();
            }
            //So when handleFull() executes the front will be at capacity - 1 index and rear is at index prevCapacity - 1 so this works out. 
            this.front = (this.front - 1 + this.capacity) % this.capacity;;
            this.A[this.front] = e;
        }  
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     *  *Abdulla Notes: we increase the size when we add elements and I used a private method to remove redundant code*
     */
    public void insertLast( int e )
    {
        this.A[this.rear] = e;
        this.rear = (this.rear + 1) % this.capacity;
        if (this.size() == this.capacity - 1) {
            this.handleFull();
        }
    }


    /**
     * Removes and returns the first element of the deque
     * *Abdulla Notes: we shrink when we remove elements and I used a private method to remove redundant code*
     */
    public int removeFirst( ) throws EmptyDequeException
    {
        int prevValue = 0; 
        if (!this.isEmpty()) {
            if (this.size() == this.capacity/4 && this.capacity != ArrayDeque.INIT_CAPACITY){
                this.shrinkArray();
            }
        prevValue = this.A[this.front];
        this.front = (this.front + 1) % this.capacity;
        }
        else {
            throw new EmptyDequeException("The Array is empty! Cannot remove element.");
        }
        return prevValue;  
    }


    /**
     * Removes and returns the last element of the deque
     *  *Abdulla Notes: we shrink when we remove elements and I used a private method to remove redundant code*
     */
    public int removeLast( ) throws EmptyDequeException
    {
        int prevValue = 0;
    	if (!this.isEmpty()) {
            if (this.size() == this.capacity/4 && this.capacity != ArrayDeque.INIT_CAPACITY){
                this.shrinkArray();
            }
            prevValue = this.A[this.rear - 1];
            this.rear = (this.rear - 1 + this.capacity) % this.capacity;
        }
        else {
            throw new EmptyDequeException("The Array is empty! Cannot remove element.");
        }

      return prevValue;   
    }

    private void handleFull() {
        int[]  prevArray = this.A.clone();
        int i = 0;
        this.A = new int[this.capacity * 2];
        while (!this.isEmpty()) {
            this.A[i++] = prevArray[this.front];
            this.front = (this.front + 1) % this.capacity;
        }

        this.front = 0;   this.rear = i;  this.capacity *= 2;
    }

    private void shrinkArray() {
        int[]  prevArray = this.A.clone();
        int i = 0;
        this.A = new int[capacity/2];
        while (!this.isEmpty()) {
            this.A[i++] = prevArray[this.front];
            this.front = (this.front + 1) % this.capacity; 
        }
        this.front = 0;   this.rear = i;  this.capacity /= 2;
    }

    public static void main(String[]args) {
        ArrayDeque a = new ArrayDeque();
        a.insertFirst(1);
        a.insertFirst(1);
        a.insertFirst(1);
        a.insertFirst(1);
        a.insertFirst(1);
        a.insertFirst(1);
        a.insertFirst(1);
        System.out.println(a.size());
        a.insertFirst(1);
        System.out.println(a.size());
        a.insertFirst(1);
        System.out.println(a.size());
    }
}  
