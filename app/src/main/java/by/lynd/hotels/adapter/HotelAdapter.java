package by.lynd.hotels.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import by.lynd.hotels.R;
import by.lynd.hotels.model.Hotel;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private List<Hotel> hotels;
    private LayoutInflater inflater;
    private OnHotelClickListener listener;

    public interface OnHotelClickListener {
        void onHotelClick(Hotel hotel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView price;

        public ViewHolder(View viewItem) {
            super(viewItem);

            viewItem.setOnClickListener(view -> {
                Hotel hotel = hotels.get(getLayoutPosition());
                listener.onHotelClick(hotel);
            });

            image = viewItem.findViewById(R.id.hotel_image);
            name = viewItem.findViewById(R.id.hotel_name);
            price = viewItem.findViewById(R.id.hotel_price);
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getName() {
            return name;
        }

        public TextView getPrice() {
            return price;
        }
    }

    public HotelAdapter(Context context, List<Hotel> hotels) {
        this.hotels = hotels;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.hotel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);

        Glide
                .with(inflater.getContext())
                .load(hotel.getImageUrl())
                .into(holder.getImage());

        holder.getName().setText(hotel.getName());
        holder.getPrice().setText(String.valueOf(hotel.getPrice()));
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }
}
