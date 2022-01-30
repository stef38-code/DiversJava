package org.example.java.pattern.visitor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LaPoste implements ForfaitLivraison {
    @Getter
    int delai;
    @Getter
    String label;
    @Getter
    double prix;

    @Override
    public void accept(Livraison livraison) {
        livraison.visit(this);
    }
}
