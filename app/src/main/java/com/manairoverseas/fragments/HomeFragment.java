package com.manairoverseas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manairoverseas.R;
import com.manairoverseas.adapter.RecyclerAdapter;
import com.manairoverseas.adapter.SliderPagerAdapter;
import com.manairoverseas.model.VisaType;
import com.manairoverseas.util.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {
   ViewPager viewPager;
   CircleIndicator indicator;
   ArrayList<Integer> arrayList;
   SliderPagerAdapter sliderPagerAdapter;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    RecyclerView visaTypeRecView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<VisaType> arrayList1;
    ImageView facebook,instagram;
    TextView phone,email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,container,false);
        // initialising views for Slider image Indicator
        visaTypeRecView=(RecyclerView)myview.findViewById(R.id.recHome);
        recyclerAdapter=new RecyclerAdapter(HomeFragment.this,arrayList1);
        viewPager=(ViewPager)myview.findViewById(R.id.vp_slider);
        indicator=(CircleIndicator) myview.findViewById(R.id.indicator);
        //initialising views for Home Fragment RecyclerView Items
        visaTypeRecView=(RecyclerView)myview.findViewById(R.id.recHome);
        facebook=(ImageView)myview.findViewById(R.id.facebook);
        instagram=(ImageView)myview.findViewById(R.id.instagram);
        phone=(TextView)myview.findViewById(R.id.phone);
        email=(TextView)myview.findViewById(R.id.email);
        AppCompatActivity activity=(AppCompatActivity)myview.getContext();
        imageSlider();// This Method contains all the codes related to image slideshow with indicator in home fragment
        visaTypeItems();//This Method contains all the codes related to recycler view visa type and descriptions
        //This code is for footer which include phone call, email, instaprofile view and facebook profile view

   onClickBottom();
       return myview;
    }


    public void visaTypeItems()
    {
        if(arrayList1 != null) {
            arrayList1.clear();
        } else {
            arrayList1 = new ArrayList<>();
        }
        arrayList1.add(new VisaType("Our Services",R.drawable.ic_services));
        arrayList1.add(new VisaType("Infomation",R.drawable.ic_essential_info_24));
        arrayList1.add(new VisaType("Media",R.drawable.ic_media));
        arrayList1.add(new VisaType("Contact Us",R.drawable.ic_contact_us));
        arrayList1.add(new VisaType("Candidate Login",R.drawable.ic_login_in));
        arrayList1.add(new VisaType("Our Works",R.drawable.ic_work));

        /*arrayList1.add(new VisaType("Study Visa","If you're a student,enroll with us to get an offer letter from any of our 700 partner Universities in Canada,New Zeeland,Australlia,the UK or the US,we can advise"));
        arrayList1.add(new VisaType("Permanent Residence","A permanent resident is someone who has been given permanent resident status by immigrating to canada, but is not a Canadian Citizen.Permanent Residents... "));
        arrayList1.add( new VisaType("Family Visa","A Canada Family Visa is a way to sponsor your family to immigrate to Canada as a permanent resident.Through this catagory family member can...."));
        arrayList1.add(new VisaType("Tourist Visa" ,"A visitor visa(also called a temporary resident visa) is an official document that we stick in your passport.it shows that you meet the requirement...."));*/
        recyclerAdapter = new RecyclerAdapter(getActivity(), arrayList1, new RecyclerViewInterface() {
            @Override
            public void onItemClick(int position) {
                if(position == 0){
                    OurServicesFragment osf = new OurServicesFragment ();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,osf).addToBackStack(null).commit();
                }else if (position==1){
                    EssentialInformationFragment eif = new EssentialInformationFragment ();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,eif).addToBackStack(null).commit();

                }else if (position==2){
                    BlogFragment bf = new BlogFragment ();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,bf).addToBackStack(null).commit();

                }else if (position==3){
                    ContactUsFragment cuf = new ContactUsFragment ();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,cuf).addToBackStack(null).commit();

                }else if (position==4){
                    FragmentManager fm=getActivity().getSupportFragmentManager();
                    fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.frame,new CandidateLoginFragment());
                    // ft.remove(new CandidateDashboardFragment());

                    ft.commit();
                    ft.addToBackStack(null);
                   /* CandidateLoginFragment clf = new CandidateLoginFragment ();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,clf).addToBackStack(null).commit();*/

                }else if (position==5){
                    OurWorksFragment owf = new OurWorksFragment ();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,owf).addToBackStack(null).commit();

                }
            }
        });
        visaTypeRecView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        visaTypeRecView.setAdapter(recyclerAdapter);
        visaTypeRecView.setAdapter(recyclerAdapter);



    }
    public void imageSlider()
    {
        if(arrayList != null) {
            arrayList.clear();
        } else {
            arrayList= new ArrayList<>();
        }
        arrayList.add(R.drawable.homeslider1);
        arrayList.add(R.drawable.homeslider2);
        arrayList.add(R.drawable.homeslider3);
        sliderPagerAdapter=new SliderPagerAdapter(getActivity(),arrayList);
        viewPager.setAdapter(sliderPagerAdapter);
        indicator.setViewPager(viewPager);

        NUM_PAGES =arrayList.size();
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++,true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 2000);
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

}