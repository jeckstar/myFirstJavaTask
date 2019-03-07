package store;

public class Car extends Vehicle {
    private String machineSeries;
    private int price;

    public Car() {
    }
    public Car(String model, String color, int maxSpeed, String machineSeries, int price){
        super(model, color,maxSpeed);
        this.machineSeries = machineSeries;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean equals(Car car){
        return this.getModel() == car.getModel() && this.getColor() == car.getColor() && this.getMaxSpeed() == car.getMaxSpeed() && this.price == car.price && this.machineSeries == car.machineSeries;
    }
    public String toString(){
        return this.getModel()+" "+this.getColor()+" "+this.getMaxSpeed()+" "+this.machineSeries+" "+this.price;
    }

    public String getMachineSeries() {
        return machineSeries;
    }
    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }
    public int getMaxPassengers() {
        return price;
    }
    public void setMaxPassengers(int maxPassengers) {
        this.price = maxPassengers;
    }

    public static void main(String[] args) {
        Car car = new Car("a","b",123,"chi",4);
        Car car2 = new Car("a","b",123,"chi",4);

        System.out.println(car.toString());
        System.out.println(car.equals(car2));

    }

}
