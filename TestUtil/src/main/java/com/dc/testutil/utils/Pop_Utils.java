package com.dc.testutil.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

public class Pop_Utils {
    public void poplisten(PopupWindow popupWindow, Context context){
        //pop消失监听
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //改变显示的按钮图片为正常状态
                ScreenUtils.backgroundAlpha(1f, (Activity) context);
                popupWindow.dismiss();
            }
        });
    }


    //取消弹框和背景
    public void setPopupDis(PopupWindow popupWindow, View view, Context context) {
        view.setOnTouchListener((view1, motionEvent) -> {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
                ScreenUtils.backgroundAlpha(1f, (Activity) context);
            }
            return false;
        });
    }

}
