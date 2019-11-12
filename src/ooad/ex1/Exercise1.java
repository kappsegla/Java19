package ooad.ex1;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {


}

interface Printable {
    void print();
}

class Order implements Printable {

    List<Product> products = new ArrayList<>();
    boolean paid;

    void markAsPaid() {
        paid = true;
    }

    @Override
    public void print() {

    }
}

class Cart {
}

class Product {
    String name;
    int price;

    public void addToCart(Cart cart) {
    }
}

class User {
    String email;
    private String password;

    public boolean authenticate(String password) {
        return false;
    }
}

class Customer extends User {
    List<Order> orders = new ArrayList<>();
    int id;

    public Customer(String email) {
        this.email = email;
    }

}

class Administrator extends User {
    int privilegeLevel;

    public Product createProduct() {
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        var c = new Computer.ComputerBuilder()
                .computerInfo("Some build info")
                .build();
    }
}

class Computer {
    private String info;

    private Computer() {
    }

    public String getInfo() {
        return info;
    }

    public static class ComputerBuilder {
        public Computer build() {
            Computer computer = new Computer();
            computer.info = info;
            return computer;
        }

        private String info;

        public ComputerBuilder computerInfo(String info) {
            this.info = info;
            return this;
        }

        //Add more fields and methods
    }
}

