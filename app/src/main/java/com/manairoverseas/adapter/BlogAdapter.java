package com.manairoverseas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.manairoverseas.R;
import com.manairoverseas.fragments.BlogFragment;
import com.manairoverseas.fragments.CandidateDashboardFragment;
import com.manairoverseas.fragments.FamilyVisaFragment;
import com.manairoverseas.fragments.StudyVisaFragment;
import com.manairoverseas.fragments.WorkPermitFragment;
import com.manairoverseas.model.BlogModel;
import com.manairoverseas.util.BlogrecyclerViewInterface;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.Myblog>{
    Context context;
    ArrayList<BlogModel> arrayList;
    BlogrecyclerViewInterface blogRec;



    public BlogAdapter(Context context, ArrayList<BlogModel> arrayList, BlogrecyclerViewInterface blogRec) {
        this.context = context;
        this.arrayList = arrayList;
        this.blogRec = blogRec;
    }

    @NonNull
    @Override
    public Myblog onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View w= LayoutInflater.from(context).inflate(R.layout.blogitems,parent,false);
        return new Myblog(w);
    }

    @Override
    public void onBindViewHolder(@NonNull Myblog holder, int position) {
           holder.main.setText(arrayList.get(position).getMainheading());
          holder.innerimage.setImageResource(arrayList.get(position).getInnerheading());
     //
    }


    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class Myblog extends RecyclerView.ViewHolder {
    TextView main;
    ImageView innerimage;
    ConstraintLayout constClick;

    public Myblog(@NonNull View itemView) {
        super(itemView);
        context=itemView.getContext();
        main=(TextView)itemView.findViewById(R.id.mainheading);
        innerimage=(ImageView)itemView.findViewById(R.id.innerheading);
        constClick=(ConstraintLayout)itemView.findViewById(R.id.constitem);
        itemView.setClickable(true);
       // itemView.setOnClickListener();
        constClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              blogRec.onItemClick(getAdapterPosition());

            }
        });
    }
}
}
