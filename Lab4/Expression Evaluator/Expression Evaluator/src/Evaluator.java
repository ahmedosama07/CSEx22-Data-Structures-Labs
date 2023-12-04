import java.util.*;

class SLNode<T> {
    private T element;
    private SLNode<T> next;

    /**
     * Node constructor
     * 
     * @param e
     * @param n
     */
    public SLNode(T e, SLNode<T> n) {
        element = e;
        next = n;
    }

    /* Getters */
    /**
     * gets node data
     * 
     * @return node data
     */
    public T getElement() {
        return element;
    }

    /**
     * gets next node
     * 
     * @return next node
     */
    public SLNode<T> getNext() {
        return next;
    }

    /* Setters */
    /**
     * sets node's data
     * 
     * @param newElement
     */
    public void setElement(T newElement) {
        element = newElement;
    }

    /**
     * sets node's next node
     * 
     * @param newNext
     */
    public void setNext(SLNode<T> newNext) {
        next = newNext;
    }
}

interface ILinkedList<T> {
    /**
     * Inserts a specified element at the specified position in the list.
     * 
     * @param index
     * @param element
     */
    public void add(int index, T element);

    /**
     * Inserts the specified element at the end of the list.
     * 
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
     * 
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
     * 
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
     * @return a view of the portion of this list between the specified fromIndex
     *         and toIndex, inclusively.
     */
}

class SingleLinkedList<T> implements ILinkedList<T> {
    private SLNode<T> head;
    private int length;

    SingleLinkedList() {
        this.head = null;
        length = 0;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            System.out.println("Error");
            System.exit(0);
        }

        SLNode<T> newNode = new SLNode<T>(element, null);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            SLNode<T> currNode = head;
            for (int i = 0; i < index - 1; ++i) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
        ++length;
    }

    public void add(T element) {
        SLNode<T> newNode = new SLNode<T>(element, null);
        if (head == null) {
            head = newNode;
        } else {
            SLNode<T> currNode = head;
            while (currNode.getNext() != null) {
                currNode = currNode.getNext();
            }
            currNode.setNext(newNode);
        }
        ++length;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Error");
            return null;
        }
        SLNode<T> currNode = head;
        for (int i = 0; i < index; ++i) {
            currNode = currNode.getNext();
        }
        return currNode.getElement();
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size()) {
            System.out.println("Error");
            return;
        }

        SLNode<T> currNode = head;
        for (int i = 0; i < index; ++i) {
            currNode = currNode.getNext();
        }
        currNode.setElement(element);
    }

    public void clear() {
        head = null;
        length = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Error");
            return;
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            SLNode<T> currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            currNode.setNext(currNode.getNext().getNext());
        }
        --length;
    }

    public int size() {
        return length;
    }

    public boolean contains(T o) {
        SLNode<T> currNode = head;
        while (currNode != null) {
            if (currNode.getElement() == o) {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    public void printList() {
        System.out.print("[");
        SLNode<T> currNode = head;
        for (int i = 0; i < size(); ++i) {
            System.out.print(currNode.getElement());
            currNode = currNode.getNext();
            if (i != size() - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}

interface IStack<T> {

    /***
     * Removes the element at the top of stack and returnsthat element.
     * 
     * @return top of stack element, or through exception if empty
     */

    public T pop();

    /***
     * Get the element at the top of stack without removing it from stack.
     * 
     * @return top of stack element, or through exception if empty
     */

    public T peek();

    /***
     * Pushes an item onto the top of this stack.
     * 
     * @param object to insert*
     */

    public void push(T element);

    /***
     * Tests if this stack is empty
     * 
     * @return true if stack empty
     */
    public boolean isEmpty();

    public int size();
}

class MyStack<T> implements IStack<T> {
    private SingleLinkedList<T> stack;

    public MyStack() {
        stack = new SingleLinkedList<T>();
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Error");
        }
        T elem = stack.get(0);
        stack.remove(0);
        return elem;
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Error");
        }
        return stack.get(0);
    }

    public void push(T element) {
        if (stack.isEmpty()) {
            stack.add(element);
        } else {
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
}

interface IExpressionEvaluator {

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression infix expression
     * @return postfix expression
     */

    public String infixToPostfix(String expression);

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     * 
     * @param expression postfix expression
     * @return the expression evaluated value
     */

    public int evaluate(String expression);

}

public class Evaluator implements IExpressionEvaluator {

    private int A;
    private int B;
    private int C;

    public void readInts(Scanner sc) {
        this.A = Integer.parseInt(sc.nextLine().replaceAll("(a|b|c)=", ""));
        this.B = Integer.parseInt(sc.nextLine().replaceAll("(a|b|c)=", ""));
        this.C = Integer.parseInt(sc.nextLine().replaceAll("(a|b|c)=", ""));
        sc.close();
    }

    private int getInts(char c) {
        int value = -1;
        switch (c) {
            case 'a':
                value = this.A;
                break;
            case 'b':
                value = this.B;
                break;
            case 'c':
                value = this.C;
                break;

            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }
        return value;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' | c == ')';
    }

    private int getPrecedence(char operator) {
        int precedence = -1;
        switch (operator) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
            case '(':
                precedence = 4;
                break;
            case ')':
                precedence = 0;
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }

        return precedence;
    }

    private int performOperation(char operator, int operand1, int operand2) {
        int value = -1;
        switch (operator) {
            case '+':
                value = operand1 + operand2;
                break;
            case '-':
                value = operand1 - operand2;
                break;
            case '*':
                value = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0)
                {
                    System.out.println("Error");
                    System.exit(0);
                }
                value = operand1 / operand2;
                break;
            case '^':
                if (operand2 < 0)
                    return 0;
                value = (int) Math.pow(operand1, operand2);
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }

        return value;
    }

    public String infixToPostfix(String expression) {
        expression = expression.replace("^--", "^").replace("*--", "*").replace("/--", "/").replace("+--", "+")
                .replace("(--", "(");
        if (expression.startsWith("--"))
            expression = expression.replaceFirst("--", "");
        if (expression.contains("--"))
            expression = expression.replaceAll("--", "+");

        MyStack<Character> operatorStack = new MyStack<Character>();
        String postfix = "";

        int parentheses = 0;

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);

            if (Character.isLetter(c)) {
                postfix += c;
                if ((i > 0) && Character.isLetter(expression.charAt(i - 1)))
                {
                    System.out.println("Error");
                    System.exit(0);
                }
            } else if (c == '(') {
                operatorStack.push(c);
                ++parentheses;
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(')
                    postfix += operatorStack.pop();

                if (!operatorStack.isEmpty())
                    operatorStack.pop();

                --parentheses;
            } else if (isOperator(c)) {
                if ((i == 0 && c != '-') || (i == expression.length() - 1))
                {
                    System.out.println("Error");
                    System.exit(0);
                }

                if ((i > 0) && isOperator(expression.charAt((i - 1))) && expression.charAt(i - 1) != '('
                        && expression.charAt(i - 1) != ')')
                {
                    System.out.println("Error");
                    System.exit(0);
                }

                if (operatorStack.isEmpty())
                    operatorStack.push(c);
                else {
                    while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())
                            && operatorStack.peek() != '(') {
                        postfix += operatorStack.pop();
                    }
                    operatorStack.push(c);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix += operatorStack.pop();
        }

        if (parentheses != 0)
        {
            System.out.println("Error");
            System.exit(0);
        }

        return postfix;
    }

    public int evaluate(String expression) {
        MyStack<Integer> evaluationStack = new MyStack<Integer>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);

            if (Character.isLetter(c)) {
                evaluationStack.push(getInts(c));
            } else if (isOperator(c)) {
                int operand1 = 0;
                int operand2 = 0;
                int result = 0;
                try {
                    operand2 = evaluationStack.pop();
                    operand1 = evaluationStack.pop();
                } catch (Exception e) {
                    if (c != '-')
                    {
                        System.out.println("Error");
                        System.exit(0);
                    }
                    operand1 = 0;
                }
                try {
                    result = performOperation(c, operand1, operand2);
                } catch (Exception e) {
                    System.out.println("Error");
                    System.exit(0);

                }
                evaluationStack.push(result);
            }
        }

        return evaluationStack.pop();
    }

    public static void main(String[] args) {
        try {
            Evaluator ev = new Evaluator();
            Scanner sc = new Scanner(System.in);
            String infixExpression = sc.nextLine();
            ev.readInts(sc);
            sc.close();
            String postfixExpression = ev.infixToPostfix(infixExpression);
            int result = ev.evaluate(postfixExpression);

            System.out.println(postfixExpression);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error");
            System.exit(0);
        }
    }
}