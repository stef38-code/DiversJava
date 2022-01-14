package org.example.java.core.entities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class VillageTest {
    @Test
    void getVillageois_Lorsque_contructeurVide_Attend_10Personnes() {
        Village village = new Village();
        List<Personne> villageois = village.getVillageois();
        then(villageois).isNotEmpty().hasSize(Village.NOMBRE_PERSONNE_DEFAUT);
    }

    @Test
    void getVillageois_Lorsque_contructeur_nombrePersonne100_Attend_100Personnes() {
        int nombrePersonne = 100;
        Village village = new Village(nombrePersonne);
        List<Personne> villageois = village.getVillageois();
        then(villageois).isNotEmpty().hasSize(nombrePersonne);
    }

}
