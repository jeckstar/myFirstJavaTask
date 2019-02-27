public class superCar extends Car {
    private boolean canFly;
    private boolean canTransform;

    public superCar(){
    }

    public superCar(String model, String color, int maxSpeed, String machineSeries, int maxPassengers, boolean canFly, boolean canTransform){
        super(model, color, maxSpeed, machineSeries, maxPassengers);
        this.canFly = canFly;
        this.canTransform = canTransform;
    }
    public String toString(){
        return "Model: "+this.getModel()+", Color: "+this.getColor()+", Max Speed: "+this.getMaxSpeed()+", Series: "+this.getMachineSeries()+", Max Passengers "+this.getMaxPassengers()+", Can Fly: "+ this.canFly+", Can Transform: "+this.canTransform+".";
    }
    public boolean equals(superCar car){
        return this.getModel() == car.getModel() && this.getColor() == car.getColor() && this.getMaxSpeed() == car.getMaxSpeed() && this.getMaxPassengers() == car.getMaxPassengers() && this.getMachineSeries() == car.getMachineSeries() && this.canFly == car.canFly && this.canTransform == car.canTransform;
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
        superCar puperCar = new superCar("ace", "pad", 444, "Super", 2, true, false);
        superCar IronCar = new superCar("Spidi", "Snack", 999, "SuperPuper", 1, true, true);
        System.out.println(puperCar.toString());
        System.out.println(puperCar.equals(IronCar));

    }
}
