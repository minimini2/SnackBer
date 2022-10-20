package com.example.snackber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView btn = (TextView) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackber = Snackbar.make(v,"这是snackber。",Snackbar.LENGTH_SHORT);
                snackber.setAction("能交互吗", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "真的能够交互", Toast.LENGTH_SHORT).show();
                    }
                });
                snackber.setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                        switch (event) {
                            case Snackbar.Callback.DISMISS_EVENT_ACTION:
                                Toast.makeText(MainActivity.this, "Snackbar通过Action的点击事件退出", Toast.LENGTH_SHORT).show();
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_CONSECUTIVE:
                                Toast.makeText(MainActivity.this, "Snackbar由于新的Snackbar显示而退出", Toast.LENGTH_SHORT).show();
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_MANUAL:
                                Toast.makeText(MainActivity.this, "Snackbar通过调用dismiss()方法退出", Toast.LENGTH_SHORT).show();
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_SWIPE:
                                Toast.makeText(MainActivity.this, "Snackbar右划退出", Toast.LENGTH_SHORT).show();
                                break;
                            case Snackbar.Callback.DISMISS_EVENT_TIMEOUT:
                                Toast.makeText(MainActivity.this, "Snackbar自然退出", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
                        Toast.makeText(MainActivity.this, "Snackbar显示", Toast.LENGTH_SHORT).show();
                    }
                });
                snackber.show();
            }
        });

    }
}