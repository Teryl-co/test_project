package by.lynd.hotels.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import by.lynd.hotels.Model.Hotel;
import by.lynd.hotels.Tasks.DownloadImageTask;
import by.lynd.hotels.R;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    public HotelAdapter(Context context, int resource, List<Hotel> hotels){
        super(context, resource, hotels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hotel hotel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_hotel, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.hotel_image);
        TextView name = convertView.findViewById(R.id.hotel_name);
        TextView price = convertView.findViewById(R.id.hotel_price);

        Glide
                .with(getContext())
                .load(hotel.getImageUrl())
                .into(img);

        name.setText(hotel.getName());
        price.setText("price: " + hotel.getPrice());

        return convertView;
    }

}
