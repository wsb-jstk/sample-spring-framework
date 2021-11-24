package com.capgemini.sample.sf.infrastructure;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Class<?> clazz) {
        super("Couldn't find registered object of type " + clazz.getCanonicalName());
    }

}
