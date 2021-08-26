package com.andev.framework.engine.storage.listener;

import com.andev.framework.data.DevSource;
import com.andev.framework.engine.storage.IStorageEngine;

/**
 * detail: 插入多媒体资源事件
 * @author Ttt
 */
public interface OnInsertListener<Item extends IStorageEngine.EngineItem, Result extends IStorageEngine.EngineResult> {

    /**
     * 插入多媒体资源结果方法
     * @param result 存储结果
     * @param params 原始参数
     * @param source 原始数据
     */
    void onResult(
            Result result,
            Item params,
            DevSource source
    );
}