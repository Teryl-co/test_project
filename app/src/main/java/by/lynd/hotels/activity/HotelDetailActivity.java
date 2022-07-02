package by.lynd.hotels.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import by.lynd.hotels.R;
import by.lynd.hotels.contract.ItemContract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.presenter.DetailPresenter;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class HotelDetailActivity extends AppCompatActivity implements ItemContract.View {
    private ItemContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new DetailPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
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
    public void setUpCallButtonListener(String number) {
        Button button = findViewById(R.id.button_call);
        button.setOnClickListener(view -> startActivity(UtilActivity.call(number)));
    }

    @Override
    public void setUpEmailButtonListener(String... emails) {
        Button button = findViewById(R.id.button_send_email);
        button.setOnClickListener(view -> startActivity(UtilActivity.sendEmail(emails)));
    }

    @Override
    public void setUpLocationButtonListener(String location) {
        Button button = findViewById(R.id.button_find_location);
        button.setOnClickListener(view -> startActivity(UtilActivity.findLocation(location)));
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
}