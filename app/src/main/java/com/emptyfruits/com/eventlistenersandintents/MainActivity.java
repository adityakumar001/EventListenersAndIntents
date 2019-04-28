package com.emptyfruits.com.eventlistenersandintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button implicitBtn, explicitBtn;
    View touchListenerView;
      private void initialize() {
        implicitBtn = findViewById(R.id.implicit_intent_btn);
        touchListenerView = findViewById(R.id.touch_listener);
        explicitBtn = findViewById(R.id.explicit_intent_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        implicitBtn.setOnClickListener(v ->
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "No approriate action found",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );

        implicitBtn.setOnLongClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bing.com/"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "No approriate action found",
                        Toast.LENGTH_SHORT).show();
            }
            return false;

        });
        explicitBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HelloWorldActivity.class);
            startActivity(intent);

        });
        touchListenerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "View Was Touched!!",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
