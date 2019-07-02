package com.example.android.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakeActivity.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = "of ";
    private String primaryLocation;
    private String locationOffset;


    // public class because we need it in the EarthquakeActivity

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */


    @Override

    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Earthquake currentEarthquake = getItem(position);
        if (currentEarthquake != null) {



            TextView earthquakeMagnitudeView = listItemView.findViewById(R.id.earthquake_magnitude);
            earthquakeMagnitudeView.setText(currentEarthquake.getmEarthquakeMagnitude());

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) earthquakeMagnitudeView.getBackground();

            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentEarthquake.getmEarthquakeMagnitude());

            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

            String exactLocation = currentEarthquake.getmEarthquakeLocation();

            if (exactLocation.contains(LOCATION_SEPARATOR)) {
                int endIndex = exactLocation.indexOf(LOCATION_SEPARATOR) + 3;
                locationOffset = exactLocation.substring(0, endIndex);
                primaryLocation = exactLocation.substring(endIndex, exactLocation.length());

            } else {
                locationOffset = "Near the";
                primaryLocation = exactLocation;
            }

            TextView primaryLocationView = listItemView.findViewById(R.id.earthquake_primary_location);
            primaryLocationView.setText(primaryLocation);

            TextView locationOffsetView = listItemView.findViewById(R.id.location_offset);
            locationOffsetView.setText(locationOffset);

            Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

            TextView earthquakeDateView = listItemView.findViewById(R.id.earthquake_date);
            String formattedDate = formatDate(dateObject);
            earthquakeDateView.setText(formattedDate);

            TextView earthquakeTimeView = listItemView.findViewById(R.id.earthquake_time);
            String formattedTime = formatTime(dateObject);
            earthquakeTimeView.setText(formattedTime);



        }

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");

        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(String magnitude){
        int earthquakeMagnitude = (int) Double.parseDouble(magnitude);
        int magnitudeColorResourceId;


        switch (earthquakeMagnitude){
            case 0: case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;

            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }


}
