package com.example.jdatech.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jdatech.R;

import java.util.ArrayList;

public class RecyclerViewAdapter_CardView extends RecyclerView.Adapter<RecyclerViewAdapter_CardView.MyViewHolder> {
    private ArrayList<String> dataset;
    private LayoutInflater mInflater;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView timeStart, timeFinish, note;
        public MyViewHolder(View v) {
            super(v);
            timeStart = v.findViewById(R.id.timeStart);
            timeFinish = v.findViewById(R.id.timeFinish);
            note = v.findViewById(R.id.note);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter_CardView(Context context, ArrayList<String> list) {
        dataset = list;
        mInflater = LayoutInflater.from(context);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter_CardView.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {

        // create a new view
        View view = mInflater.inflate(R.layout.cardview_home, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //String content = dataset[position];
        //holder.textView.setText(content);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
