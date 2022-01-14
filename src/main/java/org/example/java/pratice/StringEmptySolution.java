package org.example.java.pratice;



import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

/**
 * Cas d'utilisation du null (pratique recommendée )
 */
public class StringEmptySolution  {
    private final String nom = null;

    protected String getNomValue() {
        if (Objects.isNull(nom)) {
            return StringUtils.EMPTY;
        }
        return nom;
    }

    public String useCaseNomMajuscule(){
        return getNomValue().toUpperCase(Locale.ROOT);
    }
}
