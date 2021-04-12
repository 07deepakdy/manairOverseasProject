package com.manairoverseas.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manairoverseas.R;
import com.manairoverseas.helper.SharedPrefManager;
import com.manairoverseas.util.ApiInterface;
import com.manairoverseas.util.CandidateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CandidateLoginFragment extends Fragment {
    EditText applictionno,passenter;
    Button signbutton;
    SharedPrefManager sharedPrefManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_candidate_login, container, false);

        applictionno=(EditText)view.findViewById(R.id.applictionno);
        passenter=(EditText)view.findViewById(R.id.passenter);
        signbutton=(Button)view.findViewById(R.id.signbutton);
        sharedPrefManager=new SharedPrefManager(getActivity());
        if(sharedPrefManager.IsUserLogin()){
            String uName=sharedPrefManager.getUserName();
            String uId=sharedPrefManager.getUserId();
            String CandidateId=sharedPrefManager.getCandidateId();
            Bundle bundle=new Bundle();
            bundle.putString("FullName",uName);
            bundle.putString("APNO",uId);
            bundle.putString("Candidateid",CandidateId);
            CandidateDashboardFragment candidateDashboardFragment1 = new CandidateDashboardFragment ();
            candidateDashboardFragment1.setArguments(bundle);
            FragmentManager fm=getActivity().getSupportFragmentManager();
            fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.frame,candidateDashboardFragment1);
            // ft.remove(new CandidateDashboardFragment());

            ft.commit();
            ft.addToBackStack(null);


        }

        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userSignUp();
            }
        });
        return view;
    }

    private void userSignUp() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String applicationNumber=applictionno.getText().toString().trim();
        String password=passenter.getText().toString().trim();


        /*Retrofit insalized*/
       // https://manairoverseas.in/candidate-mobile-app/mobileapi/login
        Retrofit retrofit=new Retrofit.Builder()
                                      .baseUrl("https://manairoverseas.in/candidate-mobile-app/mobileapi/")
                                      .addConverterFactory(GsonConverterFactory.create())
                                      .build();

        ApiInterface service=retrofit.create(ApiInterface.class);
        Call<CandidateResponse> call=service.userLogin(applicationNumber,password);
        Log.e("URL HIT",call.request().url().toString());
        call.enqueue(new Callback<CandidateResponse>() {
            @Override
            public void onResponse(Call<CandidateResponse> call, Response<CandidateResponse> response) {
                progressDialog.dismiss();
              Log.e("Status",""+response.body().getStatus());
              Log.e("message",""+response.body().getMessage());


                if(response.body().getMessage().equals("Login Sucessfully!")){
                    String APNO=response.body().getCandidatedetail().getApplicationNumber();
                    String FULLNAME=response.body().getCandidatedetail().getFullName();
                    String CandidateId=response.body().getCandidatedetail().getFullName();

                    Log.e("Usedetailssend ",""+APNO+"   "+FULLNAME);
                    Log.e("Candidateid",""+response.body().getCandidatedetail().getCandidateid());
                    Log.e("ApplicationNumber",""+response.body().getCandidatedetail().getApplicationNumber());
                    Log.e("Fullname",""+response.body().getCandidatedetail().getFullName());
                    Log.e("email_id",""+response.body().getCandidatedetail().getEmailId());
                    Log.e("phone no",""+response.body().getCandidatedetail().getPhoneNumber());

                    sharedPrefManager.UpdateUserLoginStatus(true);
                    sharedPrefManager.SaveUserName(FULLNAME);
                    sharedPrefManager.SaveUserID(APNO);
                    sharedPrefManager.SaveCandidateID(CandidateId);
                    Bundle bundle=new Bundle();
                    bundle.putString("FullName",FULLNAME);
                    bundle.putString("APNO",APNO);
                    bundle.putString("Candidateid",CandidateId);
                    CandidateDashboardFragment candidateDashboardFragment1 = new CandidateDashboardFragment ();
                    candidateDashboardFragment1.setArguments(bundle);
                    FragmentManager fm=getActivity().getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.frame,candidateDashboardFragment1);
                    ft.remove(new CandidateLoginFragment());
                    ft.commit();
                    ft.addToBackStack(null);
                    fm.popBackStack();

                   /* getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,candidateDashboardFragment1).
                            addToBackStack(null).commit();*/

                }
                else{
                    Toast.makeText(getActivity(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<CandidateResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });


    }
}