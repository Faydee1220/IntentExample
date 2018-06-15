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
public class ActivityThree extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ActivityThree.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate " + "TaskId: " + getTaskId() + " hasCode: " + hashCode());
        setContentView(R.layout.activity_three);

        Button goToTwoButton = findViewById(R.id.goToTwoButton);
        goToTwoButton.setOnClickListener(this);

        Button singleTaskButton = findViewById(R.id.singleTaskButton);
        singleTaskButton.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent" + " TaskId: " + getTaskId() + " hasCode: " + hashCode());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goToTwoButton:
                Intent intent = new Intent(this, ActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.singleTaskButton:
                Intent singleTaskIntent = new Intent(this, ActivityThree.class);
                startActivity(singleTaskIntent);
                break;
        }

    }
}
