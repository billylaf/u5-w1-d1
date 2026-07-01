package lafdilibilal.u5_w1_d1.runners;

import lafdilibilal.u5_w1_d1.Enum.StatoOrdine;
import lafdilibilal.u5_w1_d1.Enum.StatoTavolo;
import lafdilibilal.u5_w1_d1.entities.Menu;
import lafdilibilal.u5_w1_d1.entities.Ordine;
import lafdilibilal.u5_w1_d1.entities.Tavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerOrdini implements CommandLineRunner {

    private final Menu menu;
    private final double costoCoperto;

    public RunnerOrdini(Menu menu, @Value("${costo.coperto}") double costoCoperto) {
        this.menu = menu;
        this.costoCoperto = costoCoperto;
    }

    @Override
    public void run(String... args) {

        System.out.println("MENU COMPLETO \n");
        menu.printMenu();

        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine(
                1001,
                StatoOrdine.IN_CORSO,
                2,
                tavolo,
                costoCoperto
        );

        ordine.aggiungiElemento(menu.getPizza().get(0));
        ordine.aggiungiElemento(menu.getDrink().get(1));

        System.out.println("\nORDINE CREATO \n");
        System.out.println(ordine);
    }
}