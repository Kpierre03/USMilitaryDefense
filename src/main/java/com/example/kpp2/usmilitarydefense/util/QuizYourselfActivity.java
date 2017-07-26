package com.example.kpp2.usmilitarydefense.util;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RadioGroup;

import com.example.kpp2.usmilitarydefense.R;
import com.example.kpp2.usmilitarydefense.dialog.CustomDialog;
import com.example.kpp2.usmilitarydefense.dialog.CustomDialog2;
import com.example.kpp2.usmilitarydefense.dialog.CustomDialog3;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kpp2 on 7/26/17.
 */

public class QuizYourselfActivity extends BaseActivity {

    private final int DIALOG = 12345;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };


    private int checkedID = 0;

    @BindView(R.id.activity_dialog_rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.activity_dialog_ok)
    public void ok(View v) {
        switch (checkedID) {

            case R.id.activity_dialog_rb1:
                normalDialog();
                break;
            case R.id.activity_dialog_rb2:

                CustomDialog customDialog =
                        new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                            @Override
                            public void onCancelClicked(String msg) {

                            }

                            @Override
                            public void onOkClicked(String msg) {

                            }

                        });
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();


                break;
            case R.id.activity_dialog_rb3:

                CustomDialog2 customDialog2 =
                        new CustomDialog2(this, new CustomDialog2.ICustomDialogListener2() {
                            @Override
                            public void onCancelClicked(String msg) {

                            }

                            @Override
                            public void onOkClicked(String msg) {

                            }

                        });
                customDialog2.setCanceledOnTouchOutside(true);
                customDialog2.show();


                break;
            case R.id.activity_dialog_rb4:

                CustomDialog3 customDialog3 =
                        new CustomDialog3(this, new CustomDialog3.ICustomDialogListener3() {
                            @Override
                            public void onCancelClicked(String msg) {

                            }

                            @Override
                            public void onOkClicked(String msg) {

                            }

                        });
                customDialog3.setCanceledOnTouchOutside(true);
                customDialog3.show();

                break;

            default:
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_yourself);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;


            }
        });
    }


    //can only add at most 3 buttons
    //click me first button
    private void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Pick a Question");
        builder.setMessage("Answer a question based on the infomation from this app");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });



        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        builder.show();

    }


}
