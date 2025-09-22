# 🛒 Inventory Management System (Java + Swing)

This project is an inventory management system built in Java, using JOptionPane for the graphical interface.
It allows users to register products, list them, purchase items, perform searches, and get overall inventory statistics.

## 📌 Features

- ✅ Interactive menu with JOptionPane
- ✅ Support for different product types:

## Aliment (Food)

Electrodomestic (Home appliances)
- ✅ Input validation when adding products
- ✅ Stock control and automatic updates
- ✅ Inventory statistics
- ✅ Flexible search (by full or partial name)
- ✅ Final report when exiting the system


### 📂 Project Structure

```
app/
│── Menu.java                # Main class with the interactive menu
│
├── models/                  # Model classes
│   ├── Product.java         # Abstract base class
│   ├── Aliment.java         # Subclass: food products
│   ├── Electrodomestic.java # Subclass: electronic products
│
└── services/
    └── Inventory.java       # Business logic (inventory management)
```

## ⚙️ Installation & Execution

Clone the repository:
```
git clone https://github.com/yourusername/inventory-system.git
cd inventory-system
```

## Compile the project:
```
javac app/**/*.java
```

## Run the system:

```
java app.Menu
```

## 📖 Usage

- When you start the program, you’ll see the following menu:

```
👾 Main Menu:
1. Add product
2. List Inventory
3. Buy Product
4. Statistics
5. Search Product
6. Exit
```


1. Add product: Register a new product (Aliment or Electrodomestic).

2. List Inventory: Display all products with their stock.

3. Buy Product: Purchase products, reducing stock.

4. Statistics: Show inventory statistics.

5. Search Product: Search products by full or partial name.

6. Exit: Close the program with a final report.

## 🛠️ Technologies

- Language: Java 17+

- UI: Swing (JOptionPane)

- Paradigm: Object-Oriented Programming (OOP)

## 🚀 Future Improvements

Purchase history tracking.

Advanced GUI with JavaFX.


## 👨‍💻 Author

Project developed by Cristian ✨
