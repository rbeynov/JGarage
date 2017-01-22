package com.ynov.jgarage.exception;

import com.ynov.jgarage.model.Owner;

/*
 * Exception personnalisee fonctionnant comme toutes les classes (possibilite d'avoir des attributes et des methodes).
 * En se declarant comme enfant de "Exception" cela permet a la classe d'etre consideree comme telle et donc de pouvoir etre levee.
 */
public class NoCarFoundException extends Exception {
    private Owner invalidOwner;

    public NoCarFoundException(Owner owner) {
        super("No car has been found for owner "+owner);
        this.invalidOwner = owner;
    }

    public Owner getInvalidOwner() {
        return invalidOwner;
    }
}
