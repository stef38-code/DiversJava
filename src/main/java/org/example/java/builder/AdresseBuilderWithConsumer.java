package org.example.java.builder;

import org.example.java.entities.Adresse;

import java.util.function.Consumer;

public class AdresseBuilderWithConsumer {
    public String id;
    public String appartementEscalierEtage;
    public String batimentResidence;
    public String numeroNomVoie;
    public String complementAdresse;
    public String codePostal;
    public String ville;
    public String pays;

    public AdresseBuilderWithConsumer with(
            Consumer<AdresseBuilderWithConsumer> builderFunction) {
        builderFunction.accept(this);
        return this;
    }


    public Adresse createAdresse() {
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

}
