package org.example.java.builder;

import org.example.java.entities.Adresse;
import org.example.java.entities.Personne;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

/**
 * source : https://medium.com/beingprofessional/think-functional-advanced-builder-pattern-using-lambda-284714b85ed5
 */
public class PersonneBuilderWithConsumer {
    public String id;
    public String nom;
    public String prenom;
    public LocalDate dateNaissance;
    public List<Adresse> adresses;

    public PersonneBuilderWithConsumer with(
            Consumer<PersonneBuilderWithConsumer> builderFunction) {
        builderFunction.accept(this);
        return this;
    }


    public Personne createPersonne() {
        Personne personne = new Personne();
        personne.setId(this.id);
        personne.setNom(this.nom);
        personne.setPrenom(this.prenom);
        personne.setDateNaissance(this.dateNaissance);
        personne.setAdresses(this.adresses);
        return personne;
    }
}
