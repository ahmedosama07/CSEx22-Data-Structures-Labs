import java.util.*;


class SLNode<T> {
    private T element;
    private SLNode<T> next;

    /**
     * Node constructor
     * @param e
     * @param n
     */
    public SLNode(T e, SLNode<T> n)
    {
        element = e;
        next = n;
    }

    /* Getters */
    /**
     * gets node data
     * @return node data
     */
    public T getElement()
    {
        return element;
    }
    /**
     * gets next node
     * @return next node
     */
    public SLNode<T> getNext()
    {
        return next;
    }

    /* Setters */
    /**
     * sets node's data
     * @param newElement
     */
    public void setElement(T newElement)
    {
        element = newElement;
    }
    /**
     * sets node's next node
     * @param newNext
     */
    public void setNext(SLNode<T> newNext)
    {
        next = newNext;
    }
}

interface ILinkedList<T> {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, T element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(T element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public T get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, T element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
}


class SingleLinkedList<T> implements ILinkedList<T> {
    private SLNode<T> head;
    private int length;

    SingleLinkedList() {
        this.head = null;
        length = 0;
    }

    public void add(int index, T element)
    {
        if (index < 0 || index > size())
        {
            System.out.println("Error");
            System.exit(0);
        }

        SLNode<T> newNode = new SLNode<T>(element, null);
        if (index == 0)
        {
            newNode.setNext(head);
            head = newNode;
        }
        else
        {
            SLNode<T> currNode = head;
            for (int i = 0; i < index - 1; ++i)
            {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
        ++length;
    }
    
    public void add(T element)
    {
        SLNode<T> newNode = new SLNode<T>(element, null);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            SLNode<T> currNode = head;
            while (currNode.getNext() != null)
            {
                currNode = currNode.getNext();
            }
            currNode.setNext(newNode);
        }
        ++length;
    }
    
    public T get(int index)
    {
        if (index < 0 || index >= size())
        {
            System.out.println("Error");
            return null;
        }
        SLNode<T> currNode = head;
        for (int i = 0; i < index; ++i)
        {
            currNode = currNode.getNext();
        }
        return currNode.getElement();
    }

    public void set(int index, T element)
    {
        if (index < 0 || index >= size())
        {
            System.out.println("Error");
            return;
        }

        SLNode<T> currNode = head;
        for( int i = 0; i < index; ++i)
        {
            currNode = currNode.getNext();
        }
        currNode.setElement(element);
    }
    
    public void clear()
    {
        head = null;
        length = 0;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void remove(int index)
    {
        if (index < 0 || index >= size())
        {
            System.out.println("Error");
            return;
        }
        if (index == 0)
        {
            head = head.getNext();
        }
        else
        {
            SLNode<T> currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            currNode.setNext(currNode.getNext().getNext());
        }
        --length;
    }
    
    public int size()
    {
        return length;
    }
    
    public boolean contains(T o)
    {
        SLNode<T> currNode = head;
        while (currNode != null)
        {
            if (currNode.getElement() == o)
            {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    public void printList()
    {
        System.out.print("[");
        SLNode<T> currNode = head;
        for(int i = 0; i < size(); ++i) {
            System.out.print(currNode.getElement());
            currNode = currNode.getNext();
            if(i != size() - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
  }


interface IStack<T> {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public T pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public T peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(T element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}


public class MyStack<T> implements IStack<T> {
  private SingleLinkedList<T> stack;

  public MyStack() {
    stack = new SingleLinkedList<T>();
  }

  public T pop() {
    if(stack.isEmpty()) {
      throw new RuntimeException("Error");
    }
    T elem = stack.get(0);
    stack.remove(0);
    return elem;
  }

  public T peek() {
    if(stack.isEmpty()) {
      throw new RuntimeException("Error");
    }
    return stack.get(0);
  }

  public void push(T element) {
    if (stack.isEmpty()) {
      stack.add(element);
    } 
    else {
      stack.add(0, element);
    }
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public int size() {
    return stack.size();
  }

  public void printStack() {
    stack.printList();
  }

    public static void main(String[] args) {
      try {
      MyStack<Integer> stack = new MyStack<Integer>();
      Scanner sc = new Scanner(System.in);
      String sin = sc.nextLine().replaceAll("\\[|\\]", "");
      //sc.close();
    	String[] s = sin.split(", ");
      if (!(s.length == 1 && s[0].isEmpty())) {
      
        for(int i = s.length-1; i >= 0; --i) {
              stack.push(Integer.parseInt(s[i]));
        }
      }
        
      String op = sc.nextLine();

      switch (op) {
        case "push":
          stack.push(sc.nextInt());
          stack.printStack();
          break;

        case "pop":
          stack.pop();
          stack.printStack();
          break;

        case "peek":
          System.out.println(stack.peek());
          break;

        case "isEmpty":
          System.out.println(String.valueOf(stack.isEmpty()).substring(0, 1).toUpperCase() 
                            + String.valueOf(stack.isEmpty()).substring(1));
          break;

        case "size":
          System.out.println(stack.size());
          break;
      
        default:
          System.out.println("Error");
          System.exit(0);
          break;
      }
      sc.close();
      } 
      catch (Exception e) {
          System.out.println("Error");
          System.exit(0);
      }
    }
}