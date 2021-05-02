package Restaurant;

import java.util.Date;
import java.util.List;

public class ServiceRobot extends Robot implements Service {

    public void takeOrder(Table t, Order o) {
        // Write your code here
        t.setOrder(o);
    }

    public float checkOut(Table t) {
        // Write your code here
        /*
        if (t == null) {
            return 0F;
        } else {

            t.markAvailable();
            return t.getCurrentOrder().getBill();
        }
        */

        return (float)0.0;
    }
 /*
    public List<Meal> getMenu() {
        return menu;
    }
*/
    public void findTable(Party p, List<Table> tables) {
        Date currentDate = new Date();
        for(Table t :tables)
        {
            if (t.isAvailable()) {
                if (t.getCapacity() >= p.getSize()) {
                    if (t.noFollowReservation(currentDate)) {
                        t.markUnavailable();
                        return;
                    }
                }
            }
        }
        //throw new NoTableException(p);
    }
    public List<Reservation> findTableForReservation(Reservation r,List<Table> tables) {
        // Write your code here

        for(Table t : tables) {
            if (t.getCapacity() >= r.size) {
              //  return t.CheckReservation(r.startTime, r.endTime);

            }
        }


        return null;
    }

    public void cancelReservation(Reservation r) {
      //  Date date = r.getDate();
      //  r.getTable().removeReservation(date);
    }

    public void redeemReservation(Reservation r) {
     //   Date date = r.getDate();
     //   Table table = r.getTable();

      //  table.markUnavailable();
      //  table.removeReservation(date);
    }

}
