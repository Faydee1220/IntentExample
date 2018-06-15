package com.rq.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ActivityOne.class.getSimpleName();

    // REQUEST_CODE can be any value we like, used to determine the result type later
    private final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate " + "TaskId: " + getTaskId() + " hasCode: " + hashCode());

        setContentView(R.layout.activity_one);

        Button goToTwoButton = findViewById(R.id.goToTwoButton);
        goToTwoButton.setOnClickListener(this);

        Button emailButton = findViewById(R.id.emailButton);
        emailButton.setOnClickListener(this);

        Button webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(this);

    }

    public void launchComposeView() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(ActivityOne.this, ActivityTwo.class);
        i.putExtra("mode", 2); // pass arbitrary data to launched activity
        startActivityForResult(i, REQUEST_CODE);
//        startActivity(i); // brings up the second activity
    }

    public void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "some@email.address" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "mail body");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, ""));
        }
    }

    public void goWeb() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(browserIntent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goToTwoButton:
                launchComposeView();
                break;
            case R.id.emailButton:
                sendEmail();
                break;
            case R.id.webButton:
                goWeb();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract name value from result extras
//            String name = data.getExtras().getString("name");
//            int code = data.getExtras().getInt("code", 0);
            // Toast the name to display temporarily on screen
            Toast.makeText(this, "You back activity two", Toast.LENGTH_SHORT).show();
        }
    }
}
