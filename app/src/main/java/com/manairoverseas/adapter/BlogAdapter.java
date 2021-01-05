package com.manairoverseas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manairoverseas.R;
import com.manairoverseas.model.BlogModel;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.Myblog>{
    Context context;
    ArrayList<BlogModel> arrayList;

    public BlogAdapter(Context context, ArrayList<BlogModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
           holder.inner.setText(arrayList.get(position).getInnerheading());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myblog extends RecyclerView.ViewHolder {
    TextView main,inner;

    public Myblog(@NonNull View itemView) {
        super(itemView);
        main=(TextView)itemView.findViewById(R.id.mainheading);
        inner=(TextView)itemView.findViewById(R.id.innerheading);
    }
}
}
