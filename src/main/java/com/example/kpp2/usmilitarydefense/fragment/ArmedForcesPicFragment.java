package com.example.kpp2.usmilitarydefense.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.example.kpp2.usmilitarydefense.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kpp2 on 7/26/17.
 */

public class ArmedForcesPicFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ArmedForcesPicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArmedForcesPicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArmedForcesPicFragment newInstance(String param1, String param2) {
        ArmedForcesPicFragment fragment = new ArmedForcesPicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.armedforces_jpg)
    ImageView iv;

    @OnClick(R.id.animator_alpha1)
    public void alpha(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "alpha", 1, 0, 1,0,1,0,1,0,1,0,1,0,1,0,1);
        animator.setDuration(3000);
        animator.start();
    }
    @OnClick(R.id.animator_alpha1)
    public void rotation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "rotationY", 0,360,0 ); //rotationX
        animator.setDuration(4000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(1);
        animator.start();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_armed_forces_pic, container, false);
        ButterKnife.bind(this, view);
        iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
