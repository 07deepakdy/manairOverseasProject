package com.manairoverseas.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manairoverseas.R;

public class OurServicesFragment extends Fragment {
    ConstraintLayout studyConst,familyConst,touristConst,workConst,permanentConst;



    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_our_services, container, false);
        studyConst=(ConstraintLayout)view.findViewById(R.id.constraint2);
        familyConst=(ConstraintLayout)view.findViewById(R.id.constraint3);
        touristConst=(ConstraintLayout)view.findViewById(R.id.constraint4);
        workConst=(ConstraintLayout)view.findViewById(R.id.constraint5);
        permanentConst=(ConstraintLayout)view.findViewById(R.id.constraint6);


        onClickmethod();
        return view;
    }

    private void onClickmethod() {


        studyConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudyVisaFragment svt=new StudyVisaFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,svt).addToBackStack(null).commit();
            }
        });


        familyConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FamilyVisaFragment fvt=new FamilyVisaFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,fvt).addToBackStack(null).commit();
            }
        });


        touristConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouristVisaFragment tvf=new TouristVisaFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,tvf).addToBackStack(null).commit();
            }
        });


        workConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkPermitFragment wpt=new WorkPermitFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,wpt).addToBackStack(null).commit();
            }
        });

        permanentConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ParmanentResidenceFragment  prf=new ParmanentResidenceFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,prf).addToBackStack(null).commit();
            }
        });

    }

}