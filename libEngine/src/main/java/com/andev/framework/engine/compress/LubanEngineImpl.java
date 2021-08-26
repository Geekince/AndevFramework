package com.andev.framework.engine.compress;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.andev.framework.engine.compress.ICompressEngine;
import com.andev.framework.engine.compress.listener.CompressFilter;
import com.andev.framework.engine.compress.listener.OnCompressListener;
import com.andev.framework.engine.compress.listener.OnRenameListener;
import com.andev.framework.other.LubanUtils;

/**
 * detail: Luban Image Compress Engine 实现
 *
 * @author Ttt
 */
public class LubanEngineImpl
        implements ICompressEngine<CompressConfig> {

    @Override
    public boolean compress(
            Object data,
            CompressConfig config,
            OnCompressListener compressListener
    ) {
        return compress(data, config, null, null, compressListener);
    }

    @Override
    public boolean compress(
            Object data,
            CompressConfig config,
            CompressFilter filter,
            OnRenameListener renameListener,
            OnCompressListener compressListener
    ) {
        if (data == null || config == null || compressListener == null) return false;
        List<Object> lists = new ArrayList<>();
        lists.add(data);
        return compress(lists, config, filter, renameListener, compressListener);
    }

    @Override
    public boolean compress(
            List<?> lists,
            CompressConfig config,
            OnCompressListener compressListener
    ) {
        return compress(lists, config, null, null, compressListener);
    }

    @Override
    public boolean compress(
            List<?> lists,
            CompressConfig config,
            CompressFilter filter,
            OnRenameListener renameListener,
            OnCompressListener compressListener
    ) {
        if (lists == null || config == null || compressListener == null) return false;

        top.zibin.luban.CompressionPredicate predicate = null;
        if (filter != null) {
            predicate = path -> filter.apply(path);
        }
        top.zibin.luban.OnRenameListener rename = null;
        if (renameListener != null) {
            rename = filePath -> renameListener.rename(filePath);
        }
        return LubanUtils.compress(
                lists, new LubanUtils.Config(
                        config.ignoreSize, config.focusAlpha, config.targetDir
                ).setFailFinish(config.isFailFinish()),
                predicate, rename, new LubanUtils.OnCompressListener() {
                    @Override
                    public void onStart(
                            int index,
                            int count
                    ) {
                        compressListener.onStart(index, count);
                    }

                    @Override
                    public void onSuccess(
                            File file,
                            int index,
                            int count
                    ) {
                        compressListener.onSuccess(file, index, count);
                    }

                    @Override
                    public void onError(
                            Throwable error,
                            int index,
                            int count
                    ) {
                        compressListener.onError(error, index, count);
                    }

                    @Override
                    public void onComplete(
                            List<File> lists,
                            Map<Integer, File> maps,
                            int count
                    ) {
                        compressListener.onComplete(lists, maps, count);
                    }
                }
        );
    }
}