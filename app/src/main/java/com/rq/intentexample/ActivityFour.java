package com.rq.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Faydee on 2018/6/15.
 */
public class ActivityFour extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ActivityFour.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate " + "TaskId: " + getTaskId() + " hasCode: " + hashCode());
        setContentView(R.layout.activity_four);

        Button goToOneButton = findViewById(R.id.goToOneButton);
        goToOneButton.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent" + " TaskId: " + getTaskId() + " hasCode: " + hashCode());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityOne.class);
        startActivity(intent);
    }
}
