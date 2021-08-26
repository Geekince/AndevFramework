package com.andev.framework.data.entry;

import com.andev.framework.data.DevEntry;

public class DoubleEntry<V>
        extends DevEntry<Double, V> {

    public DoubleEntry() {
    }

    public DoubleEntry(final Double key) {
        super(key);
    }

    public DoubleEntry(
            final Double key,
            final V value
    ) {
        super(key, value);
    }
}