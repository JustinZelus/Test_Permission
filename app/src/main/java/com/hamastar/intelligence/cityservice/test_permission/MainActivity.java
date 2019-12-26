package com.hamastar.intelligence.cityservice.test_permission;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.hamastar.intelligence.cityservice.permission.PermissionHandler;
import com.hamastar.intelligence.cityservice.permission.Permissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = { Manifest.permission.CAMERA,
                                 Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                 Manifest.permission.ACCESS_NETWORK_STATE};

        Permissions.check(this, permissions, "需要這些服務才能完整", null, new PermissionHandler() {
            @Override
            public void onGranted() {
                Toast.makeText(MainActivity.this, "Camera+Storage granted.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
