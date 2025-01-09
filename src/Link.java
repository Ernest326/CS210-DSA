public class Link {
    public int data;
    public Link next;
    public Link previous; //Only used in doubled linked lists, regular lists just use next

    public void displayLink() {
        System.out.print(data+" ");
    }
    public Link(int d) {
        data=d;
    }
}
