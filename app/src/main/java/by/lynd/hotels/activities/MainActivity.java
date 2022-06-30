package by.lynd.hotels.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.List;

import by.lynd.hotels.adapters.HotelAdapter;
import by.lynd.hotels.model.Contract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.R;
import by.lynd.hotels.presenters.Presenter;

public class MainActivity extends AppCompatActivity implements Contract.View{
    private RecyclerView listView;
    private Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View content = findViewById(android.R.id.content);
        content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
//                if (hotels != null && DownloadImageTask.getQuantity() == hotels.size()) {
//                    content.getViewTreeObserver().removeOnPreDrawListener(this);
//                    return true;
//                } else {
//                    return false;
//                }
                return  true;
            }
        });

        presenter = new Presenter(this);

        listView = findViewById(R.id.list_hotels);
    }

    @Override
    public void showHotels(List<Hotel> hotels, HotelAdapter.OnHotelClickListener listener) {
        this.listView.setAdapter(new HotelAdapter(this, hotels, listener));
    }

    @Override
    public void sendIntent(Hotel hotel) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra(Hotel.class.getSimpleName(), hotel);
        startActivity(intent);
    }
}