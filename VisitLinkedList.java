/**
 * VisitLinkedList.java
 * A Singly Linked List that stores a patient's previous hospital visits.
 * Supports: add, remove, search, display.
 */
public class VisitLinkedList {

    // Inner node class - each node holds one Visit and a pointer to the next node
    private static class Node {
        Visit data;   // the visit stored in this node
        Node next;    // pointer to the next node in the list

        Node(Visit data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // first node of the list

    public VisitLinkedList() {
        this.head = null;
    }

    // Add a new visit to the end of the list
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Remove a visit by its visit id. Returns true if removed, false if not found.
    public boolean removeVisit(String visitId) {
        if (head == null) {
            return false;
        }
        if (head.data.getVisitId().equals(visitId)) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getVisitId().equals(visitId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Search for a visit by its visit id. Returns the Visit if found, otherwise null.
    public Visit searchVisit(String visitId) {
        Node current = head;
        while (current != null) {
            if (current.data.getVisitId().equals(visitId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Display all visits in this patient's history
    public void displayVisits() {
        if (head == null) {
            System.out.println("   No visit history recorded.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("   " + current.data);
            current = current.next;
        }
    }
}
