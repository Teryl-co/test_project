package by.lynd.hotels.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import by.lynd.hotels.Adapters.HotelAdapter;

import by.lynd.hotels.JSON.RetroClient;
import by.lynd.hotels.Model.Hotel;
import by.lynd.hotels.Model.HotelList;
import by.lynd.hotels.R;
import by.lynd.hotels.Tasks.DownloadImageTask;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Hotel> hotels;

    private Callback<HotelList> callback = new Callback<HotelList>() {
        @Override
        public void onResponse(Call<HotelList> call, Response<HotelList> response) {
            if (response.isSuccessful()){
                hotels = response.body().getHotels();
                HotelAdapter hotelAdapter = new HotelAdapter(getApplicationContext(), 0, hotels);
                ListView listView = findViewById(R.id.list_view_hotels);
                listView.setAdapter(hotelAdapter);
                setUpOnClickListener(listView);
            } else {
                hotels = new ArrayList<>();
            }

        }

        @Override
        public void onFailure(Call<HotelList> call, Throwable t) {
            t.printStackTrace();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View content = findViewById(android.R.id.content);

        content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {

                if (hotels != null && DownloadImageTask.getQuantity() == hotels.size()) {
                    content.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                } else {
                    return false;
                }
            }
        });

        setUpListView();
    }

    public void setUpListView() {
        RetroClient.getStoreHotels(callback);
    }

    public void setUpOnClickListener(ListView listView) {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Hotel hotel = (Hotel) listView.getItemAtPosition(position);
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(Hotel.class.getSimpleName(), hotel);
            startActivity(intent);
        });
    }

}