package com.manairoverseas.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manairoverseas.R;
import com.manairoverseas.adapter.ApplicatioStepsAdapter;
import com.manairoverseas.helper.SharedPrefManager;
import com.manairoverseas.util.ApiInterface;
import com.manairoverseas.util.CandidateResponse;
import com.manairoverseas.util.SignoutResponse;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CandidateDashboardFragment extends Fragment  {
    CircleImageView user_photo;
    TextView user_name,user_id,user_logout;
    GridLayout gridLayout;
    CardView dash_card,detail_card,steps_card,manage_card;
    SharedPrefManager sharedPrefManager;
    String candidateId;
    ImageView facebook,instagram;
    TextView phone,email;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_candidate_dashboard, container, false);
       dash_card=(CardView)view.findViewById(R.id.dash_card);
       detail_card=(CardView)view.findViewById(R.id.detail_card);
       steps_card=(CardView)view.findViewById(R.id.steps_card);
       manage_card=(CardView)view.findViewById(R.id.manage_card);
       user_photo=(CircleImageView)view.findViewById(R.id.user_photo);
       user_name=(TextView)view.findViewById(R.id.user_name);
       user_id=(TextView)view.findViewById(R.id.user_id);
       user_logout=(TextView)view.findViewById(R.id.logout);
       gridLayout=(GridLayout)view.findViewById(R.id.gridLayout);
        sharedPrefManager=new SharedPrefManager(getActivity());

        user_name.setText(getArguments().getString("FullName"));
        user_id.setText(getArguments().getString("APNO"));
         candidateId=getArguments().getString("Candidateid");
        Log.e("Usedetails ",""+getArguments().getString("FullName")+"   "+getArguments().getString("APNO"));

        //Backpressed



        user_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSignOut();

            }
        });

        dash_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JobDetailsFragment jobDetailsFragment=new JobDetailsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,jobDetailsFragment).addToBackStack(null).commit();
            }
        });
        steps_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationStepsFragment applicationStepsFragment=new ApplicationStepsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,applicationStepsFragment).addToBackStack(null).commit();
            }
        });
        detail_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JobDetailsFragment jobDetailsFragment=new JobDetailsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,jobDetailsFragment).addToBackStack(null).commit();
            }
        });
        manage_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManageFragment manageFragment=new ManageFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,manageFragment).addToBackStack(null).commit();
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

    private void userSignOut() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Signing Out...");
        progressDialog.show();



        // https://manairoverseas.in/candidate-mobile-app/mobileapi/logout
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://manairoverseas.in/candidate-mobile-app/mobileapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service=retrofit.create(ApiInterface.class);
        Call<SignoutResponse> call=service.userLogOut(candidateId);
        Log.e("URL HIT LOGOUT",call.request().url().toString());
        call.enqueue(new Callback<SignoutResponse>() {
            @Override
            public void onResponse(Call<SignoutResponse> call, Response<SignoutResponse> response) {
                progressDialog.dismiss();
                Log.e("message_dash",""+response.body().getMessage());
                Log.e("Candidateid_dash",""+response.body().getStatus());
                if(response.body().getMessage().equals("Logout successfully!")){
                    sharedPrefManager.UpdateUserLoginStatus(false);
                    sharedPrefManager.SaveCandidateID("");
                    sharedPrefManager.SaveUserID("");
                    sharedPrefManager.SaveUserName("");
                    FragmentManager fm=getActivity().getSupportFragmentManager();
                    fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.frame,new CandidateLoginFragment());
                  // ft.remove(new CandidateDashboardFragment());

                                        ft.commit();
                  ft.addToBackStack(null);


                    Toast.makeText(getActivity(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SignoutResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }





}