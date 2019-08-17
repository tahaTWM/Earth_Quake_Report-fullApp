package com.twm.quakereport;



import android.content.LocusId;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;


public class EarthQuacke_ArrayAdapter extends ArrayAdapter<Show> {
    public EarthQuacke_ArrayAdapter(MainActivity mainActivity, ArrayList<Show> arrList) {
        super(mainActivity, 0, (List<Show>) arrList);

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        if (magnitude >= 1 && magnitude <2)
            magnitudeColorResourceId = R.color.magnitude1;
        else if (magnitude >= 2 && magnitude <3)
            magnitudeColorResourceId = R.color.magnitude2;
        else if (magnitude >= 3 && magnitude <4)
            magnitudeColorResourceId = R.color.magnitude3;
        else if (magnitude >= 4 && magnitude <5)
            magnitudeColorResourceId = R.color.magnitude4;
        else if (magnitude >= 5 && magnitude <6)
            magnitudeColorResourceId = R.color.magnitude5;
        else if (magnitude >= 6 && magnitude <7)
            magnitudeColorResourceId = R.color.magnitude6;
        else if (magnitude >= 7 && magnitude <8)
            magnitudeColorResourceId = R.color.magnitude7;
        else if (magnitude >= 8 && magnitude <9)
            magnitudeColorResourceId = R.color.magnitude8;
        else if (magnitude >= 9 && magnitude <=10)
                magnitudeColorResourceId = R.color.magnitude9;
        else
            magnitudeColorResourceId = R.color.magnitude10plus;

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ListItemView = convertView;
        if (ListItemView == null) {
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.show_items, parent, false);
        }
        Show currentItem = getItem(position);

        TextView mag = (TextView) ListItemView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentItem.getMgetMagnitude());
        mag.setText(formattedMagnitude);


        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(currentItem.getMgetMagnitude()));

        TextView upLoc = (TextView) ListItemView.findViewById(R.id.location_offset);
        TextView downLoc = (TextView) ListItemView.findViewById(R.id.primary_location);
        upLoc.setText(currentItem.getUpLoc());
        downLoc.setText(currentItem.getDownLoc());


        Date dateObject = new Date(currentItem.getTimeInMilliseconds());
        TextView data = (TextView) ListItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        data.setText(formattedDate);


        TextView time = (TextView) ListItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);


        return ListItemView;
    }
}
