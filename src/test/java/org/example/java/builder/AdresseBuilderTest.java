package org.example.java.builder;

import org.example.java.entities.Adresse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

class AdresseBuilderTest {
    private String UUIDFAKE;
    private String batimentResidence;
    private String appartementEscalierEtage;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;

    @BeforeEach
    void setUp() {
        UUIDFAKE = UUID.randomUUID().toString();
        batimentResidence = "batimentResidence 1";
        appartementEscalierEtage = "appartementEscalierEtage 1";
        numeroNomVoie = "numeroNomVoie 1";
        complementAdresse = "complementAdresse 1";
        codePostal = "codePostal 1";
        ville = "ville 1";
        pays = "pays 1";
    }

    @Test
    void testClone() {
        Adresse adresse = getNouvelleAdresse();
Adresse adresseClone = AdresseBuilder.builder().clone(adresse).build();
        then(adresseClone).usingRecursiveComparison()
                .isEqualTo(adresse);
    }

    @Test
    void build() {
        Adresse adresse = getNouvelleAdresse();
        then(adresse.getId()).hasToString(UUIDFAKE);
        then(adresse.getAppartementEscalierEtage()).hasToString(appartementEscalierEtage);
        then(adresse.getBatimentResidence()).hasToString(batimentResidence);
        then(adresse.getNumeroNomVoie()).hasToString(numeroNomVoie);
        then(adresse.getComplementAdresse()).hasToString(complementAdresse);
        then(adresse.getCodePostal()).hasToString(codePostal);
        then(adresse.getVille()).hasToString(ville);
        then(adresse.getPays()).hasToString(pays);

    }

    private Adresse getNouvelleAdresse() {
        return AdresseBuilder.builder()
                .id(UUIDFAKE)
                .batimentResidence(batimentResidence)
                .appartementEscalierEtage(appartementEscalierEtage)
                .numeroNomVoie(numeroNomVoie)
                .complementAdresse(complementAdresse)
                .codePostal(codePostal)
                .ville(ville)
                .pays(pays)
                .build();
    }
}
