public class LinkedListDouble {
    private Link first;
    private Link last; //We also keep track of the last link!

    public LinkedListDouble() {
        first=null;
        last=null;
    }

    public void insertHead(int number) {
        Link newLink = new Link(number);

        if(isEmpty()) {
            last=newLink; //If we are inserting our first link, the first one will also be the last one!
        } else {
            first.previous = newLink; //Otherwise we set the current first link, to link back to new link
        }
        newLink.next = first;
        first = newLink;
    }

    //InserTail is the same as InsertHead but we replace "first" with "last" and "next" with "previous" - basically same method
    public void insertTail(int number) {
        Link newLink = new Link(number);

        if(isEmpty()) {
            first=newLink;
        } else {
            last.next = newLink; //Otherwise we set the current first link, to link back to new link
        }
        newLink.previous = last;
        last = newLink;
    }

    public Link deleteHead() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display() {
        Link current = first;
        while(current != null) {
            current.displayLink();
            current=current.next;
        }
        System.out.println();
    }
    public void displayReverse() {
        Link current = last;
        while(current != null) {
            current.displayLink();
            current=current.previous;
        }
        System.out.println();
    }

    public Link delete(int key) {
        Link current = first; //, previous = first; --Once again we dont need to keep track of previous

        //Find the link
        while(current.data != key) {
            current = current.next;
        }

        //We didnt find the element, womp womp
        if(current == null)
            return null;

        //Link the node forward
        if(current == first) {
            first = current.next; //If its the first link just set the next one to first
        } else {
            current.previous.next = current.next; //Otherwise reconnect the links
        }

        //Link the node backward
        if(current==last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    //This is a method used when we are making an OrderedLinkedList!
    public void insertOrdered(int number) {
        Link newLink = new Link(number);
        Link current=first;// previous=null;

        //Find the first link that is greater than the data
        while(current != null && newLink.data > current.data) {
            //previous=current; --With double linked lists we dont need to keep track of the previous!
            current=current.next;
        }

        if(current==first) {
            insertHead(number);
        } else if(current==last) {
            insertTail(number);
        } else {
            //Link the new node in both directions for current and the node before current
            newLink.previous = current.previous;
            current.previous.next = newLink;
            newLink.next = current;
        }

    }
}
