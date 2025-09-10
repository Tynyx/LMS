# 📚 Library Management System (LMS)

A simple, console-based Library Management System built in Java using IntelliJ. This application was designed using the **V-Model SDLC methodology**, ensuring clarity, testability, and well-defined functionality at every stage.

---

## 🚀 Features

✅ Add new patrons manually via CLI input
✅ Remove patrons by their 7-digit ID
✅ Load patron data from a text file
✅ Display all current patrons in the system
✅ On-screen menu for seamless user interaction
✅ Data validation for ID format and fine limits
✅ Exception handling for robust input checking

---

## 📁 File Structure

```bash
├── LMS
│   ├── Patron.java               # Data class for library patrons
│   ├── LibraryManager.java       # Core logic for managing patron list
│   ├── Menu.java                 # CLI menu controller
│   └── patrons.txt               # Sample file input (optional)
```

---

## 🧠 Technologies Used

* Java (JDK 17+)
* IntelliJ IDEA
* Standard Java libraries (no external dependencies)

---

## 📌 Requirements

* Java Development Kit (JDK 17 or later)
* IntelliJ IDEA (or any IDE that supports Java)

---

## 🧪 How to Use

1. **Compile and run `Menu.java`**

2. Follow the on-screen menu options:

    * `1` to Add a new patron
    * `2` to Remove a patron by ID
    * `3` to Load patrons from a file
    * `4` to Display all patrons
    * `5` to Exit

3. When adding a patron:

    * Input must be a **7-digit ID**
    * Fine (if applicable) must be between **0–250**

4. File format for loading patrons:

   ```
   1234567,John Doe,123 Main St,45.75
   7654321,Jane Smith,456 Elm St,0
   ```

---

## 🧰 Design Methodology

This application was developed following the **V-Model SDLC**:

* 🔍 Requirements defined up-front using a structured customer scenario
* 📐 System design mapped in UML with clear class relationships
* 💻 Code implemented in modular, testable pieces
* ✅ Each feature validated with integrated exception handling and test planning

---


