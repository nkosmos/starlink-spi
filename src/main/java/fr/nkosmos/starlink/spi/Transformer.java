package fr.nkosmos.starlink.spi;

import java.io.IOException;

@FunctionalInterface
public interface Transformer {

    /**
     * Transform a class buffer
     * @param name the class name
     * @param buffer the class buffer
     * @return the transformed class buffer, can be {@code null}
     */
    byte[] transform(String name, byte[] buffer);
}
