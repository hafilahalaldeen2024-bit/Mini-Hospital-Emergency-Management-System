# git-setup.ps1
# Reusable git automation script for the Mini Hospital Emergency Management System.
# Run this any time you want to save progress. Safe to run repeatedly.
# The ONLY time it will ask you for input is if no GitHub remote is configured yet.

$ErrorActionPreference = "Stop"

# 1. Initialize git if this folder isn't already a repo
if (-not (Test-Path ".git")) {
    Write-Host "No git repository found. Running git init..."
    git init
}

# 2. Force the branch to 'main' (idempotent - harmless if already on main)
git branch -M main

# 3. Connect to GitHub only if 'origin' isn't already set
$originExists = $true
try {
    git remote get-url origin | Out-Null
} catch {
    $originExists = $false
}

if (-not $originExists) {
    $repoUrl = Read-Host "Enter your GitHub repository URL"
    git remote add origin $repoUrl
}

# Helper function: stage and commit a group of files only if something changed
function Commit-Group {
    param(
        [string]$Message,
        [string[]]$Files
    )

    $existing = $Files | Where-Object { Test-Path $_ }

    if (-not $existing -or $existing.Count -eq 0) {
        return
    }

    git add $existing

    git diff --cached --quiet
    if ($LASTEXITCODE -eq 0) {
        Write-Host "No changes for: $Message (skipped)"
    } else {
        git commit -m $Message
    }
}

# 4. Grouped commits, matching the assignment's own example commit messages
Commit-Group -Message "Created project structure" -Files @("README.md", "git-setup.sh", "git-setup.ps1")
Commit-Group -Message "Implemented patient BST" -Files @("src/Patient.java", "src/PatientBST.java")
Commit-Group -Message "Implemented emergency queue" -Files @("src/EmergencyQueue.java")
Commit-Group -Message "Implemented treatment stack" -Files @("src/TreatmentRecord.java", "src/TreatmentStack.java")
Commit-Group -Message "Implemented patient visit history" -Files @("src/Visit.java", "src/VisitLinkedList.java")
Commit-Group -Message "Added main program and demo driver" -Files @("src/Main.java")
Commit-Group -Message "Updated README" -Files @("README.md", "VIDEO_SCRIPT.md")

# 5. Push once, at the end
git push -u origin main

Write-Host "Done. All changes committed and pushed."
