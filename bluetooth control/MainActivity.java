

package com.example.btcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Long3;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6;
    final static UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    final static String on1 = "10";
    final static String off1 = "20";
    final static String on2 = "30";
    final static String off2 = "40";
    final static String on3 = "50";
    final static String off3 = "60";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.on1);
        b2 = findViewById(R.id.off1);
        b3 = findViewById(R.id.on2);
        b4 = findViewById(R.id.off2);
        b5 = findViewById(R.id.on3);
        b6 = findViewById(R.id.off3);
        BluetoothAdapter btadaptor = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice hc05;
        BluetoothSocket btsocket = null;
        hc05 = btadaptor.getRemoteDevice("00:19:07:34:E0:BF");
        try {
            btsocket = hc05.createRfcommSocketToServiceRecord(mUUID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        btadaptor.cancelDiscovery();
        try {
            btsocket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final BluetoothSocket finalBtsocket5 = btsocket;
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finalBtsocket5.getOutputStream().write(off3.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final BluetoothSocket finalBtsocket4 = btsocket;
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finalBtsocket4.getOutputStream().write(on3.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final BluetoothSocket finalBtsocket3 = btsocket;
        b4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    finalBtsocket3.getOutputStream().write(off2.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final BluetoothSocket finalBtsocket2 = btsocket;
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finalBtsocket2.getOutputStream().write(on2.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final BluetoothSocket finalBtsocket1 = btsocket;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finalBtsocket1.getOutputStream().write(off1.getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final BluetoothSocket finalBtsocket = btsocket;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finalBtsocket.getOutputStream().write(on1.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}

//00:19:07:34:E0:BF