package com.hie2j.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private MyBroadCast receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册receive
        receiver = new MyBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction("weather_info");
        filter.addAction("traffic_info");
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        registerReceiver(receiver,filter);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("weather_info");
                intent.putExtra("weather","暴雨");
                intent.putExtra("wendu","20");
                sendBroadcast(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("traffic_info");
                intent.putExtra("traffic","堵塞");
                intent.putExtra("time","30");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
