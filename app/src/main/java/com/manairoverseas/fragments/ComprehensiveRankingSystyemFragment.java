package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manairoverseas.R;

import java.util.zip.Inflater;

public class ComprehensiveRankingSystyemFragment extends Fragment {
    ImageView facebook,instagram;
    TextView phone, email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View view=inflater.inflate(R.layout.fragment_comprehensive_ranking_systyem, container, false);
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
                        final Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
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
                        handler.postDelayed(new Runnable() {
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
}

