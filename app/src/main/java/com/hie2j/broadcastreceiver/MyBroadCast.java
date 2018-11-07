package com.hie2j.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("MyBroadCast","action:"+action);
        if (action.equals("weather_info")){
            Log.e(action,"天气："+intent.getStringExtra("weather")+
            "   温度："+intent.getStringExtra("wendu")+"度");
        }else if (action.equals("traffic_info")){
            Log.e(action,"交通："+intent.getStringExtra("traffic")+
                    "  时长："+intent.getStringExtra("time")+"分钟");
        }
    }
}
