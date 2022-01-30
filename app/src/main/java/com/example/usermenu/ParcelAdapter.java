package com.example.usermenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class ParcelAdapter extends FirebaseRecyclerAdapter<
        Parcel, ParcelAdapter.ParcelViewHolder> {

    public ParcelAdapter(
            @NonNull FirebaseRecyclerOptions<Parcel> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull ParcelViewHolder holder,
                     int position, @NonNull Parcel model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.trackNum.setText(model.getTrackNum());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.date.setText(model.getDate());
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public ParcelViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parcel_view, parent, false);
        return new ParcelAdapter.ParcelViewHolder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class ParcelViewHolder
            extends RecyclerView.ViewHolder {
        TextView trackNum, date;
        public ParcelViewHolder(@NonNull View itemView)
        {
            super(itemView);

            trackNum = itemView.findViewById(R.id.trackNum);
            date = itemView.findViewById(R.id.date);
        }
    }
}