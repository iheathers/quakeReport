package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private String mUrl;
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;

    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
