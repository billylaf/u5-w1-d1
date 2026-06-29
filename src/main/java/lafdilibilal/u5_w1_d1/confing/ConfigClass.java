package lafdilibilal.u5_w1_d1.confing;

import lafdilibilal.u5_w1_d1.entities.Drink;
import lafdilibilal.u5_w1_d1.entities.Menu;
import lafdilibilal.u5_w1_d1.entities.Pizza;
import lafdilibilal.u5_w1_d1.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigClass {

    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 86, 0.99);
    }

    @Bean
    public Pizza margherita(Topping cheese) {
        return new Pizza("Pizza Margherita", List.of(cheese), 4.30);
    }

    @Bean
    public Pizza hawaiian(Topping ham, Topping pineapple) {
        return new Pizza("Hawaiian Pizza", List.of(ham, pineapple), 4.71);
    }

    @Bean
    public Pizza salamiPizza(Topping salami) {
        return new Pizza("Salami Pizza", List.of(salami), 5.00);
    }


    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade", 0.33, 128, 1.29);
    }

    @Bean
    public Drink water() {
        return new Drink("Water", 0.5, 0, 1.29);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine", 0.75, 607, 7.49);
    }

    @Bean
    public Menu menu(Pizza margherita, Pizza hawaiian, Pizza salamiPizza,
                     Topping cheese, Topping ham, Topping onions, Topping pineapple, Topping salami,
                     Drink lemonade, Drink water, Drink wine) {
        return new Menu(
                List.of(margherita, hawaiian, salamiPizza),
                List.of(cheese, ham, onions, pineapple, salami),
                List.of(lemonade, water, wine)
        );
    }
}