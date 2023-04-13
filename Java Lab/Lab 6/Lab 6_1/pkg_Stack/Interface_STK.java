package pkg_Stack;

public interface Interface_STK {
    int max = 10;
    int top = 0;
    void push(int item); // add item to the stack
    int pop(); // remove and return the top item from the stack
    int peek(); // return the top item from the stack without removing it
    boolean isEmpty(); // check if the stack is empty
    boolean isFull(); // check if the stack is full
    void size();

    void displayStack();

    void displayTop();
}
