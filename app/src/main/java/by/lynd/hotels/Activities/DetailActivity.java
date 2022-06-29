package by.lynd.hotels.Activities;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import by.lynd.hotels.Model.Hotel;
import by.lynd.hotels.R;

public class DetailActivity extends Activity {
    private Hotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getHotelDetail();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getHotelDetail() {
        Intent response = getIntent();
        this.hotel = (Hotel) response.getSerializableExtra(Hotel.class.getSimpleName());
        ImageView image = findViewById(R.id.hotel_detail_image);
        TextView price = findViewById(R.id.hotel_detail_price);
        TextView email = findViewById(R.id.hotel_detail_email);
        TextView phone = findViewById(R.id.hotel_detail_phone);
        TextView description = findViewById(R.id.hotel_detail_desc);

        Glide
                .with(this)
                .load(hotel.getImageUrl())
                .into(image);

        price.setText("Price: " + this.hotel.getPrice());
        email.setText("Email: " + this.hotel.getEmail());
        phone.setText("Phone: " + this.hotel.getNumber());
        description.setText("Description:\n" + this.hotel.getDescription());
    }

    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + this.hotel.getNumber()));
        startActivity(callIntent);
    }

    public void sendEmail(View view) {
        String[] TO = {this.hotel.getEmail()};
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        startActivity(Intent.createChooser(sendIntent, "Send mail..."));
    }

    public void findLocation(View view) {
        Uri geoUri = Uri.parse("geo:" + this.hotel.getLocale() + "?z=19");
        Intent sendLocation = new Intent(Intent.ACTION_VIEW, geoUri);
        sendLocation.setPackage("com.google.android.apps.maps");
        startActivity(sendLocation);
    }

}