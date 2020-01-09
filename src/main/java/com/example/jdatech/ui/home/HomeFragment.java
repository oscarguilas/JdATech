package com.example.jdatech.ui.home;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.jdatech.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //Get the display
        WindowManager wm = (WindowManager) getContext().getSystemService(getContext().WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        //Getting the display size
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int smallSide;
        //Finding the small side of the screen
        if(width > height) smallSide = height;
        else if(height > width) smallSide = width;
        else smallSide = width;

        Double convSmall = smallSide*0.35;
        smallSide =(int) Math.round(convSmall);

        ConstraintLayout dateBackground = root.findViewById(R.id.dateLayout);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) dateBackground.getLayoutParams();

        params.height = smallSide;
        params.width = smallSide;

        dateBackground.setLayoutParams(params);

        TextView dateText = root.findViewById(R.id.dateText);

        //TODO: Format date text to better fit the shape and generally look better

        return root;




    }
}