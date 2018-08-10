package android.udacity.tomaszmarzec.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CultureFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.list, container, false);

        ArrayList<Location> locationsArray = new ArrayList<>();
        locationsArray.add(new Location(getString(R.string.culture_name_cinema),
                getString(R.string.culture_dscrpt_cinema), R.drawable.culture_cinema,
                getString(R.string.culture_map_cinema), getString(R.string.culture_url_cinema)));
        locationsArray.add(new Location(getString(R.string.culture_name_days_of_wolbrom),
                getString(R.string.culture_dscrpt_days_of_wolbrom),
                R.drawable.culture_days_of_wolbrom, getString(R.string.culture_map_days_of_wolbrom)));
        locationsArray.add(new Location(getString(R.string.culture_name_wolbromiacy),
                getString(R.string.culture_dscrpt_wolbromiacy), R.drawable.culture_wolbromiacy,
                getString(R.string.culture_map_wolbromiacy), getString(R.string.culture_url_wolbromiacy)));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locationsArray,
                R.color.categoryCultureLight, R.color.categoryCultureDark);

        ListView listView = rootView.findViewById(R.id.rootListView);
        listView.setAdapter(locationAdapter);

        return rootView;
    }
}
