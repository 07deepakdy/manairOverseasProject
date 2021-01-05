package com.manairoverseas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manairoverseas.R;
import com.manairoverseas.model.VisaType;

import java.util.ArrayList;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    Context context;
    ArrayList<VisaType> arrayList;

    public RecyclerAdapter(Context context, ArrayList<VisaType> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View myview= LayoutInflater.from(context).inflate(R.layout.cardview_items,parent,false);
        return new MyViewHolder(myview)  ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.visaType.setText(arrayList.get(position).getVisaType());
      holder.visaDesc.setText(arrayList.get(position).getVisaDesc());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView visaType;
        TextView visaDesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            visaType=(TextView)itemView.findViewById(R.id.visaType);
            visaDesc=(TextView)itemView.findViewById(R.id.visaDesc);
        }
    }
}
