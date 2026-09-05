/**
 * PatientBST.java
 * Binary Search Tree that stores Patient records, keyed by Patient ID.
 * Supports: insert, search, delete, in-order traversal.
 */
public class PatientBST {

    // Inner node class - each node holds one Patient and pointers to left/right children
    private static class Node {
        Patient patient; // the patient stored in this node
        Node left;       // left child (smaller patient IDs)
        Node right;      // right child (larger patient IDs)

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root; // root of the tree

    public PatientBST() {
        this.root = null;
    }

    // Public insert - starting point for inserting a new patient
    public void insert(Patient patient) {
        root = insert(root, patient); // current: the subtree we are inserting into
    }

    // Private recursive helper for insert
    private Node insert(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }
        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insert(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insert(current.right, patient);
        } else {
            System.out.println("Patient ID " + patient.getPatientId() + " already exists. Insert skipped.");
        }
        return current;
    }

    // Public search - returns the Patient with the given id, or null if not found
    public Patient search(int patientId) {
        return search(root, patientId); // current: the subtree we are searching in
    }

    // Private recursive helper for search
    private Patient search(Node current, int patientId) {
        if (current == null) {
            return null;
        }
        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        } else if (patientId < current.patient.getPatientId()) {
            return search(current.left, patientId);
        } else {
            return search(current.right, patientId);
        }
    }

    // Private helper that finds the smallest node in a subtree (used by delete)
    private Node findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Public delete - removes the patient with the given id
    public void delete(int patientId) {
        root = delete(root, patientId); // current: the subtree we are deleting from
    }

    // Private recursive helper for delete
    private Node delete(Node current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found. Nothing deleted.");
            return null;
        }
        if (patientId < current.patient.getPatientId()) {
            current.left = delete(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = delete(current.right, patientId);
        } else {
            // node found - handle the three deletion cases
            if (current.left == null && current.right == null) {
                return null; // no children
            } else if (current.left == null) {
                return current.right; // only right child
            } else if (current.right == null) {
                return current.left; // only left child
            } else {
                // two children: replace with the smallest node in the right subtree
                Node successor = findMin(current.right);
                current.patient = successor.patient;
                current.right = delete(current.right, successor.patient.getPatientId());
            }
        }
        return current;
    }

    // Public in-order traversal - prints patients in ascending order of Patient ID
    public void inorderTraversal() {
        inorderTraversal(root); // current: the subtree we are traversing
    }

    // Private recursive helper for in-order traversal
    private void inorderTraversal(Node current) {
        if (current == null) {
            return;
        }
        inorderTraversal(current.left);
        System.out.println("   " + current.patient);
        inorderTraversal(current.right);
    }
}
