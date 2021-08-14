package fr.nkosmos.starlink.spi;

import java.util.function.Consumer;

/**
 * Serdsaddsdavice interface to which a {@link Starlink} instance is dispatched.
 */
@FunctionalInterface
public interface StarlinkPlugin extends Consumer<Starlink>, Comparable<StarlinkPlugin> {

    default int getPriority() {
        return 0;
    }

    default int compareTo(StarlinkPlugin that) {
        if(that == null) return 1;
        return Integer.compare(this.getPriority(), that.getPriority());
    }

}