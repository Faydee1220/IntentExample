package com.rq.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Faydee on 2018/4/7.
 */

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ActivityTwo.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate " + "TaskId: " + getTaskId() + " hasCode: " + hashCode());

        setContentView(R.layout.activity_two);

        Button singleTopButton = findViewById(R.id.singleTopButton);
        singleTopButton.setOnClickListener(this);

        Button standardButton = findViewById(R.id.standardButton);
        standardButton.setOnClickListener(this);

        Button singleTaskButton = findViewById(R.id.singleTaskButton);
        singleTaskButton.setOnClickListener(this);

        Button singleInstanceButton = findViewById(R.id.singleInstanceButton);
        singleInstanceButton.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // single top 會來此
        Log.d(TAG, "onNewIntent" + " TaskId: " + getTaskId() + " hasCode: " + hashCode());
    }

    @Override
    public void onBackPressed() {
        // Prepare data intent
        Intent data = new Intent();
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy" + " TaskId: " + getTaskId() + " hasCode: " + hashCode());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.standardButton:
                Intent newTaskIntent = new Intent(this, ActivityTwo.class);
                newTaskIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newTaskIntent);
                break;
            case R.id.singleTopButton:
                Intent singleTopIntent = new Intent(this, ActivityTwo.class);
                singleTopIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(singleTopIntent);
                break;
            case R.id.singleTaskButton:
                Intent singleTaskIntent = new Intent(this, ActivityThree.class);
                startActivity(singleTaskIntent);
                break;
            case R.id.singleInstanceButton:
                Intent singleInstanceIntent = new Intent(this, ActivityFour.class);
                startActivity(singleInstanceIntent);
                break;
        }
    }
}
