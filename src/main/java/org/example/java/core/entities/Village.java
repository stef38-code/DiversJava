package org.example.java.core.entities;

import lombok.Getter;
import org.example.java.builder.GenericBuilder;
import org.example.java.core.entities.utils.RandonUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Village extends RandonUtil {

    public static final int NOMBRE_PERSONNE_DEFAUT = 10;
    private int nombrePersonne;

    public Village() {
        this.nombrePersonne = NOMBRE_PERSONNE_DEFAUT;
        Villageois = initPopulation();
    }
    public Village(int nombrePersonne) {
        this.nombrePersonne = nombrePersonne;
        Villageois = initPopulation();
    }

    @Getter
    private List<Personne> Villageois;


    List<String> noms = List.of("Lenoir de Ramos",
            "du Francois",
            "Benard",
            "Bonnin",
            "Becker de la Grenier",
            "du Bernier",
            "Dufour",
            "Samson",
            "Valentin",
            "Meunier");
    @Getter
    List<String> prenoms = List.of(
            "Louise",
            "Isaac",
            "Auguste",
            "Antoinette",
            "Eugène",
            "Laurent",
            "Grégoire",
            "Jacques",
            "Adélaïde-Caroline",
            "Philippe"
    );


    private List<Personne> initPopulation() {
        List<Personne> villageois = new ArrayList<>();
        IntStream.range(0, nombrePersonne)
                .forEachOrdered(
                        index -> {
                            villageois.add(genererUnVillageois());

                        }
                );
        return villageois;
    }

    private Personne genererUnVillageois() {
        String nom = getValues(noms);
        String prenom = getValues(prenoms);
        String uuid = getUUID();
        LocalDate dateNaissance = getLocalDate();
        return GenericBuilder.of(Personne::new)
                .with(Personne::setNom, nom)
                .with(Personne::setPrenom, prenom)
                .with(Personne::setId, uuid)
                .with(Personne::setDateNaissance, dateNaissance)
                .build();
    }
}
