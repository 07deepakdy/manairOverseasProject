package com.manairoverseas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.manairoverseas.R;

public class CandidateLoginFragment extends Fragment {
    EditText applictionno,passenter;
    Button signbutton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_candidate_login, container, false);

        applictionno=(EditText)view.findViewById(R.id.applictionno);
        passenter=(EditText)view.findViewById(R.id.passenter);
        signbutton=(Button)view.findViewById(R.id.signbutton);
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}