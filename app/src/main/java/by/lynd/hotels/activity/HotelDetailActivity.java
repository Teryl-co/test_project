package by.lynd.hotels.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import by.lynd.hotels.R;
import by.lynd.hotels.contract.ItemContract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.presenter.DetailPresenter;
import by.lynd.hotels.util.ButtonUtil;
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
    presenter.handleHotel(getIntent());
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
    android.widget.Button button = findViewById(R.id.button_call);
    button.setOnClickListener(view -> startActivity(ButtonUtil.call(number)));
  }

  @Override
  public void setUpEmailButtonListener(String... emails) {
    android.widget.Button button = findViewById(R.id.button_send_email);
    button.setOnClickListener(view -> startActivity(ButtonUtil.sendEmail(emails)));
  }

  @Override
  public void setUpLocationButtonListener(String location) {
    android.widget.Button button = findViewById(R.id.button_find_location);
    button.setOnClickListener(view -> startActivity(ButtonUtil.findLocation(location)));
  }

  @Override
  public void setUpItemView(Hotel hotel) {
    ImageView image = findViewById(R.id.hotel_detail_image);
    TextView name = findViewById(R.id.hotel_detail_name);
    TextView price = findViewById(R.id.hotel_detail_price);
    TextView email = findViewById(R.id.hotel_detail_email);
    TextView phone = findViewById(R.id.hotel_detail_phone);
    TextView description = findViewById(R.id.hotel_detail_desc);

    Glide.with(this).load(hotel.getImageUrl()).into(image);

    name.setText(hotel.getName());
    price.append(hotel.getPrice().toString());
    email.append(hotel.getEmail());
    phone.append(hotel.getNumber());
    description.append(hotel.getDescription());
  }
}
