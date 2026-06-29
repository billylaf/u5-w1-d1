package lafdilibilal.u5_w1_d1;

import lafdilibilal.u5_w1_d1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class U5W1D1Application {
    public static void main(String[] args) {
        var context = SpringApplication.run(U5W1D1Application.class, args);

        Menu menu = context.getBean(Menu.class);
        menu.print();
    }
}
