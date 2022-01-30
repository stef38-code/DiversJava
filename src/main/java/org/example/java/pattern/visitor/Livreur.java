package org.example.java.pattern.visitor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Livreur implements ForfaitLivraison {
    @Getter
    int delai;
    @Getter
    String label;
    double prix;
    double tva;

    @Override
    public void accept(Livraison livraison) {
        livraison.visit(this);
    }

    public double getPrix() {
        return prix * (1 + (tva / 100));
    }
}
