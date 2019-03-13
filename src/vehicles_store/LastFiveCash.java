package vehicles_store;

import java.util.ArrayList;

public class LastFiveCash {
    private int count = 0;
    private int countNum = 0;
    private ArrayList<Vehicle> last5Add = new ArrayList<>();

    public void lastFiveGoods(Vehicle vehicle) {
        if (count > 4) {
            if (countNum > 4) {
                count = 0;
                last5Add.set(count, vehicle);
            }
            last5Add.set(countNum, vehicle);
            countNum++;
        } else last5Add.add(vehicle);
        count++;
    }

    public void lookLastFiveGoods() {
        if (last5Add.isEmpty()) {
            System.out.println("Пусто");
        } else {
            for (Vehicle vehicle : last5Add) {
                System.out.println(vehicle);
            }
        }
    }
}
