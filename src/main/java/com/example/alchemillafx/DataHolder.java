package com.example.alchemillafx;

/**
 * Java Class that creates a singleton object, used to pass Profile, SerializableClassData, and HelloController instances
 */
public final class DataHolder {

    private SerializeClassData sc;
    private Profile prof;
    private HelloController hc;

    private static DataHolder dataholder = null;

    /**
     * Empty controller, creates instance
     */
    private DataHolder()
    {
    }

    /**
     * Gets current singleton object, or calls for the constructor if no singleton object has been created
     * @return
     */
    public static DataHolder getInstance()
    {
        if (dataholder == null)
        {
            dataholder = new DataHolder();
        }

        return dataholder;
    }

    /**
     * Sets SerializableClassData for singleton object
     * @param s SerializableClassData instance to be saved into DataHolder singleton object
     */
    public void setClassData(SerializeClassData s)
    {
        this.sc = s;
    }

    /**
     * Sets Profile for singleton object
     * @param p Profile instance to be saved into DataHolder singleton object
     */
    public void setProfile(Profile p)
    {
        this.prof = p;
    }

    /**
     * Sets HelloController for singleton object
     * @param hello HelloController instance to be saved into DataHolder singleton object
     */
    public void setController (HelloController hello) { this.hc = hello; }

    /**
     * Gets saved SerializableClassData instance
     * @return Saved SerializableClassData instance
     */
    public SerializeClassData getClassData()
    {
        return this.sc;
    }

    /**
     * Gets saved Profile instance
     * @return Saved Profile instance
     */
    public Profile getProfile()
    {
        return this.prof;
    }

    /**
     * Gets saved HelloController instance
     * @return Saved HelloController instance
     */
    public HelloController getHelloController() {return this.hc;}
}
