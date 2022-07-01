package by.lynd.hotels.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import by.lynd.hotels.adapter.HotelAdapter;
import by.lynd.hotels.contract.MainContract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.R;
import by.lynd.hotels.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private RecyclerView listView;
    private MainContract.Presenter presenter;

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
        presenter.getData();
    }

    @Override
    public void showHotels(List<Hotel> hotels) {
        this.listView.setAdapter(new HotelAdapter(this, hotels));
    }

    @Override
    public void sendIntent(Hotel hotel) {
        Intent intent = new Intent(getApplicationContext(), HotelDetailActivity.class);
        intent.putExtra(Hotel.class.getSimpleName(), hotel);
        startActivity(intent);
    }
}