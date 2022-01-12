package org.example.java.builder;

import org.example.java.entities.Adresse;
import org.example.java.entities.Personne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

class GenericBuilderTest {
    private String UUIDFAKE;
    private String UUIDFAKEAdresse;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Adresse adresse;
    private String batimentResidence;
    private String appEscalEtage;
    private String numVoie;
    private String compAdre;
    private String codePostal;
    private String ville;
    private String pays;

    @BeforeEach
    void setUp() {
        UUIDFAKE = UUID.randomUUID().toString();
        UUIDFAKEAdresse = UUID.randomUUID().toString();
        nom = "Robert";
        prenom = "Schreck";
        dateNaissance = LocalDate.of(1999, 12, 31);
        batimentResidence = "Résidence Les Tilleuls";
        appEscalEtage = "Apt. 183";
        numVoie = "14, rue de la Hulotais";
        compAdre = "BP 14";
        codePostal = "59430";
        ville = "SAINT-POL-SUR-MER";
        pays = "France";
    }

    @Test
    void build_Lorsque_ContruitUnePersonne_Attend_UnePersonne() {
        //Conditions préalables (given)

        //Une action se produit (when)
        Personne personne = GenericBuilder.of(Personne::new)
                .with(Personne::setNom, nom)
                .with(Personne::setPrenom, prenom)
                .with(Personne::setId, UUIDFAKE)
                .with(Personne::setDateNaissance, dateNaissance)
                .with(Personne::setAdresses,
                        List.of(
                                GenericBuilder.of(Adresse::new)
                                        .with(Adresse::setId, UUIDFAKEAdresse)
                                        .with(Adresse::setBatimentResidence, batimentResidence)
                                        .with(Adresse::setAppartementEscalierEtage, appEscalEtage)
                                        .with(Adresse::setNumeroNomVoie, numVoie)
                                        .with(Adresse::setComplementAdresse, compAdre)
                                        .with(Adresse::setCodePostal, codePostal)
                                        .with(Adresse::setVille, ville)
                                        .with(Adresse::setPays, pays)
                                        .build()
                        ))
                .build();
        //Vérifier la sortie (then)
        then(personne.getDateNaissance()).isNotNull().isEqualTo(dateNaissance);
        then(personne.getPrenom()).isNotNull().hasToString(prenom);
        then(personne.getNom()).isNotNull().hasToString(nom);
        then(personne.getId()).isNotNull().hasToString(UUIDFAKE);
        List<Adresse> adresseList = personne.getAdresses();
        then(adresseList).isNotEmpty();
        Adresse adresse = adresseList.get(0);
        then(adresse.getId()).hasToString(UUIDFAKEAdresse);
        then(adresse.getAppartementEscalierEtage()).hasToString(appEscalEtage);
        then(adresse.getBatimentResidence()).hasToString(batimentResidence);
        then(adresse.getNumeroNomVoie()).hasToString(numVoie);
        then(adresse.getComplementAdresse()).hasToString(compAdre);
        then(adresse.getCodePostal()).hasToString(codePostal);
        then(adresse.getVille()).hasToString(ville);
        then(adresse.getPays()).hasToString(pays);
    }


}
