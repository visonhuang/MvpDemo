package com.example.testing.mvpdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by KK on 2018/2/9.
 */

public class BaseActivity extends AppCompatActivity{

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }
}
