package app;


import app.services.Inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Menu menu = new Menu(inv);

        menu.showMenu();
    }
}