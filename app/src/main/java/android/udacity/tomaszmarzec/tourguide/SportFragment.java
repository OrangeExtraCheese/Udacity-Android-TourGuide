package android.udacity.tomaszmarzec.tourguide;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SportFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.list, container, false);

        List<Location> locationsArray = new ArrayList<>();
        locationsArray.add(new Location(getString(R.string.sport_name_pool),
                getString(R.string.sport_dscrpt_pool), R.drawable.sport_pool,
                getString(R.string.sport_map_pool), getString(R.string.sport_url_pool)));
        locationsArray.add(new Location(getString(R.string.sport_name_soccer),
                getString(R.string.sport_dscrpt_soccer),
                R.drawable.sport_soccer, getString(R.string.sport_map_soccer),
                getString(R.string.sport_url_soccer)));
        locationsArray.add(new Location(getString(R.string.sport_name_tennis),
                getString(R.string.sport_dscrpt_tennis),
                R.drawable.sport_tennis, getString(R.string.sport_map_tennis)));
        locationsArray.add(new Location(getString(R.string.sport_name_judo),
                getString(R.string.sport_dscrpt_judo), R.drawable.sport_judo,
                getString(R.string.sport_map_judo), getString(R.string.sport_url_judo)));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locationsArray,
                R.color.categorySportLight, R.color.categorySportDark);

        ListView listView = rootView.findViewById(R.id.rootListView);
        listView.setAdapter(locationAdapter);

        return rootView;
    }
}
