package com.example.android.quakereport;

public class Earthquake {

    private String  mEarthquakeMagnitude;
    private String mEarthquakeLocation;
    private long mTimeInMilliseconds;
    private String mEarthquakeUrl;

    public Earthquake(String earthquakeMagnitude, String earthquakeLocation, long timeInMilliseconds, String earthquakeUrl) {
        mEarthquakeMagnitude = earthquakeMagnitude;
        mEarthquakeLocation = earthquakeLocation;
        mTimeInMilliseconds = timeInMilliseconds;
        mEarthquakeUrl = earthquakeUrl;
    }

    public String getmEarthquakeMagnitude() {
        return mEarthquakeMagnitude;

    }

    public String getmEarthquakeLocation() {
        return mEarthquakeLocation;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getmEarthquakeUrl() {
        return mEarthquakeUrl;
    }
}
