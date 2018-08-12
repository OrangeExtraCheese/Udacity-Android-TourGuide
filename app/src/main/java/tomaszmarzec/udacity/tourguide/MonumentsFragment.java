package tomaszmarzec.udacity.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.udacity.tomaszmarzec.tourguide.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MonumentsFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.list, container, false);

        List<Location> locationsArray = new ArrayList<>();
        locationsArray.add(new Location(getString(R.string.monuments_name_church),
                getString(R.string.monuments_dscrpt_church), R.drawable.monuments_church,
                getString(R.string.monuments_map_church), getString(R.string.monuments_url_church)));
        locationsArray.add(new Location(getString(R.string.monuments_name_cemetery),
                getString(R.string.monuments_dscrpt_cementery), R.drawable.monuments_cementery,
                getString(R.string.monuments_map_cementery), getString(R.string.monuments_url_cemetery)));
        locationsArray.add(new Location(getString(R.string.monuments_name_mig_fighter),
                getString(R.string.monuments_dscrpt_mig_fighter), R.drawable.monuments_mig_fighter,
                getString(R.string.monuments_map_mig_fighter)));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locationsArray,
                R.color.categoryMonumentLight, R.color.categoryMonumentDark);

        ListView listView = rootView.findViewById(R.id.rootListView);
        listView.setAdapter(locationAdapter);

        return rootView;
    }
}
