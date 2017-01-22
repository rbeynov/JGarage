package com.ynov.jgarage.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    /*
     * ---------------------------------
     *		Attributs
     * ---------------------------------
     */

    private String model;
    private long price;
    private Color color;
    private List<Option> options;


    /*
     * ---------------------------------
     *		Constructeurs
     * ---------------------------------
     */


    public Car(String model, int price, Color color) {
        this.model = model;
        this.price = price;
        this.color = color;

        // Initialise la liste des options en tant que ArrayList (un des types de List).
        // Le type generic "Option" n'a pas besoin d'etre redefini du fait de l'operateur diamant <>
        // qui fait reference directement au type declare au niveau de la variable "options".
        this.options = new ArrayList<>();
    }


    /*
     * ---------------------------------
     *		Methodes
     * ---------------------------------
     */


    /**
     * Ajoute une option pour la voiture courante.
     * @param anOption
     *          Nouvelle option de la voiture.
     */
    public void addOption(Option anOption) {
        // Ajoute l'option passee en parametre de la methode dans la liste des options de la voiture courante
        options.add(anOption);
    }

    public List<Option> getOptions() {
        return options;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return
     *         Le prix total de ma voiture en comptabilisant les options de celle-ci.
     */
    public long getTotalPrice() {
        long totalPrice = price;

        // Pour chaque instance d'Option dans ma liste "options"
        for(Option anOption : options) {
            // Recupere le prix de cet option pour l'ajouter au prix total
            totalPrice += anOption.getPrice(); // Equivaut: totalPrice = totalPrice + anOption.getPrice();
        }

        return totalPrice;
    }
}
