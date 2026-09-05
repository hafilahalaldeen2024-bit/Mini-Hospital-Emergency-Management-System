/**
 * TreatmentRecord.java
 * Represents a completed treatment, stored in the TreatmentStack once
 * a patient's emergency treatment has finished.
 */
public class TreatmentRecord {
    private int patientId;       // id of the patient who was treated
    private String patientName;  // name of the patient who was treated
    private String treatmentGiven; // description of the treatment given
    private String completionTime; // when the treatment was completed

    public TreatmentRecord(int patientId, String patientName, String treatmentGiven, String completionTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentGiven = treatmentGiven;
        this.completionTime = completionTime;
    }

    @Override
    public String toString() {
        return "TreatmentRecord[PatientID=" + patientId + ", Name=" + patientName
                + ", Treatment=" + treatmentGiven + ", CompletedAt=" + completionTime + "]";
    }
}
