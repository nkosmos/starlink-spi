package fr.nkosmos.starlink.spi;

import java.util.Arrays;
import java.util.Optional;

public interface Starlink {

    /**
     * Adds {@link Transformer}(s) to this Starlink instance.
     *
     * @param transformers the transformers to be added
     */
    void registerTransformers(Transformer... transformers);

    /**
     * Requests the provided classes to be retransformed by the JVM.
     *
     * @param classes the requested classes
     */
    void retransformClasses(Class<?>... classes);

    /**
     * @param cla$$ the class
     * @return whether the class is modifiable or not
     */
    boolean isModifiable(Class<?> cla$$);

    default boolean isModifiable(String classNames) {
        Optional<Class> clazz = Arrays.stream(requestAllClasses())
                .filter(c -> c.getName().equalsIgnoreCase(classNames))
                .findFirst();
        return clazz.filter(this::isModifiable).isPresent();
    }

    default void retransformClasses(String... classNames) {
        Arrays.stream(requestAllClasses())
                .filter(c -> Arrays.stream(classNames).anyMatch(cn -> c.getName().equals(cn)))
                .forEach(this::retransformClasses);
    }

    /**
     * Lists every class defined by the JVM.
     *
     * @return all loaded classes
     */
    @SuppressWarnings("rawtypes")
    Class[] requestAllClasses();

}
