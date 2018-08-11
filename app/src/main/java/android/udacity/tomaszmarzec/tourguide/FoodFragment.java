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
import java.util.List;


public class FoodFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.list, container, false);

        List<Location> locationsArray = new ArrayList<>();
        locationsArray.add(new Location(getString(R.string.food_name_graffiti),
                getString(R.string.food_dscrpt_graffiti), R.drawable.food_graffiti,
                getString(R.string.food_map_graffiti), getString(R.string.food_url_graffiti)));
        locationsArray.add(new Location(getString(R.string.food_name_rynek23),
                getString(R.string.food_dscrpt_rynek23), R.drawable.food_rynek23,
                getString(R.string.food_map_rynek23), getString(R.string.food_url_rynek23)));
        locationsArray.add(new Location(getString(R.string.food_name_klimtowka),
                getString(R.string.food_dscrpt_klimtowka), R.drawable.food_klimtowka,
                getString(R.string.food_map_klimtowka), getString(R.string.food_url_klimtówka)));
        locationsArray.add(new Location(getString(R.string.food_name_kebab),
                getString(R.string.food_dscrpt_kebab), R.drawable.food_kebab,
                getString(R.string.food_map_kebab), getString(R.string.food_url_kebab)));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locationsArray,
                R.color.categoryFoodLight, R.color.categoryFoodDark);

        ListView listView = rootView.findViewById(R.id.rootListView);
        listView.setAdapter(locationAdapter);

        return rootView;
    }
}

