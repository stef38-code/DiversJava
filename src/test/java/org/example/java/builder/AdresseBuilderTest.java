package org.example.java.builder;

import org.example.java.core.entities.Adresse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;

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
        batimentResidence = "Résidence Les Tilleuls";
        appartementEscalierEtage = "Apt. 183";
        numeroNomVoie = "14, rue de la Hulotais";
        complementAdresse = "BP 14";
        codePostal = "59430";
        ville = "SAINT-POL-SUR-MER";
        pays = "France";
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
