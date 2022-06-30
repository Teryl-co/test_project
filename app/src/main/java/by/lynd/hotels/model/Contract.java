package by.lynd.hotels.model;

import android.content.Intent;

import java.util.List;

import by.lynd.hotels.adapters.HotelAdapter;
import retrofit2.Callback;

public interface Contract {

    interface MainView {
        void showHotels(List<Hotel> hotels, HotelAdapter.OnHotelClickListener listener);
        void sendIntent(Hotel hotel);
    }

    interface ItemView {
        void setUpItemView(Hotel hotel);
        void setUpCallButtonListener(String number);
        void setUpEmailButtonListener(String... emails);
        void setUpLocationButtonListener(String location);
    }

    interface MainPresenter {
        void init();
    }

    interface ItemPresenter {
        void handleIntent(Intent intent);
        void setUpButtonListener();
    }

    interface Model {
        void loadHotels(Callback<HotelList> listOfHotels);
    }
}
