# Demo Video Narration Script (Target: 5–10 minutes)

Read this in your own natural voice — it's written to sound like speech, not
an essay. Timings add up to roughly 8 minutes; adjust pacing as needed.

---

### 1. Introduction (0:00 – 0:40) — face visible

> "Hi, my name is [Your Name], and this is my CIT300 mid assignment — a Mini
> Hospital Emergency Management System built in Java. In this video I'll walk
> through my GitHub commit history, explain how I used each data structure,
> and then run the program live to show every operation working."

### 2. System Overview (0:40 – 1:30)

> "The system simulates a hospital emergency unit. Patients get registered
> and stored by their Patient ID, they wait in a queue until a doctor is
> free, once they're treated the treatment gets archived, and each patient
> also keeps a history of their past visits. I used four data structures to
> do this — a Binary Search Tree, a Queue, a Stack, and a Singly Linked
> List — because each one matched the behaviour I needed."

### 3. GitHub Repository & Commit History (1:30 – 2:30) — share screen on GitHub

> "Here's my GitHub repository. You can see I didn't upload this as one big
> commit — I committed progressively as I built each part. First I set up
> the project structure, then implemented the patient BST, then added search
> and deletion, then the emergency queue, then the treatment stack, then the
> patient linked list, and finally the README. This shows the actual
> development process rather than just a finished dump."

*(Pause here and actually scroll through your commit log on screen while
you talk.)*

### 4. Explaining Each Data Structure (2:30 – 4:30)

> "For patient records, I used a Binary Search Tree keyed on Patient ID, so
> I can insert, search, and delete efficiently, and get all patients back in
> sorted order with an in-order traversal.
>
> For the emergency queue, I used a Queue that follows First-In-First-Out —
> the first patient who arrives is the first one treated. I built it with a
> front and rear pointer so both enqueue and dequeue are fast.
>
> For treatment history, I used a Stack, which is Last-In-First-Out — so
> when I look up recent treatments, the most recently completed one shows up
> first, which made sense for a treatment log.
>
> And for each patient's visit history, I used a Singly Linked List, so I
> can add, remove, and search through their past visits one at a time."

### 5. Running the System (4:30 – 5:00) — switch to terminal/IDE

> "Now let me run the program and show every operation actually working."

*(Run `Main`. Let the printed output do the talking for each section below —
you don't need to narrate every line, just introduce each block as it
starts printing.)*

### 6. Demonstrating Each Operation (5:00 – 7:30)

> "First, the BST — you can see it inserting patients, then the in-order
> traversal showing them sorted by ID, then a search for a specific patient,
> and then a delete, with the traversal running again afterward to confirm
> it's gone."

*(Let output print — pause narrating while it scrolls.)*

> "Next, the emergency queue — patients are enqueued, the full waiting list
> is displayed, and then dequeue pulls the next patient out in the exact
> order they arrived."

*(Let output print.)*

> "Then the treatment stack — as patients get treated, their records are
> pushed onto the stack. You can see the display showing the most recent
> treatment on top, and then pop removing it."

*(Let output print.)*

> "And finally the visit history linked list — I add a few past visits for
> one patient, display the full list, search for one specific visit by ID,
> and then remove one and show the updated list."

*(Let output print.)*

### 7. Design Decisions (7:30 – 8:15)

> "A couple of decisions worth mentioning — I built the queue and stack
> using my own linked node structures instead of Java's built-in classes,
> since the assignment specifically wants the data structures implemented
> directly. I also gave each patient their own visit-history linked list
> object, so the history stays attached to that specific patient rather than
> being one big shared list."

### 8. Reflection (8:15 – 9:00)

> "Working on this helped me actually see the difference between these
> structures in a real scenario instead of just in theory — like why FIFO
> makes sense for a waiting queue but LIFO makes more sense for a treatment
> log. It also gave me practice thinking about edge cases, like deleting a
> node with two children in the BST, or handling an empty queue or stack
> without crashing. That's my assignment — thanks for watching."
