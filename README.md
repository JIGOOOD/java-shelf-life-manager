# Shelf Life Manager

## Overview

The **Shelf Life Manager** is a Java-based application designed to help users efficiently manage the shelf life of their ingredients. By registering purchased ingredients and their expiration dates, users can reduce food waste and receive recipe suggestions for ingredients nearing their expiration dates.

---

## Features

### 1. User Authentication

- **Sign-Up and Login**: Users must register and log in to access services.
- **Access Restriction**: Non-registered users cannot access main functionalities like managing ingredients or recipe suggestions.

### 2. Ingredient Management

- **Open Refrigerator**: View stored ingredients categorized by fridge, freezer, and room temperature.
- **Add Ingredients**: Add new ingredients with expiration dates.
  - Input validation ensures correct date formats.
- **Delete Ingredients**: Remove selected ingredients from storage.
- **Shelf Life Overview**: Automatically sort ingredients by expiration date and display the list.

### 3. Cooking Zone

- **Ingredients Near Expiration**: Display ingredients with less than 7 days left.
- **Recipe Links**: Direct users to recipe websites or YouTube for cooking inspiration.

---

## Technology Stack

### 1. Core Java Concepts

- **GUI**: Implemented with Java Swing for interactive user interfaces.
- **File I/O**: Used for persistent data storage, such as:
  - Saving user information during registration.
  - Validating login credentials.
  - Storing and retrieving ingredient data.
  - Sorting ingredients by expiration date.
- **Inheritance and Polymorphism**: Designed a hierarchical structure for fridge, freezer, and room temperature classes, inheriting common functionality from a `Refrigerator` class. Polymorphism was used to handle these subclasses in the `OpenRefrigerator` GUI.

### 2. Development Tools

- **Java**: Core programming language.
- **IDE**: Recommended to use IntelliJ IDEA or Eclipse.
- **File System**: Text-based file storage for user and ingredient data.

---

## How to Run (Eclipse Based)

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/JIGOOOD/java-shelf-life-manager.git
   ```

2. **Open the Project in Eclipse**:

   - Launch Eclipse.
   - Go to **File > Import > Existing Projects into Workspace**.
   - Select the cloned repository directory and import the project.

3. **Check Project Configuration**:

   - Ensure that `src` is set as the source folder.
   - Verify that `JRE System Library` is added under the project’s build path.
     - To check: Right-click the project > **Properties > Java Build Path**.

4. **Run the Program**:

   - Navigate to the `Main.java` file.
   - Right-click the file and select **Run As > Java Application**.

5. **Features Available**:
   - Register as a new user.
   - Log in to access ingredient management and recipe suggestions.

---

## Future Improvements

1. **Database Integration**: Replace file-based storage with a relational database for scalability and robustness.
2. **Mobile Application**: Develop a mobile version for easier access and notifications.
3. **Enhanced Recipe Suggestions**: Integrate advanced algorithms for personalized recipe recommendations.
4. **Barcode Scanning**: Allow users to scan products for automatic ingredient registration.
