package Stacks;
public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack
  protected int numberOfElements;
  protected int currentIndex;
  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }
  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }
  
  public int size() {
	 int size=0;
	 boolean done = false;
	 while(!done) {
		 for(int n=0;n<elements.length;n++) {
			 if(elements[n]!=null) {
				 size++;
			 }
			 else {
				 done = true;
			 }
		 }
	 }
	return size;
  }
  public String toString(){
	  String contents = "";
		  for (int n = topIndex; n >=0; n--) {
			  contents = String.valueOf(elements[n] + " " + contents);
		  }
		  return contents;
	  }
  public void popSome(int count) {
	  if (isEmpty())
	      throw new StackUnderflowException("Pop attempted on an empty stack.");
	  if(count == 1) {
		  pop();
	  }
	  else {
		  pop();
		  popSome(count-1);
	  }
  }
  public T popTop()
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      Object top = elements[topIndex];
      elements[topIndex] = null;
      topIndex--;
      return (T) top;
    }
  }
  public boolean swapTop() {
	  if(isEmpty()) {
		  return false;
	  }
	  T newTop = elements[topIndex-1];
	  T oldTop = elements[topIndex];
	  elements[topIndex] = newTop;
	  elements[topIndex-1] = oldTop;
	 //System.out.println(elements[topIndex]);
	 //System.out.println(elements[topIndex-1]);
	return true;
  }
  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }
  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
    	Object top = elements[topIndex];
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }
 
  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }

}
