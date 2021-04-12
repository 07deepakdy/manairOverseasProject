package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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
import android.widget.TextView;
import android.widget.Toast;

import com.manairoverseas.R;

import java.util.regex.Pattern;


public class ParmanentResidenceFormFragment extends Fragment {
    EditText nameedittext, emailEdit, phoneEdit, message;
    Button button;
    ImageView facebook,instagram;
    TextView phone,email;


    //boolean isNameValid, isEmailValid, isPhoneValid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parmanent_residence_form, container, false);
        nameedittext = (EditText) view.findViewById(R.id.nameedittext);
        emailEdit = (EditText) view.findViewById(R.id.emailEdit);
        phoneEdit = (EditText) view.findViewById(R.id.phoneEdit);
        message = (EditText) view.findViewById(R.id.message);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validation()) {
                        String to = "info@manairoverseas.in";
                        String subject = "Application Form Query !!!";
                        String data = "Name :- " + nameedittext.getText().toString() + "\n" + "Email Address :- " + emailEdit.getText().toString() + "\n" + "Phone Number :-" + phoneEdit.getText().toString() + "\n" + "Message :- " + message.getText().toString();


                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                        email.putExtra(Intent.EXTRA_SUBJECT, subject);
                        email.putExtra(Intent.EXTRA_TEXT, data);

                        //need this to prompts email client only
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "Choose an Email client :"));

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
        return  view;


    }
    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private boolean isValidPhone(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }


    private boolean validation() {
        if (TextUtils.isEmpty(nameedittext.getText().toString())) {
            nameedittext.setError("Please enter  FullName");
            return false;
        }
        else if (TextUtils.isEmpty(emailEdit.getText().toString()) || !isValidEmail(emailEdit.getText().toString())) {
            emailEdit.setError("Email field should not be empty or email should be valid");
            return false;
        }
       else if (TextUtils.isEmpty(phoneEdit.getText().toString())) {
            phoneEdit.setError("Enter a valid phone number");
            return false;
        }
        else if (TextUtils.isEmpty(message.getText().toString())) {
            message.setError("Please enter  FullName");
            return false;
        }
        return true;
    }




}

