package com.example.kpp2.usmilitarydefense.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kpp2.usmilitarydefense.R;
import com.example.kpp2.usmilitarydefense.adapter.ListNormalAdapter;
import com.example.kpp2.usmilitarydefense.util.FirearmsActivity;
import com.example.kpp2.usmilitarydefense.util.HandlerExampleActivity;
import com.example.kpp2.usmilitarydefense.util.HandtoHandActivity;
import com.example.kpp2.usmilitarydefense.util.HelpActivity;
import com.example.kpp2.usmilitarydefense.util.QuizYourselfActivity;
import com.example.kpp2.usmilitarydefense.util.ServiceActivity;
import com.example.kpp2.usmilitarydefense.util.SituationalAwarenessActivity;

import java.util.ArrayList;

/**
 * Created by Kpp2 on 7/26/17.
 */

public class DemoFragment extends Fragment {
    private final ArrayList<String> contentList;
    private final Context context;
    private ListView listView;

    public DemoFragment() {

        context = getContext();
        contentList = new ArrayList<String>();
        contentList.add("Situational Awareness");
        contentList.add("Armed Defense");
        contentList.add("Self-Defense");
        contentList.add("Branch Shields");
        contentList.add("Knowledge Check");
        contentList.add("ExampleService&Broadcast");
        contentList.add("RunnableHandlerExample");

        contentList.add("Video");
        contentList.add("More Videos");
        contentList.add("Another One");
        contentList.add("More For Scroll Action");


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        listView =  (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(), contentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent = new Intent(getActivity(), SituationalAwarenessActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), FirearmsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), HandtoHandActivity.class);
                        Bundle bundle = new Bundle();
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(),HelpActivity.class);
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(getActivity(), QuizYourselfActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), ServiceActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), HandlerExampleActivity.class);
                        startActivity(intent6);
                        break;



                    default:
                }
            }
        });

        return view;
    }

}
