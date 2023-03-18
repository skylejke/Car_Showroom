package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class RS6Fragment extends Fragment {
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rs6, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        TextView your_bet = view.findViewById(R.id.your_bet_ru);
        String res = getArguments().getString("rs6_bet_Key");
        if (res == null) {
            res = "0";
        }
        your_bet.setText(your_bet.getText().toString() + "  " + res + " $");

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_rs6Fragment_to_mainFragment);
            }
        });
        return view;
    }
}
