package org.example.java.core.entities;

import lombok.Getter;
import org.example.java.builder.GenericBuilder;
import org.example.java.core.entities.utils.RandonUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Village extends RandonUtil {
    @Getter
    private final List<Personne> personnes;
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

    public Village() {
        personnes = initPopulation();
    }

    private List<Personne> initPopulation() {
        List<Personne> gens = new ArrayList<>();
        IntStream.range(1, 10)
                .forEachOrdered(
                        index -> {
                            Personne personne = genererUnePersonne();
                        }
                );
        return gens;
    }

    private Personne genererUnePersonne() {
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
