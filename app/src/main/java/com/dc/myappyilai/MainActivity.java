package com.dc.myappyilai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.dc.testutil.PopupWindownTool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=findViewById(R.id.btn1);

        PopupWindownTool popupWindownTool = new PopupWindownTool();

        btn1.setOnClickListener(v -> {
            popupWindownTool.Pop_Show(this,"测试标题","测试内容","取消","确认");

            popupWindownTool.setCallBack(new PopupWindownTool.CallBack() {
                @Override
                public void onCancle() {

                }

                @Override
                public void onOk() {
                    Toast.makeText(MainActivity.this, "123123123213", Toast.LENGTH_SHORT).show();
                }
            });

        });



//        popupWindownTool.PopLoad(this,"123");
//
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                popupWindownTool.PopLoadDismiss();
//            }
//        };

    }
}