package AmazonOA;

import java.util.*;

public class Turnstile {
    public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {

        int[] result = new int[numCustomers];

        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();

        Queue<Integer> entryQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();

        int i = 0;

        int turnstileDirection = -1; // default unused-1
 // build a map and key is time stamp and value is {customer, direction } pair
        for (int a : arrTime) {
            map.computeIfAbsent( a, value->new ArrayList<int[]>()).add(new int[] { i, direction[i] });
            i++;
        }

        i = 0; // used to determine timeStamp,
        while (numCustomers > 0) {

            if (map.containsKey(i)) {
                // at current time, the customers/directions want to pass through the turnstile
                List<int[]> customers = map.get(i);
                for (int[] customer : customers) {
                    if (customer[1] == 1) {
                        exitQ.offer(customer[0]);
                    } else {
                        entryQ.offer(customer[0]);
                    }
                }
            }
            // no one pass
            if (entryQ.isEmpty() && exitQ.isEmpty()) {
                turnstileDirection = -1;
                i++;
                continue;
            }

            int customer;
            if (!entryQ.isEmpty() && !exitQ.isEmpty()) {

                switch (turnstileDirection) {
                    case -1: // unused, exist first

                        customer = exitQ.poll();
                        result[customer] = i;
                        numCustomers--;
                        turnstileDirection = 1;
                        i++;
                        break;

                    case 1: // used for exit, exist first
                        customer = exitQ.poll();
                        result[customer] = i;
                        numCustomers--;
                        turnstileDirection = 1;
                        i++;
                        break;

                    case 0: // used to entry,enter goes first
                        customer = entryQ.poll();
                        result[customer] = i;
                        numCustomers--;
                        turnstileDirection = 0;
                        i++;
                        break;

                }
                continue;
            }

            if (!entryQ.isEmpty()) {
                customer = entryQ.poll();
                result[customer] = i;
                numCustomers--;
                turnstileDirection = 0;
                i++;
                continue;
            }

            if (!exitQ.isEmpty()) {
                customer = exitQ.poll();
                result[customer] = i;
                numCustomers--;
                turnstileDirection = 1;
                i++;
                continue;
            }
        }

        return result;
    }
}
