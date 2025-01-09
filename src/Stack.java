//LIFO data structure, imagine it like a stack of books or sticky notes, we take the top-most element and place down on top
//The top most element is the Last one In, and its the First one Out

public class Stack {
    private int maxSize;
    private long[] array;
    private int top; //We keep track of the top-most element index

    public Stack(int s) { //Initialize everything in constructor
        maxSize=s;
        array = new long[maxSize];
        top = -1; //We have nothing at the moment, so keep index at -1
    }

    //Main methods that we need
    public boolean push(long item) {
        if(isFull()) return false; //If full avoid IndexOutOfBounds and do nothing
        top++;
        array[top] = item;
        return true;
    }

    public long pop() {
        return array[top--];
    }

    public long peek() {
        return array[top];
    }

    //Additional helper methods which may be used
    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }

    public void makeEmpty() {
        top=-1;
    }

}
