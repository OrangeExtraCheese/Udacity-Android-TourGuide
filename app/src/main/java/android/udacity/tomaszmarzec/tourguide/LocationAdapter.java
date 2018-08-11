package android.udacity.tomaszmarzec.tourguide;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LocationAdapter extends ArrayAdapter<Location>
{
    private int mFirstBackgroundColorId;
    private int mSecondBackgroundColorId;

    public LocationAdapter(@NonNull Context context, @NonNull List<Location> objects, int firstBackgroundColorId, int secondBackgroundColorId)
    {
        super(context, 0, objects);
        mFirstBackgroundColorId = firstBackgroundColorId;
        mSecondBackgroundColorId = secondBackgroundColorId;
    }

    private View.OnClickListener createOnClickMapIntent(final String address)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String uri;
                if(address.contains("°")) //checks if given address is in form of coordinates
                    uri = "http://maps.google.co.in/maps?q=" + address;
                else
                    uri = "http://maps.google.co.in/maps?q=Wolbrom+" + address;

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                getContext().startActivity(i);
            }
        };
    }

    private View.OnClickListener createOnClickBrowserIntent(final String URL)
    {
        if(URL!=null)
        {
            return new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    getContext().startActivity(i);
                }
            };
        }
        else
            return new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast t = Toast.makeText(getContext(),
                            getContext().getString(R.string.toast_no_url_message), Toast.LENGTH_LONG);
                    t.show();
                }
            };

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        listItemView.setBackgroundColor(ContextCompat.getColor(getContext(), mFirstBackgroundColorId));

        ConstraintLayout iconsBarView = listItemView.findViewById(R.id.icons_bar_constraint_layout);
        iconsBarView.setBackgroundColor(ContextCompat.getColor(getContext(), mSecondBackgroundColorId));

        Location location = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(location.getImgId());

        TextView nameView = listItemView.findViewById(R.id.location_name);
        nameView.setText(location.getName());

        TextView descriptionView = listItemView.findViewById(R.id.location_description);
        descriptionView.setText(location.getDescription());

       ImageView mapView = listItemView.findViewById(R.id.map_image);
        mapView.setOnClickListener(createOnClickMapIntent(location.getMapQuery()));

        ImageView webView = listItemView.findViewById(R.id.www_image);
        webView.setOnClickListener(createOnClickBrowserIntent(location.getURL()));

        return listItemView;
    }



}
