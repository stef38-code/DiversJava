package org.example.java.pratice;

import java.util.Locale;

/**
 * Cas d'utilisation du null (pas bonne pratique)
 */
public class StringNull {
    private final String  nom = null;

    protected String getNomValue() {
        return nom;
    }

    public String useCaseNomMajuscule() {
        return getNomValue().toUpperCase(Locale.ROOT);
    }
}
