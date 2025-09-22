package app.models;

public class Aliment extends Product{
    public Aliment(String name, double precio) {
        super(name, precio);
    }
    @Override
    public String getDescription(){
        return "this is an aliment";
    };
}
