package com.example.android.labwork_2_8_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // Текущее время и дата
        String myString = DateFormat.getDateTimeInstance().format(new Date());

        Toast.makeText(context, "Сообщение из BroadcastReceiver, получено: " +
                        myString, Toast.LENGTH_LONG).show();

        Log.d("myLogs", "Сообщение из BroadcastReceiver" );
    }
}