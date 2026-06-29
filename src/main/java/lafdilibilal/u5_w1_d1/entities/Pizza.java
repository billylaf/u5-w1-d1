package lafdilibilal.u5_w1_d1.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pizza implements MenuItem {
    private static final int BASE_CALORIES = 800;
    private String name;
    private List<Topping> toppings;
    private double basePrice;

    public Pizza(String name, List<Topping> toppings, double basePrice) {
        this.name = name;
        this.toppings = toppings;
        this.basePrice = basePrice;
    }

    @Override
    public int getCalories() {
        return BASE_CALORIES + toppings.stream()
                .mapToInt(Topping::getCalories)
                .sum();
    }

    @Override
    public double getPrice() {
        return basePrice + toppings.stream()
                .mapToDouble(Topping::getPrice)
                .sum();
    }

    private String getToppingNames() {
        List<String> names = new ArrayList<>();
        names.add("tomato");
        names.add("cheese");
        toppings.forEach(t -> names.add(t.getName().toLowerCase()));
        return String.join(", ", names);
    }

    @Override
    public String toString() {
        return name + " (" + getToppingNames() + ")";
    }
}
