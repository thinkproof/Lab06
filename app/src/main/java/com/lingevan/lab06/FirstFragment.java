package com.lingevan.lab06;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment {
    SharedPreferences mPreferences;
    View view;
    Button firstButton;
    TextView count_1;
    int i1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_first, container, false);
        firstButton = (Button) view.findViewById(R.id.firstButton);
        count_1 = (TextView) view.findViewById(R.id.counter1);
        mPreferences = getActivity().getSharedPreferences("com.lingevan.lab06.sharedprefs",0);
        i1 = mPreferences.getInt("i1", 1);
        firstButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                count_1.setText(""+i1++);
                Toast.makeText(getActivity(), "Liked!", Toast.LENGTH_LONG).show();
                preferencesEditor.putInt("i1", i1);
                preferencesEditor.apply();
            }
        });
        return view;
    }
}
