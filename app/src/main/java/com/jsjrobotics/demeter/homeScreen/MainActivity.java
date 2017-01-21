package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jsjrobotics.defaultTemplate.lifecycle.AppCompatNavigationManager;
import com.jsjrobotics.demeter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity);
        if (savedInstanceState == null) {
            AppCompatNavigationManager.displayFragment(
                    this,
                    R.id.content,
                    new MainFragment(),
                    null
            );
        }
    }
}
