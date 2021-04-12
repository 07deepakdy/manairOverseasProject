package com.manairoverseas.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manairoverseas.R;

public class EssentialInformationFragment extends Fragment {
   ConstraintLayout pnpConst,eepConst,crsConst,ecaConst;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_essential_information, container, false);
        pnpConst=(ConstraintLayout)v.findViewById(R.id.constraint2);
        eepConst=(ConstraintLayout)v.findViewById(R.id.constraint3);
        crsConst=(ConstraintLayout)v.findViewById(R.id.constraint4);
        ecaConst=(ConstraintLayout)v.findViewById(R.id.constraint5);
        onClickMethod();

        return v;
    }

    private void onClickMethod() {

        pnpConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PnpFragment pnp=new PnpFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,pnp).addToBackStack(null).commit();
            }
        });

        eepConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpressEntryProgramFragment eep=new ExpressEntryProgramFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,eep).addToBackStack(null).commit();
            }
        });

        crsConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComprehensiveRankingSystyemFragment crs=new ComprehensiveRankingSystyemFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,crs).addToBackStack(null).commit();
            }
        });

        ecaConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationalCredentialAssessmentFragment eca=new EducationalCredentialAssessmentFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,eca).addToBackStack(null).commit();
            }
        });
    }
}