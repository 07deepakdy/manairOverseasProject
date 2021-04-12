package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.manairoverseas.R;

public class JobDetailsFragment extends Fragment {
     TableLayout tableLayout1,tableLayout2,tableLayout3;
     ImageView plus,plus2,plus4;
     ConstraintLayout stayLayout,stayLayout1,stayLayout2;
    ImageView facebook,instagram;
    TextView phone,email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_job_details, container, false);
        tableLayout1=(TableLayout)view.findViewById(R.id.tableLayout1);
        stayLayout=(ConstraintLayout)view.findViewById(R.id.stayLayout);
        plus=(ImageView)view.findViewById(R.id.plus);

        stayLayout1=(ConstraintLayout)view.findViewById(R.id.stayLayout1);
        tableLayout2=(TableLayout)view.findViewById(R.id.tableLayout2);
        plus2=(ImageView)view.findViewById(R.id.plus2);


        stayLayout2=(ConstraintLayout)view.findViewById(R.id.stayLayout2);
        tableLayout3=(TableLayout)view.findViewById(R.id.tableLayout3);
        plus4=(ImageView)view.findViewById(R.id.plus4);




        stayLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tableLayout1.getVisibility()==View.VISIBLE){
                    tableLayout1.setVisibility(View.GONE);
                    plus.setImageResource(R.drawable.dependent_plus);
                }
                else if(tableLayout1.getVisibility()==View.GONE){
                    tableLayout1.setVisibility(View.VISIBLE);
                    plus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });

        stayLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tableLayout2.getVisibility()==View.VISIBLE){
                    tableLayout2.setVisibility(View.GONE);
                    plus2.setImageResource(R.drawable.dependent_plus);
                }
                else if(tableLayout2.getVisibility()==View.GONE){
                    tableLayout2.setVisibility(View.VISIBLE);
                    plus2.setImageResource(R.drawable.dependent_minus);
                }
            }
        });

        stayLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tableLayout3.getVisibility()==View.VISIBLE){
                    tableLayout3.setVisibility(View.GONE);
                    plus4.setImageResource(R.drawable.dependent_plus);
                }
                else if(tableLayout3.getVisibility()==View.GONE){
                    tableLayout3.setVisibility(View.VISIBLE);
                    plus4.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        //This code is for footer which include phone call, email, instaprofile view and facebook profile view
        facebook=(ImageView)view.findViewById(R.id.facebook);
        instagram=(ImageView)view.findViewById(R.id.instagram);
        phone=(TextView)view.findViewById(R.id.phone);
        email=(TextView)view.findViewById(R.id.email);
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