package org.example.java.builder;

import org.example.java.entities.Personne;

import java.time.LocalDate;

public class PersonneBuilder implements Builder<Personne> {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    private PersonneBuilder() {
    }

    public static PersonneBuilder builder() {
        return new PersonneBuilder();
    }

    public PersonneBuilder clone(Personne personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.dateNaissance = personne.getDateNaissance();
        return this;
    }

    public Personne build() {
        Personne personne = new Personne();
        personne.setId(this.id);
        personne.setNom(this.nom);
        personne.setPrenom(this.prenom);
        personne.setDateNaissance(this.dateNaissance);
        return personne;
    }

    public PersonneBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PersonneBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneBuilder dateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }
}
