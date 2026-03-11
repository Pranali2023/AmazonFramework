# AmazonFramework
# Amazon Test Automation Framework 🚀

## 📌 Project Overview

This project is a **UI Test Automation Framework** developed using **Java, Selenium WebDriver, TestNG, and Maven**.
The framework automates test scenarios for the **Amazon web application** and demonstrates best practices in automation framework design and CI/CD integration.

The framework follows a **modular and scalable architecture** using the **Page Object Model (POM)** design pattern.

This assignment demonstrates:

* ✔ Automation framework design
* ✔ Clean coding standards
* ✔ Maven project structure
* ✔ Git version control
* ✔ Jenkins CI/CD integration
* ✔ Automated test execution

---

# 🛠 Tech Stack

| Tool / Technology  | Purpose                       |
| ------------------ | ----------------------------- |
| Java               | Programming Language          |
| Selenium WebDriver | UI Automation                 |
| TestNG             | Test Execution Framework      |
| Maven              | Build & Dependency Management |
| Jenkins            | Continuous Integration        |
| Git                | Version Control               |
| GitHub             | Remote Repository             |
| WebDriverManager   | Browser Driver Management     |

---

## 📂 Project Structure

```
CloudEagleAssignment
│
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           ├── base
│   │           ├── constants
│   │           ├── listeners
│   │           ├── pages
│   │           └── utils
│   │
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── tests
│   │
│   └── resources
│        ├── config.properties
│        └── testdata.json
│
├── reports
├── target
│
├── pom.xml
├── testng.xml
├── Jenkinsfile
└── README.md
```

---

## 🏗 Framework Architecture

```
                +-----------------------+
                |      Test Layer       |
                |   TestNG Test Cases   |
                +-----------+-----------+
                            |
                            v
                +-----------------------+
                |      Page Layer       |
                |   Page Object Model   |
                +-----------+-----------+
                            |
                            v
                +-----------------------+
                |     Base Layer        |
                | WebDriver Management  |
                +-----------+-----------+
                            |
                            v
                +-----------------------+
                |    Utility Layer      |
                | Waits | Listeners     |
                | Constants | Helpers   |
                +-----------+-----------+
                            |
                            v
                +-----------------------+
                | Selenium WebDriver    |
                | Browser Interaction   |
                +-----------------------+
```

---

## 📘 Folder Description

| Folder | Description |
|------|-------------|
| **base** | Contains core setup for driver initialization and framework base functionality |
| **pages** | Implements Page Object Model representing application pages |
| **utils** | Utility classes for waits, reusable helpers, and common operations |
| **constants** | Stores framework constants and configuration values |
| **listeners** | Handles test execution events for logging and reporting |
| **tests** | Contains TestNG test scripts |
| **resources** | Configuration files and test data |
| **reports** | Stores generated execution reports |
| **target** | Maven build output directory |
| **Jenkinsfile** | Defines CI/CD pipeline configuration |
| **pom.xml** | Maven dependency and build configuration |
```

---

# ⭐ Framework Features

* Page Object Model (POM) implementation
* Reusable page classes
* Centralized configuration
* Maven based project
* Jenkins CI/CD integration
* Automated test execution
* Structured reporting

---

# ⚙️ How to Run the Project (Local Execution)

## Step 1: Clone the Repository

```
git clone https://github.com/Pranali2023/AmazonFramework.git
```

---

## Step 2: Navigate to Project Directory

```
cd AmazonFramework
```

---

## Step 3: Clean and Build the Project

```
mvn clean install
```

---

## Step 4: Execute Tests

```
mvn test
```

---

# 🔄 Jenkins CI/CD Integration

The project is integrated with **Jenkins Pipeline** for automated test execution.

### Jenkins Pipeline Flow

1️⃣ Pull code from GitHub
2️⃣ Build the project using Maven
3️⃣ Execute automated tests
4️⃣ Archive test reports

---

# 📊 Test Reports

After test execution, reports are generated in:

```
target/surefire-reports
```

These reports are automatically archived by Jenkins after pipeline execution.

---

# 🔗 GitHub Repository

Repository Link:

```
https://github.com/Pranali2023/AmazonFramework
```

---

# 🎯 Assignment Highlights

✔ Designed scalable automation framework
✔ Implemented Page Object Model (POM)
✔ Integrated Maven build lifecycle
✔ Implemented Jenkins CI/CD pipeline
✔ Managed source code with GitHub

---

# 👩‍💻 Author

**Pranali Kuulkarni**
SDET Automation Engineer Candidate

---

# 📌 Assignment Submission

This project demonstrates:

* Automation Framework Development
* CI/CD Pipeline Integration
* Maven Build Automation
* GitHub Source Control

---

⭐ Thank you for reviewing this assignment.
