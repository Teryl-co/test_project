package by.lynd.hotels.model;

import java.util.List;

import by.lynd.hotels.adapters.HotelAdapter;
import by.lynd.hotels.presenters.Presenter;
import retrofit2.Callback;

public interface Contract {

    interface View {
        void showHotels(List<Hotel> hotels, HotelAdapter.OnHotelClickListener listener);
        void sendIntent(Hotel hotel);
    }

    interface Presenter {
        void onItemWasClicked();
        void onDestroy();
    }

    interface Model {
        void loadHotels(Callback<HotelList> listOfHotels);
    }
}
