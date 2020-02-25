/***********************************
* EECS2011 - Assignment 3
* File name: DNode.java
* Author: U. T. Nguyen
************************************/


/** Node of a doubly linked list of integers */
public class DNode {
    protected int element;	// int element stored by a node
    protected DNode next, prev;	// pointers to next and previous nodes
  
    /** Constructor that creates a node with given fields */
    public DNode(int e, DNode p, DNode n) {
      element = e;
      prev = p;
      next = n;
    }
  
    /** Returns the element of this node */
    public int getElement() { return element; }
  
    /** Returns the previous node of this node */
    public DNode getPrev() { return prev; }
  
    /** Returns the next node of this node */
    public DNode getNext() { return next; }
  
    /** Sets the element of this node */
    public void setElement(int newElem) { element = newElem; }
  
    /** Sets the previous node of this node */
    public void setPrev(DNode newPrev) { prev = newPrev; }
  
    /** Sets the next node of this node */
    public void setNext(DNode newNext) { next = newNext; }
  }
  