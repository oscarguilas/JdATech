package com.example.jdatech.ui.home;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jdatech.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
        //Using a percentage of the found value to later give size to the date medal
        Double convSmall = smallSide*0.4;
        smallSide =(int) Math.round(convSmall);

        ConstraintLayout dateBackground = root.findViewById(R.id.dateLayout);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) dateBackground.getLayoutParams();
        //Giving size to the date medal
        params.height = smallSide;
        params.width = smallSide;

        dateBackground.setLayoutParams(params);

        //Given the proper SDK level, it tries to set some elevation for a shadow. Unimportant
        if(Build.VERSION.SDK_INT > 21)dateBackground.setElevation(20);

        //Formatting the text inside the date medal to fit according to its size
        TextView dateText = root.findViewById(R.id.dateText);
        TextView smallDateText = root.findViewById(R.id.smallDateText);
        //"Main" text in the medal. "hour:minute:second"
        dateText.setTextSize((float) (smallSide*0.08));
        //"Secondary" text in the medal. "day/month/year"
        smallDateText.setTextSize((float)(smallSide*0.035));

        GregorianCalendar date = getCalendar();

        dateText.setText(formatHourMinuteSecond(date));
        smallDateText.setText(formatDayMonthYear(date));

        //Setting RecyclerView up
        //
        RecyclerView recView = root.findViewById(R.id.recyclerView);
        Context context = getActivity().getApplicationContext();

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        //-Get data
        //Dummy data
        ArrayList<String> content = new ArrayList<String>();
        content.add("20:00,21:00,nota");
        content.add("21:00,22:00,otra nota");
        content.add("22:00,23:00,mas notas!");

        RecyclerView.Adapter myAdapter = new RecyclerViewAdapter_CardView(context, content);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recView.getContext(),
                layoutManager.getOrientation());

        recView.setAdapter(myAdapter);
        recView.setLayoutManager(layoutManager);
        recView.addItemDecoration(dividerItemDecoration);


        return root;



    }

    public GregorianCalendar getCalendar(){
        TimeZone tz = TimeZone.getTimeZone("GMT+1:00");
        Calendar calendar = Calendar.getInstance(tz);
        GregorianCalendar date = (GregorianCalendar) calendar;

        return date;
    } //Returns a gregorian calendar with the current date

    public String formatHourMinuteSecond(GregorianCalendar date){
        StringBuilder sb = new StringBuilder();
        int hour, minute, second;
        hour = date.get(Calendar.HOUR_OF_DAY);
        if(hour < 10) sb.append("0");
        sb.append(hour+":");
        minute = date.get(Calendar.MINUTE);
        if(minute < 10) sb.append("0");
        sb.append(minute+":");
        second = date.get(Calendar.SECOND);
        if(second < 10) sb.append("0");
        sb.append(second);

        return sb.toString();
    } //Returns a "HH:MM:SS" properly formatted string

    public String formatDayMonthYear(GregorianCalendar date){
        StringBuilder sb = new StringBuilder();
        int day, month, year;
        day = date.get(Calendar.DAY_OF_MONTH);
        if(day < 10) sb.append("0");
        sb.append(day+"/");
        month = date.get(Calendar.MONTH)+1;
        if(month < 10) sb.append("0");
        sb.append(month+"/");
        year = date.get(Calendar.YEAR);
        if(year < 10) sb.append("0");
        sb.append(year);

        return sb.toString();
    } //Returns a "DD/MM/YY"
}