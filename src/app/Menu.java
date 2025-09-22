package app;

import app.models.Aliment;
import app.models.Electrodomestic;
import app.models.Product;
import app.services.Inventory;

import javax.swing.*;

public class Menu {
    Inventory inv;

    public Menu(Inventory inv) {
        this.inv = inv;
    }

    public void showMenu(){
        String option;
    do {
        option = JOptionPane.showInputDialog(null,
                "👾 Principal Menu: \n " +
                        "1. Add product \n " +
                        "2. List Inventoy \n" +
                        "3. Buy Product \n" +
                        "4. Statistics \n"+
                        "5. Search Product \n" +
                        "6. Exit \n"+
                        "\n" +
                        "Choose a number to continue! \n"
            );

        if(option == null)
            break;

        try{
            switch (option){
                case "1":
                    String type = JOptionPane.showInputDialog("Type Product (Aliment/Electrodomestic):");
                    String name = JOptionPane.showInputDialog("Name of the product:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Initial Stock:"));

                    if (price <= 0 || stock < 0 || name.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "❌ Data incorrect.");
                        break;
                    }
                    Product p;
                    if (type.equalsIgnoreCase("Aliment")) {
                        p = new Aliment(name, price);
                    } else if (type.equalsIgnoreCase("Electrodomestic")) {
                        p = new Electrodomestic(name, price);
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Tipo de producto no válido.");
                        break;
                    }

                    boolean added = inv.addProduct(p, stock);
                    JOptionPane.showMessageDialog(null,
                            added ? "✅ Product Added." : "❌ The product already exists.");
                    break;

                case "2":
                        JOptionPane.showMessageDialog(null, inv.listProduct());
                    break;

                case "3":
                    String productName = JOptionPane.showInputDialog("Enter the name of the product: ");
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("Stock to buy: "));
                    JOptionPane.showMessageDialog(null, inv.buyProduct(productName, quantity));
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, inv.statistics());
                    break;

                case "5":
                    String search = JOptionPane.showInputDialog("Enter the name of the product o just a part of it:");
                    JOptionPane.showMessageDialog(null, inv.searchProduct(search));
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, inv.finalTick());
                    break;

                default:
                    JOptionPane.showMessageDialog(null, " Option Incorrect!!!.");
            }

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Incorrect data, should be a number!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error!: " + e.getMessage());
        }


    }while(!"6".equals(option));




        }
    }
