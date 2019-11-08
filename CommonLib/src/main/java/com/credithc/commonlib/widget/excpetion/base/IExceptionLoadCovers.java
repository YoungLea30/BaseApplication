package com.credithc.commonlib.widget.excpetion.base;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.view.View;

/**
 * @author liyong
 * @date 2019/11/4
 * @des
 */
public interface IExceptionLoadCovers {


    View getCoversView();

    // 添加遮罩
    default void showLoadCovers() {
        showLoadCovers(Color.WHITE);
    }

    void showLoadCovers(@ColorInt int color);


    void hideCovers();

}
