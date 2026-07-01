package lafdilibilal.u5_w1_d1;

import lafdilibilal.u5_w1_d1.Enum.StatoOrdine;
import lafdilibilal.u5_w1_d1.Enum.StatoTavolo;
import lafdilibilal.u5_w1_d1.entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class U5W1D1ApplicationTests {

    @Value("${costo.coperto}")
    private double costoCoperto;

    @Autowired
    private ApplicationContext ctx;


    @Test
    @DisplayName("Test Verifica Contenuto Menu")
    void testVerificaContenutoMenu() {
        Menu menu = ctx.getBean(Menu.class);

        assertNotNull(menu.getPizza(), "La lista pizze non dovrebbe essere null");
        assertNotNull(menu.getDrink(), "La lista bevande non dovrebbe essere null");
        assertNotNull(menu.getTopping(), "La lista topping non dovrebbe essere null");

        assertEquals(3, menu.getPizza().size(), "Dovrebbero esserci 3 pizze nel menu");
        assertEquals(4, menu.getDrink().size(), "Dovrebbero esserci 4 bevande nel menu");
        assertEquals(4, menu.getTopping().size(), "Dovrebbero esserci 4 topping nel menu");
    }


    @Test
    @DisplayName("Test Creazione Ordine Base")
    void testCreazioneOrdine() {
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.OCCUPATO);
        Ordine ordine = new Ordine(
                1001,
                StatoOrdine.IN_CORSO,
                2,
                tavolo,
                costoCoperto
        );

        assertNotNull(ordine, "L'ordine non dovrebbe essere null");
        assertEquals(1001, ordine.getNumeroOrdine(), "Il numero ordine dovrebbe essere 1001");
        assertEquals(StatoOrdine.IN_CORSO, ordine.getStato(), "Lo stato dovrebbe essere IN_CORSO");
        assertEquals(2, ordine.getNumeroCoperti(), "I coperti dovrebbero essere 2");
        assertNotNull(ordine.getOraAcquisizione(), "L'ora di acquisizione non dovrebbe essere null");
    }

    @Test
    @DisplayName("Test Calcolo Totale Ordine")
    void testCalcoloTotaleOrdine() {
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.OCCUPATO);
        Ordine ordine = new Ordine(1001, StatoOrdine.IN_CORSO, 2, tavolo, costoCoperto);

        Pizza margherita = ctx.getBean("margherita", Pizza.class); // 7.00
        Drink cocaCola = ctx.getBean("cocaCola", Drink.class); // 3.00

        ordine.aggiungiElemento(margherita);
        ordine.aggiungiElemento(cocaCola);

        double totaleAtteso = (2 * costoCoperto) + 7.00 + 3.00;
        assertEquals(totaleAtteso, ordine.getTotale(), 0.01, "Il totale dovrebbe essere calcolato correttamente");
    }

    @Test
    @DisplayName("Test Ordine Vuoto - Solo Coperti")
    void testOrdineVuotoSoloCoperti() {
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.OCCUPATO);
        Ordine ordine = new Ordine(1001, StatoOrdine.IN_CORSO, 2, tavolo, costoCoperto);

        assertEquals(0, ordine.getElementi().size(), "L'ordine dovrebbe essere vuoto");
        double totaleAtteso = 2 * costoCoperto;
        assertEquals(totaleAtteso, ordine.getTotale(), 0.01, "Il totale dovrebbe essere solo il costo dei coperti");
    }


}
