package com.example.kevinlay.androidfundamentalspractice.AdapterViews;

import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;

/**
 * -Steps to creating a RecyclerView
 *      1. Create Model
 *      2. Create Adapter
 *      3. Adapter must extend RecyclerView.Adapter
 *      4. RecyclerView.Adapter needs a type of RecyclerView.ViewHolder, better to have an inner class be ViewHolder
 *          4b.Declaration looks like: public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>
 *      5. Create ViewHolder Inner class and make constructor call super
 *      6. Override onBindViewHolder, getCount(), onCreateViewHolder
 *      7. Must also bind the adapter to the recyclerView in the Activity
 *          7b.RecyclerView also needs a layoutManager passed into it
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvUsername.setText(users.get(position).getUsername());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked position " + position, Toast.LENGTH_SHORT ).show();
            }
        });
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
