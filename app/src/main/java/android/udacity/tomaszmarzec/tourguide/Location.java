package android.udacity.tomaszmarzec.tourguide;

public class Location
{
    private String mName, mDescription, mMapQuery, mURL;
    private int mImgId;

    public Location(String name, String description, int imgId, String mapQuery, String URL)
    {
        mName = name;
        mDescription = description;
        mImgId = imgId;
        mMapQuery = mapQuery;
        mURL = URL;
    }

    /*Not every location has it's own website, so this constructor omits url parameter, LocationAdapter
      handles null value returned from mURL. */
    public Location(String name, String description, int imgId, String mapQuery)
    {
        mName = name;
        mDescription = description;
        mImgId = imgId;
        mMapQuery = mapQuery;
    }


    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImgId() {
        return mImgId;
    }

    public String getMapQuery() {
        return mMapQuery;
    }

    public String getURL() {
        return mURL;
    }
}
