package lafdilibilal.u5_w1_d1.entities;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;


    public void print() {
        System.out.printf("%-50s %-10s %-10s%n", "Pizzas", "Calories", "Price");
        pizzas.forEach(p -> System.out.printf("%-50s %-10d %-10.2f%n",
                p.toString(), p.getCalories(), p.getPrice()));

        System.out.println();

        System.out.printf("%-50s %-10s %-10s%n", "Toppings", "Calories", "Price");
        toppings.forEach(t -> System.out.printf("%-50s %-10d %-10.2f%n",
                t.getName(), t.getCalories(), t.getPrice()));

        System.out.println();

        System.out.printf("%-50s %-10s %-10s%n", "Drinks", "Calories", "Price");
        drinks.forEach(d -> System.out.printf("%-50s %-10d %-10.2f%n",
                d.toString(), d.getCalories(), d.getPrice()));
    }
}