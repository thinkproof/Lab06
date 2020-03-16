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

public class SecondFragment extends Fragment {
    SharedPreferences mPreferences;
    View view;
    Button secondButton;
    TextView count_2;
    int i2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_second, container, false);
        secondButton = (Button) view.findViewById(R.id.secondButton);
        count_2 = (TextView) view.findViewById(R.id.counter2);
        mPreferences = getActivity().getSharedPreferences("com.lingevan.lab06.sharedprefs",0);
        i2 = mPreferences.getInt("i2", 1);
        secondButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                count_2.setText(""+i2++);
                Toast.makeText(getActivity(), "Liked!", Toast.LENGTH_LONG).show();
                preferencesEditor.putInt("i2", i2);
                preferencesEditor.apply();
            }
        });
        return view;
    }
}
