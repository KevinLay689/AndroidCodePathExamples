package com.example.kevinlay.androidfundamentalspractice.AdapterViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;

/**
 * Created by kevinlay on 12/3/17.
 */

public class UsersCardAdapter extends RecyclerView.Adapter<UsersCardAdapter.ViewHolder>{

    ArrayList<UserModel> users;

    public UsersCardAdapter(ArrayList<UserModel> users) {
        this.users = users;
    }

    // This method inflates the item layout and creates the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    // This method sets the view attributes based on the data
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvBalooning.setText(holder.tvBalooning.getText() + users.get(position).getUsername());
    }

    // This method returns your model size
    @Override
    public int getItemCount() {
        return users.size();
    }

    // Must bind the views here using the view passed into constructor to target them
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvBalooning;

        public ViewHolder(View itemView) {
            super(itemView);

            tvBalooning = (TextView) itemView.findViewById(R.id.tvBalooning);

        }
    }
}
