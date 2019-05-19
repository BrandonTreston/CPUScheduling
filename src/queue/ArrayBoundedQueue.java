package queue;

import Stacks.StackUnderflowException;

public class ArrayBoundedQueue<T> implements QueueInterface<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array that holds queue elements
  protected int numElements = 0;    // number of elements in this queue
  protected int front = 0;          // index of front of queue
  protected int rear;               // index of rear of queue  

  @SuppressWarnings("unchecked")
public ArrayBoundedQueue() 
  {
    elements = (T[]) new Object[DEFCAP];
    rear = DEFCAP - 1;
  }

  @SuppressWarnings("unchecked")
public ArrayBoundedQueue(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
    rear = maxSize - 1;
  }
  
  public String toString(){
	  String contents = "";
		  for (int n = rear; n >=0; n--) {
			  if (String.valueOf(elements[n])!= "null") {
				  contents = String.valueOf(elements[n] + " " + contents);
			  }
		  }
		  return contents;
	  }
  public int space() {
	  int spaces = elements.length;
	  for (int n = 0; n<= elements.length;n++) {
		  if (elements[n] != null) {
			  spaces--;
		  }
		  else {n=elements.length+1;}
	  }
	  return spaces;
  }
  public void remove(int count) {
	  if (isEmpty()||elements.length<count)
	      throw new StackUnderflowException("Queue is too short!");
	  if(count == 1) {
		  dequeue();
	  }
	  else {
		  dequeue();
		  remove(count-1);
	  }
  }
  public boolean swapStart() {
	  if(isEmpty()||elements.length<2) {
		  return false;
	  }
	  T newFront = elements[front+1];
	  T oldFront = elements[front];
	  elements[front] = newFront;
	  elements[front+1] = oldFront;
	 //System.out.println(elements[front]);
	 //System.out.println(elements[front+1]);
	return true;
  }
  public boolean swapEnds() {
	  if(isEmpty()||elements.length<2) {
		  return false;
	  }
	  T newFront = elements[rear];
	  T oldFront = elements[front];
	  elements[front] = newFront;
	  elements[rear] = oldFront;
	 //System.out.println(elements[front]);
	 //System.out.println(elements[rear]);
	return true;
  }
  public void enqueue(T element)
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.
  {  
    if (isFull())
      throw new QueueOverflowException("Enqueue attempted on a full queue.");
    else
    {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
    }
  }
  
  public T getFront() {
	  return elements[front];
  }
  
  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {   
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (numElements == 0);
  }

  public boolean isFull()
  // Returns true if this queue is full; otherwise, returns false.
  {              
    return (numElements == elements.length);
  }
  
  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }

  public T get(int i) {
	return elements[i];
}
  
}