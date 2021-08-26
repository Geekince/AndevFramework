package com.andev.framework.engine.keyvalue;

import com.andev.framework.engine.keyvalue.IKeyValueEngine;
import com.andev.framework.utils.app.share.IPreference;
import com.andev.framework.utils.common.cipher.Cipher;

/**
 * detail: SharedPreferences Key-Value Config
 * @author Ttt
 */
public class SPConfig
        extends IKeyValueEngine.EngineConfig {

    // SharedPreferences
    private final IPreference mPreference;

    public SPConfig(
            Cipher cipher,
            IPreference preference
    ) {
        super(cipher);
        this.mPreference = preference;
    }

    public IPreference getPreference() {
        return mPreference;
    }
}