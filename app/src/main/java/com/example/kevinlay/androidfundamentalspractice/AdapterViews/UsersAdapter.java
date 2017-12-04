package com.example.kevinlay.androidfundamentalspractice.AdapterViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;

/**
 * Created by kevinlay on 12/3/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    ArrayList<UserModel> users;

    public UsersAdapter(ArrayList<UserModel> users) {
        this.users = users;
    }

    // This method inflates the item layout and creates the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_single_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    // This method sets the view attributes based on the data
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvUsername.setText(users.get(position).getUsername());
    }

    // This method returns your model size
    @Override
    public int getItemCount() {
        return users.size();
    }

    // Must bind the views here using the view passed into constructor to target them
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvUsername;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            imageView = (ImageView) itemView.findViewById(R.id.ivRecyclerViewImage);
        }
    }
}
