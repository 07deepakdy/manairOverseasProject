package com.manairoverseas.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;


import com.manairoverseas.R;
import com.manairoverseas.adapter.CustomAdapter;
import com.manairoverseas.fragments.BlogFragment;
import com.manairoverseas.fragments.CandidateLoginFragment;
import com.manairoverseas.fragments.ComprehensiveRankingSystyemFragment;
import com.manairoverseas.fragments.ContactUsFragment;
import com.manairoverseas.fragments.EducationalCredentialAssessmentFragment;
import com.manairoverseas.fragments.ExpressEntryProgramFragment;
import com.manairoverseas.fragments.FamilyVisaFragment;
import com.manairoverseas.fragments.HomeFragment;
import com.manairoverseas.fragments.ParmanentResidenceFragment;
import com.manairoverseas.fragments.PnpFragment;
import com.manairoverseas.fragments.StudyVisaFragment;
import com.manairoverseas.fragments.TouristVisaFragment;
import com.manairoverseas.fragments.WorkPermitFragment;
import com.manairoverseas.model.ChildInfo;
import com.manairoverseas.model.GroupInfo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;
    private ImageView alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadData();
        alert=(ImageView)toolbar.findViewById(R.id.alert);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addFragment(new AlertFragment());
            }
        });

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(MainActivity.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new HomeFragment());
        ft.commit();
        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                //display it or do something with it
                // Toast.makeText(MainActivity.this, ""+detailInfo.getName(), Toast.LENGTH_SHORT).show();
                if(detailInfo.getName().equalsIgnoreCase("Study Visa")){
                    addFragment(new StudyVisaFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Family Visa")){
                    addFragment(new FamilyVisaFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Tourist Visa")){
                   addFragment(new TouristVisaFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Work Permit")){
                    addFragment(new WorkPermitFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Permanent Residence")){
                    addFragment(new ParmanentResidenceFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("PNP Program")){
                    addFragment(new PnpFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Express Entry Program")){
                    addFragment(new ExpressEntryProgramFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("CRS")){
                    addFragment(new ComprehensiveRankingSystyemFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("ECA")){
                    addFragment(new EducationalCredentialAssessmentFragment());
                }
                else if(detailInfo.getName().equalsIgnoreCase("Blog")){
                    addFragment(new BlogFragment());
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it

                if(headerInfo.getName().equalsIgnoreCase("Home")){
                    addFragment(new HomeFragment());
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(headerInfo.getName().equalsIgnoreCase("Candidate Login")){

                    addFragment(new CandidateLoginFragment());
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(headerInfo.getName().equalsIgnoreCase("Contacts")){
                    addFragment(new ContactUsFragment());
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }


                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
    //load some initial data into out list
    private void loadData(){

        addProduct("Home","");
        addProduct("Our Services","Study Visa");
        addProduct("Our Services","Family Visa");
        addProduct("Our Services","Tourist Visa");
        addProduct("Our Services","Work Permit");
        addProduct("Our Services","Permanent Residence");
        addProduct("Essential Information","PNP Program");
        addProduct("Essential Information","Express Entry Program");
        addProduct("Essential Information","CRS");
        addProduct("Essential Information","ECA");
        addProduct("Media","Blog");
        addProduct("Candidate Login","");
        addProduct("Contacts","");

    }

    //here we maintain our products in various departments
    private int addProduct(String department, String product){

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;
        if(product.equals("")){

        }
        else{
            //create a new child and add that to the group
            ChildInfo detailInfo = new ChildInfo();
            // detailInfo.setSequence(String.valueOf(listSize));
            detailInfo.setName(product);
            productList.add(detailInfo);
            headerInfo.setProductList(productList);
        }

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
    public void addFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
        ft.addToBackStack(null);

    }
}