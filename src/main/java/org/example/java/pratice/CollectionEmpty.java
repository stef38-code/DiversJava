package org.example.java.pratice;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class CollectionEmpty {
    @Setter
    @Getter
    protected List<String> liste = null;

    private List<String> getValues(){
        if (CollectionUtils.isEmpty(liste)) {
            return Collections.emptyList();
        }
        return getListe();
    }
    public int useCaseGetSize() {
        return getValues().size();
    }
}
