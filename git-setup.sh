#!/bin/bash
# git-setup.sh
# Reusable git automation script for the Mini Hospital Emergency Management System.
# Run this any time you want to save progress. Safe to run repeatedly.
# The ONLY time it will ask you for input is if no GitHub remote is configured yet.

set -e

# 1. Initialize git if this folder isn't already a repo
if [ ! -d ".git" ]; then
    echo "No git repository found. Running git init..."
    git init
fi

# 2. Force the branch to 'main' (idempotent - harmless if already on main)
git branch -M main

# 3. Connect to GitHub only if 'origin' isn't already set
if ! git remote get-url origin >/dev/null 2>&1; then
    read -p "Enter your GitHub repository URL: " REPO_URL
    git remote add origin "$REPO_URL"
fi

# Helper function: stage and commit a group of files only if something changed
commit_group () {
    MESSAGE="$1"
    shift
    FILES=("$@")

    EXISTING_FILES=()
    for f in "${FILES[@]}"; do
        if [ -f "$f" ]; then
            EXISTING_FILES+=("$f")
        fi
    done

    if [ ${#EXISTING_FILES[@]} -eq 0 ]; then
        return
    fi

    git add "${EXISTING_FILES[@]}"

    if git diff --cached --quiet; then
        echo "No changes for: $MESSAGE (skipped)"
    else
        git commit -m "$MESSAGE"
    fi
}

# 4. Grouped commits, matching the assignment's own example commit messages
commit_group "Created project structure" README.md git-setup.sh git-setup.ps1
commit_group "Implemented patient BST" src/Patient.java src/PatientBST.java
commit_group "Implemented emergency queue" src/EmergencyQueue.java
commit_group "Implemented treatment stack" src/TreatmentRecord.java src/TreatmentStack.java
commit_group "Implemented patient visit history" src/Visit.java src/VisitLinkedList.java
commit_group "Added main program and demo driver" src/Main.java
commit_group "Updated README" README.md VIDEO_SCRIPT.md

# 5. Push once, at the end
git push -u origin main

echo "Done. All changes committed and pushed."
