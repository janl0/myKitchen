package com.application.mykitchen.consumables;

import java.nio.file.Path;

/**
 * @author Jan Lindauer
 */
public class Consumable {
    private String name;
    private String surname;

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
