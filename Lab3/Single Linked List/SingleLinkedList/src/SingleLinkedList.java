import java.util.*;

class SLNode {
    private Object element;
    private SLNode next;

    /**
     * Node constructor
     * @param e
     * @param n
     */
    public SLNode(Object e, SLNode n)
    {
        element = e;
        next = n;
    }

    /* Getters */
    /**
     * gets node data
     * @return node data
     */
    public Object getElement()
    {
        return element;
    }
    /**
     * gets next node
     * @return next node
     */
    public SLNode getNext()
    {
        return next;
    }

    /* Setters */
    /**
     * sets node's data
     * @param newElement
     */
    public void setElement(Object newElement)
    {
        element = newElement;
    }
    /**
     * sets node's next node
     * @param newNext
     */
    public void setNext(SLNode newNext)
    {
        next = newNext;
    }
}

    

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
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
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class SingleLinkedList implements ILinkedList {
    private SLNode head;

    SingleLinkedList() {
        this.head = null;
    }

    public void add(int index, Object element)
    {
        if (index < 0 || index > size())
        {
            System.out.println("Error");
            return;
        }

        SLNode newNode = new SLNode(element, null);
        if (index == 0)
        {
            newNode.setNext(head);
            head = newNode;
        }
        else
        {
            SLNode currNode = head;
            for (int i = 0; i < index - 1; ++i)
            {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
    }
    
    public void add(Object element)
    {
        SLNode newNode = new SLNode(element, null);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            SLNode currNode = head;
            while (currNode.getNext() != null)
            {
                currNode = currNode.getNext();
            }
            currNode.setNext(newNode);
        }
    }
    
    public Object get(int index)
    {
        if (index < 0 || index >= size())
        {
            System.out.println("Error");
            return null;
        }
        SLNode currNode = head;
        for (int i = 0; i < index; ++i)
        {
            currNode = currNode.getNext();
        }
        return currNode.getElement();
    }

    public void set(int index, Object element)
    {
        if (index < 0 || index >= size())
        {
            System.out.println("Error");
            return;
        }

        SLNode currNode = head;
        for( int i = 0; i < index; ++i)
        {
            currNode = currNode.getNext();
        }
        currNode.setElement(element);
    }
    
    public void clear()
    {
        head = null;
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
            SLNode currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            currNode.setNext(currNode.getNext().getNext());
        }
    }
    
    public int size()
    {
        int length = 0;
        SLNode currNode = head;
        while (currNode != null) {
            length++;
            currNode = currNode.getNext();
        }
        return length;
    }
    
    public SingleLinkedList sublist(int fromIndex, int toIndex)
    {
        if (fromIndex < 0 || fromIndex >= size() || toIndex < 0 || toIndex >= size() || fromIndex > toIndex)
        {
            System.out.println("Error");
            return null;
        }
        SingleLinkedList subList = new SingleLinkedList();
        SLNode currNode = head;
        for (int i = 0; i <= toIndex; ++i)
        {
            if (i >= fromIndex)
            {
                subList.add(currNode.getElement());
            }
            currNode = currNode.getNext();
        }

        return subList;
    }
    
    public boolean contains(Object o)
    {
        SLNode currNode = head;
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

    private void printList()
    {
        System.out.print("[");
        SLNode currNode = head;
        // if (head == null) return;
        for(int i = 0; i < size(); ++i) {
            System.out.print(currNode.getElement());
            currNode = currNode.getNext();
            if(i != size() - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");;
            //int[] arr = new int[s.length];
            SingleLinkedList list = new SingleLinkedList();
            if (!(s.length == 1 && s[0].isEmpty()))
            {
                for(int i = 0; i < s.length; ++i)
            	   {
                    try {
                        list.add(Integer.parseInt(s[i]));
                    } catch (Exception e) {
                        System.out.println("Error");
                        return;
                    }
                   }
            }
            

            String[] op = new String[3];
            op[0] = sc.nextLine();
            // System.out.println(list.size());
            // System.out.println(op);

            switch (op[0])
            {
                case "add":
                    op[1] = sc.nextLine();
                    list.add(Integer.parseInt(op[1]));
                    list.printList();
                    break;
                case "addToIndex":
                    op[1] = sc.nextLine();
                    op[2] = sc.nextLine();
                    list.add(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
                    if(Integer.parseInt(op[1]) > list.size() || Integer.parseInt(op[1]) < 0) break;
                    list.printList();
                    break;
                case "get":
                    op[1] = sc.nextLine();
                    Object val = list.get(Integer.parseInt(op[1]));
                    if (val == null) break;
                    System.out.println(val);
                    break;
                case "set":
                    op[1] = sc.nextLine();
                    op[2] = sc.nextLine();
                    list.set(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
                    if(list.size() == 0 || Integer.parseInt(op[1]) >= list.size() || Integer.parseInt(op[1]) < 0) break;
                    list.printList();
                    break;
                case "clear":
                    list.clear();
                    list.printList();
                    break;
                case "isEmpty":
                    boolean isEmpty = list.isEmpty();
                    System.out.println(String.valueOf(isEmpty).substring(0, 1).toUpperCase() + String.valueOf(isEmpty).substring(1));
                    break;
                case "remove":
                    op[1] = sc.nextLine();
                    int sz = list.size();
                    list.remove(Integer.parseInt(op[1]));
                    if ((Integer.parseInt(op[1]) >= list.size() || Integer.parseInt(op[1]) < 0) && sz == list.size()) break;
                    list.printList();
                    break;
                case "sublist":
                    op[1] = sc.nextLine();
                    op[2] = sc.nextLine();
                    SingleLinkedList subList = list.sublist(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
                    if (subList == null) break;
                    subList.printList();
                    break;
                case "contains":
                    op[1] = sc.nextLine();
                    boolean isAvail = list.contains(Integer.parseInt(op[1]));
                    System.out.println(String.valueOf(isAvail).substring(0, 1).toUpperCase() + String.valueOf(isAvail).substring(1));
                    break;
                case "size":
                    int size = list.size();
                    System.out.println(size);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            sc.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}