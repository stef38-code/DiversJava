package org.example.java.pattern.visitor;

import lombok.Getter;

import java.text.MessageFormat;

public class LivraisonImpl implements Livraison {
    String pattern = "Type: {0} Delai: {1,number} jours tarif:{2} €";
    @Getter
    StringBuilder afficheTarif = new StringBuilder();

    @Override
    public void visit(LaPoste laPoste) {
         afficheTarif.append(
                getMessage(laPoste.getLabel(),laPoste.getDelai(),laPoste.getPrix())
        ).append(System.getProperty("line.separator"));
    }

    @Override
    public void visit(Livreur livreur) {
         afficheTarif.append(
                getMessage(livreur.getLabel(),livreur.getDelai(),livreur.getPrix())
        ).append(System.getProperty("line.separator"));
    }

    @Override
    public void visit(PointRelais pointRelais) {
         afficheTarif.append(
                getMessage(pointRelais.getLabel(),pointRelais.getDelai(),pointRelais.getPrix())
        ).append(System.getProperty("line.separator"));
    }

    private String getMessage(String label, int delai, double prix) {
        return MessageFormat.format(
                pattern,
                label, delai, prix);
    }
}
