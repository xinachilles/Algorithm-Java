package Restaurant;

import java.util.Date;
import java.util.List;

public interface Service {
    public void takeOrder(Table t, Order o);
    public float checkOut(Table t);
    //public List<Meal> getMenu(Meal m);
    public void findTable(Party p, List<Table> tables);
    public List<Reservation> findTableForReservation(Reservation r,List<Table> tables);
    public void cancelReservation(Reservation r);
    public void redeemReservation(Reservation r);
    }


