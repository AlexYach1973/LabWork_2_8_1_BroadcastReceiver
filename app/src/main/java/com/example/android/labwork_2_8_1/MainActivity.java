package com.example.android.labwork_2_8_1;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStat = findViewById(R.id.button_start);
        btnStat.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction("startBroadcastReceiver");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Создаем фильтр и регистрируем широковещательный приёмник
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("startBroadcastReceiver");
        this.registerReceiver(br, filter);

        Log.d("myLogs", "Приемник зарегестрирован");

    }

    @Override
    protected void onStop() {
        super.onStop();

        // Отменяем регистрацию
        this.unregisterReceiver(br);
        Log.d("myLogs", "Приемник отменен");
    }
}