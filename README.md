# Mini Hospital Emergency Management System

A Java console application built for **CIT300 - Data Structures and Algorithms**
(Individual Mid Assignment) that simulates patient registration, emergency
treatment requests, treatment completion, and patient visit history using
four core data structures.

## Project Overview

The system models a small hospital emergency unit:

- Patients are **registered and stored** in a Binary Search Tree keyed by Patient ID.
- Patients **wait for treatment** in a FIFO Queue.
- Once treated, a **treatment record is archived** in a LIFO Stack.
- Each patient keeps a **Singly Linked List** of their previous hospital visits.

## Data Structures Used

| Data Structure     | File(s)                                   | Purpose                                              |
|---------------------|--------------------------------------------|-------------------------------------------------------|
| Binary Search Tree  | `Patient.java`, `PatientBST.java`          | Store & search patient records by Patient ID          |
| Queue (FIFO)        | `EmergencyQueue.java`                      | Manage patients waiting for emergency treatment       |
| Stack (LIFO)        | `TreatmentRecord.java`, `TreatmentStack.java` | Store completed treatment records                  |
| Singly Linked List  | `Visit.java`, `VisitLinkedList.java`       | Store a patient's previous visit history              |

All four structures are implemented from scratch (custom `Node` classes) —
no built-in `java.util.Stack`, `Queue`, or `LinkedList` classes are used for
the core logic, as required by the assignment.

## Project Structure

```
HospitalEmergencySystem/
├── src/
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   ├── VisitLinkedList.java
│   └── Main.java
├── README.md
├── git-setup.sh
└── git-setup.ps1
```

## How to Compile & Run

From the `src` folder:

```bash
javac *.java
java Main
```

Running `Main` walks through every required operation for every data
structure (BST insert/search/delete/traversal, queue enqueue/dequeue/display,
stack push/pop/display, linked list add/remove/search/display) with clear
printed section headers, so it can be used directly as the demonstration
driver for the assignment video.

## Notes

- Each class uses a private inner `Node` class to keep the linked structures self-contained.
- Deleting from the BST handles all three standard cases: leaf node, one child, and two children (using the in-order successor).
- The queue and stack are both implemented with `front`/`rear` and `top` pointers respectively for O(1) operations.
