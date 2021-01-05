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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.manairoverseas.R;


public class WorkPermitFragment extends Fragment {
CheckBox agree;
EditText firstname,lastname,emai,mobil,message;
ConstraintLayout skillworker,factorpoint,require,selection,education,proof,language,experience,live,expressentry;
TextView skillworkerText,requireText,languageText,proofText,experienceText,liveText,expressentryText,selectionText,factorpointText,educationText;
ImageView skillworkerImage,requireImage,languageImage,proofImage,experienceImage,liveImage,expressentryImage,selectionImage,factorpointImage,educationImage;
ImageView facebook,instagram;
TextView phone, email;
Button submit;

    Spinner interest,country;
    String [] program={"Select any Program","Study Visa","Work Permit","Tourist Visa","Others"};
    String [] visitcountry={"Select any Country","Australia","Canada","Thailand"};
    String selectedprogram;
    String selectedcountry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View w=inflater.inflate(R.layout.fragment_work_permit, container, false);
        agree=(CheckBox)w.findViewById(R.id.agree);
        submit=(Button)w.findViewById(R.id.submit);
        submit.setEnabled(false);
        interest=(Spinner)w.findViewById(R.id.interest);
        country=(Spinner)w.findViewById(R.id.country);

        facebook=(ImageView)w.findViewById(R.id.facebook);
        instagram=(ImageView)w.findViewById(R.id.instagram);
        phone=(TextView)w.findViewById(R.id.phone);
        email=(TextView)w.findViewById(R.id.email);
        skillworkerText=(TextView)w.findViewById(R.id.skill);
        requireText=(TextView)w.findViewById(R.id.requireText);
        languageText=(TextView)w.findViewById(R.id.languageText);
        proofText=(TextView)w.findViewById(R.id.proofText);
        experienceText=(TextView)w.findViewById(R.id.experienceText);
        liveText=(TextView)w.findViewById(R.id.liveText);
        expressentryText=(TextView)w.findViewById(R.id.expressentryText);
        selectionText=(TextView)w.findViewById(R.id.selectionText);
        factorpointText=(TextView)w.findViewById(R.id.factorpointText);
        educationText=(TextView)w.findViewById(R.id.educationText);
        skillworkerImage=(ImageView) w.findViewById(R.id.skillworkerImage);
        requireImage=(ImageView) w.findViewById(R.id.requireImage);
        languageImage=(ImageView) w.findViewById(R.id.languageImage);
        proofImage=(ImageView) w.findViewById(R.id.proogImage);
        experienceImage=(ImageView) w.findViewById(R.id.experienceImage);
        liveImage=(ImageView) w.findViewById(R.id.liveImage);
        expressentryImage=(ImageView) w.findViewById(R.id.expressentryImage);
        selectionImage=(ImageView) w.findViewById(R.id.selectionImage);
        factorpointImage=(ImageView) w.findViewById(R.id.factorpointImage);
        educationImage=(ImageView) w.findViewById(R.id.educationImage);
        proof=(ConstraintLayout)w.findViewById(R.id.proof);
        skillworker=(ConstraintLayout)w.findViewById(R.id.skillworker);
        factorpoint=(ConstraintLayout)w.findViewById(R.id.factorpoint);
        require=(ConstraintLayout)w.findViewById(R.id.require);
        selection=(ConstraintLayout)w.findViewById(R.id.selection);
        education=(ConstraintLayout)w.findViewById(R.id.education);
        language=(ConstraintLayout)w.findViewById(R.id.language);
        experience=(ConstraintLayout)w.findViewById(R.id.experience);
        live=(ConstraintLayout)w.findViewById(R.id.live);
        expressentry=(ConstraintLayout)w.findViewById(R.id.expressentry);
        skillworker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (skillworkerText.getVisibility()==View.VISIBLE){
                    skillworkerText.setVisibility(View.GONE);
                    skillworkerImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (skillworkerText.getVisibility()==View.GONE){
                    skillworkerText.setVisibility(View.VISIBLE);
                    skillworkerImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        factorpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (factorpointText.getVisibility()==View.VISIBLE){
                    factorpointText.setVisibility(View.GONE);
                    factorpointImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (factorpointText.getVisibility()==View.GONE){
                    factorpointText.setVisibility(View.VISIBLE);
                    factorpointImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        require.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (requireText.getVisibility()==View.VISIBLE){
                    requireText.setVisibility(View.GONE);
                    requireImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (requireText.getVisibility()==View.GONE){
                    requireText.setVisibility(View.VISIBLE);
                    requireImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectionText.getVisibility()==View.VISIBLE){
                    selectionText.setVisibility(View.GONE);
                    selectionImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (selectionText.getVisibility()==View.GONE){
                    selectionText.setVisibility(View.VISIBLE);
                    selectionImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (educationText.getVisibility()==View.VISIBLE){
                    educationText.setVisibility(View.GONE);
                    educationImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (educationText.getVisibility()==View.GONE){
                    educationText.setVisibility(View.VISIBLE);
                    educationImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageText.getVisibility()==View.VISIBLE){
                    languageText.setVisibility(View.GONE);
                    languageImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (languageText.getVisibility()==View.GONE){
                    languageText.setVisibility(View.VISIBLE);
                    languageImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        expressentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressentryText.getVisibility()==View.VISIBLE){
                    expressentryText.setVisibility(View.GONE);
                    expressentryImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (expressentryText.getVisibility()==View.GONE){
                    expressentryText.setVisibility(View.VISIBLE);
                    expressentryImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        proof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (proofText.getVisibility()==View.VISIBLE){
                    proofText.setVisibility(View.GONE);
                    proofImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (proofText.getVisibility()==View.GONE){
                    proofText.setVisibility(View.VISIBLE);
                    proofImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (experienceText.getVisibility()==View.VISIBLE){
                    experienceText.setVisibility(View.GONE);
                    experienceImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (experienceText.getVisibility()==View.GONE){
                    experienceText.setVisibility(View.VISIBLE);
                    experienceImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (liveText.getVisibility()==View.VISIBLE){
                    liveText.setVisibility(View.GONE);
                    liveImage.setImageResource(R.drawable.dependent_plus);
                }
                else if (liveText.getVisibility()==View.GONE){
                    liveText.setVisibility(View.VISIBLE);
                    liveImage.setImageResource(R.drawable.dependent_minus);
                }
            }
        });
        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    submit.setEnabled(true);
                }
                else{
                    submit.setEnabled(false);
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
        ArrayAdapter ii=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,program);
        ii.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interest.setAdapter(ii);
        interest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(program[i]=="Select any Program"){
                    return;
                }else{
                    selectedprogram=program[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Please select area of interest", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter cc=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,visitcountry);
        cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(cc);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (visitcountry[i]=="Select any Country"){
                    return;
                }else{
                    selectedcountry=visitcountry[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Please select any Country", Toast.LENGTH_SHORT).show();
            }
        });
        return w;
    }
}