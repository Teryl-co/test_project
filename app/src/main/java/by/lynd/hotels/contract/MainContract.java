package by.lynd.hotels.contract;

import java.util.List;

import by.lynd.hotels.adapter.HotelAdapter;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.model.HotelList;
import retrofit2.Callback;

public interface MainContract {
    interface Model {
        void loadHotels(Callback<HotelList> listOfHotels);
    }

    interface View {
        void appendHotel(List<Hotel> hotels);
        void showHotels(List<Hotel> hotels);
        void shotToast();
        boolean isTheListIsEmpty();
    }

    interface Presenter {
        void getData();
        void start();
    }
}
