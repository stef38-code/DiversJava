package org.example.java.builder;

import org.example.java.core.entities.Adresse;

public class AdresseBuilder implements Builder<Adresse> {
    private String id;
    private String appartementEscalierEtage;
    private String batimentResidence;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;

    private AdresseBuilder() {
    }

    public static AdresseBuilder builder() {
        return new AdresseBuilder();
    }

    public AdresseBuilder clone(Adresse adresse) {
        this.id = adresse.getId();
        this.appartementEscalierEtage = adresse.getAppartementEscalierEtage();
        this.batimentResidence = adresse.getBatimentResidence();
        this.numeroNomVoie = adresse.getNumeroNomVoie();
        this.complementAdresse = adresse.getComplementAdresse();
        this.codePostal = adresse.getCodePostal();
        this.ville = adresse.getVille();
        this.pays = adresse.getPays();
        return this;
    }

    public Adresse build() {
        Adresse adresse = new Adresse();
        adresse.setId(this.id);
        adresse.setAppartementEscalierEtage(this.appartementEscalierEtage);
        adresse.setBatimentResidence(this.batimentResidence);
        adresse.setNumeroNomVoie(this.numeroNomVoie);
        adresse.setComplementAdresse(this.complementAdresse);
        adresse.setCodePostal(this.codePostal);
        adresse.setVille(this.ville);
        adresse.setPays(this.pays);
        return adresse;
    }
    public AdresseBuilder id(String id) {
        this.id = id;
        return this;
    }
    public AdresseBuilder appartementEscalierEtage(String appartementEscalierEtage) {
        this.appartementEscalierEtage = appartementEscalierEtage;
        return this;
    }

    public AdresseBuilder batimentResidence(String batimentResidence) {
        this.batimentResidence = batimentResidence;
        return this;
    }

    public AdresseBuilder numeroNomVoie(String numeroNomVoie) {
        this.numeroNomVoie = numeroNomVoie;
        return this;
    }

    public AdresseBuilder complementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
        return this;
    }

    public AdresseBuilder codePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public AdresseBuilder ville(String ville) {
        this.ville = ville;
        return this;
    }

    public AdresseBuilder pays(String pays) {
        this.pays = pays;
        return this;
    }
}
