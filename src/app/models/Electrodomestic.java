package app.models;

public class Electrodomestic extends Product{

    public Electrodomestic(String name, double precio) {
        super(name, precio);
    }

    @Override
    public String getDescription(){
        return "This is an a electrodomestic";
    }
}
