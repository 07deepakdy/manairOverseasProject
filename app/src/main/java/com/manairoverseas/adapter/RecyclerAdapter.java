package com.manairoverseas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.manairoverseas.R;
import com.manairoverseas.fragments.HomeFragment;
import com.manairoverseas.model.VisaType;
import com.manairoverseas.util.RecyclerViewInterface;

import java.util.ArrayList;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<VisaType> arrayList;
    RecyclerViewInterface recyclerViewInterface;

    public RecyclerAdapter(FragmentActivity context, ArrayList<VisaType> arrayList,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.arrayList = arrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public RecyclerAdapter(HomeFragment homeFragment, ArrayList<VisaType> arrayList1) {
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View myview= LayoutInflater.from(context).inflate(R.layout.cardview_items,parent,false);
        return new MyViewHolder(myview)  ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.visaType.setImageResource(arrayList.get(position).getVisaType());
      holder.visaDesc.setText(arrayList.get(position).getVisaDesc());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView visaType;
        TextView visaDesc;
        ConstraintLayout cardrec;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            visaType=(ImageView)itemView.findViewById(R.id.visaType);
            visaDesc=(TextView)itemView.findViewById(R.id.visaDesc);
            cardrec=(ConstraintLayout) itemView.findViewById(R.id.cardrec);
            cardrec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
