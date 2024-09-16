package com.application.mykitchen.entities;

/**
 * @author Jan Lindauer
 */
public class Consumable {
    private String name;
    private String surname;
    private Integer drawable;

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
