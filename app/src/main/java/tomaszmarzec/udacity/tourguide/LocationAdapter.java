//Package renamed because "udacity" folder in it caused error in Butterknife
package tomaszmarzec.udacity.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.udacity.tomaszmarzec.tourguide.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationAdapter extends ArrayAdapter<Location>
{
    @BindView(R.id.image) protected ImageView locationImgView;
    @BindView(R.id.map_image) protected ImageView mapImgView;
    @BindView(R.id.www_image) protected ImageView webImgView;
    @BindView(R.id.icons_bar_constraint_layout) protected ConstraintLayout iconsBarView;
    @BindView(R.id.location_name) protected TextView nameTxtView;
    @BindView(R.id.location_description) protected TextView dscrptnTxtView;

    private int mFirstBackgroundColorId;
    private int mSecondBackgroundColorId;
    private static Toast mToast;
    private String address;


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
                cancelToast();

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
                    cancelToast();

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
                    cancelToast();

                    mToast = Toast.makeText(getContext(),
                            getContext().getString(R.string.toast_no_url_message), Toast.LENGTH_LONG);
                    mToast.show();
                }
            };
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ButterKnife.bind(this, convertView);

        convertView.setBackgroundColor(ContextCompat.getColor(getContext(), mFirstBackgroundColorId));
        iconsBarView.setBackgroundColor(ContextCompat.getColor(getContext(), mSecondBackgroundColorId));

        Location location = getItem(position);

        locationImgView.setImageResource(location.getImgId());
        nameTxtView.setText(location.getName());
        dscrptnTxtView.setText(location.getDescription());
        mapImgView.setOnClickListener(createOnClickMapIntent(location.getMapQuery()));
        webImgView.setOnClickListener(createOnClickBrowserIntent(location.getURL()));

        /*Unfortunately I did not figure out how to reduce boilerplate code of methods creating
          listeners. @OnClick is simple but I don't know how to pass arguments from current Location
          object (line 115) to it. For example, website url from location.getUrl() */

        return convertView;
    }

    /*This method dismisses toast message. It is called when user clicks on map or web icon, and
      also when user switches tab. This method is called by ViewPager.OnPageChangeListener() in
      Main Activity, so I declared it static. */

    public static void cancelToast()
    {
        if(mToast!=null)
            mToast.cancel();
    }
}
