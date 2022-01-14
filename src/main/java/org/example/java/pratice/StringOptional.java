package org.example.java.pratice;


import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Optional;

/**
 * Cas d'utilisation du null (pratique possible )
 */
@java.lang.SuppressWarnings("java:S125")
public class StringOptional {
    @Setter
    private String nom = null;

    protected Optional<String> getNomValue() {
        return Optional.ofNullable(nom);
    }

    public String useCaseNomMajuscule() {
        /*
          if(getNomValue().isPresent()){
            return getNomValue().get().toUpperCase(Locale.ROOT);
          }
          return StringUtils.EMPTY;
         */ //NOSONAR
        return getNomValue().orElse(StringUtils.EMPTY).toUpperCase(Locale.ROOT);
    }
}
