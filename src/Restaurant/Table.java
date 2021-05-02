package Restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Table implements Comparable<Table> {
        private int id;
        private int capacity;
        private boolean available;
        private List<Order> orders;
        List<Date> reservations;
        final int MILLI_TO_HOUR = 1000 * 60 * 60;

        public Table(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
            available = true;
            orders = new ArrayList<>();
            reservations = new ArrayList<>();
        }

        public int getId() {
            return this.id;
        }

        public int getCapacity() {
            return this.capacity;
        }

        public List<Date> getReservation() {
            return reservations;
        }

        public Boolean isAvailable() {
            return this.available;
        }

        public void markAvailable() {
            this.available = true;
        }

        public void markUnavailable() {
            this.available = false;
        }

      //  public Order getCurrentOrder() {
          //  return this.orders.get(0);
       // }

        public void setOrder(Order o) {
            if (orders == null) {
               orders = new ArrayList<>();
               orders.add(o);
            } else {
                if (o != null) {
                    this.orders.add(o);
                }
            }
        }

        @Override
        public int compareTo(Table compareTable) {
            // TODO Auto-generated method stub
            return this.capacity - compareTable.getCapacity();
        }

        // find the smallest one which greater than d
        private int findDatePosition(Date d) {
            int len = reservations.size() - 1;
            if (len == 0)
                return 0;
            if (d.compareTo(reservations.get(len))>0) {
                return len + 1;
            }

            int start = 0;
            int end = len;

            while (start + 1 < end) {
                int mid = (start + end) / 2;
                if (d.compareTo(reservations.get(mid))>0) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (reservations.get(end).compareTo(d) <= 0) {
                return end;
            } else {
                return start;
            }
        }

        public boolean noFollowReservation(Date time) {
            return false;
        }

        public List<Date> CheckReservation(Date startDatime, Date endDatime) {
            // Write your code here

            // find the smallest time bigger or equal than startDatime
            // find the bigesest time smaller or equal than endDatme
            // return the index of postion
            int start = findDatePosition(startDatime);
            int end = findDatePosition(endDatime);

            //int housr =(int) (endDatime- startDatime);
            int hoursNeed = 0;

            // if start == reservations.length-1
            if (start == reservations.size() - 1) {
                // just return next five avaiblae slottime
            }
            if (start != -1 || end != -1 || end - start >= hoursNeed) {
                //  return List from start To ned
            } else {
                return null;
            }

            return null;

        }


        public void Reservation(Date start, Date end) {

            //for(int i =  start; i<=end; i= ){

            //}

            // add hour by hour from start to end to reservations
        }

        public void removeReservation(Date d) {
            reservations.remove(d);
        }

    }
