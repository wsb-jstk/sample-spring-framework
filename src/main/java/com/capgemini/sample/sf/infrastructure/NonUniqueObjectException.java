package com.capgemini.sample.sf.infrastructure;

import java.util.List;

public class NonUniqueObjectException extends RuntimeException {

    public <T> NonUniqueObjectException(Class<T> clazz, List<T> candidates) {
        super("Found more than one registered services of type " + clazz.getCanonicalName() + ". Candidates: "
                + candidates);
    }

}
