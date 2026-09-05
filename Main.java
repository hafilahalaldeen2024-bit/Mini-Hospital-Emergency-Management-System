/**
 * Main.java
 * Entry point and demo driver for the Mini Hospital Emergency Management System.
 * Runs through every required operation for every data structure, with clear
 * printed section headers - point your screen recording at this output.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM - DEMO");
        System.out.println("=====================================================\n");

        // ---------------------------------------------------------
        // 1. PATIENT RECORDS - BINARY SEARCH TREE
        // ---------------------------------------------------------
        System.out.println("----- 1. PATIENT RECORDS (Binary Search Tree) -----");
        PatientBST patientBST = new PatientBST();

        Patient p1 = new Patient(105, "Nimal Perera", 34, "0771234567", "Fracture");
        Patient p2 = new Patient(102, "Kamala Silva", 28, "0719876543", "Fever");
        Patient p3 = new Patient(110, "Ruwan Fernando", 45, "0765554433", "Chest Pain");
        Patient p4 = new Patient(101, "Amaya Jayasuriya", 19, "0701112233", "Asthma Attack");
        Patient p5 = new Patient(108, "Saman Kumara", 60, "0752223344", "High Blood Pressure");

        System.out.println("\nInserting patients into BST...");
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);
        patientBST.insert(p4);
        patientBST.insert(p5);

        System.out.println("\nIn-order traversal (ascending Patient ID):");
        patientBST.inorderTraversal();

        System.out.println("\nSearching for Patient ID 108:");
        Patient found = patientBST.search(108);
        System.out.println("   Result: " + (found != null ? found : "Not found"));

        System.out.println("\nDeleting Patient ID 102:");
        patientBST.delete(102);

        System.out.println("\nIn-order traversal after deletion:");
        patientBST.inorderTraversal();

        // ---------------------------------------------------------
        // 2. EMERGENCY PATIENT QUEUE - QUEUE
        // ---------------------------------------------------------
        System.out.println("\n----- 2. EMERGENCY PATIENT QUEUE (Queue - FIFO) -----");
        EmergencyQueue emergencyQueue = new EmergencyQueue();

        System.out.println("\nEnqueueing patients into the emergency queue...");
        emergencyQueue.enqueue(p4); // Amaya
        emergencyQueue.enqueue(p1); // Nimal
        emergencyQueue.enqueue(p5); // Saman

        System.out.println("\nPatients currently waiting:");
        emergencyQueue.displayQueue();

        System.out.println("\nDequeueing the next patient for treatment:");
        Patient nextPatient = emergencyQueue.dequeue();
        System.out.println("   Now treating: " + nextPatient);

        System.out.println("\nPatients still waiting after dequeue:");
        emergencyQueue.displayQueue();

        // ---------------------------------------------------------
        // 3. TREATMENT HISTORY - STACK
        // ---------------------------------------------------------
        System.out.println("\n----- 3. TREATMENT HISTORY (Stack - LIFO) -----");
        TreatmentStack treatmentStack = new TreatmentStack();

        System.out.println("\nPushing completed treatment records...");
        treatmentStack.push(new TreatmentRecord(nextPatient.getPatientId(), "Amaya Jayasuriya",
                "Nebulizer treatment for asthma", "10:15 AM"));
        Patient secondPatient = emergencyQueue.dequeue();
        System.out.println("   Now treating: " + secondPatient);
        treatmentStack.push(new TreatmentRecord(secondPatient.getPatientId(), "Nimal Perera",
                "X-ray and cast for fracture", "10:40 AM"));

        System.out.println("\nDisplaying treatment records (most recent first):");
        treatmentStack.displayStack();

        System.out.println("\nPopping the most recent treatment record:");
        TreatmentRecord popped = treatmentStack.pop();
        System.out.println("   Popped: " + popped);

        System.out.println("\nTreatment records after pop:");
        treatmentStack.displayStack();

        // ---------------------------------------------------------
        // 4. PATIENT VISIT HISTORY - SINGLY LINKED LIST
        // ---------------------------------------------------------
        System.out.println("\n----- 4. PATIENT VISIT HISTORY (Singly Linked List) -----");
        System.out.println("\nAdding visit history for Patient ID 105 (Nimal Perera)...");
        p1.getVisitHistory().addVisit(new Visit("V201", "2025-11-02", "Dr. Perera", "Sprained ankle", "Bandage and rest"));
        p1.getVisitHistory().addVisit(new Visit("V202", "2026-01-15", "Dr. Fonseka", "Flu", "Medication prescribed"));
        p1.getVisitHistory().addVisit(new Visit("V203", "2026-05-20", "Dr. Wickrama", "Fracture", "X-ray and cast"));

        System.out.println("\nDisplaying full visit history for Patient 105:");
        p1.getVisitHistory().displayVisits();

        System.out.println("\nSearching for visit V202:");
        Visit foundVisit = p1.getVisitHistory().searchVisit("V202");
        System.out.println("   Result: " + (foundVisit != null ? foundVisit : "Not found"));

        System.out.println("\nRemoving visit V201:");
        p1.getVisitHistory().removeVisit("V201");

        System.out.println("\nVisit history after removal:");
        p1.getVisitHistory().displayVisits();

        System.out.println("\n=====================================================");
        System.out.println(" DEMO COMPLETE - ALL DATA STRUCTURES DEMONSTRATED");
        System.out.println("=====================================================");
    }
}
