package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.manairoverseas.R;


public class FamilyVisaFragment extends Fragment {
ImageView plus,spouseplus,grandparentimage,sponseredrelativeimage,canadianvisaimage;
TextView dependentchilddetail,spousedetail,grandparentdetail,sponseredrelativedetail,canadianvisadetail;
ImageView facebook,instagram;
TextView phone, email;
    ConstraintLayout dependentLayout,eligibilityLayout,eligibilitygpLayout,sponseredLayout,canadianLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_family_visa, container, false);
        facebook=(ImageView)view.findViewById(R.id.facebook);
        instagram=(ImageView)view.findViewById(R.id.instagram);
        phone=(TextView)view.findViewById(R.id.phone);
        email=(TextView)view.findViewById(R.id.email);
        plus=(ImageView)view.findViewById(R.id.plus);
        spouseplus=(ImageView)view.findViewById(R.id.spouseplus);
        grandparentimage=(ImageView)view.findViewById(R.id.grandparentimage);
        sponseredrelativeimage=(ImageView)view.findViewById(R.id.sponseredrelativeimage);
        canadianvisaimage=(ImageView)view.findViewById(R.id.canadianvisaimage);

        dependentchilddetail=(TextView)view.findViewById(R.id.dependentchilddetail);
        spousedetail=(TextView)view.findViewById(R.id.spousedetail);
        grandparentdetail=(TextView)view.findViewById(R.id.grandparentdetail);
        sponseredrelativedetail=(TextView)view.findViewById(R.id.sponseredrelativedetail);
        canadianvisadetail=(TextView)view.findViewById(R.id.canadianvisadetail);

        dependentLayout=(ConstraintLayout)  view.findViewById(R.id.dependentconstraint);
        eligibilityLayout=(ConstraintLayout)  view.findViewById(R.id.spouseconstraint);
        eligibilitygpLayout=(ConstraintLayout)  view.findViewById(R.id.eligibilitygpLayout);
        sponseredLayout=(ConstraintLayout)  view.findViewById(R.id.sponseredLayout);
        canadianLayout=(ConstraintLayout)  view.findViewById(R.id.canadianLayout);

        dependentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dependentchilddetail.getVisibility()==View.VISIBLE){
                    dependentchilddetail.setVisibility(View.GONE);
                    plus.setImageResource(R.drawable.dependent_plus);

                }
                else if(dependentchilddetail.getVisibility()==View.GONE){
                    dependentchilddetail.setVisibility(View.VISIBLE);
                    plus.setImageResource(R.drawable.dependent_minus);
                }

            }
        });


        eligibilityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spousedetail.getVisibility()==View.VISIBLE){
                    spousedetail.setVisibility(View.GONE);
                    spouseplus.setImageResource(R.drawable.dependent_plus);

                }else if(spousedetail.getVisibility()==View.GONE){
                    spousedetail.setVisibility(View.VISIBLE);
                    spouseplus.setImageResource(R.drawable.dependent_minus);

                }
            }
        });

        eligibilitygpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(grandparentdetail.getVisibility()==View.VISIBLE){
                    grandparentdetail.setVisibility(View.GONE);
                    grandparentimage.setImageResource(R.drawable.dependent_plus);

                }else if(grandparentdetail.getVisibility()==View.GONE){
                    grandparentdetail.setVisibility(View.VISIBLE);
                    grandparentimage.setImageResource(R.drawable.dependent_minus);

                }
            }
        });
        sponseredLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sponseredrelativedetail.getVisibility()==View.VISIBLE){
                    sponseredrelativedetail.setVisibility(View.GONE);
                    sponseredrelativeimage.setImageResource(R.drawable.dependent_plus);

                }else if(sponseredrelativedetail.getVisibility()==View.GONE){
                    sponseredrelativedetail.setVisibility(View.VISIBLE);
                    sponseredrelativeimage.setImageResource(R.drawable.dependent_minus);

                }
            }
        });

        canadianLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(canadianvisadetail.getVisibility()==View.VISIBLE){
                    canadianvisadetail.setVisibility(View.GONE);
                    canadianvisaimage.setImageResource(R.drawable.dependent_plus);

                }else if(canadianvisadetail.getVisibility()==View.GONE){
                    canadianvisadetail.setVisibility(View.VISIBLE);
                    canadianvisaimage.setImageResource(R.drawable.dependent_minus);

                }
            }
        });
        // code for footer social media interaction
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/manairoverseas/"));
                    startActivity(followIntent);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run() {
                            Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/manairoverseas/"));
                            startActivity(followIntent);
                        }
                    }, 1000 * 2);

                }
                catch (Exception e)
                {
                    Log.e("Error","Searched Profile not found");
                }
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/manairoverseas/"));
                    startActivity(followIntent);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run() {
                            Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/manairoverseas/"));
                            startActivity(followIntent);
                        }
                    }, 1000 * 2);

                }
                catch (Exception e)
                {
                    Log.e("Error","Searched Profile not found");
                }
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@manairoverseas.in"});
                startActivity(emailIntent);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonenumber = phone.getText().toString();
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                        "tel", phonenumber, null));
                startActivity(phoneIntent);
            }
        });

        return view;
    }
}