package com.manairoverseas.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.manairoverseas.R;

import java.util.regex.Pattern;

import static com.manairoverseas.R.id.agefactor;


public class ParmanentResidenceFragment extends Fragment {
    TextView agefactordetail, languageproficiencydetail, credentialdetail, experiencedetail,phone, email;
    ConstraintLayout agefactor, credentialclick, languageclick, experienceclick;

    ImageView ageplus, languageplus, eduplus, workplus,facebook,instagram;
    EditText nameedt, emailedt, phoneedt, message;
    Button send;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parmanent_residence, container, false);
        agefactordetail = (TextView) view.findViewById(R.id.agefactordetail);
        languageproficiencydetail = (TextView) view.findViewById(R.id.languageproficiencydetail);
        credentialdetail = (TextView) view.findViewById(R.id.credentialdetail);
        experiencedetail = (TextView) view.findViewById(R.id.experiencedetail);

        agefactor = (ConstraintLayout) view.findViewById(R.id.ageclick);
        credentialclick = (ConstraintLayout) view.findViewById(R.id.credentialclick);
        languageclick = (ConstraintLayout) view.findViewById(R.id.languageclick);
        experienceclick = (ConstraintLayout) view.findViewById(R.id.experienceclick);

        ageplus = (ImageView) view.findViewById(R.id.ageplus);
        eduplus = (ImageView) view.findViewById(R.id.eduplus);
        languageplus = (ImageView) view.findViewById(R.id.languageplus);
        workplus = (ImageView) view.findViewById(R.id.workplus);

        nameedt = (EditText) view.findViewById(R.id.nameedt);
        emailedt = (EditText) view.findViewById(R.id.emailedt);
        phoneedt = (EditText) view.findViewById(R.id.phoneedt);
        message = (EditText) view.findViewById(R.id.message);

        send = (Button) view.findViewById(R.id.send);
        // down page
        facebook=(ImageView)view.findViewById(R.id.facebook);
        instagram=(ImageView)view.findViewById(R.id.instagram);
        phone=(TextView)view.findViewById(R.id.phone);
        email=(TextView)view.findViewById(R.id.email);




        /*expand-1*/
        agefactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (agefactordetail.getVisibility() == View.VISIBLE) {
                    agefactordetail.setVisibility(View.GONE);
                    ageplus.setImageResource(R.drawable.dependent_plus);
                } else if (agefactordetail.getVisibility() == View.GONE) {
                    agefactordetail.setVisibility(View.VISIBLE);
                    ageplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        /*expand-2*/
        languageclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageproficiencydetail.getVisibility() == View.VISIBLE) {
                    languageproficiencydetail.setVisibility(View.GONE);
                    languageplus.setImageResource(R.drawable.dependent_plus);
                } else if (languageproficiencydetail.getVisibility() == View.GONE) {
                    languageproficiencydetail.setVisibility(View.VISIBLE);
                    languageplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        /*expand-3*/

        credentialclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (credentialdetail.getVisibility() == View.VISIBLE) {
                    credentialdetail.setVisibility(View.GONE);
                    eduplus.setImageResource(R.drawable.dependent_plus);
                } else if (credentialdetail.getVisibility() == View.GONE) {
                    credentialdetail.setVisibility(View.VISIBLE);
                    eduplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });


        /*expand-4*/
        experienceclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (experiencedetail.getVisibility() == View.VISIBLE) {
                    experiencedetail.setVisibility(View.GONE);
                    workplus.setImageResource(R.drawable.dependent_plus);
                } else if (experiencedetail.getVisibility() == View.GONE) {
                    experiencedetail.setVisibility(View.VISIBLE);
                    workplus.setImageResource(R.drawable.dependent_minus);
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // button click
            }
        });


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
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@manairoverseas.in"});
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

    private boolean validationSuccess() {
        if (TextUtils.isEmpty(nameedt.getText().toString())) {
            nameedt.setError("First name is empty ");
            return false;
        }
        if (TextUtils.isEmpty(emailedt.getText().toString()) || !validEmail(emailedt.getText().toString())) {
            emailedt.setError("Email field should not be empty or email should be valid ");
            return false;
        }
        return true;


    }

    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }



}
