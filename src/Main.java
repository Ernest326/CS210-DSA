public class Main {
    public static void main(String[] args) {

        Sorting.Test(); //Test the sorting algos to make sure they work fine

        //For practice go to the Sorting class, remove the method and try manually rewrite it
        //Run the code and it should tell you whether you fucked up or it works :D

        //Test monte carlo simulation of dice rolls (its quite likely monte carlo will show up on this years paper)
        System.out.print("\n");
        boolean testMonte = true;
        if(testMonte)
            MonteCarlo.Test(1000); //Around 14.7, checks out with https://math.stackexchange.com/questions/28905/expected-time-to-roll-all-1-through-6-on-a-die

        //Testing ADTs(Abstract Data Types) -- turn this on if you want to mess with it
        boolean testADT = true;
        if(testADT) {

            //Testing stack
            System.out.println("\nSTACK TESTING:");
            Stack stack = new Stack(10);
            stack.push(10); //10
            stack.push(15); //10, 15
            stack.push(-4); //10, 15, -4
            System.out.println(stack.pop()); //out:-4 -- 10, 15
            stack.push(21); //10, 15, 21
            stack.push(-6); //10, 15, 21, -6
            while(!stack.isEmpty()) {
                System.out.print(stack.pop()+" "); //-6, 21, 15, 10
            }
            System.out.print("\n\n");

            //Testing queue (I got lazy so I copy pasted from this point onward lol)
            System.out.println("QUEUE TESTING:");
            Queue queue = new Queue(10);
            queue.insert(10); //10
            queue.insert(15); //10, 15
            queue.insert(-4); //10, 15, -4
            System.out.println(queue.remove()); //out:10 -- 15, -4
            queue.insert(21); //15, -4, 21
            queue.insert(-6); //15, -4, 21, -6
            while(!queue.isEmpty()) {
                System.out.print(queue.remove()+" "); //15, -4, 21, -6
            }
            System.out.print("\n\n");

            //Testing priority queue
            System.out.println("PRIORITYQUEUE TESTING:");
            PriorityQueue pqueue = new PriorityQueue(10);
            pqueue.insert(10); //10
            pqueue.insert(15); //15, 10
            pqueue.insert(-4); //15, 10, -4
            System.out.println(pqueue.remove()); //out:10, -4
            pqueue.insert(21); //21, 10, -4
            pqueue.insert(-6); //21, 10, -4, -6
            while(!pqueue.isEmpty()) {
                System.out.print(pqueue.remove()+" "); //21, 10, -4, -6
            }
            System.out.print("\n\n");

            //Linked lists
            System.out.println("LINKED LIST TESTING:");
            LinkedList list = new LinkedList();
            list.insertHead(10); //10
            list.insertHead(12); //12, 10
            list.insertHead(-1); //-1, 12, 10
            System.out.println(list.deleteHead().data); //out:-1 -- 12, 10
            list.insertHead(-6); //-6, 12, 10
            list.delete(10); //-6, 12
            list.display();
            System.out.print("\n\n");

            //Ordered Linked lists
            System.out.println("LINKED LIST TESTING:");
            LinkedList linkedlist = new LinkedList();
            linkedlist.insertOrdered(10); //10
            linkedlist.insertOrdered(12); //10, 12
            linkedlist.insertOrdered(-1); //-1, 10, 12
            System.out.println(linkedlist.deleteHead().data); //out:-1 -- 10, 12
            linkedlist.insertOrdered(-6); //-6, 10, 12
            linkedlist.delete(10); //-6, 12
            linkedlist.display();
            System.out.print("\n\n");

            //Doubled Linked List --hate this one :<
            System.out.println("DOUBLE-LINKED LIST TESTING:");
            LinkedListDouble listDouble = new LinkedListDouble();
            listDouble.insertHead(1); //1
            listDouble.insertHead(5); //5, 1
            listDouble.insertTail(-3); //5, 1, -3
            listDouble.display(); //out: 5, 1, -3
            listDouble.insertTail(69); //5, 1, -3, 69
            listDouble.delete(1); //5, -3, 69
            listDouble.display(); //out: 5, -3, 69
            listDouble.displayReverse(); //out: 69, -3, 5 --if this prints then the previous links are fine

        }

    }
}