/**
 * TreatmentStack.java
 * A Stack (LIFO - Last In, First Out) that stores completed treatment
 * records. Built on a singly linked structure with a top pointer.
 */
public class TreatmentStack {

    // Inner node class - each node holds one TreatmentRecord and a pointer to the node below it
    private static class Node {
        TreatmentRecord record; // the completed treatment stored in this node
        Node next;              // pointer to the node underneath (pushed before this one)

        Node(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private Node top; // the most recently completed treatment

    public TreatmentStack() {
        this.top = null;
    }

    // Push - add a newly completed treatment record onto the top of the stack
    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + record);
    }

    // Pop - remove and return the most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty. Nothing to pop.");
            return null;
        }
        TreatmentRecord popped = top.record;
        top = top.next;
        return popped;
    }

    // Check whether the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display all treatment records, most recent first
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("   No treatment records yet.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println("   " + current.record);
            current = current.next;
        }
    }
}
