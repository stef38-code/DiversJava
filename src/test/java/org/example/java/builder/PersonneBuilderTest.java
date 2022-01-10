package org.example.java.builder;

import java.time.LocalDate;

import org.example.java.entities.Adresse;
import org.example.java.entities.Personne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.UUID;

class PersonneBuilderTest {
    private String UUIDFAKE;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Adresse adresse1;
    private Adresse adresse2;

    @BeforeEach
    void setUp() {
        UUIDFAKE = UUID.randomUUID().toString();
        nom = "Robert";
        prenom = "Schreck";
        dateNaissance = LocalDate.of(1999, 12, 31);

        adresse1 = AdresseBuilder.builder()
                .batimentResidence("batimentResidence 1")
                .appartementEscalierEtage("appartementEscalierEtage 1")
                .numeroNomVoie("numeroNomVoie 1")
                .complementAdresse("complementAdresse 1")
                .codePostal("codePostal 1")
                .ville("ville 1")
                .pays("pays 1")
                .build();
        adresse2 = AdresseBuilder.builder()
                .batimentResidence("batimentResidence 2")
                .appartementEscalierEtage("appartementEscalierEtage 2")
                .numeroNomVoie("numeroNomVoie 2")
                .complementAdresse("complementAdresse 2")
                .codePostal("codePostal 2")
                .ville("ville 2")
                .pays("pays 2")
                .build();
    }

    @Test
    void build_Lorsque_runBuild_Attend_NouvellePersonne() {
        //Conditions préalables (given)
        //Une action se produit (when)
        Personne personne = getNouvellePersonne();
        //Vérifier la sortie (then)
        then(personne.getDateNaissance()).isNotNull().isEqualTo(dateNaissance);
        then(personne.getPrenom()).isNotNull().hasToString(prenom);
        then(personne.getNom()).isNotNull().hasToString(nom);
        then(personne.getId()).isNotNull().hasToString(UUIDFAKE);
        List<Adresse> adresseList = personne.getAdresses();
        then(adresseList).isNotEmpty();
        then(adresseList.get(0)).usingRecursiveComparison()
                .isEqualTo(adresse1);
        then(adresseList.get(1)).usingRecursiveComparison()
                .isEqualTo(adresse2);
    }

    @Test
    void build_EmptyPersonne() {
        //Conditions préalables (given)
        //Une action se produit (when)
        Personne actualBuildResult = PersonneBuilder.builder().build();
        //Vérifier la sortie (then)
        then(actualBuildResult.getDateNaissance()).isNull();
        then(actualBuildResult.getPrenom()).isNull();
        then(actualBuildResult.getNom()).isNull();
        then(actualBuildResult.getId()).isNull();
        assertThat(actualBuildResult.getAdresses()).isNull();
    }

    @Test
    void clone_UnePersonne() {
        //Conditions préalables (given)
        PersonneBuilder builderResult = PersonneBuilder.builder();
        //Une action se produit (when)
        Personne personne = getNouvellePersonne();
        //Vérifier la sortie (then)
        then(builderResult.clone(personne).build()).usingRecursiveComparison()
                .isEqualTo(personne);
    }

    /**
     * Getter d'une nouvelle personne via Builder
     * @return une nouvelle personne
     */
    private Personne getNouvellePersonne() {
        PersonneBuilder actualBuilderResult = PersonneBuilder.builder();
        actualBuilderResult.dateNaissance(dateNaissance);
        actualBuilderResult.id(UUIDFAKE);
        actualBuilderResult.nom(nom);
        actualBuilderResult.prenom(prenom);
        actualBuilderResult.adresses(getNouvellesAdresses());
        return actualBuilderResult.build();
    }

    private List<Adresse> getNouvellesAdresses(){
        return List.of(adresse1, adresse2);
    }
}

