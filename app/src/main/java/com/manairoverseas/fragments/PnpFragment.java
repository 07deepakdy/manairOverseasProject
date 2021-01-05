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

import me.biubiubiu.justifytext.library.JustifyTextView;

public class PnpFragment extends Fragment {
    ConstraintLayout albertaLayout,britishLayout,manitobaLayout,newBrunswickLayout,newFoundlandLayout,novaScotiaLayout,ontarioLayout,princeEdwardLayout,saskatchewankLayout,northwestLayout,yukonLayout;
    TextView albertDetail,britishDetail,manitobaDetail,newBrunswickDetail,newFoundlandDetail,novaScotiaDetail,ontarioDetail,princeEdwardDetail,saskatchewanDetail,northwestDetail,yukonDetail;
    ImageView albertaPlus,britishPlus,manitobaPlus,newBrunswickPlus,newFoundlandPlus,novaScotiaPlus,ontarioPlus,princeEdwardPlus,saskatchewanPlus,northwestPlus,yukonPlus;
    ImageView facebook,instagram;
    TextView phone,email;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_pnp, container, false);
        albertaLayout=(ConstraintLayout)myView.findViewById(R.id.albertaLayout);
        britishLayout=(ConstraintLayout)myView.findViewById(R.id.britishLayout);
        manitobaLayout=(ConstraintLayout)myView.findViewById(R.id.manitobaLayout);
        newBrunswickLayout=(ConstraintLayout)myView.findViewById(R.id.newBrunswickLayout);
        newFoundlandLayout=(ConstraintLayout)myView.findViewById(R.id.newFoundlandLayout);
        novaScotiaLayout=(ConstraintLayout)myView.findViewById(R.id.novaScotiaLayout);
        ontarioLayout=(ConstraintLayout)myView.findViewById(R.id.ontarioLayout);
        princeEdwardLayout=(ConstraintLayout)myView.findViewById(R.id.princeEdwardLayout);
        saskatchewankLayout=(ConstraintLayout)myView.findViewById(R.id.saskatchewankLayout);
        northwestLayout=(ConstraintLayout)myView.findViewById(R.id.northwestLayout);
        yukonLayout=(ConstraintLayout)myView.findViewById(R.id.yukonLayout);
        albertDetail=(TextView) myView.findViewById(R.id.albertaDetail);
        britishDetail=(TextView)myView.findViewById(R.id.britishDetail);
        manitobaDetail=(TextView)myView.findViewById(R.id.manitobaDetail);
        newBrunswickDetail=(TextView)myView.findViewById(R.id.newBrunswickDetail);
        newFoundlandDetail=(TextView)myView.findViewById(R.id.newFoundlandDetail);
        novaScotiaDetail=(TextView)myView.findViewById(R.id.novaScotiaDetail);
        ontarioDetail=(TextView)myView.findViewById(R.id.ontarioDetail);
        princeEdwardDetail=(TextView)myView.findViewById(R.id.princeEdwardDetail);
        saskatchewanDetail=(TextView)myView.findViewById(R.id.saskatchewanDetail);
        northwestDetail=(TextView)myView.findViewById(R.id.northwestDetail);
        yukonDetail=(TextView)myView.findViewById(R.id.yukonDetail);
        albertaPlus=(ImageView)myView.findViewById(R.id.albertaPlus);
        britishPlus=(ImageView)myView.findViewById(R.id.britishPlus);
        manitobaPlus=(ImageView)myView.findViewById(R.id.manitobaPlus);
        newBrunswickPlus=(ImageView)myView.findViewById(R.id.newBrunswickPlus);
        newFoundlandPlus=(ImageView)myView.findViewById(R.id.newFoundlandPlus);
        novaScotiaPlus=(ImageView)myView.findViewById(R.id.novaScotiaPlus);
        ontarioPlus=(ImageView)myView.findViewById(R.id.ontarioPlus);
        princeEdwardPlus=(ImageView)myView.findViewById(R.id.princeEdwardPlus);
        saskatchewanPlus=(ImageView)myView.findViewById(R.id.saskatchewanPlus);
        northwestPlus=(ImageView)myView.findViewById(R.id.northwestPlus);
        yukonPlus=(ImageView)myView.findViewById(R.id.yukonPlus);

        albertaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(albertDetail.getVisibility()==View.VISIBLE){
                    albertDetail.setVisibility(View.GONE);
                    albertaPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(albertDetail.getVisibility()==View.GONE){
                    albertDetail.setVisibility(View.VISIBLE);
                    albertaPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
     britishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(britishDetail.getVisibility()==View.VISIBLE){
                    britishDetail.setVisibility(View.GONE);
                    britishPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(britishDetail.getVisibility()==View.GONE){
                    britishDetail.setVisibility(View.VISIBLE);
                    britishPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        manitobaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(manitobaDetail.getVisibility()==View.VISIBLE){
                    manitobaDetail.setVisibility(View.GONE);
                    manitobaPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(manitobaDetail.getVisibility()==View.GONE){
                    manitobaDetail.setVisibility(View.VISIBLE);
                    manitobaPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        newBrunswickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(newBrunswickDetail.getVisibility()==View.VISIBLE){
                    newBrunswickDetail.setVisibility(View.GONE);
                    newBrunswickPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(newBrunswickDetail.getVisibility()==View.GONE){
                    newBrunswickDetail.setVisibility(View.VISIBLE);
                    newBrunswickPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        newFoundlandLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(newFoundlandDetail.getVisibility()==View.VISIBLE){
                    newFoundlandDetail.setVisibility(View.GONE);
                    newFoundlandPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(newFoundlandDetail.getVisibility()==View.GONE){
                    newFoundlandDetail.setVisibility(View.VISIBLE);
                    newFoundlandPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        novaScotiaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(novaScotiaDetail.getVisibility()==View.VISIBLE){
                    novaScotiaDetail.setVisibility(View.GONE);
                    novaScotiaPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(novaScotiaDetail.getVisibility()==View.GONE){
                    novaScotiaDetail.setVisibility(View.VISIBLE);
                    novaScotiaPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        ontarioLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ontarioDetail.getVisibility()==View.VISIBLE){
                    ontarioDetail.setVisibility(View.GONE);
                    ontarioPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(ontarioDetail.getVisibility()==View.GONE){
                    ontarioDetail.setVisibility(View.VISIBLE);
                    ontarioPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        princeEdwardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(princeEdwardDetail.getVisibility()==View.VISIBLE){
                    princeEdwardDetail.setVisibility(View.GONE);
                    princeEdwardPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(princeEdwardDetail.getVisibility()==View.GONE){
                    princeEdwardDetail.setVisibility(View.VISIBLE);
                    princeEdwardPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        saskatchewankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(saskatchewanDetail.getVisibility()==View.VISIBLE){
                    saskatchewanDetail.setVisibility(View.GONE);
                    saskatchewanPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(saskatchewanDetail.getVisibility()==View.GONE){
                    saskatchewanDetail.setVisibility(View.VISIBLE);
                    saskatchewanPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        northwestLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(northwestDetail.getVisibility()==View.VISIBLE){
                    northwestDetail.setVisibility(View.GONE);
                    northwestPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(northwestDetail.getVisibility()==View.GONE){
                    northwestDetail.setVisibility(View.VISIBLE);
                    northwestPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        yukonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(yukonDetail.getVisibility()==View.VISIBLE){
                    yukonDetail.setVisibility(View.GONE);
                    yukonPlus.setImageResource(R.drawable.dependent_plus);

                }
                else if(yukonDetail.getVisibility()==View.GONE){
                    yukonDetail.setVisibility(View.VISIBLE);
                    yukonPlus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        //This code is for footer which include phone call, email, instaprofile view and facebook profile view
         facebook=(ImageView)myView.findViewById(R.id.facebook);
         instagram=(ImageView)myView.findViewById(R.id.instagram);
        phone=(TextView)myView.findViewById(R.id.phone);
        email=(TextView)myView.findViewById(R.id.email);
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

        return myView;
    }
}