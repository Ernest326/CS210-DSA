public class Queue {
    private int maxSize;
    private long[] array;
    private int front, rear;
    private int n;

    public Queue(int s) {
        maxSize=s;
        array = new long[maxSize];
        front = 0;
        rear = -1;
        n = 0;
    }

    public boolean insert(long item) {
        if(isFull()) return false; //If full we dont do anything
        if(rear == maxSize-1) //If we reached the end of array wrap around
            rear=-1;
        rear++;
        array[rear] = item;
        n++;
        return true;
    }

    public long remove() {
        if(isEmpty())
            return -1;
        long temp = array[front];
        front++;
        if(front == maxSize) //Wrap around
            front = 0;
        n--;
        return temp;
    }

    public boolean isFull() {
        return (n>=maxSize);
    }

    public boolean isEmpty() {
        return n<=0;
    }

}
