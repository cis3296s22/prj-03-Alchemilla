package com.example.alchemillafx;

public final class DataHolder {

    private SerializeClassData sc;
    private Profile prof;

    private static DataHolder dataholder = null;

    private DataHolder()
    {
    }

    public static DataHolder getInstance()
    {
        if (dataholder == null)
        {
            dataholder = new DataHolder();
        }

        return dataholder;
    }

    public void setClassData(SerializeClassData s)
    {
        this.sc = s;
    }

    public void setProfile(Profile p)
    {
        this.prof = p;
    }


    public SerializeClassData getClassData()
    {
        return this.sc;
    }

    public Profile getProfile()
    {
        return this.prof;
    }
}