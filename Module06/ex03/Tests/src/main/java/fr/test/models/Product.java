package fr.test.models;

import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private int price;

    public Product() {
    }


    public Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() && getPrice() == product.getPrice() && Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        StringBuilder bd = new StringBuilder();
        bd.append("id = ");bd.append(id);
        bd.append(" name = ");bd.append(name);
        bd.append(" price = ");bd.append(price);
        return (bd.toString());
    }
}
