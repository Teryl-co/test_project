package by.lynd.hotels.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;

import java.util.List;

import by.lynd.hotels.Adapters.HotelAdapter;

import by.lynd.hotels.Model.Contract;
import by.lynd.hotels.Model.Hotel;
import by.lynd.hotels.R;
import by.lynd.hotels.presentars.Presenter;

public class MainActivity extends AppCompatActivity implements Contract.View{
    private ListView listView;
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

        ListView listView = findViewById(R.id.list_view_hotels);
        listView.setOnItemClickListener((parent, view, position, id) -> presenter.onItemWasClicked(position));
    }

    @Override
    public void showHotels(List<Hotel> hotels) {
        this.listView.setAdapter(new HotelAdapter(getApplicationContext(), 0, hotels));
    }

    @Override
    public void sendIntent(Hotel hotel) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra(Hotel.class.getSimpleName(), hotel);
        startActivity(intent);
    }
}