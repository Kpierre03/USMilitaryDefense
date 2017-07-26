package com.example.kpp2.usmilitarydefense;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.kpp2.usmilitarydefense.fragment.DemoFragment;
import com.example.kpp2.usmilitarydefense.fragment.WorkFragment;

public class MainActivity extends AppCompatActivity {
    private TextView tv_demo;
    private TextView tv_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        setListener();
    }


    private void initialView() {
        /*this method converts the TextView with that id to a java class bc in a .java
                we can only use java objects*/

        /*right click and create a field.
        field is global so we can use it anywhere in MainActivity.java,
         local means we would only be allowed to use it in this method*/
        tv_demo = (TextView) findViewById(R.id.activity_tool_demo);
        tv_work = (TextView) findViewById(R.id.activity_tool_work);

    }

    private void setListener() {
        /*new means call the constructor method and use constructor method to create
                a new java object. new java object is onClickListener*/

        final WorkFragment workFragment = new WorkFragment();
        final DemoFragment demoFragment = new DemoFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_fragment, demoFragment).commit();

        tv_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_work.setTextColor(Color.BLACK); /*when work is clicked, it changes color*/
                tv_demo.setTextColor(Color.BLUE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment, demoFragment).commit();

            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_work.setTextColor(Color.BLUE);
                tv_demo.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment, workFragment).commit();

            }
        };
        tv_work.setOnClickListener(listener);
    }

}
