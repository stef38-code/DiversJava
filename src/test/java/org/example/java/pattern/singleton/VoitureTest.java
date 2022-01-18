package org.example.java.pattern.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

class VoitureTest {

    private int nbRoues;
    private String marque;
    private String couleur;

    @BeforeEach
    void setUp() {
        nbRoues = 4;
        marque = "Peugeot";
        couleur = "Blanche";
    }

    @Test
    void getInstance_Lorsque_Creation2Instances_Attend_LesMemeAttributs() {
        //Conditions préalables (given)
        Voiture voiture1 = Voiture.getInstance();
        Voiture voiture2 = Voiture.getInstance();
        //Une action se produit (when)
        voiture1.setInfoVoiture(nbRoues, marque, couleur);
        //Vérifier la sortie (then)
        then(voiture2.getNbRoues()).isEqualTo(nbRoues);
        then(voiture2.getMarque()).hasToString(marque);
        then(voiture2.getCouleur()).hasToString(couleur);
    }


}
