package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> meals;
    private String customers;

    public Order()
    {
        meals = new ArrayList<Meal>();
    }

    public List<Meal> getMeals()
    {
        return meals;
    }

    public void mergeOrder(Order order)
    {
        if(order != null)
        {
            for(Meal meal : order.getMeals())
            {
                meals.add(meal);
            }
        }
    }

    public float getBill()
    {
        int bill = 0;
        for(Meal meal : meals)
        {
            bill += meal.getPrice();
        }
        return bill;
    }
}
