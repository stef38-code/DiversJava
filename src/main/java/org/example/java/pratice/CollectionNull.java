package org.example.java.pratice;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CollectionNull {
    @Setter
    @Getter
    protected List<String> liste = null;

    private List<String> getValues(){
        return getListe();
    }
    public int useCaseGetSize() {
        return getValues().size();
    }
}
