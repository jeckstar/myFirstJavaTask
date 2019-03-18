package vehicles_store;

import java.util.Objects;

public class Plane extends Vehicle {
    private int maxFlySpeed;

    public Plane(){

    }

    public Plane(String model, String color, int maxSpeed,int maxFlySpeed, int price) {
        super(model, color, maxSpeed, price);
        this.maxFlySpeed = maxFlySpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(maxFlySpeed, plane.maxFlySpeed);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxFlySpeed);
    }

    @Override
    public String toString() {
        return "Модель самолета - " + this.getModel() + ", цвет - " + this.getColor() + ", максимальная скорость на суше- " + this.getMaxSpeed() + ", максисмальная скорость в воздуху - " + this.maxFlySpeed + ", стоимость - " + this.getPrice();
    }

}
