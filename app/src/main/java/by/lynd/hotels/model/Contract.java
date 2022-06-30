package by.lynd.hotels.model;

import java.util.List;

import by.lynd.hotels.adapters.HotelAdapter;
import retrofit2.Callback;

public interface Contract {

    interface MainView {
        void showHotels(List<Hotel> hotels, HotelAdapter.OnHotelClickListener listener);
        void sendIntent(Hotel hotel);
    }

    interface ItemView {

    }

    interface MainPresenter {
        void init();
    }

    interface ItemPresenter {

    }

    interface Model {
        void loadHotels(Callback<HotelList> listOfHotels);
    }
}
