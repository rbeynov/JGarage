package com.ynov.jgarage.model;

public class Owner {
    /*
     * ---------------------------------
     *		Attributs
     * ---------------------------------
     */
    private String firstname;
    private String lastname;

    /*
     * ---------------------------------
     *		Constructeurs
     * ---------------------------------
     */
    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /*
     * ---------------------------------
     *		Methodes
     * ---------------------------------
     */

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*
     * Cette methode est appelee des que l'on souhaite avoir la representation sous forme de chaine de charactere
     * de notre object "Owner". Cette methode existe deja dans le type "Object" parent implicite de tous les objets
     * et affiche la reference en memoire de notre instance.
     * Sa redefinition ici permet d'afficher a la place le prenom et le nom de famille en majuscule des que l'on passe une instance
     * d'owner en tant qu'argument de System.out.println(). Exemple:
     *
     * Owner unProprio = new Owner("Jean", "Bon");
     * System.out.println(unProprio);
     *
     * ==> Affiche "Jean BON" en console.
     */
    @Override
    public String toString() {
        return firstname + " " + lastname.toUpperCase();
    }
}
