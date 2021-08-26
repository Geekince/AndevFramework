package com.andev.framework.data.entry;

import com.andev.framework.data.DevEntry;

public class FloatEntry<V>
        extends DevEntry<Float, V> {

    public FloatEntry() {
    }

    public FloatEntry(final Float key) {
        super(key);
    }

    public FloatEntry(
            final Float key,
            final V value
    ) {
        super(key, value);
    }
}