package com.twm.quakereport;

public class Show {
    private double mgetMagnitude;
    private String mgetCity;
    private long  mTimeInMilliseconds;
    String part1;
    String part2;

    public Show(double getMagnitude, String getCity, long  TimeInMilliseconds){
        mgetMagnitude = getMagnitude;
        mgetCity = getCity;
        mTimeInMilliseconds = TimeInMilliseconds;
        String string = mgetCity;
        String[] parts = string.split("-");
        part1 = parts[0];
        part2 = parts[1];
    }
    public double getMgetMagnitude(){ return mgetMagnitude;}

    public String getUpLoc(){ return part1;}
    public String getDownLoc(){ return part2; }

    public long getTimeInMilliseconds() { return mTimeInMilliseconds; }
}
