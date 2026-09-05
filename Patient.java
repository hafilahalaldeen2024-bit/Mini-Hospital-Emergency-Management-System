/**
 * Patient.java
 * Represents a patient record stored in the PatientBST.
 * Each patient also owns a VisitLinkedList of their previous hospital visits.
 */
public class Patient {
    private int patientId;             // unique key used by the BST
    private String name;               // patient's full name
    private int age;                   // patient's age
    private String contactNumber;      // patient's contact number
    private String medicalCondition;   // current medical condition
    private VisitLinkedList visitHistory; // linked list of this patient's past visits

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    public int getPatientId() {
        return patientId;
    }

    public VisitLinkedList getVisitHistory() {
        return visitHistory;
    }

    @Override
    public String toString() {
        return "Patient[ID=" + patientId + ", Name=" + name + ", Age=" + age
                + ", Contact=" + contactNumber + ", Condition=" + medicalCondition + "]";
    }
}
