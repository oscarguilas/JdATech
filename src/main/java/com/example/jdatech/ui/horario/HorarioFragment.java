package com.example.jdatech.ui.horario;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdatech.R;

public class HorarioFragment extends Fragment {

    private HorarioViewModel myViewModel;
    private View thisView;
    private RecyclerView recView;
    private Context context;

    public static HorarioFragment newInstance() {
        return new HorarioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.horario_fragment, container, false);
        return thisView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Setting up the ViewModel to be paired to the fragment
        myViewModel = ViewModelProviders.of(this).get(HorarioViewModel.class);

        final TextView textView = thisView.findViewById(R.id.textView);
        myViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        //Setting up the Recycler View
        recView = thisView.findViewById(R.id.horario_recycler);

        //Declaring its Layout Manager and Adapter
        context = getActivity().getApplicationContext();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        RecyclerView.Adapter myAdapter = new MyRecyclerViewAdapter(context, new String[]{"TEST1", "TEST2", "TEST3"});

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recView.getContext(),
                layoutManager.getOrientation());

        recView.setAdapter(myAdapter);
        recView.setLayoutManager(layoutManager);
        recView.addItemDecoration(dividerItemDecoration);




    }

}
