package app.models;

public abstract class  Product {
    private String name;
    private double price;

    public Product(String name, double precio) {
        this.name = name;
        this.price = precio;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {return price;}
    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("You cannot enter a void name!");
        } else {
            this.name = name;
        }
    }
    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("You cannot enter negative numbers!");
        } else{
            this.price = price;
        }
    }

    public abstract String getDescription();
}
