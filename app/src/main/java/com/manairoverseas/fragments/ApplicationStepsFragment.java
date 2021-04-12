package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manairoverseas.R;
import com.manairoverseas.adapter.ApplicatioStepsAdapter;
import com.manairoverseas.model.ApplicationStepsModel;
import com.manairoverseas.model.BlogModel;

import java.util.ArrayList;
import java.util.List;

public class ApplicationStepsFragment extends Fragment {
    RecyclerView recycler_View;
    ApplicatioStepsAdapter applicatioStepsAdapter;
   ArrayList<ApplicationStepsModel> application_list=new ArrayList<>();
    ImageView facebook,instagram;
    TextView phone,email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_application_steps, container, false);
        recycler_View=(RecyclerView)v.findViewById(R.id.recSteps);
        setRecyclerView();
        //This code is for footer which include phone call, email, instaprofile view and facebook profile view
        facebook=(ImageView)v.findViewById(R.id.facebook);
        instagram=(ImageView)v.findViewById(R.id.instagram);
        phone=(TextView)v.findViewById(R.id.phone);
        email=(TextView)v.findViewById(R.id.email);
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
        return v;
    }

    private void setRecyclerView() {
        recycler_View.setHasFixedSize(true);
        recycler_View.setLayoutManager(new LinearLayoutManager(getActivity()));
        applicatioStepsAdapter=new ApplicatioStepsAdapter(getActivity(),getList());
        recycler_View.setAdapter(applicatioStepsAdapter);
    }
    private List<ApplicationStepsModel> getList(){

        application_list.add(new ApplicationStepsModel("1","Application \nReceived","",""));
        application_list.add(new ApplicationStepsModel("2","Submission \nDocuments","",""));
        application_list.add(new ApplicationStepsModel("3","Verification \nDocuments","",""));
        application_list.add(new ApplicationStepsModel("4","Registration \nFee","",""));
        application_list.add(new ApplicationStepsModel("5","IMM Form","",""));
        application_list.add(new ApplicationStepsModel("6","Form details","",""));
        application_list.add(new ApplicationStepsModel("7","Employee \nprofile ","",""));
        application_list.add(new ApplicationStepsModel("8","Selection","",""));
        application_list.add(new ApplicationStepsModel("9","Telephonic \nInterview","",""));
        application_list.add(new ApplicationStepsModel("10","Application of \nLMIA","",""));
        application_list.add(new ApplicationStepsModel("11","Medical Checkup ","",""));
        application_list.add(new ApplicationStepsModel("12","Canadian work \npermit","",""));
        application_list.add(new ApplicationStepsModel("13","Interview at \nEmbassy","",""));
        application_list.add(new ApplicationStepsModel("14"," Temporary \nWork Visa","",""));

        return application_list;
    }
}