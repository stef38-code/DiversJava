package org.example.java.pratice;


import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Optional;

/**
 * Cas d'utilisation du null (pratique possible )
 */
public class StringOptionalSolution {
    private final String nom = null;

    protected Optional<String> getNomValue() {
        return Optional.ofNullable(nom);
    }

    public String useCaseNomMajuscule() {
        /*
          if(getNomValue().isPresent()){
            return getNomValue().get().toUpperCase(Locale.ROOT);
          }
          return StringUtils.EMPTY;
         */
        return getNomValue().orElse(StringUtils.EMPTY).toUpperCase(Locale.ROOT);
    }
}
