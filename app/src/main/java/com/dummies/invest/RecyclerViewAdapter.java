package com.dummies.invest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder>{

    private Context mctx;



    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView invType;
        TextView bname;
        TextView   rate;

        PersonViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card8);
            bname= itemView.findViewById(R.id.moreDetails1);
           invType = itemView.findViewById(R.id.moreDetails2);
           rate = itemView.findViewById(R.id.moreDetails3);
        }
    }

    //did some editing here
   private List<InvestInfo> persons;

//  public  RecyclerViewAdapter(Context mctx , List <InvestInfo>  persons){
//      this.mctx=mctx;
//        this.persons = persons;
//    }

    public RecyclerViewAdapter(List<InvestInfo> persons) {
        this.persons = persons;
    }








    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_more_details, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(PersonViewHolder personViewholder, int position) {
      InvestInfo investinfo = persons.get(position);
      personViewholder.bname.setText(investinfo.getName());
  personViewholder.invType.setText(investinfo.getInvtype());
     //   personViewholder.rate.setText(investinfo.rate());
        personViewholder.rate.setText(persons.get(position).rate);
//       personViewholder.bname.setText(persons.get(position).name);
       // holder.invType.setText(persons.get(position).age);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }




    }
