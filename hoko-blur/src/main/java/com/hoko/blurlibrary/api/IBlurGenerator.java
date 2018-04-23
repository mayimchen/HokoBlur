package com.hoko.blurlibrary.api;

import android.graphics.Bitmap;
import android.view.View;

import com.hoko.blurlibrary.task.AsyncBlurTask;

/**
 * Created by yuxfzju on 16/9/8.
 */
public interface IBlurGenerator extends IBlur, ITranslate {
    /**
     * 模糊操作
     *
     * @param bitmap 输入的bitmap
     * @return
     */
    Bitmap blur(Bitmap bitmap);

    Bitmap blur(View view);

    void asyncBlur(Bitmap bitmap, AsyncBlurTask.Callback callback);

    void asyncBlur(View view, AsyncBlurTask.Callback callback);

    void forceCopy(boolean isForceCopy);

    void needUpscale(boolean needUpscale);

}
