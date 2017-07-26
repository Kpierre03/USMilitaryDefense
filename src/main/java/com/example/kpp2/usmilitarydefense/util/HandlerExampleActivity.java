package com.example.kpp2.usmilitarydefense.util;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kpp2.usmilitarydefense.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kpp2 on 7/26/17.
 */

public class HandlerExampleActivity extends AppCompatActivity {

    /* we kept everything from HandlerActivity except the thread */


    @BindView(R.id.activity_handler_runable_et)
    EditText editText;

    @BindView(R.id.activity_handler_runable_bt)
    Button button;

    private View.OnClickListener startListener;
    private View.OnClickListener stopListener;
    private View.OnClickListener resetListener;

    Handler handler = new Handler();
    private  int time = 0;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if(time >= 0){
                editText.setText(String.valueOf(time));
//                public final boolean postDelayed(Runnable r, long delayMillis)
//                handler.post(runnable); //no delay of 1 second
                handler.postDelayed(runnable, 1000); //postDelayed will send runnable object to queue
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_example);
        ButterKnife.bind(this);

        startListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Stop");
                editText.setEnabled(false);
                button.setOnClickListener(stopListener);
                time = Integer.valueOf(editText.getText().toString());
                handler.postDelayed(runnable, 1000);

            }
        };
        stopListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Reset");
                button.setOnClickListener(resetListener);
                handler.removeCallbacks(runnable);

            }
        };
        resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Start");
                editText.setEnabled(true);
                button.setOnClickListener(startListener);
            }
        };
        button.setOnClickListener(startListener);
    }
}
