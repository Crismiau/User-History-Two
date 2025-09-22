package app.services;

import app.models.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>(); // creamos un arrayList para almacenar el nombre del producto
    // dentro del arraylist colocamos
    // la clase a la cual queremos convertir en Array, y luego el nombre que va a tener ese arraylist.
    // nombre

    HashMap<String, Integer> stock = new HashMap<>();
    // luego creamos un hashmap de clave valor para almecenar nombre producto y stock del producto

    ArrayList<String> ticketShopping = new ArrayList<>();
    // creamos un arraylist para mostrar al final del programa el ticket total, con todos los productos que añadio el usuario

    double totalShopping = 0;
    // aqui cree un total shoping para mostrar el total de compras que hizo el usuario;


    // aqui agrego como parametros product y cantidad para enlazarlo con el hasmap y el arraylist
    public Boolean   addProduct(Product p, int quantity) { // en los parametros es donde vamos agregar los productos
        for (Product pro : products) {
            // aqui yo hago una pequeña validacion por si el usuario ingresa un producto que ya esta
            // en el arraylist anteriormente.
            if (pro.getName().equalsIgnoreCase(p.getName())) {
                return false;
            }
        }
        products.add(p);
        stock.put(p.getName(), quantity);
        return true;
    }


    // I crated a new way to show information about some object, with the method of java: StringBuilder.
    // the string builder is a function that allow you to change, modifiy, add, and delete strings whatever you want
    // in this function I used because I need to append each atribute, in only an one line.

    public String listProduct() {
        StringBuilder sg = new StringBuilder("Inventory");
        for (Product prod : products) {
            int cant = stock.getOrDefault(prod.getName(), 0);
                /*

                 I created a this new method of java cause if I don't put this code, I need to use this large conditional:

                 if(stock.containsKey(p.getNombre())){
                    cant = stock.get(p.getNombre());
                } else {
                    cant = 0;
                }
                */
            sg.append("Name product: ")
                    .append(prod.getName()).append("\n")
                    .append("Price Product :").append("\n")
                    .append(prod.getPrice()).append("\n")
                    .append("Stock Product :").append("\n")// here I use the appends to concat all the information of the product
                    .append(cant).append("\n")
                    .append("Product Description: ").append("\n")
                    .append(prod.getDescription()).append("\n");
        }
        return sg.toString();
    }

    public String deleteProduct(String productName) {
        for (Product pd : products) {
            if (pd.getName().equalsIgnoreCase(productName)) {
                products.remove(pd);
                stock.remove(pd.getName());
                return "Product:" + productName + "Deleted succesfully!!!";
            }
        }
        return "The product" + productName + "don't exist in the inventory!";
    }

    /* in this function I created a FOR to iterate for each product in my arraylist, in that way
    with an IF I can get secure if the product exits or not with also validations inside the code.
    next after the validations I proceeded to get the setter of my class, so in that way I can just
    put the new information really easy  /*/
    public String updateProduct(String nombre, double newPrice, int newStock) {
        for (Product pd : products) {
            if (pd.getName().equalsIgnoreCase(nombre)) { // Here I need to be sure if the product is equals to the product that I have in my arraylist
                if (newPrice < 0) {
                    return "You cannot enter a negative number to the new price";
                }
                if (newStock < 0) {
                    return "You cannot enter a negative number to the new stock";
                }
                pd.setPrice(newPrice);
                stock.put(pd.getName(), newStock);

                return "✅ product updated\n" +
                        "name: " + pd.getName() + "\n" +
                        "new price: $" + newPrice + "\n" +
                        "new stock: " + newStock;
            }
        }
        return "️ Product: '" + nombre + "' don't exists.";
    }

    /*
    Here I use a StringBuilder for show in a way more good for the UI, here I just created a function to watch exactly if
    the name of the product that entered the user make matches with the product that I have in my inventory, this function
    its witch a for to iterate for each product and if the product that enter the user is the same "(.contain())" that have the inventory
    so then it's will be show the entire information of th product
     */
    public String searchProduct(String nameProduct) {
        StringBuilder sg = new StringBuilder();
        for (Product pd : products) {
            if (pd.getName().toLowerCase().contains(nameProduct.toLowerCase())) {
                sg.append("• ").append(pd.getName())
                        .append(" | $").append(pd.getPrice())
                        .append(" | Stock: ").append(stock.get(pd.getPrice()))
                        .append("\n");
            }
        }
        return sg.length() > 12 ? sg.toString() : " No matches found!!!.";
    }
/*
    Here I built a way to buy a product, in this way I have the history of the purchase, so if the user make another purchase, now
    the user can have two purchases because with the variable of "listProductHistory" can show the all purchases that the user did before.
 */
    public String buyProduct(String productInput, int quantityInput) {
        StringBuilder sg = new StringBuilder();
        for (Product pd : products) {
            if (pd.getName().equalsIgnoreCase(productInput)) {
                int canStock = stock.get(pd.getName());
                if (canStock >= quantityInput) {
                    stock.put(pd.getName(), canStock - quantityInput);
                    // here I choose put because, with this funcion you can update something in your arraylist
                    // so,
                    double total = quantityInput * pd.getPrice();
                    totalShopping += total;

                    String listProductHistory = "Product Buyed: " + pd.getName() + "\n" +
                            " Quantity: " + quantityInput + "\n" +
                            " Price Product: " + pd.getPrice() + "\n" +
                            "Total: $" + totalShopping;

                    ticketShopping.add(listProductHistory);
                    return "✅ Compra realizada:\n" + listProductHistory;

                } else {
                    return "❌ Stock insuficiente.";
                }
            }
            return "the product don't exists.";
        }
        return productInput;
    }


    public String statistics(){
        if(products.isEmpty() || products == null) {
            return "The store don't have products right now in the inventory to show!";
        }
        Product expansive = products.get(0);
        Product cheap = products.get(0);
        for(Product pd : products){
            if (pd.getPrice() > expansive.getPrice()) expansive = pd;
            if(pd.getPrice() < cheap.getPrice()) cheap =  pd;
            }
        return "📊 Statistics:\n" +
                "More Expensive:  " +expansive.getName() + " ($" + expansive.getPrice() + ")\n" +
                "More Cheap: " + cheap.getName() + " ($" + cheap.getPrice() + ")";
        }


        public String finalTick(){
        StringBuilder sg = new StringBuilder();
        for(String line : ticketShopping){
            sg.append(line).append("\n");
        }
        sg.append("Total Shopping: $").append(totalShopping);
        return  sg.toString();
        }
    }
