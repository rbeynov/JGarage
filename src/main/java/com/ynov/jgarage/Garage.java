package com.ynov.jgarage;

import com.ynov.jgarage.exception.NoCarFoundException;
import com.ynov.jgarage.model.Car;
import com.ynov.jgarage.model.Owner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Garage {
    /*
     * ---------------------------------
     *		Attributs
     * ---------------------------------
     */
    // Map qui associe des Owner (cle) a des Car (valeurs).
    private Map<Owner, Car> cars;

    /*
     * ---------------------------------
     *		Constructeurs
     * ---------------------------------
     */
    public Garage() {
        cars = new HashMap<>();
    }

    /*
     * ---------------------------------
     *		Methodes
     * ---------------------------------
     */
    public void addCarToRepair(Owner owner, Car carToRepair) {
        // Ajoute un nouveau couple cle/valeur a la map
        cars.put(owner, carToRepair);
    }

    public boolean hasACarWaitingForRepairs(Owner owner) {
        // "containsKey" retourne un boolean indiquant si la cle passee en parametre existe bien dans la map.
        // Dans le cas present, si la cle existe dans la map, cela signifie bien que notre Owner a une voiture en attente de reparation.
        return cars.containsKey(owner);
    }

    /*
     * La methode returnCarToOwner declare qu'elle leve sous certaines conditions une exception (un comportement qu'elle juge anormal).
     * Cette exception sera de type "NoCarFoundException".
     */
    public Car returnCarToOwner(Owner owner) throws NoCarFoundException {
        // S'il n'y a pas de Car associee au proprietaire passe en parametre, leve une nouvelle exception de type "NoCarFoundException".
        if(!hasACarWaitingForRepairs(owner)) {
            throw new NoCarFoundException(owner);
        }

        // Enleve de la map le couple Owner/Car correspondant au Owner passee en parametre
        // La Car associee au Owner passe en parametre sera retournee par la methode
        return cars.remove(owner);
    }

    public void printStatus() {
        // Recupere l'ensemble des cles de la map (= l'ensemble des Owner).
        Set<Owner> allOwners = cars.keySet();

        // Pour chaque Owner dans ma liste "allOwners"...
        for(Owner anOwner : allOwners) {
            // Recupere la Car associe au Owner de l'iteration actuelle
            Car hisCar = cars.get(anOwner);

            // Affiche des informations au sujet du Owner ET de la CAR qu'il a amene au garage
            System.out.println(anOwner+" is waiting for its "+hisCar.getColor()+" "+hisCar.getModel()+ " ("+hisCar.getTotalPrice()+"€).");
        }
    }
}
