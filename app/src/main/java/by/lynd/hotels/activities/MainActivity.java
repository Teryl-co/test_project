package by.lynd.hotels.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import by.lynd.hotels.adapters.HotelAdapter;
import by.lynd.hotels.model.Contract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.R;
import by.lynd.hotels.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements Contract.MainView {
    private RecyclerView listView;
    private Contract.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_hotels);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                listView.getContext(),
                DividerItemDecoration.VERTICAL
        );
        listView.addItemDecoration(mDividerItemDecoration);

        presenter = new MainPresenter(this);
        presenter.init();
    }

    @Override
    public void showHotels(List<Hotel> hotels, HotelAdapter.OnHotelClickListener listener) {
        this.listView.setAdapter(new HotelAdapter(this, hotels, listener));
    }

    @Override
    public void sendIntent(Hotel hotel) {
        Intent intent = new Intent(getApplicationContext(), HotelDetailActivity.class);
        intent.putExtra(Hotel.class.getSimpleName(), hotel);
        startActivity(intent);
    }
}