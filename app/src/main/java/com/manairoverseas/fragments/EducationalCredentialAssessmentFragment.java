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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.manairoverseas.R;

import java.util.zip.Inflater;

public class EducationalCredentialAssessmentFragment extends Fragment {
    ImageView whatitplus,credentialplus;
    TextView whatitdetail,credentialdetail;
    ConstraintLayout whatitclick,credentialclick;
    ImageView facebook,instagram;
    TextView phone, email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_educational_credential_assessment,container,false);
        facebook=(ImageView)view.findViewById(R.id.facebook);
        instagram=(ImageView)view.findViewById(R.id.instagram);
        phone=(TextView)view.findViewById(R.id.phone);
        email=(TextView)view.findViewById(R.id.email);
        whatitplus=(ImageView)view.findViewById(R.id.whatitplus);
        credentialplus=(ImageView)view.findViewById(R.id.credentialplus);
        whatitdetail=(TextView)view.findViewById(R.id.whatitdetail);
        credentialdetail=(TextView)view.findViewById(R.id.credentialdetail);
        whatitclick=(ConstraintLayout)view.findViewById(R.id.whatitclick);
        credentialclick=(ConstraintLayout)view.findViewById(R.id.credentialclick);

        whatitclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(whatitdetail.getVisibility()==View.VISIBLE){
                    whatitdetail.setVisibility(View.GONE);
                    whatitplus.setImageResource(R.drawable.dependent_plus);
                }
                else if(whatitdetail.getVisibility()==View.GONE){
                    whatitdetail.setVisibility(View.VISIBLE);
                    whatitplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        credentialclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(credentialdetail.getVisibility()==View.VISIBLE){
                    credentialdetail.setVisibility(View.GONE);
                    credentialplus.setImageResource(R.drawable.dependent_plus);
                }
                else if(credentialdetail.getVisibility()==View.GONE){
                    credentialdetail.setVisibility(View.VISIBLE);
                    credentialplus.setImageResource(R.drawable.dependent_minus);
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



        // Inflate the layout for this fragment
        return view;
    }
}