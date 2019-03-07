package store;

import java.util.Objects;

public class Car extends Vehicle {
    private String machineSeries;


    public Car() {
    }

    public Car(String model, String color, int maxSpeed, String machineSeries, int price) {
        super(model, color, maxSpeed, price);
        this.machineSeries = machineSeries;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(machineSeries, car.machineSeries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), machineSeries);
    }

    public String toString() {
        return "Модель - " + this.getModel() + ", цвет - " + this.getColor() + ", максимальная скорость - " + this.getMaxSpeed() + ", серия - " + this.machineSeries + ", стоимость - " + this.getPrice();
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public static void main(String[] args) {
        Car car = new Car("a", "b", 123, "chi", 4);
        Car car2 = new Car("a", "b", 123, "chi", 4);

        System.out.println(car.toString());
        System.out.println(car.equals(car2));

    }

}
