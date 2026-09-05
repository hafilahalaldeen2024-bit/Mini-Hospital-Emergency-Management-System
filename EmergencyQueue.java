/**
 * EmergencyQueue.java
 * A Queue (FIFO - First In, First Out) that manages patients waiting
 * in the emergency unit. Built on a singly linked structure with
 * front and rear pointers so enqueue/dequeue are both O(1).
 */
public class EmergencyQueue {

    // Inner node class - each node holds one Patient and a pointer to the next node
    private static class Node {
        Patient patient; // patient waiting in the queue
        Node next;       // pointer to the next waiting patient

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front; // the next patient to be treated
    private Node rear;  // the most recently added patient

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue - add a patient to the back of the waiting queue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued: " + patient);
    }

    // Dequeue - remove and return the next patient for treatment
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No patient to dequeue.");
            return null;
        }
        Patient treated = front.patient;
        front = front.next;
        if (front == null) {
            rear = null; // queue is now empty
        }
        return treated;
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display all patients currently waiting, in FIFO order
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("   No patients currently waiting.");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.println("   " + current.patient);
            current = current.next;
        }
    }
}
