package org.example.java.builder;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.UUID;

class PersonneBuilderTest {
    private String UUIDFAKE;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    @BeforeEach
    void setUp() {
        UUIDFAKE = UUID.randomUUID().toString();
        nom = "Robert";
        prenom = "Schreck";
        dateNaissance = LocalDate.of(1999, 12, 31);
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
        return actualBuilderResult.build();
    }
}

