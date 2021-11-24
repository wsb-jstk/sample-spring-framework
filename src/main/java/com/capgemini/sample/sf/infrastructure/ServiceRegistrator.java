package com.capgemini.sample.sf.infrastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRegistrator implements Registrator {

    private final List<Object> services = new LinkedList<>();

    @Override
    public void register(Object object) {
        services.add(object);
    }

    @Override
    public <T> T getObject(Class<T> objectType) {
        List<T> candidates = getAllCandidates(objectType);
        if (candidates.isEmpty()) {
            throw new ObjectNotFoundException(objectType);
        }
        if (candidates.size() == 1) {
            return candidates.get(0);
        }
        throw new NonUniqueObjectException(objectType, candidates);
    }

    private <T> List<T> getAllCandidates(Class<T> objectType) {
        return services.stream()
                .filter(objectType::isInstance) // .filter(o -> objectType.isInstance(o))
                .map(objectType::cast) // .map(o -> objectType.cast(o))
                .collect(Collectors.toList());
    }
}

