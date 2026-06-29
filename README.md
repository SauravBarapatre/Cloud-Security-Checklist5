# 🔐 Cloud Security System

A Java-based **Cloud Security System** that demonstrates secure authentication, role-based access control (RBAC), password validation, AES encryption/decryption, security logging, and object-oriented programming principles.

This project is designed to showcase secure software development practices and follows modular programming concepts using multiple Java classes.

---

# 📌 Features

* User Registration
* Secure User Authentication
* Strong Password Validation
* Role-Based Access Control (RBAC)
* AES-128 Encryption
* AES Decryption
* Security Event Logging
* User Management using HashMap
* Password Change Facility
* Modular Object-Oriented Design
* Exception Handling
* JavaDoc Documentation

---

# 🛠 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections Framework (HashMap)
* Java Cryptography Extension (JCE)
* AES Encryption
* Base64 Encoding
* java.util.logging
* Exception Handling

---

# 📂 Project Structure

```
Cloud-Security-System
│
├── src
│   ├── Main.java
│   ├── Constants.java
│   ├── User.java
│   ├── UserManager.java
│   ├── PasswordValidator.java
│   ├── EncryptionService.java
│   ├── AccessControl.java
│   └── SecurityLogger.java
│
├── README.md
├── .gitignore
└── security.log
```

---

# 📖 Class Description

## Main.java

Acts as the entry point of the application and manages user interaction.

---

## Constants.java

Stores all constant values such as:

* User Roles
* Encryption Algorithm
* Logger Name
* Messages
* Password Length

---

## User.java

Represents a user object with:

* Username
* Password
* Role

Implements encapsulation using getters and setters.

---

## UserManager.java

Responsible for:

* Registering users
* Authenticating users
* Updating passwords
* Removing users
* Managing users using HashMap

---

## PasswordValidator.java

Validates passwords using the following rules:

* Minimum 8 characters
* One uppercase letter
* One lowercase letter
* One digit
* One special character
* No spaces

Also displays password strength.

---

## EncryptionService.java

Implements AES-128 encryption and decryption.

Functions include:

* Secret key generation
* Encrypting plaintext
* Decrypting ciphertext
* Encryption demonstration

---

## AccessControl.java

Implements Role-Based Access Control.

Admin permissions:

* Register Users
* Delete Users
* View Users
* Encrypt Data
* Decrypt Data

User permissions:

* Encrypt Data
* Decrypt Data
* Change Password

---

## SecurityLogger.java

Stores application events inside **security.log**.

Logs:

* Successful Login
* Failed Login
* Registration
* Password Change
* Encryption
* Decryption
* Logout
* Unauthorized Access

---

# 🔒 Security Features

* Strong Password Validation
* AES-128 Encryption
* Secure Authentication Workflow
* Role-Based Access Control
* Security Logging
* Password Strength Analysis
* Modular Architecture
* Exception Handling

---

# ▶️ How to Run

### Compile

```
javac *.java
```

### Execute

```
java Main
```

---

# 🧪 Sample Workflow

### Register User

```
Username:
saurav

Password:
Saurav@123

Role:
USER
```

---

### Login

```
Username:
saurav

Password:
Saurav@123
```

---

### Encrypt Data

```
Input:
Hello Cloud Security
```

Example Output

```
Encrypted:
QmFzZTY0RW5jb2RlZERhdGE=

Decrypted:
Hello Cloud Security
```

*(The encrypted output will differ each run because AES encryption uses a generated key.)*

---

# 📜 Logging

All security-related events are stored inside

```
security.log
```

Example:

```
INFO : User Logged In : admin

INFO : Encryption Performed By : admin

WARNING : Failed Login : guest

INFO : Password Changed : john
```

---

# 💡 Object-Oriented Principles Used

* Encapsulation
* Abstraction
* Modularity
* Single Responsibility Principle
* Reusability
* Separation of Concerns

---

# 🚀 Future Enhancements

* Database Integration (MySQL)
* Password Hashing (SHA-256/BCrypt)
* Multi-Factor Authentication (MFA)
* RSA Encryption
* File Encryption
* Email Verification
* OTP-based Login
* Graphical User Interface (JavaFX/Swing)
* REST API Integration
* Cloud Storage Integration

---

# 👨‍💻 Author

**Saurav Manoj Barapatre**

B.Tech Computer Science and Engineering

Vellore Institute of Technology (VIT)

---

# 📄 License

This project is created for educational and learning purposes.
