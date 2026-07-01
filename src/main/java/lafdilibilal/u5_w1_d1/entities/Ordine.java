package lafdilibilal.u5_w1_d1.entities;

import lafdilibilal.u5_w1_d1.Enum.StatoOrdine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordine {

    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private Tavolo tavolo;
    private double costoCoperto;
    private List<ElementMenu> elementi = new ArrayList<>();

    public Ordine(int numeroOrdine, StatoOrdine stato, int numeroCoperti,
                  Tavolo tavolo, double costoCoperto) {
        this.numeroOrdine = numeroOrdine;
        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.tavolo = tavolo;
        this.costoCoperto = costoCoperto;
        this.oraAcquisizione = LocalDateTime.now();
    }

    public void aggiungiElemento(ElementMenu elemento) {
        elementi.add(elemento);
    }

    public double getTotale() {
        double totale = numeroCoperti * costoCoperto;
        for (ElementMenu e : elementi) {
            totale += e.getPrice();
        }
        return totale;
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public int getNumeroCoperti() {
        return numeroCoperti;
    }

    public LocalDateTime getOraAcquisizione() {
        return oraAcquisizione;
    }

    public List<ElementMenu> getElementi() {
        return elementi;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", stato=" + stato +
                ", numeroCoperti=" + numeroCoperti +
                ", oraAcquisizione=" + oraAcquisizione +
                ", tavolo=" + tavolo +
                ", totale=" + getTotale() +
                '}';
    }


}