package vehicles_store;

public class SuperCar extends Car {
    private boolean canFly;
    private boolean canTransform;

    public SuperCar() {
    }

    public SuperCar(String model, String color, int maxSpeed, String machineSeries, int maxPassengers, boolean canFly, boolean canTransform) {
        super(model, color, maxSpeed, machineSeries, maxPassengers);
        this.canFly = canFly;
        this.canTransform = canTransform;
    }

    public String toString() {
        return "Модель супер авто: " + this.getModel() + ", цвет: " + this.getColor() + ", максимальная скорость: " + this.getMaxSpeed() +
                ", серия: " + this.getMachineSeries() + ", возможность летать: " + this.canFly + ", возможность трансформироваться: " +
                this.canTransform + ", стоимость " + this.getPrice() + " $.";
    }

    public boolean equals(SuperCar car) {
        return this.getModel() == car.getModel() && this.getColor() == car.getColor() && this.getMaxSpeed() == car.getMaxSpeed() && this.getPrice() == car.getPrice() && this.getMachineSeries() == car.getMachineSeries() && this.canFly == car.canFly && this.canTransform == car.canTransform;
    }


    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isCanTransform() {
        return canTransform;
    }

    public void setCanTransform(boolean canTransform) {
        this.canTransform = canTransform;
    }

    public static void main(String[] args) {
        SuperCar puperCar = new SuperCar("ace", "pad", 444, "Super", 2, true, false);
        SuperCar IronCar = new SuperCar("Spidi", "Snack", 999, "SuperPuper", 1, true, true);
        System.out.println(puperCar.toString());
        System.out.println(puperCar.equals(IronCar));

    }
}
