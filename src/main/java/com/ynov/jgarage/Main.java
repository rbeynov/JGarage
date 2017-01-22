package com.ynov.jgarage;

import com.ynov.jgarage.exception.NoCarFoundException;
import com.ynov.jgarage.model.Car;
import com.ynov.jgarage.model.Color;
import com.ynov.jgarage.model.Option;
import com.ynov.jgarage.model.Owner;

public class Main {

    public static void main(String[] args) {
        // Creation d'instances de proprietaires
        Owner alex = new Owner("Alex", "Terieur");
        Owner thomas = new Owner("Aimée", "Naimes");
        Owner ray = new Owner("Ray", "Defesse");

        // Creation d'instances d'options
        Option toitOuvrant = new Option("Toit ouvrant", 500);
        Option climatisation = new Option("Climatisation", 200);
        Option regulateur = new Option("Régulateur de vitesse", 100);

        // Creation d'instances de voitures
        Car clio = new Car("Clio", 1000, Color.WHITE);
        Car auditt = new Car("Audi TT", 30000, Color.YELLOW);

        // Ajout des options aux voitures
        clio.addOption(climatisation);
        clio.addOption(toitOuvrant);
        auditt.addOption(regulateur);

        // Creation d'une instance de garage
        Garage garage = new Garage();

        // Ajout des voitures au garage avec leurs proprietaires respectifs
        garage.addCarToRepair(alex, clio);
        garage.addCarToRepair(thomas, auditt);

        // Affiche le status actuel du garage
        garage.printStatus();

        /*
         * Tente de retirer une voiture pour un proprietaire. Ce code est "a risque" puisque "returnCarToOwner" est une methode qui indique lever
         * potentiellement des exceptions de type "NoCarFoundException". Le code est donc entoure d'un bloc try...catch capable de gerer ce genre de soucis.
         */
        try {
            System.out.println("Retirons la voiture d'Alex...");
            garage.returnCarToOwner(alex); // Retire la voiture d'Alex
            garage.printStatus();

            System.out.println("Retirons la voiture de Ray...");
            garage.returnCarToOwner(ray); // Va lever une exception parce que Ray n'a pas de voiture au garage...
            garage.printStatus(); // Ce code ne sera jamais atteint du fait de l'exception levee juste au dessus lors de l'execution
        } catch (NoCarFoundException ex) {
            // On peut acceder a des proprietes ou methodes dans mon exception
            System.out.println("Le client "+ex.getInvalidOwner()+" ne semble pas avoir de voiture au garage...");
            ex.printStackTrace();
        }
    }
}
