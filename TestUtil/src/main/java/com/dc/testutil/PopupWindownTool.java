package com.dc.testutil;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dc.testutil.utils.Pop_Utils;
import com.dc.testutil.utils.ScreenUtils;

public class PopupWindownTool {
    private static PopupWindow popupWindow;
    private PopupWindow popupWindowload;
    private PopupWindow popupWindow2;

    public void Pop_Show(Context context, String tit,String content, String btn1, String btn2){
        ScreenUtils.backgroundAlpha(0.5f, (Activity) context);
        LayoutInflater inflater_Recognition_style = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vPopupWindow = inflater_Recognition_style.inflate(R.layout.item_pop1, null, false);//引入弹窗布局
        popupWindow = new PopupWindow(vPopupWindow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);

        TextView title=vPopupWindow.findViewById(R.id.title);
        TextView cont=vPopupWindow.findViewById(R.id.content);
        TextView btn_cancle=vPopupWindow.findViewById(R.id.btn_cancle);
        TextView btn_getvip=vPopupWindow.findViewById(R.id.btn_getvip);

        title.setText(tit);
        cont.setText(content);
        btn_cancle.setText(btn1);
        btn_getvip.setText(btn2);

        btn_cancle.setOnClickListener(v1 -> {
            popupWindow.dismiss();
            try {
                callBack.onCancle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btn_getvip.setOnClickListener(v1 -> {
            popupWindow.dismiss();
            try {
                callBack.onOk();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Pop_Utils pop_utils = new Pop_Utils();
        pop_utils.poplisten(popupWindow,context);
        pop_utils.setPopupDis(popupWindow,vPopupWindow,context);

        View parentView = LayoutInflater.from(context).inflate(R.layout.item_pop1, null);
        popupWindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
        popupWindow.setTouchable(true);
    }



//    public void PopLoad(Context context, String str){
//
//        ScreenUtils.backgroundAlpha(0.5f, (Activity) context);
//        LayoutInflater inflater_Recognition_style = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View vPopupWindow = inflater_Recognition_style.inflate(R.layout.item_load, null, false);//引入弹窗布局
//        popupWindow2 = new PopupWindow(vPopupWindow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
//        popupWindow2.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
//        popupWindow2.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
//
//        TextView tit=vPopupWindow.findViewById(R.id.tit);
//        tit.setText(str);
//
//
//        Pop_Utils pop_utils = new Pop_Utils();
//        pop_utils.poplisten(popupWindow2,context);
//        pop_utils.setPopupDis(popupWindow2,vPopupWindow,context);
//
//        View parentView = LayoutInflater.from(context).inflate(R.layout.item_load, null);
//        popupWindow2.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
//        popupWindow2.setTouchable(true);
//    }
//
//    public void PopLoadDismiss(){
//        if (popupWindow2!=null)
//            popupWindow2.dismiss();
//    }


    public interface CallBack{
        void onCancle();
        void onOk();
    }

    public CallBack callBack;

    public void setCallBack(CallBack callBack){
        this.callBack=callBack;
    }
}
