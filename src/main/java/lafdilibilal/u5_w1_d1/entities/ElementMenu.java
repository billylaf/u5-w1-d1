package lafdilibilal.u5_w1_d1.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class ElementMenu {

    private String name;
    @Setter
    private double price;
    @Setter
    private int calories;

    protected ElementMenu() {
    }


    public ElementMenu(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                '}';
    }
}
