# ArrayDeque-ListDeque
## 1. Circular Arrays (ArrayDeque.java file)

Instructions (Provided by the professor):
- When a new element is to be inserted into a deque and the array is full, do not throw en exception. Extend the array by doubling its capacity and insert the element into the new array. Use an initial array size of INIT_CAPACITY = 8.

- Shrink the array by half the current capacity N when the number of elements in the deque falls below N/4 (but the minimum capacity, INIT_CAPACITY, should always be 8).

- Complete the "blank" methods in file ArrayDeque.java. 
***
I implemented this using the array structure (To summarize it is an implementation of a circular array ADT with the request functionality, such as: isEmpty(), size(), getFirst(), getLast(), insertFirst(), insertLast(), removeFirst() and removeLast()). 
> For specific details on the implementation it is the ArrayDeque.java file (it has comments to make things more clear)

## 2. Doubly linked lists with header and trailer dummy nodes (ListDeque.java file)

Instructions: 
- Complete the "blank" methods in file ListDeque.java. Class DNode is implemented in file DNode.java. 
***
This was designed using the Doubly linked lists with fixed header and trailer dummy nodes, we were provided the DNode.java file and we had to implement the same functionality from the above class.  
> For specific details on the implementation it is the ListDeque.java file (it has comments to make things more clear as well)

## 3. Doubly linked lists without fixed header or trailer dummy nodes (AnotherListDeque.java file)

Instructions: 
- Use variables head and tail to keep track of the front and rear of the deque. Variables head and tail are not dummy nodes: they contain actual data elements of the deque.
- Complete the "blank" methods in file AnotherListDeque.java. Class DNode is implemented in file DNode.java.
***
Implementation was similar to that of the ListDeque.java file but with the added challenge of the variable dummy nodes, I feel that having the dummy nodes can increase productivity since implementing the class without the dummy nodes took more time than implementing the class with the fixed dummy nodes.
> For specific details on the implementation it is the AnotherListDeque.java file (it has comments to make things more clear)

**In Conclusion**: I feel that implementing these classes helped me gain more insight into these respective data structures and how they work. As well as I learned that we cannot reach the most optimized solution at first glance, so implementing the brute force solution and optimizing where possible is a more productive approach. 

Thank you for taking the time to read over my work! 
