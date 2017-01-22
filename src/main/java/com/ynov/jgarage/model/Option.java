package com.ynov.jgarage.model;

public class Option {
    /*
     * ---------------------------------
     *		Attributs
     * ---------------------------------
     */
    private String name;
    private long price;

    /*
     * ---------------------------------
     *		Constructeurs
     * ---------------------------------
     */
    public Option(String name, long price) {
        this.name = name;
        this.price = price;
    }

    /*
     * ---------------------------------
     *		Methodes
     * ---------------------------------
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
