package by.lynd.hotels.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import by.lynd.hotels.R;
import by.lynd.hotels.adapter.HotelAdapter;
import by.lynd.hotels.contract.MainContract;
import by.lynd.hotels.listener.OnHotelClickListener;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.presenter.MainPresenter;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements MainContract.View, OnHotelClickListener {
  private MainContract.Presenter presenter;
  private HotelAdapter adapter;
  private RecyclerView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    SplashScreen.installSplashScreen(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    presenter = new MainPresenter(this);
    adapter = new HotelAdapter(getApplicationContext());
    adapter.setOnHotelClickListener(this);

    listView = findViewById(R.id.list_hotels);
    DividerItemDecoration mDividerItemDecoration =
        new DividerItemDecoration(listView.getContext(), DividerItemDecoration.VERTICAL);
    listView.addItemDecoration(mDividerItemDecoration);
    listView.setAdapter(adapter);
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.start();
  }

  @Override
  public boolean isTheListIsEmpty() {
    return adapter.isTheListEmpty();
  }

  @Override
  public void showHotels(List<Hotel> hotels) {
    adapter.showHotels(hotels);
  }

  @Override
  public void shotToast(String text) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show();
  }

  @Override
  public void onHotelClick(Hotel hotel) {
    Intent intent = new Intent(getApplicationContext(), HotelDetailActivity.class);
    intent.putExtra(Hotel.class.getSimpleName(), hotel);
    startActivity(intent);
  }
}
