package lafdilibilal.u5_w1_d1.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Menu {

    private List<Pizza> pizza;
    private List<Drink> drink;
    private List<Topping> topping;

    protected Menu() {
    }

    public Menu(List<Pizza> pizza, List<Topping> topping, List<Drink> drink) {
        this.pizza = pizza;
        this.topping = topping;
        this.drink = drink;
    }

    public void printMenu() {

        System.out.printf("%-40s %-10s %-10s%n", "PIZZE", "Calories", "Price");
        pizza.forEach(p -> System.out.printf(
                "%-40s %-10d %-10.2f%n",
                p.getName(), p.getCalories(), p.getPrice()
        ));

        System.out.println();

        System.out.printf("%-40s %-10s %-10s%n", "TOPPING", "Calories", "Price");
        topping.forEach(t -> System.out.printf(
                "%-40s %-10d %-10.2f%n",
                t.getName(), t.getCalories(), t.getPrice()
        ));

        System.out.println();

        System.out.printf("%-40s %-10s %-10s%n", "BEVANDE", "Calories", "Price");
        drink.forEach(d -> System.out.printf(
                "%-40s %-10d %-10.2f%n",
                d.getName(), d.getCalories(), d.getPrice()
        ));
    }


}