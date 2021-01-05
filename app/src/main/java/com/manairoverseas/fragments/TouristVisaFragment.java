package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.manairoverseas.R;


public class TouristVisaFragment extends Fragment {
    ImageView plus,visitorplus,needresidentplus,residentplus,seperateplus,studycanadaplus;
    TextView longdetail,visitordetail,needresidentdetail,residentdetail,seperatedetail,studycanadadetail;
    ImageView facebook,instagram;
    TextView phone, email;
    ConstraintLayout stayLayout,visitorsLayout,needResidentialLayout,residentialLayout,seperatelyLayout,studyCanadaLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_tourist_visa, container, false);
        facebook=(ImageView)view.findViewById(R.id.facebook);
        instagram=(ImageView)view.findViewById(R.id.instagram);
        phone=(TextView)view.findViewById(R.id.phone);
        email=(TextView)view.findViewById(R.id.email);
      plus=(ImageView)view.findViewById(R.id.plus);
      visitorplus=(ImageView)view.findViewById(R.id.visitorplus);
      needresidentplus=(ImageView)view.findViewById(R.id.needresidentplus);
      residentplus=(ImageView)view.findViewById(R.id.residentplus);
      seperateplus=(ImageView)view.findViewById(R.id.seperateplus);
      studycanadaplus=(ImageView)view.findViewById(R.id.studycanadaplus);
      longdetail=(TextView)view.findViewById(R.id.longdetail);
      visitordetail=(TextView)view.findViewById(R.id.visitordetail);
      needresidentdetail=(TextView)view.findViewById(R.id.needresidentdetail);
      residentdetail=(TextView)view.findViewById(R.id.residentdetail);
      seperatedetail=(TextView)view.findViewById(R.id.seperatedetail);
      studycanadadetail=(TextView)view.findViewById(R.id.studycanadadetail);
      stayLayout=(ConstraintLayout)view.findViewById(R.id.stayLayout);
      visitorsLayout=(ConstraintLayout)view.findViewById(R.id.visitorsLayout);
      needResidentialLayout=(ConstraintLayout)view.findViewById(R.id.needresdentLayout);
      residentialLayout=(ConstraintLayout)view.findViewById(R.id.residentLayout);
      seperatelyLayout=(ConstraintLayout)view.findViewById(R.id.seperatelyLayout);
      studyCanadaLayout=(ConstraintLayout)view.findViewById(R.id.studycanadaLayout);
      stayLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(longdetail.getVisibility()==View.VISIBLE){
                                   longdetail.setVisibility(View.GONE);
                  plus.setImageResource(R.drawable.dependent_plus);
              }
              else if(longdetail.getVisibility()==View.GONE){
                  longdetail.setVisibility(View.VISIBLE);
                  plus.setImageResource(R.drawable.dependent_minus);
              }



          }
      });
      visitorsLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(visitordetail.getVisibility()==View.VISIBLE){
                  visitordetail.setVisibility(View.GONE);
                  visitorplus.setImageResource(R.drawable.dependent_plus);
              }
              else if(visitordetail.getVisibility()==View.GONE){
                  visitordetail.setVisibility(View.VISIBLE);
                  visitorplus.setImageResource(R.drawable.dependent_minus);
              }
          }
      });
        needResidentialLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(needresidentdetail.getVisibility()==View.VISIBLE){
                    needresidentdetail.setVisibility(View.GONE);
                    needresidentplus.setImageResource(R.drawable.dependent_plus);
                }
                else if(needresidentdetail.getVisibility()==View.GONE){
                    needresidentdetail.setVisibility(View.VISIBLE);
                    needresidentplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        residentialLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(residentdetail.getVisibility()==View.VISIBLE){
                    residentdetail.setVisibility(View.GONE);
                    residentplus.setImageResource(R.drawable.dependent_plus);
                }
                else if(residentdetail.getVisibility()==View.GONE){
                    residentdetail.setVisibility(View.VISIBLE);
                    residentplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        seperatelyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seperatedetail.getVisibility()==View.VISIBLE){
                    seperatedetail.setVisibility(View.GONE);
                    seperateplus.setImageResource(R.drawable.dependent_plus);
                }
                else if(seperatedetail.getVisibility()==View.GONE){
                    seperatedetail.setVisibility(View.VISIBLE);
                    seperateplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        studyCanadaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(studycanadadetail.getVisibility()==View.VISIBLE){
                    studycanadadetail.setVisibility(View.GONE);
                    studycanadaplus.setImageResource(R.drawable.dependent_plus);
                }
                else if(studycanadadetail.getVisibility()==View.GONE){
                    studycanadadetail.setVisibility(View.VISIBLE);
                    studycanadaplus.setImageResource(R.drawable.dependent_minus);
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