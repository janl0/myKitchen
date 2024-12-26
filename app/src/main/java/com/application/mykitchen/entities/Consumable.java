package com.application.mykitchen.entities;

/**
 * @author Jan Lindauer
 */
public class Consumable {

    private int id;

    private String name;
    private String surname;
    private Integer drawable;
    private String quant;
    private String unit;

    public int getId() {
        return id;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getDrawable() {
        return drawable;
    }

    public void setDrawable(Integer drawable) {
        this.drawable = drawable;
    }

    /**
     *
     * @return den Namen
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Name des Getränks
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return die Sorte
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname Sorte des Getränks
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
