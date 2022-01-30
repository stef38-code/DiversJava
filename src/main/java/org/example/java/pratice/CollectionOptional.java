package org.example.java.pratice;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class CollectionOptional {
    @Setter
    @Getter
    protected List<String> liste = null;

    private Optional<List<String>> getValues(){
        return Optional.ofNullable(getListe());
    }
    public int useCaseGetSize() {
        return getValues().orElse(Collections.emptyList()).size();
    }
}
