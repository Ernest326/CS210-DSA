public class LinkedList {
    private Link first;

    public LinkedList() {
        first=null;
    }

    public void insertHead(int number) {
        Link newLink = new Link(number);
        newLink.next = first;
        first = newLink;
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

    public Link delete(int key) {
        Link current = first, previous = first;

        //Find the link + previous link
        while(current.data != key) {
            previous = current;
            current = current.next;
        }
        //We didnt find the element, womp womp
        if(current == null)
            return null;

        //Relink the nodes
        if(current == first) {
            first = first.next; //If its the first link just set the next one to first
        } else {
            previous.next = current.next; //Otherwise reconnect the links
        }

        return current;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    //This is a method used when we are making an OrderedLinkedList!
    public void insertOrdered(int number) {
        Link newLink = new Link(number);
        Link current=first, previous=null;

        //Find the first link that is greater than the data
        while(current != null && newLink.data > current.data) {
            previous=current;
            current=current.next;
        }

        if(previous==null) {
            first=newLink; //If the first link is bigger, set the new link to first
        } else {
            previous.next=newLink;
        }
        newLink.next = current;
    }
}
