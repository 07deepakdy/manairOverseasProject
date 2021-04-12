package com.manairoverseas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manairoverseas.R;
import com.manairoverseas.model.ApplicationStepsModel;

import java.util.List;

public class ApplicatioStepsAdapter extends  RecyclerView.Adapter<ApplicatioStepsAdapter.myViewHolder>{
    Context context;
    List<ApplicationStepsModel> application_list;

    public ApplicatioStepsAdapter(Context context, List<ApplicationStepsModel> application_list) {
        this.context = context;
        this.application_list = application_list;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.items_application_steps,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if(application_list !=null && application_list.size()> 0){
            ApplicationStepsModel model=application_list.get(position);
            holder.step_tv.setText(model.getStepsNo());
            holder.apllication_tv.setText(model.getSteps());
            holder.status_tv.setText(model.getStatus());
            holder.dated_tv.setText(model.getDated());
        }else{
            return;
        }

    }

    @Override
    public int getItemCount() {
        return application_list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView step_tv,apllication_tv,status_tv,dated_tv;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            step_tv=(TextView)itemView.findViewById(R.id.step_tv);
            apllication_tv=(TextView)itemView.findViewById(R.id.apllication_tv);
            status_tv=(TextView)itemView.findViewById(R.id.status_tv);
            dated_tv=(TextView)itemView.findViewById(R.id.dated_tv);
        }
    }

}
