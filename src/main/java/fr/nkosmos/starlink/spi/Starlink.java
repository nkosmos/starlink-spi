package fr.nkosmos.starlink.spi;

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

    /**
     * Lists every class defined by the JVM.
     *
     * @return all loaded classes
     */
    @SuppressWarnings("rawtypes")
    Class[] requestAllClasses();

}
