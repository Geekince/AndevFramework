package com.andev.framework.engine.cache;

import com.andev.framework.utils.app.cache.DevCache;
import com.andev.framework.utils.common.cipher.Cipher;

/**
 * detail: Cache Config
 *
 * @author Ttt
 */
public class CacheConfig extends ICacheEngine.EngineConfig {

    public final DevCache mDevCache;

    public CacheConfig(
            Cipher cipher,
            DevCache cache
    ) {
        super(cipher);
        this.mDevCache = cache;
    }
}