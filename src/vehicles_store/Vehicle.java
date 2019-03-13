package vehicles_store;

import java.util.Objects;

public class Vehicle {

    private String model;
    private String color;
    private int maxSpeed;
    private int price;

    public Vehicle() {

    }

    public Vehicle(String model, String color, int maxSpeed, int price) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice() {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, maxSpeed, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return maxSpeed == vehicle.maxSpeed &&
                price == vehicle.price &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(color, vehicle.color);
    }

    @Override
    public String toString() {
        return this.model + " " + this.color + " " + this.maxSpeed + " " + this.price;
    }

    public static void main(String[] args) {
        Vehicle a = new Vehicle("a", "B", 123, 1);
        Vehicle b = new Vehicle("a", "B", 123, 1);
        System.out.println(b.toString());
        System.out.println(a.equals(b));
    }
}
