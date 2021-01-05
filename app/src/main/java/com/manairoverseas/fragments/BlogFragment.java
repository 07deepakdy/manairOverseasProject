package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manairoverseas.R;
import com.manairoverseas.adapter.BlogAdapter;
import com.manairoverseas.model.BlogModel;

import java.util.ArrayList;


public class BlogFragment extends Fragment {
    ImageView facebook,instagram;
    TextView phone, email;
 RecyclerView recyclerView;
 ArrayList<BlogModel> arrayList=new ArrayList<>();
 BlogAdapter blogAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_blog, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        facebook=(ImageView)v.findViewById(R.id.facebook);
        instagram=(ImageView)v.findViewById(R.id.instagram);
        phone=(TextView)v.findViewById(R.id.phone);
        email=(TextView)v.findViewById(R.id.email);
        arrayList.add(new BlogModel("Skilled Worker Visa","Learn more"));
        arrayList.add(new BlogModel("Student/Study Visa","Learn more"));
        arrayList.add(new BlogModel("Family Visa","Learn more"));
        arrayList.add(new BlogModel("Visitor Visa","Learn more"));
        arrayList.add(new BlogModel("Work Permit Visa","Learn more"));
        arrayList.add(new BlogModel("Tourist Visa","Learn more"));
        blogAdapter=new BlogAdapter(getActivity(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(blogAdapter);
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
        // Inflate the layout for this fragment
        return  v;
    }
}