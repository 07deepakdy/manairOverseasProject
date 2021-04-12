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
import com.manairoverseas.adapter.RecyclerAdapter;
import com.manairoverseas.model.BlogModel;
import com.manairoverseas.util.BlogrecyclerViewInterface;
import com.manairoverseas.util.RecyclerViewInterface;

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
        blogTypeItem();
        onClickBottom();
        // Inflate the layout for this fragmen
        return  v;
    }

    private void onClickBottom() {
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
    }

    private void blogTypeItem() {
        if(arrayList != null) {
            arrayList.clear();
        } else {
            arrayList = new ArrayList<>();
        }
        arrayList.add(new BlogModel("Skilled Worker Visa",R.drawable.ic_skilled_worker));
        arrayList.add(new BlogModel("Student/Study Visa",R.drawable.ic_study_visa));
        arrayList.add(new BlogModel("Family Visa",R.drawable.ic_family_visa));
        arrayList.add(new BlogModel("Visitor Visa",R.drawable.ic_visitor));
        arrayList.add(new BlogModel("Work Permit Visa",R.drawable.ic_work));
        arrayList.add(new BlogModel("Tourist Visa",R.drawable.ic_tourist_visa));
        blogAdapter = new BlogAdapter(getActivity(),arrayList, new BlogrecyclerViewInterface() {
            @Override
            public void onItemClick(int position) {
               Log.e("postion",""+position);
                    if(position == 0){
                        WorkPermitFragment wpf = new WorkPermitFragment ();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,wpf).addToBackStack(null).commit();
                    }else if (position==1){
                        StudyVisaFragment svf = new StudyVisaFragment ();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,svf).addToBackStack(null).commit();

                    }else if (position==2){
                        FamilyVisaFragment fvf = new FamilyVisaFragment ();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,fvf).addToBackStack(null).commit();

                    }else if (position==3){
                        TouristVisaFragment tvf = new TouristVisaFragment ();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,tvf).addToBackStack(null).commit();

                    }else if (position==4){
                        WorkPermitFragment wpf = new WorkPermitFragment ();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,wpf).addToBackStack(null).commit();

                    }else if (position==5){
                        TouristVisaFragment tvf = new TouristVisaFragment ();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,tvf).addToBackStack(null).commit();

                    }
                }



        });
       // blogAdapter=new BlogAdapter(getActivity(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(blogAdapter);
    }
}