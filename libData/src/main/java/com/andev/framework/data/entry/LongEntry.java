package com.andev.framework.data.entry;

import com.andev.framework.data.DevEntry;

public class LongEntry<V>
        extends DevEntry<Long, V> {

    public LongEntry() {
    }

    public LongEntry(final Long key) {
        super(key);
    }

    public LongEntry(
            final Long key,
            final V value
    ) {
        super(key, value);
    }
}