package com.capgemini.sample.sf.infrastructure;

public interface Registrator {

    /**
     * Registers given service.
     * "Wrzucam cos do worka (rejestru)"
     */
    void register(Object object);

    /**
     * Retrieves a single service of given type.
     * "Wyjmuje cos z worka (rejestru)"
     *
     * @throws ObjectNotFoundException
     * @throws NonUniqueObjectException
     */
    <T> T getObject(Class<T> objectType);


}
