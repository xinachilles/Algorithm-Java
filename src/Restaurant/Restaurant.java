package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private List<Table> tables;
    private List<Meal> menu;
    private List<ServiceRobot> robots;
    public final int MAX_DINEHOUR = 2;
    public final long HOUR = 3600 * 1000;
    private static Restaurant instance;

    public Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    private Restaurant() {
        tables = new ArrayList<>();
        menu = new ArrayList<>();
    }
    public void addTable(Table t) {
        // Write your code here
    }
    public ServiceRobot findAvailableRobert(){
        for(Robot r: robots){
            // if r is service robert and is available
        }
        return null;
    }


    public void MakeReservation(Reservation r) {
        // Write your code here


    }



}



