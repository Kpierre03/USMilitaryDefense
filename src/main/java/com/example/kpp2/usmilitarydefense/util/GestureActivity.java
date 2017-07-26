package com.example.kpp2.usmilitarydefense.util;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.kpp2.usmilitarydefense.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kpp2 on 7/26/17.
 */
public class GestureActivity extends BaseActivity implements View.OnTouchListener {

    @BindView(R.id.h2h_combat)
    ImageView iv;


    private GestureDetector gestureDetector;
    private int sumX=0;
    private int sumY=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_to_hand);
        ButterKnife.bind(this);

        gestureDetector = new GestureDetector(this, new simpleGestureListener());
        iv.setOnTouchListener(this);
        iv.setFocusable(true);
        iv.setClickable(true);
        iv.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);

    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapUp");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            UtilLog.d("Gesture","onLongPress");

            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture","onScroll");

            sumX+=distanceX;
            sumY+=distanceY;


            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.d("Gesture","onFling");
            if(sumX<0){
                if(Math.abs(sumX)>200){
                    shortToast("you scrolled from left to right");

                }
            }
            if(sumX>0){
                if(Math.abs(sumX)>200){
                    shortToast("you scrolled from right to left");

                }
            }

            if(sumY<0){
                if(Math.abs(sumY)>200){
                    shortToast("you scrolled from top to bottom");

                }
            }
            if(sumY>0){
                if(Math.abs(sumY)>200){
                    shortToast("you scrolled from botton to top");

                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            UtilLog.d("Gesture","onShowPress");

            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            UtilLog.d("Gesture","onDown");

            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTap");

            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTapEvent");

            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapConfirmed");

            return super.onSingleTapConfirmed(e);
        }
    }


