package org.example.java.core.entities.utils;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandonUtil {
    protected String getValues(Collection<String> values){
        Random rand = new Random();
        return (new ArrayList<>(values)).get(rand.nextInt(values.size()));
    }
    protected String getUUID() {
        return UUID.randomUUID().toString();
    }
    protected LocalDate getLocalDate(){
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
