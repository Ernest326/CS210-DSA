//Same as regular queue however any element we insert, we do an insertion sort on it
//We also keep the rear at 0 and dont have to keep track
public class PriorityQueue {
    private int maxSize;
    private long[] array;
    private int top; //We dont need to keep track of the rear and front, since either way its gonna be ordered. Heaps are more like Stacks


    public PriorityQueue(int s) {
        maxSize=s;
        array = new long[maxSize];
        top=-1;
    }

    public boolean insert(long item) {
        if(isFull())
            return false; //If we are full don't try anything funky

        if(isEmpty()) {
            array[0] = item; //If array is empty just insert it at 0th element
            top++;
        } else { //Otherwise do insertion sort from the right side, using the new item as pivot
            int j = top;
            while(j>0 && array[j-1]>item) {
                array[j]=array[j-1];
                j--;
            }
            array[j]=item;
        }
        top++;
        return true;
    }

    public long remove() {
        return array[top--];
    }

    public boolean isFull() {
        return (top>=maxSize-1);
    }

    public boolean isEmpty() {
        return (top<0);
    }

}
