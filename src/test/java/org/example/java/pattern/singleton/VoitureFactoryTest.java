package org.example.java.pattern.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertAll;

class VoitureFactoryTest {

    private int nbRoues;
    private String marque;
    private String couleur;
    private Voiture voiture1;
    private Voiture voiture2;
private VoitureFactory voitureFactory1;
private VoitureFactory voitureFactory2;
    @BeforeEach
    void setUp() {
        nbRoues = 4;
        marque = "Peugeot";
        couleur = "Blanche";
        voitureFactory1 = new VoitureFactory();
        voitureFactory2 = new VoitureFactory();

        voiture1 = voitureFactory1.getInstance();
        voiture2 = voitureFactory2.getInstance();
    }

    @Test
    void getInstance_Lorsque_Creation2Instances_Attend_LesMemeAttributs() {
        //Conditions préalables (given)
        //Une action se produit (when)
        voiture1.setInfoVoiture(nbRoues, marque, couleur);
        //Vérifier la sortie (then)

        assertAll("Controle des propriete de la voiture 1",
                ()->then(voiture1.getNbRoues()).isEqualTo(nbRoues),
                ()->then(voiture1.getMarque()).hasToString(marque),
                () ->then(voiture1.getCouleur()).hasToString(couleur)
        );
        assertAll("Controle des propriete de la voiture 2",
                ()->then(voiture2.getNbRoues()).isEqualTo(nbRoues),
                ()->then(voiture2.getMarque()).hasToString(marque),
                ()->then(voiture2.getCouleur()).hasToString(couleur)
        );
        assertAll("Controle si la voiture1 egale voiture 2",
                ()->then(voiture1).isEqualTo(voiture2)
        );
    }


}
