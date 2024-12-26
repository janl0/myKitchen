package com.application.mykitchen.entities;

/**
 * @author Jan Lindauer
 */
public class Beverage extends Consumable {
    private Integer volume;
    private Integer alcoholVol;

    /**
     *
     * @return die Menge in Milliliter
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     *
     * @param volume Menge in Milliliter
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     *
     * @return den Alkoholprozentsatz
     */
    public Integer getAlcoholVol() {
        return alcoholVol;
    }

    /**
     *
     * @param alcoholVol den Alkoholprozentsatz
     */
    public void setAlcoholVol(Integer alcoholVol) {
        this.alcoholVol = alcoholVol;
    }
}
