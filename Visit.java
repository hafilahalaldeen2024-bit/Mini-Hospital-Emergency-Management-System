/**
 * Visit.java
 * Represents a single past hospital visit belonging to a patient.
 * Used as the data payload for each node in VisitLinkedList.
 */
public class Visit {
    private String visitId;      // unique id for this visit (e.g. "V101")
    private String visitDate;    // date of the visit, e.g. "2026-05-01"
    private String doctorName;   // doctor who attended the visit
    private String diagnosis;    // diagnosis given during the visit
    private String treatment;    // treatment given during the visit

    public Visit(String visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getVisitId() {
        return visitId;
    }

    @Override
    public String toString() {
        return "Visit[id=" + visitId + ", date=" + visitDate + ", doctor=" + doctorName
                + ", diagnosis=" + diagnosis + ", treatment=" + treatment + "]";
    }
}
