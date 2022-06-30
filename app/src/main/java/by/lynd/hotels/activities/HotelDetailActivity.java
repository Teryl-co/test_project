package by.lynd.hotels.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import by.lynd.hotels.model.Contract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.R;
import by.lynd.hotels.presenters.DetailPresenter;

public class HotelDetailActivity extends UtilActivity implements Contract.ItemView{
    private Contract.ItemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new DetailPresenter(this);
        presenter.handleIntent(getIntent());
        presenter.setUpButtonListener();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUpItemView(Hotel hotel) {
        ImageView image = findViewById(R.id.hotel_detail_image);
        TextView price = findViewById(R.id.hotel_detail_price);
        TextView email = findViewById(R.id.hotel_detail_email);
        TextView phone = findViewById(R.id.hotel_detail_phone);
        TextView description = findViewById(R.id.hotel_detail_desc);

        Glide
                .with(this)
                .load(hotel.getImageUrl())
                .into(image);

        price.setText("Price: " + hotel.getPrice());
        email.setText("Email: " + hotel.getEmail());
        phone.setText("Phone: " + hotel.getNumber());
        description.setText("Description:\n" + hotel.getDescription());
    }

    @Override
    public void setUpCallButtonListener(String number) {
        Button button = findViewById(R.id.button_call);
        button.setOnClickListener(view -> call(number));
    }

    @Override
    public void setUpEmailButtonListener(String... emails) {
        Button button = findViewById(R.id.button_send_email);
        button.setOnClickListener(view -> sendEmail(emails));
    }

    @Override
    public void setUpLocationButtonListener(String location) {
        Button button = findViewById(R.id.button_find_location);
        button.setOnClickListener(view -> findLocation(location));
    }
}